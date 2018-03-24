package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dao.RoomDetailDao;
import com.entities.RoomDetail;
import com.services.RoomService;

@Configuration
@ComponentScan("com.dao")
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomDetailDao roomDetailDao;
	
	public List<RoomDetail> getAllRooms() {
		return roomDetailDao.getAllRooms();
	}
	
	public Long getAvailableRooms() {
		return roomDetailDao.getAvailableRooms();
	}

}
