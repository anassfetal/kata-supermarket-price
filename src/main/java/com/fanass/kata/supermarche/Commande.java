package com.fanass.kata.supermarche;

import java.math.BigDecimal;

import com.fanass.kata.supermarche.model.GroupProduit;
import com.fanass.kata.supermarche.model.Panier;
import com.fanass.kata.supermarche.utils.Utils;

public class Commande {

	public BigDecimal total(Panier panier) {
		GroupProduit gProduit;
		if(panier.getListGroupProduit().size()!=0) {
			gProduit = new GroupProduit();
			gProduit = panier.getListGroupProduit().get(0);
			
			return Utils.multiDeuxBigDecimal(gProduit.getProduit().getPrix().getPrix(),Utils.intToBigDecimal(gProduit.getNombre())); 
		}
		return Utils.intToBigDecimal(0);
	}
	
	


}
