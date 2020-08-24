package com.fanass.kata.supermarche;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.fanass.kata.supermarche.model.Panier;
import com.fanass.kata.supermarche.model.Prix;
import com.fanass.kata.supermarche.model.Produit;
import com.fanass.kata.supermarche.model.ReductionTotalNProduit;
import com.fanass.kata.supermarche.model.RegleAjouterProduitGratuit;
import com.fanass.kata.supermarche.utils.Poids;


public class CommandeTest {

	private Produit p1;
	private Produit p2;
	private Produit p3;
	private Produit p4;
	
	@Before
	  public void initialiser() throws Exception {
		p1 = new Produit(new Prix(new BigDecimal("1.5")),1);
		p2 = new Produit(new Prix(new BigDecimal("1.0")),2);
		p3 = new Produit(new Prix(new BigDecimal("2.5")),3);
		p4 = new Produit(new Prix(new BigDecimal("3.0")),Poids.KILOGRAMME.getValue(),4);
	  }
	@After
	  public void nettoyer() throws Exception {
		p1 =  null;
		p2 =  null;
		p3 =  null;
		p4 =  null;
	  }
	
	@Test
	public void testCommandeSansProduit() {
		Commande commande = new Commande();
		Panier panier = new Panier();
		BigDecimal total = commande.total(panier,null);
		org.junit.Assert.assertEquals(new BigDecimal("0.00"), total.setScale(2));
	}
	
	@Test
	public void testCommandeAvecUnSeulProduitAuPanier() {
		Commande commande = new Commande();
		Panier panier = new Panier();
		panier.ajouterProduit(p1,1);
		BigDecimal total = commande.total(panier,null);
		org.junit.Assert.assertEquals(new BigDecimal("1.50"), total.setScale(2));
	}
	
	@Test
	public void testCommandeAvecUnSeulProduitEnDoubleAuPanier() {
		Commande commande = new Commande();
		Panier panier = new Panier();
		panier.ajouterProduit(p1,2);
		BigDecimal total = commande.total(panier,null);
		org.junit.Assert.assertEquals(new BigDecimal("3.00"), total.setScale(2));
	}
	
	@Test
	public void testCommandeAvecDeuxProduitAuPanier() {
		Commande commande = new Commande();
		Panier panier = new Panier();
		panier.ajouterProduit(p1,10);
		panier.ajouterProduit(p2,10);
		BigDecimal total = commande.total(panier,null);
		org.junit.Assert.assertEquals(new BigDecimal("25.00"), total.setScale(2));	
	}
	
	@Test
	public void testCommandeAvecTroisProduitAuPanier() {
		Commande commande = new Commande();
		Panier panier = new Panier();
		panier.ajouterProduit(p1,10);
		panier.ajouterProduit(p2,10);
		panier.ajouterProduit(p3,1);
		BigDecimal total = commande.total(panier,null);
		org.junit.Assert.assertEquals(new BigDecimal("27.50"), total.setScale(2));	
	}

	
	@Test
	public void testCommandeAvecRegleAjouterProduitGratuit() {
		Commande commande = new Commande();
		commande.ajouterRegle(new RegleAjouterProduitGratuit(p1,3));
		Panier panier = new Panier();
		panier.ajouterProduit(p1,10);
		panier.ajouterProduit(p2,10);
		panier.ajouterProduit(p3,1);
		BigDecimal total = commande.total(panier,commande.getListReglesPrix());
		org.junit.Assert.assertEquals(new BigDecimal("23.00"), total.setScale(2));

	}
	@Test
	public void testCommandeAvecDeuxRegleAjouterProduitGratuit() {
		Commande commande = new Commande();
		commande.ajouterRegle(new RegleAjouterProduitGratuit(p1,3));
		commande.ajouterRegle(new RegleAjouterProduitGratuit(p2,3));	
		Panier panier = new Panier();
		panier.ajouterProduit(p1,10);
		panier.ajouterProduit(p2,10);
		panier.ajouterProduit(p3,1);
		BigDecimal total = commande.total(panier,commande.getListReglesPrix());
		org.junit.Assert.assertEquals(new BigDecimal("20.00"), total.setScale(2));

	}

	
	@Test
	public void testCommandeAvecTroisRegleAjouterProduitGratuit() {
		Commande commande = new Commande();
		commande.ajouterRegle(new RegleAjouterProduitGratuit(p1,3));
		commande.ajouterRegle(new RegleAjouterProduitGratuit(p2,3));
		commande.ajouterRegle(new RegleAjouterProduitGratuit(p3,3));	
		Panier panier = new Panier();
		panier.ajouterProduit(p1,10);
		panier.ajouterProduit(p2,10);
		panier.ajouterProduit(p3,10);
		BigDecimal total = commande.total(panier,commande.getListReglesPrix());
		org.junit.Assert.assertEquals(new BigDecimal("35.00"), total.setScale(2));

	}
	
	@Test
	public void testCommandeAvecRegleReductionTotalNProduit() {
		Commande commande = new Commande();
		commande.ajouterRegle(new ReductionTotalNProduit(p2,new Prix(new BigDecimal("2.5")) , 3));
		Panier panier = new Panier();
		panier.ajouterProduit(p1,10);
		panier.ajouterProduit(p2,10);
		panier.ajouterProduit(p3,1);
		BigDecimal total = commande.total(panier,commande.getListReglesPrix());
		org.junit.Assert.assertEquals(new BigDecimal("26.00"), total.setScale(2));

	}
	
	@Test
	public void testCommandeAvecDeuxRegleReductionTotalNProduit() {
		Commande commande = new Commande();
		commande.ajouterRegle(new ReductionTotalNProduit(p2,new Prix(new BigDecimal("2.5")) , 3));
		commande.ajouterRegle(new ReductionTotalNProduit(p1,new Prix(new BigDecimal("5.5")) , 4));
		Panier panier = new Panier();
		panier.ajouterProduit(p1,10);
		panier.ajouterProduit(p2,10);
		panier.ajouterProduit(p3,1);
		BigDecimal total = commande.total(panier,commande.getListReglesPrix());
		org.junit.Assert.assertEquals(new BigDecimal("25.00"), total.setScale(2));

	}

	@Test
	public void testCommandeAvecTroisRegleReductionTotalNProduit() {
		Commande commande = new Commande();
		commande.ajouterRegle(new ReductionTotalNProduit(p2,new Prix(new BigDecimal("2.5")) , 3));
		commande.ajouterRegle(new ReductionTotalNProduit(p1,new Prix(new BigDecimal("5.5")) , 4));
		commande.ajouterRegle(new ReductionTotalNProduit(p3,new Prix(new BigDecimal("4")) , 2));
		Panier panier = new Panier();
		panier.ajouterProduit(p1,10);
		panier.ajouterProduit(p2,10);
		panier.ajouterProduit(p3,10);
		BigDecimal total = commande.total(panier,commande.getListReglesPrix());
		org.junit.Assert.assertEquals(new BigDecimal("42.50"), total.setScale(2));

	}
	
	@Test
	public void testCommandeAvecUneRegleReductionTotalNProduitEtRegleAjouterProduitGratuit() {
		Commande commande = new Commande();
		commande.ajouterRegle(new ReductionTotalNProduit(p2,new Prix(new BigDecimal("2.5")) , 3));
		commande.ajouterRegle(new RegleAjouterProduitGratuit(p1,3));
		Panier panier = new Panier();
		panier.ajouterProduit(p1,10);
		panier.ajouterProduit(p2,10);
		panier.ajouterProduit(p3,1);
		BigDecimal total = commande.total(panier,commande.getListReglesPrix());
		org.junit.Assert.assertEquals(new BigDecimal("21.50"), total.setScale(2));

	}
	
	
	@Test
	public void testCommandeAvecUnProduitKiloAuPanier() {
		Commande commande = new Commande();
		Panier panier = new Panier();
		panier.ajouterProduitAvecPoids(p4,new BigDecimal("1.50"),"KG");
		BigDecimal total = commande.total(panier,null);
		org.junit.Assert.assertEquals(new BigDecimal("4.50"), total.setScale(2));
	}
	
	
	
	@Test
	public void testCommandeAvecUnProduitKiloPlusProduitSimpleAuPanier() {
		Commande commande = new Commande();
		Panier panier = new Panier();
		panier.ajouterProduit(p1,10);
		panier.ajouterProduit(p2,10);
		panier.ajouterProduit(p3,1);
		panier.ajouterProduitAvecPoids(p4,new BigDecimal("1.50"),Poids.KILOGRAMME.getValue());
		BigDecimal total = commande.total(panier,null);
		org.junit.Assert.assertEquals(new BigDecimal("32.00"), total.setScale(2));
	}
	
}
