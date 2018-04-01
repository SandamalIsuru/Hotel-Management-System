package com.services;

import java.util.List;

import com.entities.RoomCategory;

public interface RoomCategoryService {

	public boolean addRoomCategory(RoomCategory roomCategory);
	
	public List<RoomCategory> getAllRoomCategories();
}
