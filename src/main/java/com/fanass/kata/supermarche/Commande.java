package com.fanass.kata.supermarche;

import java.math.BigDecimal;

import com.fanass.kata.supermarche.model.GroupProduit;
import com.fanass.kata.supermarche.model.Panier;
import com.fanass.kata.supermarche.utils.Utils;

public class Commande {

	public BigDecimal total(Panier panier) {
		GroupProduit gProduit;
		BigDecimal total=Utils.intToBigDecimal(0);
		if(panier.getListGroupProduit().size()!=0) {
			for(int i=0;i<panier.getListGroupProduit().size();i++) {
				gProduit = new GroupProduit();
				gProduit = panier.getListGroupProduit().get(i);
				BigDecimal prixGProduit=Utils.multiDeuxBigDecimal(gProduit.getProduit().getPrix().getPrix(),Utils.intToBigDecimal(gProduit.getNombre()));
				
				total= total.add(prixGProduit);
				
			}
			return total;
		}
		return Utils.intToBigDecimal(0);
	}
	
	


}
