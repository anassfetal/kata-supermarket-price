package com.fanass.kata.supermarche.model;

public class Produit {

	private int idProduit;
	private String unite;
	private Prix prix;

	public Produit(Prix prix,int id) {
		this.prix= prix;
		this.idProduit=id;
	}
	
	public Produit(Prix prix,String unite,int id) {
		this.prix= prix;
		this.unite=unite;
		this.idProduit=id;
	}

	public Prix getPrix() {
		return prix;
	}

	public void setPrix(Prix prix) {
		this.prix = prix;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}
	
	
	
}
