package com.hotel.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.google.gson.Gson;
import com.hotel.interfaceimp.RoMaImp;
import com.hotel.interfaces.RoMaInt;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.iap.Response;


public class CountAction extends ActionSupport implements ServletRequestAware {
	 private RoMaInt romaint;
	 private RoMaImp romaimp;
	 private HttpServletRequest request;
	 private String result2;
	public String getResult2() {
		return result2;
	}
	public void setResult2(String result2) {
		this.result2 = result2;
	}
	public RoMaInt getRomaint() {
		return romaint;
	}
	public void setRomaint(RoMaInt romaint) {
		this.romaint = romaint;
	}
	public RoMaImp getRomaimp() {
		return romaimp;
	}
	public void setRomaimp(RoMaImp romaimp) {
		this.romaimp = romaimp;
	}
		@Override
		public void setServletRequest(HttpServletRequest request) {
			 this.request = request;
			
		}
		public String pieCount(){
			List<Object[]> list1 = romaint.viewP();
			Map<String,Object> map1 = new HashMap<String,Object>();
			
		for (Object[] obj : list1) {
			if (obj[0].equals("���˼�")) {
				map1.put("���˼�", obj[1]);
			}
			if (obj[0].equals("��׼��")) {
				map1.put("��׼��", obj[1]);
			}
			if (obj[0].equals("�����")) {
				map1.put("�����", obj[1]);
			}
			if (obj[0].equals("�������ⷿ")) {
				map1.put("�������ⷿ", obj[1]);
			}
			if (obj[0].equals("������")) {
				map1.put("������", obj[1]);
			}
			if (obj[0].equals("���˼�")) {
				map1.put("���˼�", obj[1]);
			}
		}
			
			Gson gson = new Gson(); 
			result2 = gson.toJson(map1); 
			System.out.println(result2);
			return SUCCESS;
		}
}
