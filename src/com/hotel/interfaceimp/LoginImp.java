package com.hotel.interfaceimp;

import java.util.List;

import com.hotel.FormService.LoginService;
import com.hotel.domain.Stuff;
import com.hotel.interfaces.LoginInter;
import com.hotel.utils.HibernateUtil;

public class LoginImp implements LoginInter {

	private HibernateUtil hibernateUtil;
	
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	@Override
	public int check(LoginService loginService) {
		// TODO Auto-generated method stub
		System.out.println(loginService.getName());
		System.out.println(loginService.getPassword());
		String hql = "from Stuff a where a.psw=?";
		String[] parameters = {
				loginService.getPassword()
		};
		List<Stuff>list = hibernateUtil.executeQuery(hql, parameters);
		
		String name=null;
		int name1=0;
		int count = 0;//�û������벻��ȷ
		for(Stuff stuff:list){
			name = stuff.getPosition();
			name1 = stuff.getStuffId();
			count++;
		}

		int id=Integer.parseInt(loginService.getName());

		if(count>0){
			if(id==name1&& name.equals("酒店经理")){
				count=1;//�Ƶ꾭��
			}
			else if(id==name1 && name.equals("酒店客服")){
				count = 2;//�Ƶ�ͷ�
			}
		}
		return count;
	}

}
