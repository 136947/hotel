package com.hotel.interfaceimp;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.hotel.FormService.PriceService;
import com.hotel.domain.Roomprice;
import com.hotel.domain.Roomtype;
import com.hotel.interfaces.modifyInt;
import com.hotel.utils.HibernateUtil;

public class modifyImp implements modifyInt{
	private HibernateUtil hibernateUtil;
    public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}
	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}
	public void manage(PriceService priceService){
		int price = Integer.parseInt(priceService.getPrice());
		int roomtype = Integer.parseInt(priceService.getRoomType());
		Date modifyDate =  priceService.getModifyDate();
		System.out.println("�۸�"+price);
		System.out.println("��������"+roomtype);
		System.out.println("��������"+modifyDate);
		
		
	    Roomprice roomprice = new Roomprice();
	    Roomtype room = new Roomtype ();
	    room.setRoomTypeId(roomtype);
	    roomprice.setRoomPrice(price);
	    roomprice.setRoomtype(room);
	    roomprice.setPriceDate(modifyDate);
	    //String now = modifyDate.toString();

	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//���Է�����޸����ڸ�ʽ
	    String now = dateFormat.format(modifyDate);
	    String hql = "select a.roomPrice from Roomprice a where a.priceDate=?";
	    String hql2 = "update Roomprice a set a.roomPrice=? where a.priceDate=? and a.roomtype.roomTypeId=?";
	    String parameters[] = {now};
	    String parameters1[] = {priceService.getPrice(),now,priceService.getRoomType()};
	    int i =hibernateUtil.isExist(hql, parameters);
	    if(i==0){
	       hibernateUtil.save(roomprice);
	    }else{
	    	hibernateUtil.executeUpdate(hql2, parameters1);
	    }
	    
		
    	 
    }
}
