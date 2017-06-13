package com.hotel.interfaces;

import java.util.List;

import com.hotel.FormService.BookSelectService;
import com.hotel.FormService.BookService;
import com.hotel.domain.Reserve;
import com.hotel.domain.Room;

public interface EconomicInter {
	public List<Object[]> book(BookSelectService bookSelectService);
	public Reserve book1(BookService bookService);
	public void ChangeRoomStatus(BookService bookService);
}
