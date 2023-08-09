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
import com.entity.UserBookings;
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
		String email = data.getParameter("email");
		System.out.println(data.getParameter("password"));
		Boolean loginData = newuseradding.loginUserData(data);
		if(loginData) {
		ModelAndView view = new ModelAndView("welcome");
		view.addObject("email",email);

		return view;
		}
		else
		{
			ModelAndView view = new ModelAndView("invalidlogin");

			return view;
		}

	} 
	@PostMapping("/bookslot")
	public ModelAndView slotDisplay(HttpServletRequest data)
	{
		System.out.println("Entering*******************");
		System.out.println(data.getParameter("email")+"**************************");
		String email = data.getParameter("email");
		String from = data.getParameter("timingsfrom");
		String to = data.getParameter("timingsto");
		String number = data.getParameter("parkingnumber");
		System.out.println(from+"********************");
		System.out.println(to+"Entering");
		System.out.println(number+"Entering");
		Boolean slotsChecking = newuseradding.slotsChecking(from,to,number,email);
	
	int parkingNumber = Integer.parseInt(number);
	
	System.out.println(parkingNumber+"********************");
		if(slotsChecking)
		{
			 ModelAndView view = new ModelAndView("slotsuccess");

				return view;
		}
	 
	
		
		else
		{
			ModelAndView view = new ModelAndView("slotfail");

			return view;
		}
 
	}
	@PostMapping("/showslots")
	public ModelAndView displaySlot( HttpServletRequest data )
	{
		System.out.println("Entering Slot");
		System.out.println(data.getParameter("email")+"****************************");
		String email = data.getParameter("email");
		ModelAndView view = new ModelAndView("parkingslot");
		view.addObject("email",email);

		return view;

	}
	
	 
	@PostMapping("/bookings")
	public ModelAndView userSlotsDisplaying( HttpServletRequest data )
	{
		System.out.println("Entering Slot");
		System.out.println(data.getParameter("email")+"****************************");
		String email = data.getParameter("email");
		
		
		List<UserBookings> userHistory = newuseradding.userHistory(email);
		
		for (UserBookings userBookings : userHistory) {
			System.out.println(userBookings+"**************************************************************");
			
		}
		ModelAndView view = new ModelAndView("userhistory");
		
		 
		 view.addObject("email", email);
		    view.addObject("userHistoryList", userHistory);
		return view;

	}
	
	@PostMapping("/cancelBooking")
	 public ModelAndView deleteUserSlots(HttpServletRequest data)
	 {
		
	String userMail = data.getParameter("email");
		String timingslot = data.getParameter("timings");
		System.out.println("Controller Layer**************************************");
		System.out.println(userMail);
		System.out.println(timingslot);
		newuseradding.deleteInServiceLayer(userMail, timingslot);
		
		ModelAndView view = new ModelAndView("deleteSlots");
		return view;
		
	 }
	

}
