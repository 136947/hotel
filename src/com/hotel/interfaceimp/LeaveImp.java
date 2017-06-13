package com.hotel.interfaceimp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hotel.FormService.BookSelectService;
import com.hotel.FormService.BookService;
import com.hotel.FormService.LeavePayService;
import com.hotel.FormService.LeaveSelectService;
import com.hotel.FormService.LeaveService;
import com.hotel.domain.Cost;
import com.hotel.domain.Customer;
import com.hotel.domain.Live;
import com.hotel.domain.Reserve;
import com.hotel.domain.Room;
import com.hotel.domain.Roomtype;
import com.hotel.interfaces.EconomicInter;
import com.hotel.interfaces.LeaveInter;
import com.hotel.utils.HibernateUtil;

public class LeaveImp implements LeaveInter {
	private HibernateUtil hibernateUtil;
	
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	@Override
	public void ChangeRoomStatus(LeaveService leaveService) {
		// TODO Auto-generated method stub
		String hql = "update Room set status='空闲' where roomNumber=?";
		String[] parameters = {
				leaveService.getRoomNumber()
		};
		hibernateUtil.executeUpdate(hql, parameters);
	}

	@Override
	public List<Object[]> SelectRoom(LeaveSelectService leaveSelectService) {
		// TODO Auto-generated method stub
		if(RoomNull(leaveSelectService)){
			String roomNumber1 = leaveSelectService.getSelect()+"";
			String hql="select a.roomNumber,a.status,c.name,b.idCard,b.tel," +
					"c.security,c.consume,c.bookIntoDate,c.bookLeaveDate " +
					"from Room a,Customer b,Live c " +
					"where c.customer.idCard=b.idCard and a.roomNumber=c.room.roomNumber " +
					" and a.roomNumber=? and a.status='入住'";
			String[] parameters={leaveSelectService.getSelect() };
			List<Object[]> list = hibernateUtil.executeQuery(hql, parameters);
			
			return list;	
		}
		else{
			return null;
		}
	}
	//����
	//@Override
	public int Change(LeaveService leaveService) {
		// TODO Auto-generated method stub
		if(leaveService.getPay().equals("")){
			return 0;
		}
		else{
			int pay = Integer.parseInt(leaveService.getPay());//����
			int security = Integer.parseInt(leaveService.getSecurity());//Ѻ��
			int allRoomPrise = Integer.parseInt(leaveService.getTotalPrice());//�ܷ���
			System.out.println("pay="+pay);
			System.out.println("security="+security);
			System.out.println("allRoomPrise="+allRoomPrise);
			int change = pay+security-allRoomPrise;
			System.out.println("change="+change);
			Live live = new Live();
			String hql ="update Live set consume=? where tel=?";
			String[] parameters={
				allRoomPrise+"",
				leaveService.getTel()
			};
			hibernateUtil.executeUpdate(hql, parameters);
			return change;
		}
	}


	@Override
	public void DeleteCustomer(LeaveService leaveService) {
		// TODO Auto-generated method stub
		String hql1 = "delete from Live where idCard=?";
		
	/*	String hql = "delete from Customer where idCard=?";*/
		String[] parameters = {
				leaveService.getIdCard()
		};
		String hql2 = "select b.roomTypeName from Room a,Roomtype b where a.roomtype.roomTypeId=b.roomTypeId " +
				"and a.roomNumber=?";
		String[] parameters1={
				leaveService.getRoomNumber()
		};
		List<String>list = hibernateUtil.executeQuery(hql2, parameters1);
		String roomName=null;
		for(String object:list){
			System.out.println(object);
			roomName=object;
		}
		System.out.println(roomName);
		Cost cost = new Cost();
		int money = Integer.parseInt(leaveService.getTotalPrice());
		cost.setDate(leaveService.getLeaveDate());
		cost.setMoney(money);
		cost.setRoomTypeName(roomName);
		hibernateUtil.save(cost);
		hibernateUtil.executeUpdate(hql1, parameters);
		/*hibernateUtil.executeUpdate(hql, parameters);*/
	}

	@Override
	public int AllRoomPrice(LeaveSelectService leaveSelectService) {
		// TODO Auto-generated method stub
		Date date1 = null;
		Date date2 = null;
		List<Object[]>list = SelectRoom(leaveSelectService);
		for(Object[] object:list){
			date1=(Date) object[8];
			date2=(Date) object[7];
		}
		if(date1 != null && date2 != null){
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
			String date3 = s.format(date1);//ʵ���뿪����
			String date4 = s.format(date2);//ס������

			String hql="select a.roomPrice from Roomprice a,Roomtype b,Room c,Live d " +
				"where a.roomtype.roomTypeId=b.roomTypeId and c.roomtype.roomTypeId = b.roomTypeId " +
				"and d.room.roomNumber=c.roomNumber" +
				" and a.priceDate between ? and ? ";
			String[] parameters={
				date4,
				date3
			};
			List<Integer>list1 = hibernateUtil.executeQuery(hql, parameters);
		
			int price = 0;
			int price1 = 0;
			for(Integer object:list1){
				price = object;
				System.out.println("price="+object);
				price1+=price;
			}
			System.out.println("price1="+price1);
			return price1;
		}else{
			return 0;
		}
	}

	@Override
	public Boolean RoomNull(LeaveSelectService leaveSelectService) {
		// TODO Auto-generated method stub
		String hql = "from Room where roomNumber=? and status='入住'";
		String[] parameters = {
				leaveSelectService.getSelect()
		};
		List<Room> list = hibernateUtil.executeQuery(hql, parameters);
		if(list != null){
			return true;
		}
		else
			return false;
	}

	@Override
	public List<Object[]> SelectRoom1(LeaveService leaveService) {
		// TODO Auto-generated method stub
		String hql="select a.roomNumber,a.status,c.name,b.idCard,b.tel," +
				"c.security,c.consume,c.bookIntoDate,c.bookLeaveDate " +
				"from Room a,Customer b,Live c " +
				"where c.customer.idCard=b.idCard and a.roomNumber=c.room.roomNumber " +
				" and a.roomNumber=?";
		String[] parameters={leaveService.getRoomNumber() };
		List<Object[]> list = hibernateUtil.executeQuery(hql, parameters);
		return list;
	}


}
