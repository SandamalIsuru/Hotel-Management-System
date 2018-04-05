package com.dao;

import java.util.List;

import com.entities.RoomDetail;
import com.entities.RoomReservation;

public interface RoomDetailDao {

	public List<RoomDetail> getAllRooms();
	
	public Long getAvailableRooms();
	
	public boolean addRoomDetail(RoomDetail roomDetail);
	
	public List<RoomDetail> getRoomDetailsByRoomType(int roomTypeId);
}
