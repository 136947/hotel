package com.hotel.interfaceimp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hotel.FormService.AddRoomService;
import com.hotel.FormService.GsService;
import com.hotel.FormService.RoomViewService;
import com.hotel.domain.Reserve;
import com.hotel.domain.Room;
import com.hotel.domain.Roomtype;
import com.hotel.interfaces.RoMaInt;
import com.hotel.utils.HibernateUtil;

public class RoMaImp implements RoMaInt {

    private HibernateUtil hibernateUtil;
    
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	//所有类
	@Override
	public List view1(RoomViewService roomViewService) {
		String roomTypeId = roomViewService.getRoomTypeId();
		String hql = "select a.status,count(a.status) from Room a ,Roomtype b where a.roomtype.roomTypeId=b.roomTypeId Group by a.status";
		
		List<Object[]> list = hibernateUtil.executeQuery(hql,null);
		return list;
		
	}
 
	//同类
	@Override
	public List view2(RoomViewService roomViewService) {
		String roomTypeId = roomViewService.getRoomTypeId();
		String hql = "select b.roomTypeName,a.status,count(a.status) from Room a ,Roomtype b where a.roomtype.roomTypeId=b.roomTypeId and b.roomTypeId=? Group by a.status";
		 
		String parameters[] = {roomTypeId};
		List<Object[]> list = hibernateUtil.executeQuery(hql, parameters);
		return list;
	}

	//单个
	@Override
	public List view3(RoomViewService roomViewService) {
		String roomNumber = roomViewService.getRoomNumber();
		String hql = "select a.roomNumber,b.roomTypeName,a.floor,a.status from Room a,Roomtype b where a.roomtype.roomTypeId=b.roomTypeId and a.roomNumber=?";
		String parameter[]= {roomNumber};
		List<Object[]> list = hibernateUtil.executeQuery(hql,parameter);
		return list;
	}
	
	//入住所有具体信息
	public List view4(){
		
		String hql = "select a.roomNumber,b.roomTypeName,a.status,c.name,c.tel,c.bookIntoDate,c.bookLeaveDate from Room a,Roomtype b,Live c where a.roomtype.roomTypeId=b.roomTypeId and c.room.roomNumber=a.roomNumber";
		List<Object[]> list = hibernateUtil.executeQuery(hql,null);
		return list;
		
	}
	//预定具体信息
	 public List view5(){
		 String hql  = "select a.room.roomNumber,b.tel,b.idCard,a.bookIntoDate from Reserve a,Customer b where a.customer.idCard=b.idCard";
		 List<Reserve> list = hibernateUtil.executeQuery(hql,null);
		return list;
		 
	 }
	    //修改预定信息
	 public void view6(GsService gsService){
		String tel = gsService.getTel();
		String idCard = gsService.getIdCard();
		Date bookIntoDate = gsService.getBookIntoDate();
		SimpleDateFormat fs = new SimpleDateFormat("yyyy-MM-dd");
		String s = fs.format(bookIntoDate);
		String hql = "update Reserve a set a.tel=?,a.bookIntoDate=? where a.customer.idCard=?";
		String parameters[] = {tel,s,idCard};
		String hql1 = "update Customer b set b.tel=? where b.idCard=?";
		String parameters1[] = {tel,idCard};
	    hibernateUtil.executeUpdate(hql,parameters);
	    hibernateUtil.executeUpdate(hql1, parameters1);
		 
	 }
	 
	 public void view7(GsService gsService){
		 String idCard = gsService.getIdCard();
		 String roomNum = gsService.getRoomNum();
		 String hql = "delete from Reserve a where a.customer.idCard=?";
		 String parameters[] = {idCard};
		 hibernateUtil.executeUpdate(hql,parameters);
		 String hql2 = "delete from Customer b where b.idCard=?";
		 hibernateUtil.executeUpdate(hql2,parameters);
		 String hql3 = "update Room a set a.status='空闲' where a.roomNumber=?";
		 String parameters1[] = {roomNum};
		 hibernateUtil.executeUpdate(hql3,parameters1);
		 
		 
	 }
	 //空房间查询
	 public List view8(){
		String hql = "select a.roomNumber,b.roomTypeName,a.floor,a.status from Room a,Roomtype b where a.roomtype.roomTypeId=b.roomTypeId and a.status='空闲'";
		List<Object[]> list =hibernateUtil.executeQuery(hql,null);
		return list;
	 }
	//增加客房
 public void view9(AddRoomService room){
	    int roomNumber = Integer.parseInt(room.getRoomNumber());
	    int roomtype = Integer.parseInt(room.getRoomType());
	    int floor = Integer.parseInt(room.getFloor());
	    Room r = new Room();
	    Roomtype type = new Roomtype();
	    type.setRoomTypeId(roomtype);
	    r.setRoomNumber(roomNumber);
	    r.setRoomtype(type);
	    r.setFloor(floor);
	    r.setStatus("空闲");
	    System.out.println(r.getRoomNumber());
	    System.out.println(r.getRoomtype());
	    System.out.println(r.getFloor());
	    System.out.println(r.getStatus());
	    String hql = "select a.roomNumber from Room a where a.roomNumber=?";
	    String parameters[] = {room.getRoomNumber()};
	    int i = hibernateUtil.isExist(hql, parameters);
	    if(i==0)
	    hibernateUtil.save(r);
	    else
	    	return;
	    
 }
 //修改客房
 public void view10(AddRoomService room){
	 String roomNumber = room.getRoomNumber();
	 String roomTypeId = room.getRoomType();
	 String status =  room.getStatus();
	 String hql = "update Room a set a.roomtype.roomTypeId=?,a.status=? where a.roomNumber=?";
	 String parameters[] = {room.getRoomType(),room.getStatus(),roomNumber};
	 hibernateUtil.executeUpdate(hql, parameters);
 }
 //删除客房
 public void view11(AddRoomService room){
	 String roomNumber = room.getRoomNumber();
	 String hql = "delete from Room a where a.roomNumber=?";
	 String parameters[] = {roomNumber};
	 hibernateUtil.executeUpdate(hql, parameters);
	 
 }
 
 
//图表
	@Override
	public List viewt() {
		String hql = "select a.status,count(a.status) from Room a ,Roomtype b where a.roomtype.roomTypeId=b.roomTypeId Group by a.status";
        
		List<Object[]> list = hibernateUtil.executeQuery(hql,null);
		return list;
	}

	@Override
	public List viewP() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String s = df.format(date);
		String hql = "select a.roomTypeName,sum(a.money) from Cost a where a.date=? Group by a.roomTypeName";
        String parameters[] = {s};
		//System.out.println(s);
		List<Object[]> list = hibernateUtil.executeQuery(hql,parameters);
		/*for(Object[] obj:list){
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}*/
		return list;
	}
	
	
}
                          