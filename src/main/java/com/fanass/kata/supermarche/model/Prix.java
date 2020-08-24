package com.fanass.kata.supermarche.model;

import java.math.BigDecimal;

public class Prix {

	private BigDecimal prix;
	
	public Prix(BigDecimal prix) {
		this.prix=prix;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	
}
