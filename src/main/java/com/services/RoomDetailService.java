package com.services;

import java.util.List;

import com.entities.RoomDetail;

public interface RoomDetailService {

	public boolean addRoomDetail(RoomDetail roomDetail);
	
	public List<RoomDetail> getRoomDetailsByRoomType(int roomTypeId);
}
