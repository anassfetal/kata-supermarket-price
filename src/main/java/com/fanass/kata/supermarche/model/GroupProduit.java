package com.fanass.kata.supermarche.model;

import java.math.BigDecimal;

public class GroupProduit {

	public Produit produit;
	public  int nombre;
	public BigDecimal poids;
	public String unite;
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
	public BigDecimal getPoids() {
		return poids;
	}
	public void setPoids(BigDecimal poids) {
		this.poids = poids;
	}
	public String getUnite() {
		return unite;
	}
	public void setUnite(String unite) {
		this.unite = unite;
	}
	
	
	
}
