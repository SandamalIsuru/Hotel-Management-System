package com.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.RoomDetailDao;
import com.entities.RoomDetail;

@Repository
@Transactional
public class RoomDetailDaoImpl implements RoomDetailDao {

	@Autowired
	SessionFactory sessionFactory;
	public List<RoomDetail> getAllRooms() {
		String queryString = "from RoomDetail";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		return query.list();
	}
	
	public Long getAvailableRooms() {
		//SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select count(*) from RoomDetail where isAvailable=1");
		Long count = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from RoomDetail where isAvailable=1").uniqueResult();
		return count;
	}

}
