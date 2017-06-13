package com.hotel.interfaces;

import java.util.List;

import com.hotel.FormService.AddRoomService;
import com.hotel.FormService.GsService;
import com.hotel.FormService.RoomViewService;

public interface RoMaInt {
	//查询所有类型房间入住情况
    public List view1(RoomViewService roomViewService);
    //查询同类房间入住情况
    public List view2(RoomViewService roomViewService);
    //查询具体房间入住的情况
    public List view3(RoomViewService roomViewService);
    //入住查询
    public List view4();
    //预定查询
    public List view5();
    
    //修改预定信息
    public void view6(GsService gsService);
    
    //删除预定信息
    public void view7(GsService gsService);
    
    //空闲房间查询
    public List view8();
    
    //增加客房
    public void view9(AddRoomService room);
    //修改客房
    public void view10(AddRoomService room);
    
    //删除客房
    public void view11(AddRoomService room);
    //查询生成图表信息
    public List viewt();
    
    public List viewP();
}
