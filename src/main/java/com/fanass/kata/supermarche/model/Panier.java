package com.fanass.kata.supermarche.model;


import java.util.ArrayList;
import java.util.List;

public class Panier {
	List<GroupProduit> listGroupProduit= new ArrayList<GroupProduit>();


	public List<GroupProduit> getListGroupProduit() {
		return listGroupProduit;
	}

	public void setListGroupProduit(List<GroupProduit> listGroupProduit) {
		this.listGroupProduit = listGroupProduit;
	}

	
	

}
