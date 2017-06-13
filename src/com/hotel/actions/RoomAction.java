package com.hotel.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.hotel.FormService.AddRoomService;
import com.hotel.FormService.GsService;
import com.hotel.FormService.RoomViewService;
import com.hotel.domain.Reserve;
import com.hotel.interfaceimp.ResultUtils;
import com.hotel.interfaceimp.RoMaImp;
import com.hotel.interfaces.RoMaInt;
import com.opensymphony.xwork2.ActionContext;

public class RoomAction {
   private RoMaInt romaint;
   private RoMaImp romaimp;
   @Resource
   private RoomViewService roomview;
   @Resource
   private GsService gsService;
   @Resource
   private AddRoomService room;
public AddRoomService getRoom() {
	return room;
}
public void setRoom(AddRoomService room) {
	this.room = room;
}
public GsService getGsService() {
	return gsService;
}
public void setGsService(GsService gsService) {
	this.gsService = gsService;
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
public RoomViewService getRoomview() {
	return roomview;
}
public void setRoomview(RoomViewService roomview) {
	this.roomview = roomview;
}
public String check(){
	//���������Ͳ�ѯͳ��
	if(roomview.getCheckStyle().equals("2")){
		List<Object[]> list = romaint.view1(roomview);
		
		ActionContext.getContext().put("list",list);
		ActionContext.getContext().put("key",2);
		return "success";
	}
	else if(roomview.getCheckStyle().equals("3")){
        List<Object[]> list = romaint.view4();
		
		ActionContext.getContext().put("list",list);
		ActionContext.getContext().put("key",4);
		return "success";
	}
	//��Ԥ����ѯ
	else if(roomview.getCheckStyle().equals("4")){
        List<Reserve> list = romaint.view5();
		
		ActionContext.getContext().put("list",list);
		ActionContext.getContext().put("key",5);
		return "success";
	}
	
	//�����з����ѯ
	else if(roomview.getCheckStyle().equals("5")){
        List<Object[]> list = romaint.view8();
		
		ActionContext.getContext().put("list",list);
		ActionContext.getContext().put("key",6);
		return "success";
	}
	//���������Ͳ�ѯͳ��
	else if(roomview.getRoomNumber().equals("")){
		List<Object[]> list = romaint.view2(roomview);
	    
		ActionContext.getContext().put("list",list);
		ActionContext.getContext().put("key",1);
		return "success";
	}
	//�����������ѯͳ��
	else{
		List<Object[]> list = romaint.view3(roomview);
		ActionContext.getContext().put("list",list);
		ActionContext.getContext().put("key",3);
	}
	return "success";
	
}

public String check2(){
	romaint.view6(gsService);
	return "success";
}
   
//ɾ��ѡ����Ԥ����¼
public String check3(){
	romaint.view7(gsService);
	return "success";
}

//���ӿͷ���¼
public String check4(){
	romaint.view9(room);
	return "success";
}


//�޸Ŀͷ���¼
public String check5(){
	romaint.view10(room);
	return "success";
}
//ɾ���ͷ�
public String check6(){
	romaint.view11(room);
	return "success";
}
}
