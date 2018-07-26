package main.java.api;

public class Customer {

	
	private String address;
	private String dob;	//assume ddmmyyyy
	private String email;
	private char gender;
	private int id;
	private int mobileNo;
	private String name;
	private int pincode;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String string) {
		this.dob = string;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getName() {
		return name;
	}
//	public Integer getMobileNo() {
//		return mobileNo;
//	}
//	public void setMobileNo(Integer mobileNo) {
//		this.mobileNo = mobileNo;
//	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}
