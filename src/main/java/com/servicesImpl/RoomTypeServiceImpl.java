package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dao.RoomDetailDao;
import com.dao.RoomTypeDao;
import com.entities.RoomType;
import com.services.RoomTypeService;

@Configuration
@ComponentScan("com.dao")
public class RoomTypeServiceImpl implements RoomTypeService {

	@Autowired
	RoomTypeDao roomTypeDao;
	@Autowired
	RoomDetailDao roomDetailDao;
	public boolean addRoomType(RoomType roomType) {
		return roomTypeDao.addRoomType(roomType);
	}

	public List<RoomType> getAllRoomTypes() {
		return roomTypeDao.getAllRoomTypes();
	}

}
