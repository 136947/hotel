package com.hotel.actions;

import javax.annotation.Resource;

import com.hotel.FormService.PriceService;
import com.hotel.interfaceimp.modifyImp;
import com.hotel.interfaces.modifyInt;

public class PriceAction {
	@Resource
	private PriceService priceService;
	
	private modifyInt modifyint;
	private modifyImp  modifyimp; 
	
	public modifyImp getModifyimp() {
		return modifyimp;
	}

	public void setModifyimp(modifyImp modifyimp) {
		this.modifyimp = modifyimp;
	}

    public modifyInt getModifyint() {
		return modifyint;
	}

	public void setModifyint(modifyInt modifyint) {
		this.modifyint = modifyint;
	}
	public PriceService getPriceService() {
		return priceService;
	}

	public void setPriceService(PriceService priceService) {
		this.priceService = priceService;
	}

	public String modifyPrice(){
		modifyint.manage(priceService);
    	return "success";
    }
}
