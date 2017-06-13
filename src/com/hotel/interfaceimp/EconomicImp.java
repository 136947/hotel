package com.hotel.interfaceimp;

import java.text.SimpleDateFormat;
import java.util.List;

import com.hotel.FormService.BookSelectService;
import com.hotel.FormService.BookService;
import com.hotel.domain.Customer;
import com.hotel.domain.Reserve;
import com.hotel.domain.Room;
import com.hotel.domain.Stuff;
import com.hotel.interfaces.EconomicInter;
import com.hotel.utils.HibernateUtil;

public class EconomicImp implements EconomicInter {
	private HibernateUtil hibernateUtil;
	
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}

	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}

	@Override
	public List<Object[]> book(BookSelectService bookSelectService) {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String date1=date.format(bookSelectService.getBookLiveDate());
		if(bookSelectService.getSelect().equals("")){
			System.out.println(bookSelectService.getRoomType());
			String hql = "select a.roomNumber,b.roomTypeName, " +
					"a.status,a.floor,c.roomPrice " +
					"from Room a,Roomtype b,Roomprice c " +
					"where a.roomtype.roomTypeId=b.roomTypeId " +
					"and c.roomtype.roomTypeId=b.roomTypeId and " +
					"b.roomTypeId=? " +
					"and a.floor=? " +
					" and a.status='空闲' " +
					" and c.priceDate=?";
			String[] parameters={
					bookSelectService.getRoomType(),
					bookSelectService.getFloor(),
					date1
			};
			List<Object[]> list = hibernateUtil.executeQuery(hql, parameters);
	
				return list;
		}
		else{
			String roomNumber1 = bookSelectService.getSelect()+"";
			String hql="select a.roomNumber,c.roomTypeName,a.status, a.floor,b.roomPrice " +
					"from Room a,Roomprice b, Roomtype c " +
					" where a.roomtype.roomTypeId=c.roomTypeId and b.roomtype.roomTypeId=c.roomTypeId" +
					" and a.roomNumber=?" +
					"and c.priceDate=?";
			String[] parameters={bookSelectService.getSelect(),date1 };
			List<Object[]> list = hibernateUtil.executeQuery(hql, parameters);
			
			return list;
		}	
	}
	@Override
	public Reserve book1(BookService bookService) {
		// TODO Auto-generated method stub
		int count = 0;
		String hql="from Customer where idCard = ?";
		String[] parameters={
				bookService.getIdcard()
		};
		List<Customer>list = hibernateUtil.executeQuery(hql, parameters);
		for(Customer customer:list){
			count++;
		}
		Reserve reserve = new Reserve();
		int roomNumber = Integer.parseInt(bookService.getRoomNumber());
		reserve.setBookNumber(1);
		reserve.setBookIntoDate(bookService.getLiveDate());
		reserve.setBookLeaveDate(bookService.getLeaveDate());
		reserve.setTel(bookService.getPhone());
		Room room = new Room();
		int roomNumber1 = Integer.parseInt(bookService.getRoomNumber());
		int stuffNumber = Integer.parseInt(bookService.getStuffNumber());
		room.setRoomNumber(roomNumber1);
		Stuff stuff=new Stuff();
		stuff.setStuffId(stuffNumber);
		Customer customer = new Customer();
		customer.setIdCard(bookService.getIdcard());
		customer.setTel(bookService.getPhone());
		reserve.setCustomer(customer);
		reserve.setRoom(room);
		reserve.setStuff(stuff);
		if(count!=0){						
			hibernateUtil.save(reserve);
			return reserve;
		}
		else{
			hibernateUtil.save(customer);
			hibernateUtil.save(reserve);
			return reserve;
		}
	}

	@Override
	public void ChangeRoomStatus(BookService bookService) {
		// TODO Auto-generated method stub
		String hql = "update Room set status='预定' where roomNumber=?";
		String[] parameters={
				bookService.getRoomNumber()
		};
		hibernateUtil.executeUpdate(hql, parameters);
	}

}
