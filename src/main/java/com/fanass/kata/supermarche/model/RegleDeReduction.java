package com.fanass.kata.supermarche.model;

public abstract class RegleDeReduction {

	private Produit produit;

	public RegleDeReduction(Produit produit) {

		this.produit=produit;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	
	
}
