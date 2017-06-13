package com.hotel.actions;
import java.util.List;

import javax.annotation.Resource;

import com.hotel.FormService.LiveInto;
import com.hotel.FormService.LiveSelectService;
import com.hotel.domain.Customer;
import com.hotel.domain.Live;
import com.hotel.domain.Reserve;
import com.hotel.domain.Room;
import com.hotel.interfaceimp.LiveImp;
import com.hotel.interfaces.Livefor;
import com.opensymphony.xwork2.ActionContext;

public class LiveAction {
 
	private Livefor livefor;
	private LiveImp liveImp;

	@Resource
	private LiveSelectService liveselect;
	
	@Resource
	private LiveInto liveInto;




	public LiveInto getLiveInto() {
		return liveInto;
	}




	public void setLiveInto(LiveInto liveInto) {
		this.liveInto = liveInto;
	}




	public Livefor getLivefor() {
		return livefor;
	}




	public void setLivefor(Livefor livefor) {
		this.livefor = livefor;
	}




	public LiveImp getLiveImp() {
		return liveImp;
	}




	public void setLiveImp(LiveImp liveImp) {
		this.liveImp = liveImp;
	}




	public LiveSelectService getLiveselect() {
		return liveselect;
	}
	public void setLiveselect(LiveSelectService liveselect) {
		this.liveselect = liveselect;
	}
   //登记入住
	public String check() {
		//未预定客户入住
		
		if(liveselect.getRoomNumber().equals("")){
		    List<Object[]> list =livefor.live(liveselect);
			ActionContext.getContext().put("list",list);
			ActionContext.getContext().put("key",0);
			
		}
		//已经预定的客户办理入住
		else{
			List<Reserve> list = livefor.roomlive(liveselect);
			ActionContext.getContext().put("list",list);
			ActionContext.getContext().put("key",1);

		}
			
		return "success";
}
	//未预定，直接入住
	public String liveCheck(){
		int i = livefor.liveIn(liveInto);
		if(i==1)
			return "inser";
		else
			return "success";
	}
	//已经预定后入住
	public String roomCheck(){
		Live live = new Live();
		Room room  = new Room();
		Customer customer = new Customer();
		room.setRoomNumber(Integer.parseInt(liveInto.getRoomNumber()));
		customer.setIdCard(liveInto.getIdCard());
		live.setRoom(room);
		live.setTel(liveInto.getTel());
		live.setCustomer(customer);
		live.setName(liveInto.getName());
		live.setBookIntoDate(liveInto.getLiveDate());
		live.setBookLeaveDate(liveInto.getWileaveDate());
		live.setSecurity(Integer.parseInt(liveInto.getSecurity()));
		livefor.insert(live);
		livefor.update(liveInto);
		return "success";
	}
}
