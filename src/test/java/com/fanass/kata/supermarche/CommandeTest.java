package com.fanass.kata.supermarche;

import java.math.BigDecimal;
import org.junit.Test;

import com.fanass.kata.supermarche.model.Panier;


public class CommandeTest {
	
	@Test
	public void testCommandeSansProduit() {
		Commande commande = new Commande();
		Panier panier = new Panier();
		BigDecimal total = commande.total(panier);
		org.junit.Assert.assertEquals(new BigDecimal("0.00"), total.setScale(2));
	}
	
	

}
