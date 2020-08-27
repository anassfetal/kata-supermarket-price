package com.fanass.kata.supermarche.model;

public class RegleAjouterProduitGratuit extends RegleDeReduction {

	//Produit produit;
	int nombre;
	

	public RegleAjouterProduitGratuit(Produit produit, int nombre) {
		this.produit = produit;
		this.nombre = nombre;
	}


	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	

}
