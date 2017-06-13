package com.hotel.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.apache.struts2.util.StrutsUtil;

import com.google.gson.Gson;
import com.hotel.FormService.LeavePayService;
import com.hotel.FormService.LeaveSelectService;
import com.hotel.FormService.LeaveService;
import com.hotel.domain.Customer;
import com.hotel.domain.Live;
import com.hotel.domain.Room;
import com.hotel.interfaces.EconomicInter;
import com.hotel.interfaces.LeaveInter;
import com.opensymphony.xwork2.ActionContext;

public class LeaveAction{
	private EconomicInter economicInter; 
	private LeaveInter leaveInter;
	private int change;
	
	
	

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}

	@Resource
	private LeaveSelectService leaveSelectService;
	@Resource
	private LeaveService leaveService;
	@Resource
	private LeavePayService leavePayService;
	
	public LeavePayService getLeavePayService() {
		return leavePayService;
	}

	public void setLeavePayService(LeavePayService leavePayService) {
		this.leavePayService = leavePayService;
	}

	public EconomicInter getEconomicInter() {
		return economicInter;
	}

	public void setEconomicInter(EconomicInter economicInter) {
		this.economicInter = economicInter;
	}

	public LeaveInter getLeaveInter() {
		return leaveInter;
	}

	public void setLeaveInter(LeaveInter leaveInter) {
		this.leaveInter = leaveInter;
	}

	public LeaveSelectService getLeaveSelectService() {
		return leaveSelectService;
	}

	public void setLeaveSelectService(LeaveSelectService leaveSelectService) {
		this.leaveSelectService = leaveSelectService;
	}

	public LeaveService getLeaveService() {
		return leaveService;
	}

	public void setLeaveService(LeaveService leaveService) {
		this.leaveService = leaveService;
	}

	public String leaveSelect(){
		int count1=0;
		List<Object[]>list1 = leaveInter.SelectRoom(leaveSelectService);
		int allRoomPrise = leaveInter.AllRoomPrice(leaveSelectService);

		System.out.println(allRoomPrise);
		
		ActionContext.getContext().put("allRoomPrise", allRoomPrise);
		ActionContext.getContext().put("list1",list1);
		
		return "success1";
	}
	
	public String leave(){
		
		List<Object[]>list1 = leaveInter.SelectRoom1(leaveService);
		ActionContext.getContext().put("list1",list1);
		change = leaveInter.Change(leaveService);
		Map map = new HashedMap();
		map.put("change", change);
		Gson gson = new Gson();
		gson.toJson(map);
		ActionContext.getContext().put("change", change);
		return "leave";
	}
	
	public String changeStatus(){
		leaveInter.ChangeRoomStatus(leaveService);
		leaveInter.DeleteCustomer(leaveService);
		return "pay";
	}
	
}
