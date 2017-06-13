package com.hotel.interfaces;

import java.util.List;

import com.hotel.FormService.LiveInto;
import com.hotel.FormService.LiveSelectService;
import com.hotel.domain.Customer;
import com.hotel.domain.Live;
import com.hotel.domain.Room;


public interface Livefor {
		public List live(LiveSelectService liveselect);
		public List roomlive(LiveSelectService liveselect);
		public int liveIn(LiveInto into);
		public void insert(Live live);
		public void update(LiveInto liveInto);
}
