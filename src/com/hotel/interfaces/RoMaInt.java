package com.hotel.interfaces;

import java.util.List;

import com.hotel.FormService.AddRoomService;
import com.hotel.FormService.GsService;
import com.hotel.FormService.RoomViewService;

public interface RoMaInt {
	//��ѯ�������ͷ�����ס���
    public List view1(RoomViewService roomViewService);
    //��ѯͬ�෿����ס���
    public List view2(RoomViewService roomViewService);
    //��ѯ���巿����ס�����
    public List view3(RoomViewService roomViewService);
    //��ס��ѯ
    public List view4();
    //Ԥ����ѯ
    public List view5();
    
    //�޸�Ԥ����Ϣ
    public void view6(GsService gsService);
    
    //ɾ��Ԥ����Ϣ
    public void view7(GsService gsService);
    
    //���з����ѯ
    public List view8();
    
    //���ӿͷ�
    public void view9(AddRoomService room);
    //�޸Ŀͷ�
    public void view10(AddRoomService room);
    
    //ɾ���ͷ�
    public void view11(AddRoomService room);
    //��ѯ����ͼ����Ϣ
    public List viewt();
    
    public List viewP();
}
