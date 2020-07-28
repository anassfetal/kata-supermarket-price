package com.fanass.kata.supermarche.model;

public class ReductionTotalNProduit  implements ReglePrix {

	public Produit produit;
	
	public Prix prix;
	
	public int nombreProduit;
	

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Prix getPrix() {
		return prix;
	}

	public void setPrix(Prix prix) {
		this.prix = prix;
	}

	public int getNombreProduit() {
		return nombreProduit;
	}

	public void setNombreProduit(int nombreProduit) {
		this.nombreProduit = nombreProduit;
	}

	public ReductionTotalNProduit(Produit produit, Prix prix, int nombreProduit) {
		this.produit = produit;
		this.prix = prix;
		this.nombreProduit = nombreProduit;
	}
	
	

}
