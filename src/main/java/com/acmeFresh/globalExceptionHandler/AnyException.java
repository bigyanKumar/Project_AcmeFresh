package com.acmeFresh.globalExceptionHandler;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AnyException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public AnyException(String msg) {
		
		super(msg);
		// TODO Auto-generated constructor stub
	}
	

}
