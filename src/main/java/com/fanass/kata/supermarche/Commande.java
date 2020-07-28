package com.fanass.kata.supermarche;

import java.math.BigDecimal;

import com.fanass.kata.supermarche.model.Panier;

public class Commande {

	public BigDecimal total(Panier panier) {

		return intToBigDecimal(0);
	}
	
	
	public BigDecimal intToBigDecimal(int nombre) {
		return new BigDecimal(nombre);
	}

}
