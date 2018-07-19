package fr.formation;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMaClasseprincipale {
private MaClassePrincipale mcp=new  MaClassePrincipale();
	@Test
	public void test() {
		assertEquals(mcp.fonctionATester("Blanc"), "Ok");
	}

}
