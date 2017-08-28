package com.assignment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.beans.UserDto;
import com.assignment.services.UserService;

@EnableAutoConfiguration
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<UserDto> finduserById(@RequestParam(value = "email") String email) {
		UserDto userDto = service.findUserByEmail(email);
		if(userDto == null){
			return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Void> findUser(@RequestBody UserDto userDto) {
		UserDto user = service.findUserByEmail(userDto.getEmail());
		if(user != null){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		service.addUser(userDto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteUser(@RequestParam(value = "email") String email) {
		UserDto user = service.findUserByEmail(email);
		if(user == null){
			return new ResponseEntity<Boolean>(Boolean.FALSE,HttpStatus.NOT_FOUND);
		}
		
		service.deleteUser(email);
		return new ResponseEntity<Boolean>(Boolean.TRUE,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>> findAll() {
		List<UserDto> users = service.findAll();
		return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "check", method = RequestMethod.POST)
	public ResponseEntity<Boolean> checkPassword(@RequestParam(value = "email") String email, 
													@RequestBody String password) {

		return new ResponseEntity<Boolean>(service.FindByEmailAndPassword(email, password),HttpStatus.OK);
	}
}

