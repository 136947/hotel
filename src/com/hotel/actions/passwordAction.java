package com.hotel.actions;

import java.util.List;

import javax.annotation.Resource;
import com.hotel.FormService.PasswordService;
import com.hotel.domain.Stuff;
import com.hotel.interfaces.ChangePasswordInter;
import com.opensymphony.xwork2.ActionContext;
public class passwordAction {
	
	private ChangePasswordInter changePasswordInter;
	
	public ChangePasswordInter getChangePasswordInter() {
		return changePasswordInter;
	}

	public void setChangePasswordInter(ChangePasswordInter changePasswordInter) {
		this.changePasswordInter = changePasswordInter;
	}

	@Resource
	private PasswordService passwordService;
	
	
	public PasswordService getPasswordService() {
		return passwordService;
	}

	public void setPasswordService(PasswordService passwordService) {
		this.passwordService = passwordService;
	}

	public String changePassword(){
		System.out.println("1111111");
		List<Stuff>list = changePasswordInter.changePassword(passwordService);
		ActionContext.getContext().put("list", list);
		return "success";
	}
	public String changePassword1(){
		System.out.println("1111111");
		List<Stuff>list = changePasswordInter.changePassword1(passwordService);
		ActionContext.getContext().put("list", list);
		return "success1";
	}
}
