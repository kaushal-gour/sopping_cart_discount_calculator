package com.cdk.shoppingcart.discount.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="discount")
@Component
public class PropertyCofig {
	
	private Map<String, List<Double>> discountRangeMap;
	
	private Map<String, Double> discountMap;
	

	public Map<String, List<Double>> getDiscountRangeMap() {
		return discountRangeMap;
	}

	public void setDiscountRangeMap(Map<String, List<Double>> discountRangeMap) {
		this.discountRangeMap = discountRangeMap;
	}

	public Map<String, Double> getDiscountMap() {
		return discountMap;
	}

	public void setDiscountMap(Map<String, Double> discountMap) {
		this.discountMap = discountMap;
	}
	
	
	

}
