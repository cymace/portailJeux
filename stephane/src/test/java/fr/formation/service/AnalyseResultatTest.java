package fr.formation.service;

import junit.framework.TestCase;

public class AnalyseResultatTest extends TestCase {
	
	public void testVerifierResultat() {
		
		String resultOk = "bien joué";
		
		String resultKo = "mauvaise réponse, rééssayez !";
		
		assertEquals(resultOk, AnalyseResultat.verifierResultat("blanc"));
		
		assertEquals(resultKo, AnalyseResultat.verifierResultat("rouge"));
	}
	
}
