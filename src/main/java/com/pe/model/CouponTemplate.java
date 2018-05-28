package com.pe.model;



public class CouponTemplate{
	
	public static final String BASE_COLLECTION = "couponTemplate";
	public static final String PROFILE_FIELDNAME = "profile";
	

	private String id;
	private String profile;
	private boolean nominal;
	private Double ammount;
	private Redeemable redeemable;
	private Double minimumTransactionAmmount;
	private Double maximumDiscountAmmount;
	private String targetId;
	private Integer quantity;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public boolean isNominal() {
		return nominal;
	}
	public void setNominal(boolean nominal) {
		this.nominal = nominal;
	}
	public Double getAmmount() {
		return ammount;
	}
	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}
	public Redeemable getRedeemable() {
		return redeemable;
	}
	public void setRedeemable(Redeemable redeemable) {
		this.redeemable = redeemable;
	}
	public Double getMinimumTransactionAmmount() {
		return minimumTransactionAmmount;
	}
	public void setMinimumTransactionAmmount(Double minimumTransactionAmmount) {
		this.minimumTransactionAmmount = minimumTransactionAmmount;
	}
	public Double getMaximumDiscountAmmount() {
		return maximumDiscountAmmount;
	}
	public void setMaximumDiscountAmmount(Double maximumDiscountAmmount) {
		this.maximumDiscountAmmount = maximumDiscountAmmount;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}

