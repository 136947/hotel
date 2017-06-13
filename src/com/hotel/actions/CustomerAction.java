package com.hotel.actions;

import java.util.List;

import javax.annotation.Resource;

import com.hotel.FormService.ChangeCustomer;
import com.hotel.FormService.SelectCustomerNumber;
import com.hotel.interfaceimp.CustomerSelectImp;
import com.hotel.interfaces.CustomerSelectInter;
import com.opensymphony.xwork2.ActionContext;

public class CustomerAction {
	
	
	private CustomerSelectInter customerSelectInter;
	private CustomerSelectImp customerSelectImp;
	
	@Resource
	private SelectCustomerNumber selectCustomerNumber;
	
	@Resource
	private ChangeCustomer changeCustomer;
	
	public ChangeCustomer getChangeCustomer() {
		return changeCustomer;
	}

	public void setChangeCustomer(ChangeCustomer changeCustomer) {
		this.changeCustomer = changeCustomer;
	}

	public CustomerSelectInter getCustomerSelectInter() {
		return customerSelectInter;
	}



	public void setCustomerSelectInter(CustomerSelectInter customerSelectInter) {
		this.customerSelectInter = customerSelectInter;
	}



	public CustomerSelectImp getCustomerSelectImp() {
		return customerSelectImp;
	}



	public void setCustomerSelectImp(CustomerSelectImp customerSelectImp) {
		this.customerSelectImp = customerSelectImp;
	}



	public SelectCustomerNumber getSelectCustomerNumber() {
		return selectCustomerNumber;
	}



	public void setSelectCustomerNumber(SelectCustomerNumber selectCustomerNumber) {
		this.selectCustomerNumber = selectCustomerNumber;
	}



	public String selectCustomer(){
		List<Object[]>list1 = customerSelectInter.selectReserveCustomer(selectCustomerNumber);		
		List<Object[]>list2 = customerSelectInter.selectLiveCustomer(selectCustomerNumber);

		ActionContext.getContext().put("list1111", list1);
		ActionContext.getContext().put("list2222", list2);
		return"customer";
	}
	
	public String changeCustomer(){
		customerSelectInter.ChangeCustomer(changeCustomer);

		return "change";
	}
	
	public String manageSelectCustomer(){
		List<Object[]>list1 = customerSelectInter.selectReserveCustomer(selectCustomerNumber);		
		List<Object[]>list2 = customerSelectInter.selectLiveCustomer(selectCustomerNumber);

		ActionContext.getContext().put("list1111", list1);
		ActionContext.getContext().put("list2222", list2);
		return "manage";
	}
	public String manageChangeCustomer(){
		customerSelectInter.ChangeCustomer(changeCustomer);
		return "manage1";
	}
}
