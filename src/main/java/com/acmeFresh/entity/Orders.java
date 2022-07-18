package com.acmeFresh.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String trasactionId;
	@ManyToOne(cascade = CascadeType.ALL,targetEntity = UserDetails.class)
	private UserDetails customerId;
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Product.class)
	private List<Product> product;
	@OneToOne(cascade =  CascadeType.ALL)
	private Transactions transaction;
	
}
