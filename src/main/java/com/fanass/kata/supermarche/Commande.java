package com.fanass.kata.supermarche;

import java.math.BigDecimal;


import com.fanass.kata.supermarche.model.GroupProduit;
import com.fanass.kata.supermarche.model.Panier;
import com.fanass.kata.supermarche.model.RegleAjouterProduitGratuit;
import com.fanass.kata.supermarche.model.ReglePrix;
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
				total=Utils.ajoutDeuxBigDecimal(total,prixGProduit);
				
				
			}
			
		}
		return total;
	}
	private ReglePrix reglesPrix ;

	public void ajouterRegle(RegleAjouterProduitGratuit regleAjouterProduitGratuit) {
		this.setReglesPrix(regleAjouterProduitGratuit);
		
	}
	public BigDecimal totalAvecRegle(Panier panier, ReglePrix reglesPrix) {
		GroupProduit gProduit;
		BigDecimal total=Utils.intToBigDecimal(0);
		if(panier.getListGroupProduit().size()!=0) {
			for(int i=0;i<panier.getListGroupProduit().size();i++) {
				gProduit = new GroupProduit();
				gProduit = panier.getListGroupProduit().get(i);
				BigDecimal prixGProduit=Utils.multiDeuxBigDecimal(gProduit.getProduit().getPrix().getPrix(),Utils.intToBigDecimal(gProduit.getNombre()));				
				total=Utils.ajoutDeuxBigDecimal(total,prixGProduit);
				int nombre =gProduit.getNombre();
				if(reglesPrix instanceof RegleAjouterProduitGratuit) {
					RegleAjouterProduitGratuit regleAjouterProduitGratuit =(RegleAjouterProduitGratuit) reglesPrix;
					if(regleAjouterProduitGratuit.getProduit().getIdProduit()==gProduit.getProduit().getIdProduit()) {
						Utils.multiDeuxBigDecimal(gProduit.getProduit().getPrix().getPrix(),Utils.intToBigDecimal(nombre));
						int rapport =gProduit.getNombre()/regleAjouterProduitGratuit.getNombre();
						total=total.subtract(Utils.multiDeuxBigDecimal(Utils.intToBigDecimal(rapport),gProduit.getProduit().prix.getPrix()));
					}
				}
					
				
				
			}
			
		}
		return total;
	}

	public ReglePrix getReglesPrix() {
		return reglesPrix;
	}

	public void setReglesPrix(ReglePrix reglesPrix) {
		this.reglesPrix = reglesPrix;
	}


	
	


}
