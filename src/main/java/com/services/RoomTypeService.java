package com.services;

import java.util.List;

import com.entities.RoomType;

public interface RoomTypeService {

	public boolean addRoomType(RoomType RoomType);
	
	public List<RoomType> getAllRoomTypes();
}
