package com.fanass.kata.supermarche.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Panier {
	List<GroupProduit> listGroupProduit= new ArrayList<GroupProduit>();


	public List<GroupProduit> getListGroupProduit() {
		return listGroupProduit;
	}

	public void setListGroupProduit(List<GroupProduit> listGroupProduit) {
		this.listGroupProduit = listGroupProduit;
	}

	public void ajouterProduit(Produit p1, int i) {
		GroupProduit gProduit = new GroupProduit();
		gProduit.nombre=i;
		gProduit.produit=p1;
		listGroupProduit.add(gProduit);
		
	}

	public void ajouterProduitAvecPoids(Produit produit, BigDecimal poids, String unite) {

		GroupProduit gProduit = new GroupProduit();
		gProduit.poids=poids;
		gProduit.unite=unite;
		gProduit.produit=produit;
		listGroupProduit.add(gProduit);
		
	}

	
	

}
