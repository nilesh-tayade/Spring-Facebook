package com.facebook.entities;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String mobile;
	private String password;
	
    @Temporal(TemporalType.DATE)
	private Date dob;
	private String profileUrl;
	private String coverUrl;
	private String gender;
	
	@Column(length = 1000)
	private String bio;
	private boolean active;
	
	@ElementCollection
	private List<String> photos = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private Collection<Post> posts;

}
