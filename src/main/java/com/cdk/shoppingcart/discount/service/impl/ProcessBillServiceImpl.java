package com.cdk.shoppingcart.discount.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdk.shoppingcart.discount.config.PropertyCofig;
import com.cdk.shoppingcart.discount.dto.BillDetails;
import com.cdk.shoppingcart.discount.service.ProcessBillService;


@Service
public class ProcessBillServiceImpl implements ProcessBillService{
	
	@Autowired
	PropertyCofig config;

	@Override
	public BillDetails processBill(Double purchaseAmount) {
		
		double billAmount = purchaseAmount;
		double discountPercentage = getDiscount(purchaseAmount);
		if(discountPercentage >=0) {
			double dicountAmount = (purchaseAmount * discountPercentage) /100;
			billAmount = purchaseAmount - dicountAmount;
		}
		
		BillDetails billDetails = new BillDetails(purchaseAmount, billAmount, discountPercentage);
		
		return billDetails;
	}
	
	
	
	private double getDiscount(Double purchaseAmount) {
		Map<String, List<Double>> rangeMap = config.getDiscountRangeMap();
		
		Map<String, Double> discountMap = config.getDiscountMap();
		
		for(String range : rangeMap.keySet()) {
			if(purchaseAmount>= rangeMap.get(range).get(0) && purchaseAmount <= rangeMap.get(range).get(1)) {
				return discountMap.get(range);
			}
		}
		
		return 0;
		
		
		/*if(purchaseAmount>=map.get("RANGE1.LOWER") && purchaseAmount<=map.get("RANGE1.UPPER")) {
			return map.get("RANGE1");
		} else if(purchaseAmount>=map.get("RANGE2.LOWER") && purchaseAmount<=map.get("RANGE2.UPPER")) {
			return map.get("RANGE2");
		} else {
			return map.get("RANGE3");
		}*/
	}

}
