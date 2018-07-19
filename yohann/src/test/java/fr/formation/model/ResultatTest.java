package fr.formation.model;

import junit.framework.TestCase;

public class ResultatTest extends TestCase{
	
	public void testVerifier() {
		
		assertEquals(Resultat.verifier("FORMATION"), "OK");
		assertEquals(Resultat.verifier("formation"), "PENDU");
		
	}

}
