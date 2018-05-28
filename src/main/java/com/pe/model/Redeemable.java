package com.pe.model;

import java.util.List;

public class Redeemable{
	
	public static final String BUSINESS_TYPE_FIELDNAME = "businessType";
	public static final String COMMERCE_FIELDNAME = "commerce";
	public static final String STORE_FIELDNAME = "stores";
	
	private String businessType;
	private List<String> commerce;
	private List<String> stores;
	
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public List<String> getCommerce() {
		return commerce;
	}
	public void setCommerce(List<String> commerce) {
		this.commerce = commerce;
	}
	public List<String> getStores() {
		return stores;
	}
	public void setStores(List<String> stores) {
		this.stores = stores;
	}
	
}
