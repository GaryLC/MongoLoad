package com.pe.model;

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable{


	private static final long serialVersionUID = 3236696212989637617L;
	public static final String BASE_COLLECTION = "customer";
	

	private String id;

	private String customerId;
	private List<String> profiles;
	private Integer invoicePeriod;
	private String name;
	private String lastName;
	private boolean active;
	
	
	public Customer() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getProfiles() {
		return profiles;
	}
	public void setProfiles(List<String> profiles) {
		this.profiles = profiles;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Integer getInvoicePeriod() {
		return invoicePeriod;
	}
	public void setInvoicePeriod(Integer invoicePeriod) {
		this.invoicePeriod = invoicePeriod;
	}
}