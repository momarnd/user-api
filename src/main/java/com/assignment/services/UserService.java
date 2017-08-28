package com.assignment.services;

import java.util.List;

import com.assignment.beans.UserDto;

public interface UserService {
	
	/**
	 * 
	 * @param email
	 * @return the user by this email
	 */
	public UserDto findUserByEmail(String email);
	
	
	/**
	 * Add an User
	 * 
	 * @param userDto
	 */
	public void addUser(UserDto userDto);
	
	/**
	 * 
	 * @param email
	 * 
	 * delete User
	 */
	public void deleteUser(String email);
	
	
	/**
	 * 
	 * @return All users 
	 */
	public List<UserDto> findAll();
	
	/**
	 * 
	 * Verify if password is good for an user 
	 * 
	 * @param email
	 * @param password
	 * @return boolean
	 */
	public boolean FindByEmailAndPassword(String email, String password);

}
