package com.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dao.RoomCategoryDao;
import com.entities.RoomCategory;
import com.services.RoomCategoryService;

@Configuration
@ComponentScan("com.dao")
public class RoomCategoryServiceImpl implements RoomCategoryService {

	@Autowired
	RoomCategoryDao roomCategoryDao;
	public boolean addRoomCategory(RoomCategory roomCategory) {
		return roomCategoryDao.addRoomCategory(roomCategory);
	}

}
