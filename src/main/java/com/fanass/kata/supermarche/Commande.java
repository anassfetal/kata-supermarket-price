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
		Optional<Panier> panierOptionel = Optional.ofNullable(panier);
		if (panierOptionel.isPresent()) {
			BigDecimal totalUniteSansReduction = panier.getListeGroupeProduit().stream()
					.filter(g -> g.getPoids() == null).map(g -> calculerTotalSansReductionUnite(g))
					.reduce(BigDecimal.ZERO, (a, b) -> CalculsUtils.ajoutDeuxBigDecimal(a, b));
			BigDecimal totalPoidsSansReduction = panier.getListeGroupeProduit().stream()
					.filter(g -> g.getPoids() != null).map(g -> calculerMontantGroupProduit(g))
					.reduce(BigDecimal.ZERO, (a, b) -> CalculsUtils.ajoutDeuxBigDecimal(a, b));

			BigDecimal totalSansReduction = CalculsUtils.ajoutDeuxBigDecimal(totalUniteSansReduction,
					totalPoidsSansReduction);

			BigDecimal cumulReduction = panier.getListeGroupeProduit().stream()
					.map(g -> calculerCumulDeReductionTotal(listReglesPrix, g))
					.reduce(BigDecimal.ZERO, (a, b) -> CalculsUtils.ajoutDeuxBigDecimal(a, b));

			return CalculsUtils.soustractionBigDecimal(totalSansReduction, cumulReduction);

		}
		return BigDecimal.ZERO;
	}
	 
	 
	private BigDecimal calculerCumulDeReductionTotal(List<RegleDeReduction> listReglesPrix, GroupProduit gProduit) {
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
