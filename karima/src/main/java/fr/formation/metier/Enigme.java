package fr.formation.metier;

public class Enigme {
	public static String verifier (String reponse) {
		
		if(reponse.equals("blanc")) {
			return "Votre reponse est juste";		 
			}
		else {
			return "Votre reponse est fausse";
		}
}
}