package fr.formation.model;

import java.util.Arrays;

public class JeuPendu {

	private static JeuPendu uniqueInstance;
	private int nbErreur;
	private String mot;
	private int cache[];
	
	
	private JeuPendu(String mot) {
		
		this.mot = mot;
		cache = new int[mot.length()];
		for (int i = 0; i < cache.length; i++) {
			cache[i]=1;
		}
		nbErreur=0;
	}


	 public static JeuPendu getInstance(String mot) {
	        if (null == uniqueInstance) { // Premier appel
	        	uniqueInstance = new JeuPendu(mot);
	        }
	        return uniqueInstance;
	    }
	
	
	
	public int getNbErreur() {
		return nbErreur;
	}


	public void setNbErreur(int nbErreur) {
		this.nbErreur = nbErreur;
	}


	public String getMot() {
		return mot;
	}


	public void setMot(String mot) {
		this.mot = mot;
	}


	public int[] getCache() {
		return cache;
	}


	public void setCache(int[] cache) {
		this.cache = cache;
	}

	public void modifCacheById(int i, int valeur) {
		cache[i]=valeur;
	}

	@Override
	public String toString() {
		return "JeuPendu [nbErreur=" + nbErreur + ", mot=" + mot + ", cache=" + Arrays.toString(cache) + "]";
	}
	
	

}
