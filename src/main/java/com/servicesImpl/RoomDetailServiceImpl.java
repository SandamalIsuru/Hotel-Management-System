package com.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dao.RoomDetailDao;
import com.entities.RoomDetail;
import com.services.RoomDetailService;

@Configuration
@ComponentScan("com.dao")
public class RoomDetailServiceImpl implements RoomDetailService {

	@Autowired
	RoomDetailDao roomDetailDao;
	public boolean addRoomDetail(RoomDetail roomDetail) {
		return roomDetailDao.addRoomDetail(roomDetail);
	}

}
