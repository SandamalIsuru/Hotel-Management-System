package com.services;

import java.util.List;

import com.entities.RoomReservation;

public interface ReservationDetailService {

	public List<RoomReservation> getAllRoomReservation(String checkin);
	
	public List<RoomReservation> getAllRoomBookingDetails();
}
