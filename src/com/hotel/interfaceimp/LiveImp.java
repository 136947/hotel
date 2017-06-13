package com.hotel.interfaceimp;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.hotel.FormService.LiveInto;
import com.hotel.FormService.LiveSelectService;
import com.hotel.domain.Customer;
import com.hotel.domain.Live;
import com.hotel.domain.Reserve;
import com.hotel.domain.Room;
import com.hotel.interfaces.Livefor;
import com.hotel.utils.HibernateUtil;
import com.opensymphony.xwork2.ActionContext;

public class LiveImp implements Livefor {
	private HibernateUtil hibernateUtil;
	@Override
	public int liveIn(LiveInto into) {
		Live live = new Live();
		Room room = new Room();
		Customer customer = new Customer();
		customer.setIdCard(into.getIdCard());
		customer.setName(into.getName());
		customer.setTel(into.getTel());
		room.setRoomNumber(Integer.parseInt(into.getRoomNumber()));
		hibernateUtil.save(customer);
		
		live.setRoom(room);
		live.setCustomer(customer);
		live.setName(into.getName());
		live.setBookIntoDate(into.getLiveDate());
		live.setBookLeaveDate(into.getWileaveDate());
		live.setSecurity(Integer.parseInt(into.getSecurity()));
		live.setTel(into.getTel());
		hibernateUtil.save(live);
		String hql = "update Room a set a.status='��ס' where a.roomNumber=?";
		String [] parameters  ={into.getRoomNumber()};
		hibernateUtil.executeUpdate(hql, parameters);
		return 1;
	}
	@Override
	//δԤ���ͻ���ס
	public List live(LiveSelectService liveselect) {
		    Date date = new Date();
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//���Է�����޸����ڸ�ʽ
		    String now = dateFormat.format(date);
			String hql = "select a.roomNumber,b.roomTypeName,c.roomPrice,a.status,b.roomIntroduce from Room a,Roomtype b,Roomprice c where a.roomtype.roomTypeId=b.roomTypeId and c.roomtype.roomTypeId=b.roomTypeId and b.roomTypeId=? and a.floor=? and c.roomPrice>=? and c.roomPrice<=? and a.status='空闲' and c.priceDate=?";
			String parameters[]={
					liveselect.getRoomTypeId(),
					liveselect.getFloor(),
					liveselect.getRoomPrice1(),
					liveselect.getRoomPrice2(),
					now
			};
			List<Object[]>  list = hibernateUtil.executeQuery(hql, parameters);
			
			return list;
		
	}
	//�Ѿ�Ԥ���Ŀͻ�������ס
	public List roomlive(LiveSelectService liveselect){
		
		String hql = "from Reserve a where a.room.roomNumber=?"; 
		String[] parameters = { liveselect.getRoomNumber() };
		List<Reserve> list=  hibernateUtil.executeQuery(hql, parameters);
		
	    return list;
		
	}
    public void insert(Live live){
    	hibernateUtil.save(live);
    }
    public void update(LiveInto liveInto){
    	
    	String room  = liveInto.getRoomNumber();
    	String name = liveInto.getName();
    	String idCard = liveInto.getIdCard();
    	String hql1 = "update Room a set a.status='入住' where a.roomNumber=?";
    	String hql2 = "delete Reserve a where a.room.roomNumber=?";
    	String hql3 = "update Customer a set a.name=? where a.idCard=?";
    	String   parameters1[]={
    		room
    	};
    	String parameters2[]={
    			room
    	};
    	String parameters3[]={
    			name,
    			idCard
    	};
    	hibernateUtil.executeUpdate(hql1, parameters1);
    	hibernateUtil.executeUpdate(hql2, parameters2);
    	hibernateUtil.executeUpdate(hql3, parameters3);
    	
    }

	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}
}
