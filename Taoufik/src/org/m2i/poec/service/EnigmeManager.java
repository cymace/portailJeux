package org.m2i.poec.service;

import java.util.HashMap;

import org.m2i.poec.model.Enigme;

public class EnigmeManager {
	public static HashMap<String, Enigme> mapEnigme = new HashMap<String, Enigme>();

	static {

		mapEnigme.put("enigme1", new Enigme(1, "Si je suis muet, aveugle et sourd, combien de sens me reste-t-il ?",
				"trois",
				"3 car il reste l'odorat, le toucher et le goût. Muet ne correspond pas à la privation d'un sens."));
		mapEnigme.put("enigme2", new Enigme(2,
				"Je donne des coups à tout le monde, mais je suis toujours le bienvenu et je ne peux pas passer inaperçu dans le monde.",
				"Le soleil", ""));
	}

}
