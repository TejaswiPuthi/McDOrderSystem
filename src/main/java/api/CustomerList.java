package main.java.api;

import java.util.ArrayList;
import java.util.List;



public class CustomerList {
	
List<Customer> customers = new ArrayList<Customer>();
	
	public CustomerList(){
		
		Customer customer = new Customer();
		customer.setAddress("Shantipuaram,Visakhapatnam,50-92-27");
		customer.setDob("01-02-1997"); 
		customer.setEmail("tejaswiputhi@gmail.com");
		customer.setGender('F');
		customer.setId(1);
		customer.setMobileNo(773679536);
		customer.setName("Tejaswi");
		customer.setPincode(530016);
		customers.add(customer);
		
		
		customer = new Customer();
		customer.setAddress("Bellandur,Bangalore,flat no:230");
		customer.setDob("21-08-1996");
		customer.setEmail("saikumar@gmail.com");
		customer.setGender('M');
		customer.setId(2);
		customer.setMobileNo(951510068);
		customer.setName("Sai Kumar");
		customer.setPincode(813004);
		customers.add(customer);
		
		
		customer = new Customer();
		customer.setAddress("Miyapur,Hyderabad,23-98-12");
		customer.setDob("22-10-1994");
		customer.setEmail("anthony_94@gmail.com");
		customer.setGender('M');
		customer.setId(3);
		customer.setMobileNo(90250426);
		customer.setName("Anthony");
		customer.setPincode(530123);
		customers.add(customer);
		
		
		customer = new Customer();
		customer.setAddress("Calicut,Kerala,NITC campus");
		customer.setDob("23-12-1994");
		customer.setEmail("varalaxmi@gmail.com");
		customer.setGender('F');
		customer.setId(4);
		customer.setMobileNo(995101291);
		customer.setName("VaraLaxmi");
		customer.setPincode(321004);
		
		customers.add(customer);
		
		customer = new Customer();
		customer.setAddress("Ahmedabad,Gujarath,IIITV");
		customer.setDob("30-12-1996");
		customer.setEmail("anuradha@gmail.com");
		customer.setGender('F');
		customer.setId(5);
		customer.setMobileNo(773679536);
		customer.setName("AnuRadha");
		customer.setPincode(123456);
		customers.add(customer);
		
		
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	

}
