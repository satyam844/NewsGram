package com.piedpiper.NewsGram.ServiceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piedpiper.NewsGram.Entities.User;
import com.piedpiper.NewsGram.Exceptions.UserAlreadyExistsException;
import com.piedpiper.NewsGram.Repository.UserRepository;
import com.piedpiper.NewsGram.Service.UserService;
import com.piedpiper.NewsGram.dtos.CreateUserDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(CreateUserDto userDto) {
		
		if(userRepository.findByEmail(userDto.email()) != null) {
			throw new UserAlreadyExistsException("User Already Exists !!!");
		}
		
		User user = User.builder()
				.name(userDto.name())
				.email(userDto.email().toLowerCase())
				.createDate(LocalDateTime.now())
				.modifiedDate(LocalDateTime.now()).build();
		
		return userRepository.save(user);
	}

}
