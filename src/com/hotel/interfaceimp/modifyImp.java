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
		System.out.println("价格"+price);
		System.out.println("房间类型"+roomtype);
		System.out.println("房间日期"+modifyDate);
		
		
	    Roomprice roomprice = new Roomprice();
	    Roomtype room = new Roomtype ();
	    room.setRoomTypeId(roomtype);
	    roomprice.setRoomPrice(price);
	    roomprice.setRoomtype(room);
	    roomprice.setPriceDate(modifyDate);
	    //String now = modifyDate.toString();

	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
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
