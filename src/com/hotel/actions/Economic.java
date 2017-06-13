package com.hotel.actions;

import java.util.List;

import javax.annotation.Resource;

import com.hotel.FormService.BookSelectService;
import com.hotel.FormService.BookService;
import com.hotel.domain.Reserve;
import com.hotel.domain.Room;
import com.hotel.interfaceimp.EconomicImp;
import com.hotel.interfaceimp.HibernateUtilsImp;
import com.hotel.interfaces.EconomicInter;
import com.hotel.utils.HibernateUtil;
import com.opensymphony.xwork2.ActionContext;

public class Economic {

	private EconomicInter economicInter;
	
	private HibernateUtil hibernateUtil;
	@Resource
	private HibernateUtilsImp hibernateImp;

	@Resource
	private EconomicImp economicImp;

	@Resource
	private BookSelectService bookSelectService;
	@Resource
	private BookService bookService;	
	
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}
	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}
	public HibernateUtilsImp getHibernateImp() {
		return hibernateImp;
	}
	public void setHibernateImp(HibernateUtilsImp hibernateImp) {
		this.hibernateImp = hibernateImp;
	}
	public EconomicImp getEconomicImp() {
		return economicImp;
	}
	public void setEconomicImp(EconomicImp economicImp) {
		this.economicImp = economicImp;
	}
	public EconomicInter getEconomicInter() {
		return economicInter;
	}
	public void setEconomicInter(EconomicInter economicInter) {
		this.economicInter = economicInter;
	}
	public BookSelectService getBookSelectService() {
		return bookSelectService;
	}
	public void setBookSelectService(BookSelectService bookSelectService) {
		this.bookSelectService = bookSelectService;
	}
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	public String book1(){
		int count=0;
		List<Object[]> list=economicInter.book(bookSelectService);
		ActionContext.getContext().put("list", list);
		for(Object[] object:list){
			System.out.println(object[0].toString());
		}
		return "book";
	}
	
	public String book2(){
		Reserve reserve  = economicInter.book1(bookService);
		economicInter.ChangeRoomStatus(bookService);
		return "success";
	}
}
