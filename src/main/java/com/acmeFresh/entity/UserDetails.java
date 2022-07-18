package com.acmeFresh.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetails {
	@Id
	private String email;
	private String phoneNo;
	private String name;
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
}
