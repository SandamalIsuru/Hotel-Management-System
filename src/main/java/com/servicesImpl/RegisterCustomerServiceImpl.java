package com.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dao.RegisterCustomerDao;
import com.entities.UserRegister;
import com.services.RegisterCustomerService;

@Configuration
@ComponentScan("com.dao")
public class RegisterCustomerServiceImpl implements RegisterCustomerService{

}
