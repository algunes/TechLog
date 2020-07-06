package com.TechLog.Dao;

import java.util.List;

import com.TechLog.Users.Users;

public interface UsersDao {
	
	Long addUser(Users user); // Create
	Users fetchUser(Long id); // Fetching a user lazily
	Users fullFetchUser(Long id); // Fetching a user eagerly
	List<Users> fetchAllUsers(); // Fetch a list of all users (lazily)
	void updateUser(Users user); // Update
	void deleteUser(Users user); // Delete

}
