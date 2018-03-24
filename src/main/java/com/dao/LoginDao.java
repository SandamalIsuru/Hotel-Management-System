package com.dao;

import java.util.List;
import com.entities.Login;

public interface LoginDao {
	
	public List<Login> getLoginByUsernameAndPassword(Login login);
}
