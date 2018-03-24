package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dao.ReservationDetailDao;
import com.entities.RoomReservation;
import com.services.ReservationDetailService;

@Configuration
@ComponentScan("com.dao")
public class ReservationDetailServiceImpl implements ReservationDetailService{

	@Autowired
	ReservationDetailDao reservationDetailDao;
	public List<RoomReservation> getAllRoomReservation(String checkin) {
		// TODO Auto-generated method stub
		return reservationDetailDao.getAllRoomReservation(checkin);
	}

}
