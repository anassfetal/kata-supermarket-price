package com.fanass.kata.supermarche.model;

public class RegleAjouterProduitGratuit extends RegleDeReduction {


	private int nombre;
	

	public RegleAjouterProduitGratuit(Produit produit, int nombre) {
		super(produit);
		this.nombre = nombre;
	}


	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	

}
