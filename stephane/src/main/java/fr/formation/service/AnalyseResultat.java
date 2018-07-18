package fr.formation.service;

public class AnalyseResultat {

	public static String verifierResultat(String reponse) {

		if (reponse.equals("blanc")) {

			return "bien joué";
		} else {

			return "mauvaise réponse, rééssayez !";
		}

	}

}
