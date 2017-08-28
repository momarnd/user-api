package com.assignment.services;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.beans.UserDto;
import com.assignment.dao.UserRepository;
import com.assignment.entities.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Mapper dozerMapper;
	
	public UserDto findUserByEmail(String email) {
		User user = userRepository.findOne(email);
		if(user != null){
			UserDto userDto = dozerMapper.map(user, UserDto.class);
			return userDto;
		}
		return null;
	}
	

	@Transactional
	public void addUser(UserDto userDto) {
		User user = dozerMapper.map(userDto, User.class);
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	public List<UserDto> findAll() {
		List<UserDto> users = new ArrayList<>();
		userRepository.findAll()
			.stream()
			.forEach(user ->
				users.add(dozerMapper.map(user, UserDto.class))
					);
		
		return users;
		
	}
	
	
	@Override
	@Transactional
	public void deleteUser(String email) {
		userRepository.delete(email);
	}


	@Override
	public boolean FindByEmailAndPassword(String email, String password) {
		User user = userRepository.findOne(email);
		if(user != null){
			return passwordEncoder.matches(password, user.getPassword());
		} 
		return false;
	}
}
