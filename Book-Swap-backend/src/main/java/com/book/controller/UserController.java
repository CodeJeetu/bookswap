package com.book.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.service.UserSeviceImpl;
import com.book.user.entity.SaveUserData;
import com.book.user.entity.UserCredetial;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserSeviceImpl service;
	
	@GetMapping("/test")
	public String test()
	{
		return "User Controller Is running";
	}
	
	@PostMapping("/save")
	public SaveUserData SaveUser(@RequestBody SaveUserData user)
	{
		SaveUserData saved = service.SaveUserData(user);
		return saved;	
	}
	@PostMapping("/login")
	public  String Login(@RequestBody UserCredetial credetial)
	{
		return this.service.userLogin(credetial);
	}
}
