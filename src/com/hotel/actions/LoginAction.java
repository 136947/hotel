package com.hotel.actions;

import javax.annotation.Resource;

import com.hotel.FormService.LoginService;
import com.hotel.interfaces.LoginInter;

public class LoginAction {
	
	private LoginInter loginInter;
	@Resource
	private LoginService loginService;
	
	public LoginInter getLoginInter() {
		return loginInter;
	}
	public void setLoginInter(LoginInter loginInter) {
		this.loginInter = loginInter;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	public String checkStuff(){
		int count = loginInter.check(loginService);
		System.out.println("count="+count);
		if(count==1){
			return "manage";
		}
		if(count == 2)
			return "assistant";
		return "success";
	}
}
