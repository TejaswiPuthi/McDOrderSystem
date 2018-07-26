package main.java.rest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

//
@Path("Order")
public class OrderService {
	
	OnlineOfflineLogic logic = new OnlineOfflineLogic();
	Result result = new Result();
	Date date = new Date();   
	Calendar calendar = GregorianCalendar.getInstance(); 
	
	
	@Path("/Check")
	@Produces(MediaType.TEXT_PLAIN)
	@GET
	public String checkMethod() {
		return "Hello World";
	}
//	
//	
	Result response = new Result();
	@Path("/Online")
	@Produces("application/json")
	@POST
	public Result onlineOrder(@FormParam("CustomerDeliveryInformation") String customerDelivery) {
		
//	System.out.println("tejasw");
//	System.out.println(customerDelivery.getClass());
	//check if the customer is valid customer
	
	
//	System.out.println("before try block");
	try {
//		System.out.println("in try block before");
		logic.repeat(customerDelivery);
//		logic = new OnlineOfflineLogic(customerDelivery);
//		System.out.println("in try block after");
	}catch(Exception e) {
//		System.out.println("in catch");
		System.out.println("exception "+e);
	}
//		System.out.println("after try block");
		if(logic.ifValidCustomer()) {
			//get current time 
//			System.out.println("valid");
			calendar.setTime(date);
			int current_hour = calendar.get(Calendar.HOUR_OF_DAY);
//			System.out.println(date);
			if(current_hour > 8 && current_hour <10) {
				if(logic.ifValidCoupon()) {
					int order_id = logic.addCustomerOrder(date,"Online");
					
					result.setCode(200);
					result.setMessage("Order ID" + order_id);
					return result;
				}
				else {
					result.setCode(400);
					result.setMessage("Coupon code not valid");
				}
			}
			else if(current_hour > 10 && current_hour <22) {
				if(!logic.ifValidCoupon()) {
					int order_id = logic.addCustomerOrder(date,"Online");
					logic.addProductOrder();
					result.setCode(200);
					result.setMessage("Order ID: " + order_id);
					return result;
				}
			}
			else {
				result.setCode(400);
				result.setMessage("Orders not accepted at this time");
				return result;
			}
			
		}
		
		result.setCode(401);
		result.setMessage("Customer not registered");
		return result;
		
	}
	
	
	@POST
	@Path("/Offline")
	@Produces("application/json")
	public Result offlineOrder(@FormParam("CustomerDeliveryInformation")  String customerDelivery) {
		logic.repeat(customerDelivery);
		if(logic.ifValidCustomer()) {
			calendar.setTime(date);
			int current_hour = calendar.get(Calendar.HOUR_OF_DAY);
//			System.out.println(date);
//			System.out.println(current_hour); 
			if(current_hour > 8 && current_hour <10) {	
					result.setCode(400);
					result.setMessage("Offline Orders not accepted at this moment");
					return result;
			}
			else if (current_hour >= 10 && current_hour <22) {
				if(!logic.ifValidCoupon()) {
					int order_id = logic.addCustomerOrder(date,"Offline");
					logic.addProductOrder();
					result.setCode(200);
					result.setMessage("Order ID: " + order_id);
					return result;
				}
				else {
					result.setCode(400);
					result.setMessage("Coupon is not applicable at this time");
					return result;
				}
			}
			else {
				result.setCode(400);
				result.setMessage("Orders not accepted at this time");
				return result;
			}
			
		}
		else {
			result.setCode(401);
			result.setMessage("Customer not registered");
			return result;
		}
		
	}
}
