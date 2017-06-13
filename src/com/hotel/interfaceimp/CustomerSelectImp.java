package com.hotel.interfaceimp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hotel.FormService.SelectCustomerNumber;
import com.hotel.domain.Customer;
import com.hotel.domain.Live;
import com.hotel.domain.Reserve;
import com.hotel.domain.Room;
import com.hotel.interfaces.CustomerSelectInter;
import com.hotel.utils.HibernateUtil;

public class CustomerSelectImp implements CustomerSelectInter {
	
	private HibernateUtil hibernateUtil;
	
	
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}


	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}


	@Override
	public List<Object[]> selectReserveCustomer(SelectCustomerNumber selectCustomerNumber) {
		if(selectCustomerNumber.getCustomerTel1().equals("")){
			String hql = "select b.name,a.tel,b.idCard,d.roomNumber,d.status,a.bookIntoDate,a.bookLeaveDate " +
					"from Reserve a,Customer b,Room d where a.customer.idCard=b.idCard " +
					" and a.room.roomNumber=d.roomNumber and d.status='预定'";
			String[] parameters = null;
			List<Object[]>list = hibernateUtil.executeQuery(hql, parameters);
			return list;
		}
		else{
			String hql = "select distinct b.name,a.tel,b.idCard,d.roomNumber,d.status,a.bookIntoDate,a.bookLeaveDate " +
					"from Reserve a,Customer b,Room d where a.customer.idCard=b.idCard " +
					" and a.room.roomNumber=d.roomNumber and d.status='预定'" +
					"and d.roomNumber=?";
			String[] parameters={
					selectCustomerNumber.getCustomerTel1()
			};
			List<Object[]>list = hibernateUtil.executeQuery(hql, parameters);
			return list;
		}
		
	}



	@Override
	public List<Object[]> selectLiveCustomer(
			SelectCustomerNumber selectCustomerNumber) {
		// TODO Auto-generated method stub
		if(selectCustomerNumber.getCustomerTel1().equals("")){
			String hql = "select b.name,a.tel,b.idCard,d.roomNumber,d.status,a.bookIntoDate,a.bookLeaveDate " +
					"from Live a,Customer b,Room d where a.customer.idCard=b.idCard " +
					" and a.room.roomNumber=d.roomNumber and d.status='入住'";
			String[] parameters = null;
			List<Object[]>list = hibernateUtil.executeQuery(hql, parameters);

			return list;
		}
		else{
			String hql = "select b.name,a.tel,b.idCard,d.roomNumber,d.status,a.bookIntoDate,a.bookLeaveDate " +
					"from Live a,Customer b,Room d where a.customer.idCard=b.idCard " +
					" and a.room.roomNumber=d.roomNumber  and d.status='入住'" +
					"and a.tel=?";
			String[] parameters={
					selectCustomerNumber.getCustomerTel1()
			};
			List<Object[]>list = hibernateUtil.executeQuery(hql, parameters);
			return list;
		}
	}


	@Override
	public void ChangeCustomer(com.hotel.FormService.ChangeCustomer changeCustomer) {
		// TODO Auto-generated method stub
		String hql = "update Customer set name=? , tel=? where idCard = ?";
		String[] parameters = {
				changeCustomer.getName(),				
				changeCustomer.getTel(),
				changeCustomer.getIdcard()
		};
		hibernateUtil.executeUpdate(hql, parameters);
	
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = s.format(changeCustomer.getLiveIntoDate());
		String date2 = s.format(changeCustomer.getLeaveDate());
		if(changeCustomer.getStatus().equals("预定")){
			String hql1 = "update Reserve a set a.bookIntoDate=? , a.bookLeaveDate=? where a.customer.idCard=?";
			String[] parameters1 ={
					date1,
					date2,
					changeCustomer.getIdcard()
			};
			hibernateUtil.executeUpdate(hql1, parameters1);
		}
		else if(changeCustomer.getStatus().equals("入住")){
			String hql2 = "update Live a set a.bookIntoDate=? , a.bookLeaveDate=? where a.customer.idCard=?";
			String[] parameters2 ={
					date1,
					date2,
					changeCustomer.getIdcard()
			};
			hibernateUtil.executeUpdate(hql2, parameters2);		
		}
		
	}



}
