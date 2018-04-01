package com.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
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
		sessionFactory.getCurrentSession().save(roomType);
		return true;
	}
	public List<RoomType> getAllRoomTypes() {
		String queryString = "from RoomType";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		return query.list();
	}
}
