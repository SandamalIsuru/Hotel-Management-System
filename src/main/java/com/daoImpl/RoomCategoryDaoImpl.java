package com.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
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
		sessionFactory.getCurrentSession().save(roomCategory);
		return true;
	}
	public List<RoomCategory> getAllRoomCategories() {
		String queryString = "from RoomCategory";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		return query.list();
	}

}
