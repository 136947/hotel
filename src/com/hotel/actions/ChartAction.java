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


public class ChartAction extends ActionSupport implements ServletRequestAware {
	 private RoMaInt romaint;
	 private RoMaImp romaimp;
	 private HttpServletRequest request;
	 private String result;
	 private String result2;
	public String getResult2() {
		return result2;
	}
	public void setResult2(String result2) {
		this.result2 = result2;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
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
		//将返回的数据封装成Map对象
		public String count() throws IOException {
			Map<String,Object> map = new HashMap<String,Object>();
			List<Object[]> list = romaint.viewt();
			for(Object[] obj:list){
			    System.out.println(obj[0]);
				System.out.println(obj[1]);
				if(obj[0].equals("预定")){
					map.put("预定",obj[1]);
					System.out.println("预定"+obj[1]);
				}
				if(obj[0].equals("空闲")){
					map.put("空闲",obj[1]);
				}
				if(obj[0].equals("入住")){
					map.put("入住",obj[1]);
				}
				if(obj[0].equals("暂停使用")){
					map.put("暂停使用", obj[1]);
				}
			}
			Gson gson = new Gson(); 
			result = gson.toJson(map);
	        System.out.println(result);
			return SUCCESS;
		}
		@Override
		public void setServletRequest(HttpServletRequest request) {
			 this.request = request;
			
		}
		public String pieCount(){
			List<Object[]> list1 = romaint.viewP();
			Map<String,Object> map1 = new HashMap<String,Object>();
			
		for (Object[] obj : list1) {
			if (obj[0].equals("单人间")) {
				map1.put("单人间", obj[1]);
			}
			if (obj[0].equals("标准间")) {
				map1.put("标准间", obj[1]);
			}
			if (obj[0].equals("商务间")) {
				map1.put("商务间", obj[1]);
			}
			if (obj[0].equals("情侣主题房")) {
				map1.put("情侣主题房", obj[1]);
			}
			if (obj[0].equals("豪华房")) {
				map1.put("豪华房", obj[1]);
			}
			if (obj[0].equals("三人间")) {
				map1.put("三人间", obj[1]);
			}
		}
			
			Gson gson = new Gson(); 
			result2 = gson.toJson(map1); 
			System.out.println(result2);
			return SUCCESS;
		}
}
