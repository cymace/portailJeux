package fr.formation.service;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Demineur extends JFrame {

	private int width = 10;
	private int height = 10;
	private int[][] grille;
	private boolean[][] ouvertes;
	private boolean[][] flags;
	private int bombs;
	private boolean perdu;

	public Demineur(int width, int height, int bombs) {

		setTitle("Mon d�mineur");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(width, height));
		
		//Initialisation
		this.width = width;
		this.height = height;
		this.bombs = bombs;
		
		grille = new int[width][height];
		ouvertes = new boolean[width][height];
		flags = new boolean[width][height];
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				grille[i][j] = 0;
				ouvertes[i][j] = false;
				flags[i][j] = false;
			}
		}

		miner(bombs);

		rafraichir();
	}

	private void rafraichir() {
		
		getContentPane().removeAll();

		for(int i=0; i<width; i++) {

			for(int j=0; j<height; j++) {
				
				final int iFinal = i;
				final int jFinal = j;
				final Demineur d = this;

				if(ouvertes[i][j]) {

					JLabel myLabel = new JLabel("" + grille[i][j]);
					myLabel.setPreferredSize(new Dimension(20, 20));
					add(myLabel);

				} else {
					
					JButton myButton;
					if (flags[iFinal][jFinal]) {
						
						myButton = new JButton(new ImageIcon(getClass().getResource("flag.png")));
						
					} else {
						
						myButton = new JButton();
					}

					myButton.setPreferredSize(new Dimension(20, 20));
					
					myButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							ouvrir (iFinal, jFinal);
							
							if (! perdu()) {
								rafraichir();
								if (gagne()) {
									JOptionPane.showMessageDialog(d, "Vous avez gagn� !");
								}
								
							} else {
								JOptionPane.showMessageDialog(d, "Vous avez perdu !");
							}
							
						}
					});
					
					myButton.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mousePressed(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseExited(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {
							
							if (SwingUtilities.isRightMouseButton(e)) {
								switchFlag(iFinal, jFinal);
								rafraichir();
							}
							
						}
					});

					add(myButton);

				}

			}

		}

		pack();
		setVisible(true);	
				
	}

	/**
	 * Ouvre les cases adjacentes d'une case donnée
	 * 
	 * @param i L'abcisse de la case
	 * @param j L'ordonnée de la case
	 */
	protected void ouvrirAdjacentes(int i, int j) {
		int nb = grille[i][j];
		if (nb > 0) {
			int count = 0;
			for (int a = i-1; a <= i+1; a++) {
				for (int b = j-1; b <= j+1; b++) {
					if (a >= 0 && b >= 0 && a < width && b < height && flags[a][b]) count++;
				}
			}
			if (count == nb) {
				for (int a = i-1; a <= i+1; a++) {
					for (int b = j-1; b <= j+1; b++) {
						ouvrir(a, b);
					}
				}
			}
		}
	}

	/**
	 * Ouvre une case
	 * 
	 * @param i L'abcisse de la case
	 * @param j L'ordonnée de la case
	 */
	public void ouvrir(int i, int j) {
		if (i < 0 || j < 0 || i >= width || j >= height || ouvertes[i][j] || flags[i][j]) return;
		ouvertes[i][j] = true;
		if (grille[i][j] == 0) {
			for (int a = i-1; a <= i+1; a++) {
				for (int b = j-1; b <= j+1; b++) {
					ouvrir(a, b);
				}
			}
		} else if (grille[i][j] == -1) perdu = true;
	}

	/**
	 * Indique si le joueur a gagné la partie
	 * 
	 * @return <code>true</code> si le joueur a gagné, <code>false</code> autrement
	 */
	public boolean gagne() {
		int nb = 0;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (!ouvertes[i][j]) nb++;
			}
		}
		return (nb == bombs);
	}

	public boolean perdu() {
		return perdu;
	}

	/**
	 * Pose une bombe sur une case et incrémente les cases adjacentes si elle est libre
	 * 
	 * @param i L'abcisse de la bombe
	 * @param j L'ordonnée de la bombe
	 * @return <code>true</code> si la bombe a été placée, <code>false</code> autrement
	 */
	private boolean placerBombe(int i, int j) {
		if (grille[i][j] == -1) return false;
		grille[i][j] = -1;
		for (int a = i-1; a <= i+1; a++) {
			for (int b = j-1; b <= j+1; b++) {
				incremente(a, b);
			}
		}
		return true;
	}

	/**
	 * Incrémente les cases adjacentes d'une bombe
	 * 
	 * @param i L'abcisse de la bombe
	 * @param j L'ordonnée de la bombe
	 */
	private void incremente(int i, int j) {
		if (i >= 0 && j >= 0 && i < width && j < height && grille[i][j] != -1) grille[i][j]++;
	}

	/**
	 * Place les bombes sur la grille de jeu
	 * 
	 * @param nb Le nombre de bombes à poser
	 */
	private void miner(int nb) {
		int total = 0;
		Random random = new Random();
		while (total < nb) {
			if (placerBombe(random.nextInt(width), random.nextInt(height))) total++;
		}
	}

	protected boolean[][] getCases() {
		return ouvertes;
	}

	protected int[][] getGrille() {
		return grille;
	}

	public void ouvrirTout() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				ouvertes[i][j] = true;
			}
		}		
	}

	public boolean[][] getFlags() {
		return flags;
	}

	public void switchFlag(int i, int j) {
		flags[i][j] = !flags[i][j];
	}


	public static void main(String[] args) throws Exception {
		// Débutant
		// new Demineur(8, 8, 10);
		
		// Moyen
		new Demineur(16, 16, 20);
		
		// Expert
		//		new Demineur(40, 16, 99);
	}


}
