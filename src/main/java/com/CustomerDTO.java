package com;

public class CustomerDTO {
	
	
	private int id;
	private String customername;
	private String gender;
	private String address;
	private String email;
	private String phonenumber;
	
	
	
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



	public String getPhonenumber() {
		return phonenumber;
	}



	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}



	public CustomerDTO(int id, String customername, String gender, String address, String email, String phonenumber) {
		this.id = id;
		this.customername = customername;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phonenumber = phonenumber;
	}



	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", customername=" + customername + ", gender=" + gender + ", address="
				+ address + ", email=" + email + ", phonenumber=" + phonenumber + "]";
	}



	public CustomerDTO() {
	}
	
	



	
}
