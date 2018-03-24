package com.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.LoginDao;
import com.entities.Login;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Login> getLoginByUsernameAndPassword(Login login) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Login where username = :username and password = :password");
		query.setParameter("username", login.getUsername());
		query.setParameter("password", login.getPassword());
		List loginList = query.list();
		return loginList;
	}

	public boolean addLogin(Login login) {
		sessionFactory.getCurrentSession().saveOrUpdate(login);
		return true;
	}

}
