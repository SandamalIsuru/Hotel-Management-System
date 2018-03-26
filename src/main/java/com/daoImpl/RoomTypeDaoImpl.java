package com.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.RoomTypeDao;
import com.entities.RoomType;

@Repository
@Transactional
public class RoomTypeDaoImpl implements RoomTypeDao {

	@Autowired
	SessionFactory sessionFactory;
	public boolean addRoomType(RoomType roomType) {
		sessionFactory.getCurrentSession().saveOrUpdate(roomType);
		return true;
	}
}
