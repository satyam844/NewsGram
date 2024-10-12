package com.piedpiper.NewsGram.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piedpiper.NewsGram.Entities.User;
import com.piedpiper.NewsGram.Service.UserService;
import com.piedpiper.NewsGram.dtos.CreateUserDto;
import com.piedpiper.NewsGram.dtos.CreateUserResponseDto;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<CreateUserResponseDto> create(@RequestBody CreateUserDto userDto) {
		User user  = userService.createUser(userDto);
		CreateUserResponseDto dto =new CreateUserResponseDto(user.getId(),user.getName(),user.getEmail());
		return new ResponseEntity<CreateUserResponseDto>(dto,HttpStatus.CREATED);
	}
	
	

}
