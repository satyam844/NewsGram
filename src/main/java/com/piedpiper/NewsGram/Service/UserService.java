package com.piedpiper.NewsGram.Service;

import com.piedpiper.NewsGram.Entities.User;
import com.piedpiper.NewsGram.dtos.CreateUserDto;

public interface UserService {
	
	
	User createUser(CreateUserDto userDto);

}
