package com.gb.sboum.mongodao;

import java.time.LocalDate;
import java.time.Month;

import com.gb.sboom.model.User;

public class UserDao {

	public User findUser(String id) {
		User user = new User();
		user.setDateOfBirth(LocalDate.of(1982, Month.APRIL, 11));
		user.setFirstName("guillaume");
		user.setId(id);
		user.setLastName("sboum");
		user.setNickName("BoomBoom");
		return user;
	}

}
