package com.piedpiper.NewsGram.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name="New_Channel")
@Data
public class NewsChannel {

	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		
		@Column(name="channel_name",nullable = false,unique = true)
		private String channelName;
		
		
		@Column(name="api_end_point",nullable=false)
		private String apiEndPoint;

		@Column(name="catogory")
		private List<String> category;
		
		  @OneToMany
		  (mappedBy = "newsChannel", cascade = CascadeType.ALL, orphanRemoval = true)
		   private Set<Subscription> subscriptions = new HashSet<>();

	    @Column(name="create_date",nullable = false)
	    private LocalDateTime createDate;

	    @Column(name="modified_time",nullable = false)
	    private LocalDateTime modifiedDate;

		
		
	
	
}
