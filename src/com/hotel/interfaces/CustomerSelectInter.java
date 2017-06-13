package com.hotel.interfaces;

import java.util.List;

import com.hotel.FormService.SelectCustomerNumber;
import com.hotel.FormService.ChangeCustomer;
import com.hotel.domain.Customer;
import com.hotel.domain.Live;
import com.hotel.domain.Reserve;
import com.hotel.domain.Room;

public interface CustomerSelectInter {
	public List<Object[]> selectReserveCustomer(SelectCustomerNumber selectCustomerNumber);
	public List<Object[]> selectLiveCustomer(SelectCustomerNumber selectCustomerNumber);
	public void ChangeCustomer(ChangeCustomer changeCustomer);
}
