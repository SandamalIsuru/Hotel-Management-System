package com.services;

import java.util.List;

import com.entities.RoomDetail;

public interface RoomService {

	public List<RoomDetail> getAllRooms();
	
	public Long getAvailableRooms();
}
