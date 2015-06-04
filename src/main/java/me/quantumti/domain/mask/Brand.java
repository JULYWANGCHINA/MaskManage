package me.quantumti.domain.mask;

import me.quantumti.common.BaseDomain;

public class Brand extends BaseDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7010981041413149643L;
	
	private String brand_name;
	
	public Brand(){}
	
	public Brand(String brand_name){
		this.brand_name = brand_name;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	
}
