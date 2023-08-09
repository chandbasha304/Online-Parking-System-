package com.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.CustomerDTO;
import com.entity.Customer;
import com.repository.DBOperations;
import com.repository.DBProcess;
import com.service.ParkingOperations;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ClientRequest {


	@Autowired
	ParkingOperations newuseradding;


//	@GetMapping("/getuser") 
//	public List<Customer> getData()
//	{
//		return null;
//	}



	@PostMapping("/newuser")
	public CustomerDTO newdata(@RequestBody Customer data)
	{
		System.out.println("Entering");
		System.out.println(data);
		CustomerDTO adding = newuseradding.userAdding(data);


		return adding;

	}




	@PostMapping("/newsignup")
	public ModelAndView newdata(HttpServletRequest  data)
	{
		System.out.println("Entering");
		Boolean userAdding = newuseradding.userAdding(data);        
		if(userAdding)
		{
			ModelAndView view = new ModelAndView("accountsuccess");

			return view;
		}
		else
		{
			ModelAndView view = new ModelAndView("signupfail");

			return view;
		}

	}


	@GetMapping("/signup")
	public ModelAndView signupaccount()
	{ 
		ModelAndView signupView = new ModelAndView("newaccount");
		return signupView;
	}


	@GetMapping("/start")
	public ModelAndView startProcess()
	{ 
		ModelAndView signupView = new ModelAndView("mainpage");
		return signupView;
	}
	
	
	@GetMapping("/login")
	public ModelAndView loginUser(HttpServletRequest  data)
	{
		ModelAndView view = new ModelAndView("loginaccount");

		return view;

	}
	
	@PostMapping("/loginuser")
	public ModelAndView loginUserProcess(HttpServletRequest  data)
	{
		System.out.println(data.getParameter("email"));
		System.out.println(data.getParameter("password"));
		Boolean loginData = newuseradding.loginUserData(data);
		if(loginData) {
		ModelAndView view = new ModelAndView("welcome");

		return view;
		}
		else
		{
			ModelAndView view = new ModelAndView("invalidlogin");

			return view;
		}

	}
	@GetMapping("/bookslots")
	public ModelAndView slotDisplay()
	{
		System.out.println("Entering");
		
  ModelAndView view = new ModelAndView("parkingslot");

		return view;

	}
	
	

}
