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
		BigDecimal total=Utils.intVersBigDecimal(0);
		if(panier.getListeGroupeProduit().size()!=0) {
			for(int i=0;i<panier.getListeGroupeProduit().size();i++) {
				gProduit = new GroupProduit();
				gProduit = panier.getListeGroupeProduit().get(i);
				if(gProduit.getPoids()==null) {
					BigDecimal prixGProduit=Utils.multiDeuxBigDecimal(gProduit.getProduit().getPrix().getPrix(),Utils.intVersBigDecimal(gProduit.getNombre()));				
					total=Utils.ajoutDeuxBigDecimal(total,prixGProduit);
				}else {
					total=Utils.ajoutDeuxBigDecimal(total,Utils.multiDeuxBigDecimal(gProduit.getPoids(),gProduit.getProduit().getPrix().getPrix()));
				}
				int nombre =gProduit.getNombre();
				if(listReglesPrix!=null) {
					for(int h=0;h<listReglesPrix.size();h++) {
						if(listReglesPrix.get(h) instanceof RegleAjouterProduitGratuit) {
							RegleAjouterProduitGratuit regleAjouterProduitGratuit =(RegleAjouterProduitGratuit) listReglesPrix.get(h);
							if(regleAjouterProduitGratuit.getProduit().getIdProduit()==gProduit.getProduit().getIdProduit()) {
								Utils.multiDeuxBigDecimal(gProduit.getProduit().getPrix().getPrix(),Utils.intVersBigDecimal(nombre));
								int rapport =gProduit.getNombre()/regleAjouterProduitGratuit.getNombre();
								total=Utils.soustractionBigDecimal(total, Utils.multiDeuxBigDecimal(Utils.intVersBigDecimal(rapport),gProduit.getProduit().prix.getPrix()));
							}
							
						}
						else if (listReglesPrix.get(h) instanceof ReductionTotalNProduit) {
							ReductionTotalNProduit reductionTotalNProduit =(ReductionTotalNProduit) listReglesPrix.get(h);
							if(reductionTotalNProduit.getProduit().getIdProduit()==gProduit.getProduit().getIdProduit()) {
								int N=gProduit.getNombre()/reductionTotalNProduit.getNombreProduit();
								total=Utils.soustractionBigDecimal(total,Utils.multiDeuxBigDecimal(
														Utils.intVersBigDecimal(N),
														(Utils.soustractionBigDecimal(
																Utils.multiDeuxBigDecimal(
																	gProduit.getProduit().prix.getPrix(),
																	Utils.intVersBigDecimal(reductionTotalNProduit.getNombreProduit())
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
	public List<ReglePrix> getListeReglesPrix() {
		return listReglesPrix;
	}
	public void setListReglesPrix(List<ReglePrix> listeReglesPrix) {
		this.listReglesPrix = listReglesPrix;
	}

	


	
	


}
