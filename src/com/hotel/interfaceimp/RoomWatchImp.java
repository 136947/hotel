package com.hotel.interfaceimp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hotel.FormService.WatchSelectService;
import com.hotel.interfaces.RoomWacthInter;
import com.hotel.utils.HibernateUtil;

public class RoomWatchImp implements RoomWacthInter {
	private HibernateUtil hibernateUtil;
	
	
	public HibernateUtil getHibernateUtil() {
		return hibernateUtil;
	}


	public void setHibernateUtil(HibernateUtil hibernateUtil) {
		this.hibernateUtil = hibernateUtil;
	}
	@Override
	public List<Object[]> RoomWatch(WatchSelectService watchSelectService) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		String now = s.format(date);
		
		if(watchSelectService.getSelect().equals("")){
			
			String hql ="select a.roomNumber, b.roomTypeName,a.status, a.floor, c.roomPrice from Room a, Roomtype b, Roomprice c " +
				"where a.roomtype.roomTypeId = b.roomTypeId " +
				"and b.roomTypeId=c.roomtype.roomTypeId and " +
				"b.roomTypeId=? and a.floor=? and c.priceDate=?";
			String[] parameters = {
					watchSelectService.getRoomType(),
					watchSelectService.getFloor(),
					now
			};
			List<Object[]>list = hibernateUtil.executeQuery(hql, parameters);
			return list;
		}else{
			String hql ="select a.roomNumber,b.roomTypeName,a.status,a.floor,c.roomPrice from Room a, Roomtype b, Roomprice c " +
					"where a.roomtype.roomTypeId = b.roomTypeId " +
					"and b.roomTypeId=c.roomtype.roomTypeId and " +
					"a.roomNumber=? and c.priceDate=?";
				String[] parameters = {
						watchSelectService.getSelect(),
						now
				};
				List<Object[]>list = hibernateUtil.executeQuery(hql, parameters);
				return list;
		}
	}

}
