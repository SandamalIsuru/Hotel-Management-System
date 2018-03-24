package com.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.RegisterCustomerDao;
import com.entities.UserRegister;

@Repository
@Transactional
public class RegisterCustomerDaoImpl implements RegisterCustomerDao {

	@Autowired
	SessionFactory sessionFactory;
	public boolean addCustomer(UserRegister newCustomer){
		sessionFactory.getCurrentSession().saveOrUpdate(newCustomer);
		return true;
	}
}
