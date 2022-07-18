package com.acmeFresh.service;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmeFresh.DTO.LoginDTO;
import com.acmeFresh.dao.LoginSessionDao;
import com.acmeFresh.dao.UserDetailsDao;
import com.acmeFresh.entity.LoginSession;
import com.acmeFresh.entity.UserDetails;
import com.acmeFresh.globalExceptionHandler.AnyException;

import net.bytebuddy.utility.RandomString;


@Service
public class AuthenticationImpl implements AuthenticationIntr{
	
	@Autowired
	private UserDetailsDao userD;
	@Autowired
	private LoginSessionDao loginS;
	@Override
	public LoginSession login(LoginDTO login) throws AnyException {
		//checking in loginSession already present or not. if it is present then just  returning the login session object
//		Optional<LoginSession> loggedIn=loginS.findById(login.getEmail());
//		if(loggedIn.get()!=null) {
//			return loggedIn.get();
//		}else {
		Optional<UserDetails> userEntity=userD.findById(login.getEmail());
			if(userEntity.get()==null) {
				throw new AnyException("User not found please chechk Email");
			}else {
				//converting hashcode password from normal password
				Integer password=login.getPassword().hashCode();
				//checking password both coming to the user and database if both are not equal then it will not go inside loginsession .
				if(password!=Integer.parseInt(userEntity.get().getPassword())) {
					throw new AnyException("Password does not match please check agin.");
				}else {
					//if both are equal then return randomValue to the user.
					return loginS.save(new LoginSession(login.getEmail(),LocalDateTime.now(),RandomString.make(10)));
				}
			}
	//}
	}
	@Override
	public String logOut(String key) {	
		//delete session from loginSession 
		loginS.delete(loginS.findByAutoGenId(key));
		return "Logged Out Sucessfully! Thanks for visiting our website.";
	}
	
	@Override
	public UserDetails validateKey(String key) throws AnyException {
		// TODO Auto-generated method stub
		LoginSession loggedIn=loginS.findByAutoGenId(key);
		if(loggedIn==null) {
			throw new AnyException("Session not fount");
		}else {
			Optional<UserDetails> userObject=userD.findById(loggedIn.getEmail());
			return userObject.get();
			
		}
		
	}
	
	

}
