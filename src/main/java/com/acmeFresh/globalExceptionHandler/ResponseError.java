package com.acmeFresh.globalExceptionHandler;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseError {
	
	private LocalDateTime timestamp; 
	private String message;
	private String details;

}
