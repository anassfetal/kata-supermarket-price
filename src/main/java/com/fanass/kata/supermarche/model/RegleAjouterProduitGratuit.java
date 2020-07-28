package com.fanass.kata.supermarche.model;

public class RegleAjouterProduitGratuit implements ReglePrix {

	Produit produit;
	int nombre;
	

	public RegleAjouterProduitGratuit(Produit produit, int nombre) {
		this.produit = produit;
		this.nombre = nombre;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	

}
