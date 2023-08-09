package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerDTO;
import com.entity.Customer;
import com.repository.DBOperations;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ParkingOperations {
	
	  @Autowired
	  DBOperations dataAdding;
	public CustomerDTO userAdding(Customer data)
	{
		CustomerDTO userAddingImplentation = dataAdding.userAddingImplentation(data);
		return userAddingImplentation;
	}
	public Boolean userAdding(HttpServletRequest data)
	{
		boolean newUserAdding = dataAdding.newUserAdding(data);
		
		return newUserAdding;
	}
	
	
	public Boolean loginUserData(HttpServletRequest login)
	{
		System.out.println("Service Layer*****************************************");
		
		
		Boolean dataAvailable = dataAdding.loginDataChecking(login);
		return dataAvailable;
	}

}
