package com.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="user_register")
public class UserRegister {

	@TableGenerator(name = "user_register_id_gen", table = "id_generator", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "user_register_id_gen")
	@Column(name="user_register_id")
	private int userRegID;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="login_id")
	private Login login;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="guest_id")
	private Guest guest;
	
	public int getUserRegID() {
		return userRegID;
	}

	public void setUserRegID(int userRegID) {
		this.userRegID = userRegID;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}
}
