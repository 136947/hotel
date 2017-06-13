package com.hotel.interfaces;

import java.util.List;

import com.hotel.FormService.LeavePayService;
import com.hotel.FormService.LeaveSelectService;
import com.hotel.FormService.LeaveService;
import com.hotel.domain.Customer;
import com.hotel.domain.Live;
import com.hotel.domain.Room;

public interface LeaveInter {
	public void ChangeRoomStatus(LeaveService leaveService);
	public List<Object[]> SelectRoom(LeaveSelectService leaveSelectService);
	public List<Object[]> SelectRoom1(LeaveService leaveService);
	public int Change(LeaveService leaveService);//找零
	public void DeleteCustomer(LeaveService leaveService);
	public int AllRoomPrice(LeaveSelectService leaveSelectService);//得到总房价
	public Boolean RoomNull(LeaveSelectService leaveSelectService);
}
