package com.cdk.shoppingcart.discount.service;

import com.cdk.shoppingcart.discount.dto.BillDetails;

public interface ProcessBillService {
	
	public BillDetails processBill(Double purchaseAmount);

}
