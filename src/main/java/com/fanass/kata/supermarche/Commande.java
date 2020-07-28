package com.fanass.kata.supermarche;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fanass.kata.supermarche.model.GroupProduit;
import com.fanass.kata.supermarche.model.Panier;
import com.fanass.kata.supermarche.model.ReductionTotalNProduit;
import com.fanass.kata.supermarche.model.RegleAjouterProduitGratuit;
import com.fanass.kata.supermarche.model.ReglePrix;
import com.fanass.kata.supermarche.utils.Utils;

public class Commande {
	
	private List<ReglePrix> listReglesPrix = new ArrayList<ReglePrix>();

	public BigDecimal total(Panier panier, List<ReglePrix> listReglesPrix) {
		GroupProduit gProduit;
		BigDecimal total=Utils.intToBigDecimal(0);
		if(panier.getListGroupProduit().size()!=0) {
			for(int i=0;i<panier.getListGroupProduit().size();i++) {
				gProduit = new GroupProduit();
				gProduit = panier.getListGroupProduit().get(i);
				BigDecimal prixGProduit=Utils.multiDeuxBigDecimal(gProduit.getProduit().getPrix().getPrix(),Utils.intToBigDecimal(gProduit.getNombre()));				
				total=Utils.ajoutDeuxBigDecimal(total,prixGProduit);
				int nombre =gProduit.getNombre();
				if(listReglesPrix!=null) {
					for(int h=0;h<listReglesPrix.size();h++) {
						if(listReglesPrix.get(h) instanceof RegleAjouterProduitGratuit) {
							RegleAjouterProduitGratuit regleAjouterProduitGratuit =(RegleAjouterProduitGratuit) listReglesPrix.get(h);
							if(regleAjouterProduitGratuit.getProduit().getIdProduit()==gProduit.getProduit().getIdProduit()) {
								Utils.multiDeuxBigDecimal(gProduit.getProduit().getPrix().getPrix(),Utils.intToBigDecimal(nombre));
								int rapport =gProduit.getNombre()/regleAjouterProduitGratuit.getNombre();
								total=Utils.substractionBigDecimal(total, Utils.multiDeuxBigDecimal(Utils.intToBigDecimal(rapport),gProduit.getProduit().prix.getPrix()));
							}
							
						}
						else if (listReglesPrix.get(h) instanceof ReductionTotalNProduit) {
							ReductionTotalNProduit reductionTotalNProduit =(ReductionTotalNProduit) listReglesPrix.get(h);
							if(reductionTotalNProduit.getProduit().getIdProduit()==gProduit.getProduit().getIdProduit()) {
								int N=gProduit.getNombre()/reductionTotalNProduit.getNombreProduit();
								total=Utils.substractionBigDecimal(total,Utils.multiDeuxBigDecimal(
														Utils.intToBigDecimal(N),
														(Utils.substractionBigDecimal(
																Utils.multiDeuxBigDecimal(
																	gProduit.getProduit().prix.getPrix(),
																	Utils.intToBigDecimal(reductionTotalNProduit.getNombreProduit())
																				),
															reductionTotalNProduit.getPrix().getPrix())
													    )
													)
								);
								
							}
						} 
					}
				}	
				
			}
			
		}
		return total;
	}
	
	public void ajouterRegle(ReglePrix reglePrix) {
		listReglesPrix.add(reglePrix);
		
	}
	public List<ReglePrix> getListReglesPrix() {
		return listReglesPrix;
	}
	public void setListReglesPrix(List<ReglePrix> listReglesPrix) {
		this.listReglesPrix = listReglesPrix;
	}

	


	
	


}
