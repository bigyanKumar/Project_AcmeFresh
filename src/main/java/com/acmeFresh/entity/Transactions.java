package com.acmeFresh.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transactions {
	
	@Id
	private String transId;
	private Boolean status=false;
	private LocalDateTime dateAndTime;
	private Double totalAmount;
}
