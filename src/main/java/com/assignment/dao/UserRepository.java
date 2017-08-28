package com.assignment.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	public List<User> findBydateOfBirthBetween(Date date1, Date date2);
	
	public User findByEmailAndPassword(String email, String password);

}