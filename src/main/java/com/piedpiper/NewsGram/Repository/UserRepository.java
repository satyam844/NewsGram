package com.piedpiper.NewsGram.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.piedpiper.NewsGram.Entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
//	@Query
//	("SELECT * from User where email=(?1)")
//	User findByUserEmail(String email);
	
    User findByEmail(String email);

}

