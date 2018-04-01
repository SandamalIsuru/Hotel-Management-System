package com.dao;

import java.util.List;

import com.entities.RoomType;

public interface RoomTypeDao {

	public boolean addRoomType(RoomType roomType);
	
	public List<RoomType> getAllRoomTypes();
}
