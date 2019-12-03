package com.cdk.shoppingcart.discount.dto;

public class BillDetails {
	
	private Double purchaseAmount;
	private Double billAmount;
	private Double discount;
	
	public BillDetails(Double purchaseAmount, Double billAmount, Double discount) {
		this.purchaseAmount = purchaseAmount;
		this.billAmount = billAmount;
		this.discount = discount;
	}
	
	public Double getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(Double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public Double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	

}
