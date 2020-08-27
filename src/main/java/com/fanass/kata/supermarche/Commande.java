package com.fanass.kata.supermarche;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		BigDecimal[] total= {BigDecimal.ZERO};
		BigDecimal[] cumulReduction= {BigDecimal.ZERO};	
		Optional<Panier> panierOptionel = Optional.ofNullable(panier);
		if(panierOptionel.isPresent()) {
			panier.getListeGroupeProduit().forEach(gProduit->
					{
						if(gProduit.getPoids()==null) {
							BigDecimal prixGProduit=calculerTotalSansReductionUnite(gProduit);				
							total[0]=CalculsUtils.ajoutDeuxBigDecimal(total[0],prixGProduit);
						}else {
							total[0]=CalculsUtils.ajoutDeuxBigDecimal(total[0],calculerMontantGroupProduit(gProduit));
						}
						cumulReduction[0] = calculerCumulDeReductionTotal(listReglesPrix, gProduit, total[0]);	
						total[0]=CalculsUtils.soustractionBigDecimal(total[0],cumulReduction[0]);
					}
					);
		}
		return total[0];
	}

	
	private BigDecimal calculerCumulDeReductionTotal(List<RegleDeReduction> listReglesPrix, GroupProduit gProduit,BigDecimal total) {
		BigDecimal[] montantTotalDeReduction= {BigDecimal.ZERO};
		Optional<List<RegleDeReduction>> listReglesPrixOptionnel = Optional.ofNullable(listReglesPrix);
		if(listReglesPrixOptionnel.isPresent()) {
			listReglesPrix.forEach(reglePrix->
			{
				if(reglePrix instanceof RegleAjouterProduitGratuit) {
					RegleAjouterProduitGratuit regleAjouterProduitGratuit =(RegleAjouterProduitGratuit) reglePrix;
					BigDecimal montantAdeduire = ReglesUtils.calculerMontantAReduction(gProduit, regleAjouterProduitGratuit);
					montantTotalDeReduction[0]= CalculsUtils.ajoutDeuxBigDecimal(montantTotalDeReduction[0],montantAdeduire);
					
				}
				else if (reglePrix instanceof ReductionTotalNProduit) {
					ReductionTotalNProduit reductionTotalNProduit =(ReductionTotalNProduit) reglePrix;
					if(reductionTotalNProduit.getProduit().getIdProduit()==gProduit.getProduit().getIdProduit()) {
						BigDecimal montantAdeduire2 =ReglesUtils.calculerMontantAReductionRegle2(gProduit, reductionTotalNProduit);
						montantTotalDeReduction[0]= CalculsUtils.ajoutDeuxBigDecimal(montantTotalDeReduction[0],montantAdeduire2);
					}
				} 
			}
			);
		}
		
		return montantTotalDeReduction[0];
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
		this.listReglesPrix = listeReglesPrix;
	}

	


	
	


}
