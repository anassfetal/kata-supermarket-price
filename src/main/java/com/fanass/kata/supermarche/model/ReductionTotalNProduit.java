package com.fanass.kata.supermarche.model;

public class ReductionTotalNProduit  extends RegleDeReduction {


	
	private Prix prix;
	
	private int nombreProduit;
	


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
		super(produit);
		this.prix = prix;
		this.nombreProduit = nombreProduit;
	}
	
	

}
