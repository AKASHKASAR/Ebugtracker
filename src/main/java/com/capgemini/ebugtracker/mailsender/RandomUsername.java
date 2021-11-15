package com.capgemini.ebugtracker.mailsender;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class RandomUsername {
	static String usingUUID() { 
        UUID randomUUID = UUID.randomUUID(); 
        return randomUUID.toString().replaceAll("-", ""); 
      }
	
	public String usename(String fname,String lname) {
		return (fname.substring(0,3)+lname.substring(0,3));
		
	}
	public String password(String fname,String Lname) {
		String randomString = usingUUID(); 
	      //  System.out.println("Random string is: " + randomString); 
	        System.out.println("Random string of 8 characters is: " + randomString.substring(0, 8)); 
		return randomString.substring(0, 8) ;
		
	}


}
