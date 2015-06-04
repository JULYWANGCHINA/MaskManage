package me.quantumti.domain.mask;

import org.springframework.util.StringUtils;

import me.quantumti.common.BaseDomain;

public class MaskDetail extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2994836865407004016L;
	
	private String maskName;
	private String effect;
	private String barCode;
	private String maskMin;
	private String maskMax;
	private String maskTime;
	private String address;
	
	private Brand brand;
	
	
	public String getMaskName() {
		return maskName;
	}
	public void setMaskName(String maskName) {
		this.maskName = maskName;
	}
	public String getEffect() {
		if(StringUtils.isEmpty(effect))
			effect= "";
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public String getBarCode() {
		if(StringUtils.isEmpty(barCode))
			barCode= "";
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getMaskMin() {
		if(StringUtils.isEmpty(maskMin))
			maskMin= "";
		return maskMin;
	}
	public void setMaskMin(String maskMin) {
		this.maskMin = maskMin;
	}
	public String getMaskMax() {
		if(StringUtils.isEmpty(maskMax))
			maskMax = "";
		return maskMax;
	}
	public void setMaskMax(String maskMax) {
		this.maskMax = maskMax;
	}
	public String getMaskTime() {
		if(StringUtils.isEmpty(maskTime))
			maskTime = "";
		return maskTime;
	}
	public void setMaskTime(String maskTime) {
		this.maskTime = maskTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

}
