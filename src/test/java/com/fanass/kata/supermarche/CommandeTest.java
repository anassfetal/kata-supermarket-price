package com.fanass.kata.supermarche;

import java.math.BigDecimal;
import org.junit.Test;


import com.fanass.kata.supermarche.model.Panier;
import com.fanass.kata.supermarche.model.Prix;
import com.fanass.kata.supermarche.model.Produit;


public class CommandeTest {

	Produit p1 = new Produit(new Prix(new BigDecimal("1.5")),1);
	Produit p2 = new Produit(new Prix(new BigDecimal("1.0")),2);
	Produit p3 = new Produit(new Prix(new BigDecimal("2.5")),3);

	@Test
	public void testCommandeSansProduit() {
		Commande commande = new Commande();
		Panier panier = new Panier();
		BigDecimal total = commande.total(panier);
		org.junit.Assert.assertEquals(new BigDecimal("0.00"), total.setScale(2));
	}
	
	@Test
	public void testCommandeAvecUnSeulProduitAuPanier() {
		Commande commande = new Commande();
		Panier panier = new Panier();
		panier.ajouterProduit(p1,1);
		BigDecimal total = commande.total(panier);
		org.junit.Assert.assertEquals(new BigDecimal("1.50"), total.setScale(2));
	}
	
	@Test
	public void testCommandeAvecUnSeulProduitEnDoubleAuPanier() {
		Commande commande = new Commande();
		Panier panier = new Panier();
		panier.ajouterProduit(p1,2);
		BigDecimal total = commande.total(panier);
		org.junit.Assert.assertEquals(new BigDecimal("3.00"), total.setScale(2));
	}
	
	@Test
	public void testCommandeAvecDeuxProduitAuPanier() {
		Commande commande = new Commande();
		Panier panier = new Panier();
		panier.ajouterProduit(p1,10);
		panier.ajouterProduit(p2,10);
		BigDecimal total = commande.total(panier);
		org.junit.Assert.assertEquals(new BigDecimal("25.00"), total.setScale(2));	
	}


	
}
