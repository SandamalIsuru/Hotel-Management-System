package com.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.RoomCategoryDao;
import com.entities.RoomCategory;

@Repository
@Transactional
public class RoomCategoryDaoImpl implements RoomCategoryDao {

	@Autowired
	SessionFactory sessionFactory;
	public boolean addRoomCategory(RoomCategory roomCategory) {
		sessionFactory.getCurrentSession().saveOrUpdate(roomCategory);
		return true;
	}

}
