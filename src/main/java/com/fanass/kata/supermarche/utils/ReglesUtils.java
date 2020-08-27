package com.fanass.kata.supermarche.utils;

import java.math.BigDecimal;

import com.fanass.kata.supermarche.model.GroupProduit;
import com.fanass.kata.supermarche.model.ReductionTotalNProduit;
import com.fanass.kata.supermarche.model.RegleAjouterProduitGratuit;

public final class ReglesUtils {

	public static BigDecimal calculerMontantAReduction(GroupProduit gProduit,  RegleAjouterProduitGratuit regleAjouterProduitGratuit) {
		
		if(regleAjouterProduitGratuit.getProduit().getIdProduit()==gProduit.getProduit().getIdProduit()) {
			CalculsUtils.multiDeuxBigDecimal(gProduit.getProduit().getPrix().getPrix(),CalculsUtils.intVersBigDecimal(gProduit.getNombre()));
			int rapport =gProduit.getNombre()/regleAjouterProduitGratuit.getNombre();
			return  CalculsUtils.multiDeuxBigDecimal(CalculsUtils.intVersBigDecimal(rapport),gProduit.getProduit().prix.getPrix());
			}
			return BigDecimal.ZERO;
		
	}
	

	public static BigDecimal calculerMontantAReductionRegle2(GroupProduit gProduit, ReductionTotalNProduit reductionTotalNProduit) {
		int N=gProduit.getNombre()/reductionTotalNProduit.getNombreProduit();
		return CalculsUtils.multiDeuxBigDecimal(
								CalculsUtils.intVersBigDecimal(N),
								(CalculsUtils.soustractionBigDecimal(
										CalculsUtils.multiDeuxBigDecimal(
											gProduit.getProduit().prix.getPrix(),
											CalculsUtils.intVersBigDecimal(reductionTotalNProduit.getNombreProduit())
														),
									reductionTotalNProduit.getPrix().getPrix())
							    )
							);
	}

		
}
