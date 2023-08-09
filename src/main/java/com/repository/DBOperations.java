package com.repository;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CustomerDTO;
import com.entity.Customer;
import com.entity.UserBookings;

import jakarta.servlet.http.HttpServletRequest;

@Repository
public class DBOperations {

	@Autowired
	DBProcess dataTasks;
	
	@Autowired
	UserBookingsImpl dataBook;


	public CustomerDTO userAddingImplentation(Customer data)
	{
		Customer save = dataTasks.save(data);
		CustomerDTO duplicate = new CustomerDTO();
		BeanUtils.copyProperties(save, duplicate);
		List<UserBookings> customermail = save.getCustomermail();
		for (UserBookings userBookings : customermail) {
			System.out.println(userBookings);
			userBookings.setTimings("7");
			
		}
		String usermail="";
		String timings="";
		for (UserBookings userBookings : customermail) {
			System.out.println(userBookings);
			 timings = userBookings.getTimings();
			 usermail = userBookings.getUsermail();
			 System.out.println(usermail+"******************************");
			
		}
		
		UserBookings userBookings = new UserBookings(0, usermail, timings);
		UserBookings save2 = dataBook.save(userBookings);
		

		return duplicate;
	}


	public boolean newUserAdding(HttpServletRequest data)
	{
		String username = data.getParameter("name");
		String address = data.getParameter("address");
		String gender = data.getParameter("gender");
		String phonenumber = data.getParameter("phonenumber");

		String email = data.getParameter("email");
		String password = data.getParameter("password");
		Customer newUser = new Customer(0, username, gender, address, email, password, phonenumber, null);
		Customer save = dataTasks.save(newUser);
		System.out.println(save);
		CustomerDTO customerDTO = new CustomerDTO();
		BeanUtils.copyProperties(save, customerDTO);
		System.out.println(customerDTO+"Copied Data From Database*******************************************");
        UserBookings userBookings = new UserBookings(0, email, "2");
        UserBookings save2 = dataBook.save(userBookings);
        System.out.println(save2);
		if(save !=null)
		{
			return true;
		}

		else
		{
			return false;
		}
	}


	public Boolean loginDataChecking(HttpServletRequest login) 

	{

		System.out.println("Repository Layer*****************************************");

		String email = login.getParameter("email");
		String password = login.getParameter("password");
		//		dataTasks
		Customer customer = dataTasks.findByEmailAndPassword(email, password);
		if(customer !=null)
		{


			System.out.println(customer);
			if(customer.getEmail().equals(email) & customer.getPassword().equals(password))
			{
				System.out.println("Valid credentials");
				return true;
			}
			else
			{
				System.out.println("InValid credentials");

				return false;
			}
		}
		return false;

	}
}
