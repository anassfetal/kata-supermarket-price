package com.fanass.kata.supermarche.model;

import java.math.BigDecimal;

public class GroupProduit {

	private Produit produit;
	private  int nombre;
	private BigDecimal poids;
	private String unite;
	
	
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
