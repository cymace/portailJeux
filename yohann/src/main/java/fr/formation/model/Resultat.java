package fr.formation.model;

public class Resultat {
	public static String verifier (String reponse) {
		if (reponse.equals("FORMATION")) {
			return "OK";
		}
		else {
			return "PENDU";
		}
	}

}
