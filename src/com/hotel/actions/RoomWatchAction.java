package com.hotel.actions;

import java.util.List;

import javax.annotation.Resource;

import com.hotel.FormService.WatchSelectService;
import com.hotel.interfaces.RoomWacthInter;
import com.opensymphony.xwork2.ActionContext;

public class RoomWatchAction {
	private RoomWacthInter roomWatchInter;
	@Resource
	private WatchSelectService watchSelectService;
	public RoomWacthInter getRoomWatchInter() {
		return roomWatchInter;
	}
	public void setRoomWatchInter(RoomWacthInter roomWatchInter) {
		this.roomWatchInter = roomWatchInter;
	}
	public WatchSelectService getWatchSelectService() {
		return watchSelectService;
	}
	public void setWatchSelectService(WatchSelectService watchSelectService) {
		this.watchSelectService = watchSelectService;
	}
	
	public String roomWatch(){
		
		List<Object[]>list = roomWatchInter.RoomWatch(watchSelectService);

		ActionContext.getContext().put("list1", list);
		return "success";
	}
public String roomWatch1(){
		
		List<Object[]>list = roomWatchInter.RoomWatch(watchSelectService);

		ActionContext.getContext().put("list1", list);
		return "success1";
	}
}
