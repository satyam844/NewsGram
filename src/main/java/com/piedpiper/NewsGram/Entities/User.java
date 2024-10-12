package com.piedpiper.NewsGram.Entities;


import java.util.Set;
import java.time.LocalDateTime;
import java.util.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name="User")
@Data
@Builder
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="email" ,nullable = false, unique = true)
	private String email;
	
	@OneToMany
	(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<Subscription> subscriptions = new HashSet<>();
	
	@Column(name="create_date",nullable = false)
	private LocalDateTime createDate;
	
	@Column(name="modified_time",nullable = false)
	private LocalDateTime modifiedDate;
	
	
	
	
}
