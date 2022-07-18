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
public class LoginSession {
	@Id
	private String email;
	private LocalDateTime sessionTime;
	private String autoGenId;
	
}
