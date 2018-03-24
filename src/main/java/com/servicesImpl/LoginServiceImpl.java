package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dao.LoginDao;
import com.entities.Login;
import com.services.LoginService;

@Configuration
@ComponentScan("com.dao")
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;
	
	public boolean getLoginByLoginDetails(Login login) {
		List loginDetails = loginDao.getLoginByUsernameAndPassword(login);
		if(loginDetails.size() > 0){
			return true;
		}
		return false;
	}

}
