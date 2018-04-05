package com.dao;

import java.util.List;

import com.entities.RoomReservation;

public interface ReservationDetailDao {
	
	public List<RoomReservation> getAllRoomReservation(String checkinDate);

	public List<RoomReservation> getAllRoomBookingDetails();
}
