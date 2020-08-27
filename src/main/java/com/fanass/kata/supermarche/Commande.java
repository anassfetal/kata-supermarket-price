package com.fanass.kata.supermarche;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fanass.kata.supermarche.model.GroupProduit;
import com.fanass.kata.supermarche.model.Panier;
import com.fanass.kata.supermarche.model.ReductionTotalNProduit;
import com.fanass.kata.supermarche.model.RegleAjouterProduitGratuit;
import com.fanass.kata.supermarche.model.RegleDeReduction;

import com.fanass.kata.supermarche.utils.CalculsUtils;
import com.fanass.kata.supermarche.utils.ReglesUtils;

public class Commande {
	
	
	private List<RegleDeReduction> listReglesPrix = new ArrayList<RegleDeReduction>();
	
	
	public BigDecimal calculerTotal(Panier panier, List<RegleDeReduction> listReglesPrix) {
		GroupProduit gProduit;
		BigDecimal total=BigDecimal.ZERO;
		BigDecimal cumulReduction=BigDecimal.ZERO;
		for(int i=0;i<panier.getListeGroupeProduit().size();i++) {
			
			gProduit = new GroupProduit();
			gProduit = panier.getListeGroupeProduit().get(i);
			if(gProduit.getPoids()==null) {
				BigDecimal prixGProduit=calculerTotalSansReductionUnite(gProduit);				
				total=CalculsUtils.ajoutDeuxBigDecimal(total,prixGProduit);
			}else {
				total=CalculsUtils.ajoutDeuxBigDecimal(total,calculerMontantGroupProduit(gProduit));
			}
			cumulReduction = calculerCumulDeReductionTotal(listReglesPrix, gProduit, total);	
			total=CalculsUtils.soustractionBigDecimal(total,cumulReduction);
		}
			
		
		return total;
	}

	
	private BigDecimal calculerCumulDeReductionTotal(List<RegleDeReduction> listReglesPrix, GroupProduit gProduit,BigDecimal total) {
		BigDecimal montantTotalDeReduction=BigDecimal.ZERO;
		if(listReglesPrix!=null) {
			for(int h=0;h<listReglesPrix.size();h++) {
				if(listReglesPrix.get(h) instanceof RegleAjouterProduitGratuit) {
					RegleAjouterProduitGratuit regleAjouterProduitGratuit =(RegleAjouterProduitGratuit) listReglesPrix.get(h);
					BigDecimal montantAdeduire = ReglesUtils.calculerMontantAReduction(gProduit, regleAjouterProduitGratuit);
					montantTotalDeReduction= CalculsUtils.ajoutDeuxBigDecimal(montantTotalDeReduction,montantAdeduire);
					
				}
				else if (listReglesPrix.get(h) instanceof ReductionTotalNProduit) {
					ReductionTotalNProduit reductionTotalNProduit =(ReductionTotalNProduit) listReglesPrix.get(h);
					if(reductionTotalNProduit.getProduit().getIdProduit()==gProduit.getProduit().getIdProduit()) {
						BigDecimal montantAdeduire2 =ReglesUtils.calculerMontantAReductionRegle2(gProduit, reductionTotalNProduit);
						montantTotalDeReduction= CalculsUtils.ajoutDeuxBigDecimal(montantTotalDeReduction,montantAdeduire2);
						
					}
				} 
			}
			
		}
		return montantTotalDeReduction;
	}



	private BigDecimal calculerTotalSansReductionUnite(GroupProduit gProduit) {
		return CalculsUtils.multiDeuxBigDecimal(gProduit.getProduit().getPrix().getPrix(),CalculsUtils.intVersBigDecimal(gProduit.getNombre()));
	}

	private BigDecimal calculerMontantGroupProduit(GroupProduit gProduit) {
		return CalculsUtils.multiDeuxBigDecimal(gProduit.getPoids(),gProduit.getProduit().getPrix().getPrix());
	}
	
	public void ajouterRegle(RegleDeReduction regleDeReduction) {
		listReglesPrix.add(regleDeReduction);
		
	}
	public List<RegleDeReduction> getListeReglesPrix() {
		return listReglesPrix;
	}
	public void setListReglesPrix(List<RegleDeReduction> listeReglesPrix) {
		this.listReglesPrix = listReglesPrix;
	}

	


	
	


}
