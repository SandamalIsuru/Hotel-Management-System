package com.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ReservationDetailDao;
import com.entities.RoomReservation;

@Repository
@Transactional
public class ReservationDetailDaoImpl implements ReservationDetailDao {

	@Autowired
	SessionFactory sessionFactory;
	public List<RoomReservation> getAllRoomReservation(String checkinDate) {
		String queryString = "from RoomReservation where checkin=:checkinDate";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setParameter("checkinDate", checkinDate);
		return query.list();
	}

	public List<RoomReservation> getAllRoomBookingDetails() {
		String queryString = "from RoomReservation";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		return query.list();
	}
}
