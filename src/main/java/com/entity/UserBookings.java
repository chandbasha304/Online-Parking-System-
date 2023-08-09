package com.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "userbookings")
public class UserBookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String usermail;
	private String timings;
	
	@ManyToOne
	@JoinColumn(name = "usermail", referencedColumnName = "email", insertable = false, updatable = false)
	private Customer customer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	public String getTimings() {
		return timings;
	} 
	public void setTimings(String timings) {
		this.timings = timings;
	}
	@Override
	public String toString() {
		return "UserBookings [id=" + id + ", usermail=" + usermail + ", timings=" + timings + "]";
	}
	public UserBookings(int id, String usermail, String timings) {
		this.id = id;
		this.usermail = usermail;
		this.timings = timings;
	}
	public UserBookings() {
		
	}
	
	

}
