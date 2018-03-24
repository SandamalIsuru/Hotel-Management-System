package com.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.GuestDao;
import com.entities.Guest;

@Repository
@Transactional
public class GuestDaoImpl implements GuestDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addGuest(Guest guest) {
		sessionFactory.getCurrentSession().saveOrUpdate(guest);
		return true;
	}

}
