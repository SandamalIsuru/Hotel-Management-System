package com.dao;

import java.util.List;

import com.entities.RoomCategory;

public interface RoomCategoryDao {

	public boolean addRoomCategory(RoomCategory roomCategory);
	
	public List<RoomCategory> getAllRoomCategories();
}
