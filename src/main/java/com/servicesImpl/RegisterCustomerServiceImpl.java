package com.servicesImpl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.services.RegisterCustomerService;

@Configuration
@ComponentScan("com.dao")
public class RegisterCustomerServiceImpl implements RegisterCustomerService{

}
