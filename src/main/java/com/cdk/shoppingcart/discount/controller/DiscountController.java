package com.cdk.shoppingcart.discount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdk.shoppingcart.discount.config.PropertyCofig;
import com.cdk.shoppingcart.discount.dto.BillDetails;
import com.cdk.shoppingcart.discount.service.ProcessBillService;

@RestController
@RequestMapping("/discountService/api/v1")
public class DiscountController {
	
	@Autowired
	ProcessBillService billService;
	
	@Autowired
	PropertyCofig config;
	
	@GetMapping(value = "/amount/{purchaseAmount}")
	public ResponseEntity<BillDetails> calculateDiscount(@PathVariable Double purchaseAmount) {
		
		if( null == purchaseAmount || 0 >= purchaseAmount || config.getMAX_PURCHASE_AMOUNT() <= purchaseAmount) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		BillDetails billDetails = billService.processBill(purchaseAmount);
		
		if(billDetails == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<BillDetails>(billDetails, HttpStatus.OK);
		
	}

}
