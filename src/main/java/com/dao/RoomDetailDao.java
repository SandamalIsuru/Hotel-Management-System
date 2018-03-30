package com.dao;

import java.util.List;

import com.entities.RoomDetail;

public interface RoomDetailDao {

	public List<RoomDetail> getAllRooms();
	
	public Long getAvailableRooms();
	
	public boolean addRoomDetail(RoomDetail roomDetail);
}
