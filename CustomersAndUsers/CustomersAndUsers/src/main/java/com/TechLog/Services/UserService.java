package com.TechLog.Services;

import java.time.LocalDate;

import com.TechLog.Users.Users;

public interface UserService {
	
	Users createUser(String firstname, String lastname, Long corporationId, 
			String department, String position, String role, String email, String telNumber, String address, LocalDate startdate);
	Users removeUser(Long UserId);
	Users getUser(Long id, boolean isFull);
	Users updateUser(Users user);

}
