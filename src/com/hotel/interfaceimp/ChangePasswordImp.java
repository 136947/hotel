package com.hotel.interfaceimp;

import java.util.List;

import com.hotel.FormService.PasswordService;
import com.hotel.domain.Stuff;
import com.hotel.interfaces.ChangePasswordInter;
import com.hotel.utils.HibernateUtil;

public class ChangePasswordImp implements ChangePasswordInter {

	private HibernateUtil hibernateUtil;
	
	
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}


	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}
	
	@Override
	public List<Stuff> changePassword(
			PasswordService passwordService) {
		// TODO Auto-generated method stub
		String hql = "update Stuff set psw=? where stuffid=11";
		String hql1="from Stuff";
		String[] parameters = {
				passwordService.getPassword()
		};
		String[] parameters1 = null;
		System.out.println("22222222222222");
		hibernateUtil.executeUpdate(hql, parameters);
		List<Stuff>list = hibernateUtil.executeQuery(hql1, parameters1);
		return list;
	}
	public List<Stuff> changePassword1(
			PasswordService passwordService) {
		// TODO Auto-generated method stub
		String hql = "update Stuff set psw=? where stuffid=1";
		String hql1="from Stuff";
		String[] parameters = {
				passwordService.getPassword()
		};
		String[] parameters1 = null;
		
		hibernateUtil.executeUpdate(hql, parameters);
		List<Stuff>list = hibernateUtil.executeQuery(hql1, parameters1);
		return list;
	}

	
}
