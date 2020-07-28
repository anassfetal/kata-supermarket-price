package com.fanass.kata.supermarche.utils;



public enum Poids {
	 	KILOGRAMME("Kg"),
	    GRAMME("gr"),
	    POUND("pnd");

	 	private final String value;

		Poids(String string) {
		
			this.value=string;
		}
		
		public String getValue() {
		        return value;
		 }

		  
	
}
