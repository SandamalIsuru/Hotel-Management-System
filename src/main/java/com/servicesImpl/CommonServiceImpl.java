package com.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dao.GuestDao;
import com.dao.LoginDao;
import com.dao.RegisterCustomerDao;
import com.entities.Login;
import com.entities.UserRegister;
import com.services.CommonService;

@Configuration
@ComponentScan("com.dao")
public class CommonServiceImpl implements CommonService {

	@Autowired
	RegisterCustomerDao registerCustomerDao;
	@Autowired
	GuestDao guestDao;
	@Autowired
	LoginDao loginDao;
	public boolean addCustomer(UserRegister newCustomer){
		boolean isGuestInserted = guestDao.addGuest(newCustomer.getGuest());
		Login login = new Login();
		login.setUsername(newCustomer.getGuest().getFirstName());
		login.setPassword(newCustomer.getGuest().getFirstName());
		newCustomer.setLogin(login);
		boolean isLoginInserted = loginDao.addLogin(newCustomer.getLogin());
		boolean isUserInserted = registerCustomerDao.addCustomer(newCustomer);
		return true;
	}

}
