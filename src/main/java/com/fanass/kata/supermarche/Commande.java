package com.fanass.kata.supermarche;

import java.math.BigDecimal;

import com.fanass.kata.supermarche.model.GroupProduit;
import com.fanass.kata.supermarche.model.Panier;

public class Commande {

	public BigDecimal total(Panier panier) {
		GroupProduit gProduit;
		if(panier.getListGroupProduit().size()!=0) {
			gProduit = new GroupProduit();
			gProduit = panier.getListGroupProduit().get(0);
			
			return gProduit.getProduit().getPrix().getPrix(); 
		}
		return intToBigDecimal(0);
	}
	
	
	public BigDecimal intToBigDecimal(int nombre) {
		return new BigDecimal(nombre);
	}

}
