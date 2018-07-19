package fr.formation.service;

import junit.framework.TestCase;

public class AnalyseResultatTest extends TestCase {
	
	public void testVerifierResultat() {
		
		String resultOk = "bien jou�";
		
		String resultKo = "mauvaise r�ponse, r��ssayez !";
		
		assertEquals(resultOk, AnalyseResultat.verifierResultat("blanc"));
		
		assertEquals(resultKo, AnalyseResultat.verifierResultat("rouge"));
	}
	
}
