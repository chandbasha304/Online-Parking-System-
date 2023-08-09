package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Customer;
import java.util.List;


public interface DBProcess extends JpaRepository<Customer, Integer> {
	
	
	Customer findByEmailAndPassword(String customername,String password);

}
