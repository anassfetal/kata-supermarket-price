package com.fanass.kata.supermarche.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Panier {
	List<GroupProduit> listeGroupeProduit= new ArrayList<GroupProduit>();


	public List<GroupProduit> getListeGroupeProduit() {
		return listeGroupeProduit;
	}

	public void setListeGroupeProduit(List<GroupProduit> listGroupProduit) {
		this.listeGroupeProduit = listGroupProduit;
	}

	public void ajouterProduit(Produit p1, int i) {
		GroupProduit gProduit = new GroupProduit();
		gProduit.nombre=i;
		gProduit.produit=p1;
		listeGroupeProduit.add(gProduit);
		
	}

	public void ajouterProduitAvecPoids(Produit produit, BigDecimal poids, String unite) {

		GroupProduit gProduit = new GroupProduit();
		gProduit.poids=poids;
		gProduit.unite=unite;
		gProduit.produit=produit;
		listeGroupeProduit.add(gProduit);
		
	}

	
	

}
