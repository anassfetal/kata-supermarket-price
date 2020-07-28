package com.fanass.kata.supermarche.utils;

import java.math.BigDecimal;

public class Utils {
	
	
	public static BigDecimal intToBigDecimal(int nombre) {
		
		return new BigDecimal(nombre);
	
	}
	
	
	public static BigDecimal multiDeuxBigDecimal(BigDecimal a1,BigDecimal a2) {
		
		return a1.multiply(a2);
	
	}
	
	
	public static BigDecimal ajoutDeuxBigDecimal(BigDecimal a1, BigDecimal a2) {
		
		return a1.add(a2);
	
	}


}
