package com.fanass.kata.supermarche.model;

public class ReductionTotalNProduit  extends RegleDeReduction {


	
	public Prix prix;
	
	public int nombreProduit;
	


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
