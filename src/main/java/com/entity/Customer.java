package com.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	private String customername;
	private String gender;
	private String address;
	
	private String email;


	private String password;
	private String phonenumber;
  @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
  private List<UserBookings> customermail;
	


	
	
	

	public int getId() {
	return id;
}







public void setId(int id) {
	this.id = id;
}







public String getCustomername() {
	return customername;
}







public void setCustomername(String customername) {
	this.customername = customername;
}







public String getGender() {
	return gender;
}







public void setGender(String gender) {
	this.gender = gender;
}







public String getAddress() {
	return address;
}







public void setAddress(String address) {
	this.address = address;
}







public String getEmail() {
	return email;
}







public void setEmail(String email) {
	this.email = email;
}







public String getPassword() {
	return password;
}







public void setPassword(String password) {
	this.password = password;
}







public String getPhonenumber() {
	return phonenumber;
}







public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}







public List<UserBookings> getCustomermail() {
	return customermail;
}







public void setCustomermail(List<UserBookings> customermail) {
	this.customermail = customermail;
}







	public Customer(int id, String customername, String gender, String address, String email, String password,
		String phonenumber, List<UserBookings> customermail) {
	this.id = id;
	this.customername = customername;
	this.gender = gender;
	this.address = address;
	this.email = email;
	this.password = password;
	this.phonenumber = phonenumber;
	this.customermail = customermail;
}







	@Override
	public String toString() {
		return "Customer [id=" + id + ", customername=" + customername + ", gender=" + gender + ", address=" + address
				+ ", email=" + email + ", password=" + password + ", phonenumber=" + phonenumber + ", customermail="
				+ customermail + "]";
	}







	public Customer() {
	}


}
