package fr.formation.service;

import fr.formation.model.JeuPendu;

public class JeuDuPenduManagerImpl implements JeuDuPenduManager {

	@Override
	public boolean jouerUneLettre(char c, JeuPendu jp) {
		int i = 0;
		boolean erreur=true;
		for (char cp : jp.getMot().toCharArray()) {
			if (cp == c) {
				jp.modifCacheById(i, 1);
				erreur=false;
			}
			i++;
		}
		if (erreur) {
			jp.setNbErreur(jp.getNbErreur()+1);
			return true;
		}
		else {
			return false;	
		}
		
	}

}
