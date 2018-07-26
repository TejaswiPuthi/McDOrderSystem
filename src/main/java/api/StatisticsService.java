package main.java.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.JSONObject;

@Path("statistics")
public class StatisticsService {
	CustomerOrdersList orders = new CustomerOrdersList();
	List<CustomerDeliveryInformation> ordersList;
	
	@POST
	@Path("/getStatisticsOnOrderProduct")
	@Produces("application/json")
	public List<Product> productList(){
		ProductOrdersList orderList = new ProductOrdersList();
		System.out.println(orderList.getProductOrderList());
		return(orderList.getProductOrderList());
	}
	
	
	@POST
	@Path("/getCustomerList")
	@Produces("application/json")
	public List<Customer> customerList() {
		CustomerList list = new CustomerList();
		return (list.getCustomers());
	}
	
	@POST
	@Path("/getStatisticsOnHourBasis")
	@Produces("application/json")
	public LinkedHashMap<String,String> staticsOnHourBasis(){
//		JSONObject result = new JSONObject();
		LinkedHashMap<String, String> result = 
                new LinkedHashMap<String, String>();
//		result.put("gender",null);
		System.out.println("in method");
		result.put("gender", null);
//		result.append("gender", null);
		int order8to9=0,order9to10=0,order10to11=0,order11to12=0,order12to13=0,order13to14=0,order14to15=0,order15to16=0,
				order16to17=0,order17to18=0,order18to19=0,order19to20=0,order20to21=0,order21to22=0;
		
		 ordersList = orders.getCustomerOrderList();
		for (CustomerDeliveryInformation customer : ordersList) {
			Date date = customer.getOrderTime();
			int hours = date.getHours();
			if(hours<9 && hours>=8) order8to9++;
			if(hours<10 && hours>=9) order9to10++;
			if(hours<11 && hours>=10) order10to11++;
			if(hours<12 && hours>=11) order11to12++;
			if(hours<13 && hours>=12) order12to13++;
			if(hours<14 && hours>=13) order13to14++;
			if(hours<15 && hours>=14) order14to15++;
			if(hours<16 && hours>=15) order15to16++;
			if(hours<17 && hours>=16) order16to17++;
			if(hours<18 && hours>=17) order17to18++;
			if(hours<19 && hours>=18) order18to19++;
			if(hours<20 && hours>=19) order19to20++;
			if(hours<21 && hours>=20) order20to21++;
			if(hours<22 && hours>=21) order21to22++;
		}
		int size = ordersList.size();
		System.out.println("size: "+size);
		if(size == 0) {
			result.put("orders","No orders yet");
		}
		else {
		result.put("order8to9", (order8to9/size)*100+" %");
		result.put("order9to10", (order9to10/size)*100+" %");
		result.put("order10to11", (order10to11/size)*100+" %");
		result.put("order11to12", (order11to12/size)*100+" %");
		result.put("order12to13",(order12to13/size)*100+" %");
		result.put("order13to14", (order13to14/size)*100+" %");
		result.put("order14to15", (order14to15/size)*100+" %");
		result.put("order15to16", (order15to16/size)*100+" %");
		result.put("order16to17", (order16to17/size)*100+" %");
		result.put("order17to18", (order17to18/size)*100+" %");
		result.put("order18to19", (order18to19/size)*100+" %");
		result.put("order19to20", (order19to20/size)*100+" %");
		result.put("order20to21", (order20to21/size)*100+" %");
		result.put("order21to22", (order21to22/size)*100+" %");
		}
//		System.out.println("result");
//		System.out.println(result);
		return result;
		
		
	}
	
	
	@POST
	@Produces("application/json")
	@Path("/getStatisticMenWomenOnHoursBasis")
	public List<LinkedHashMap<String,String>> menWomenStatictics() {
		List<LinkedHashMap<String,String>> list = new ArrayList<LinkedHashMap<String,String>>();
		LinkedHashMap<String,String> male = new LinkedHashMap<String,String>();
		LinkedHashMap<String,String> female = new LinkedHashMap<String,String>();
		CustomerList customerList  = new CustomerList();
		ordersList = orders.getCustomerOrderList();
		char gender= ' ';
		List<Customer> listCustomers = customerList.getCustomers();
		int m_size=0,f_size=0;
		int m_8=0,m_9=0,m_10=0,m_11=0,m_12=0,m_13=0,m_14=0,m_15=0,m_16=0,m_17=0,m_18=0,m_19=0,m_20=0,m_21=0;
		int f_8=0,f_9=0,f_10=0,f_11=0,f_12=0,f_13=0,f_14=0,f_15=0,f_16=0,f_17=0,f_18=0,f_19=0,f_20=0,f_21=0;
		for(CustomerDeliveryInformation customer : ordersList) {
			Date date = customer.getOrderTime();
			int hours = date.getHours();
			int id = customer.getCustomerId();
			for (Customer i : listCustomers) {
				if(i.getId() == id) {
					gender = i.getGender();
				}
			}
			if(gender == 'M') {
				m_size++;
				if(hours<9 && hours>=8) m_8++;
				if(hours<10 && hours>=9) m_9++;
				if(hours<11 && hours>=10) m_10++;
				if(hours<12 && hours>=11) m_11++;
				if(hours<13 && hours>=12) m_12++;
				if(hours<14 && hours>=13) m_13++;
				if(hours<15 && hours>=14) m_14++;
				if(hours<16 && hours>=15) m_15++;
				if(hours<17 && hours>=16) m_16++;
				if(hours<18 && hours>=17) m_17++;
				if(hours<19 && hours>=18) m_18++;
				if(hours<20 && hours>=19) m_19++;
				if(hours<21 && hours>=20) m_20++;
				if(hours<22 && hours>=21) m_21++;
			}
			else if(gender == 'F') {
				f_size++;
				if(hours<9 && hours>=8) f_8++;
				if(hours<10 && hours>=9) f_9++;
				if(hours<11 && hours>=10) f_10++;
				if(hours<12 && hours>=11) f_11++;
				if(hours<13 && hours>=12) f_12++;
				if(hours<14 && hours>=13) f_13++;
				if(hours<15 && hours>=14) f_14++;
				if(hours<16 && hours>=15) f_15++;
				if(hours<17 && hours>=16) f_16++;
				if(hours<18 && hours>=17) f_17++;
				if(hours<19 && hours>=18) f_18++;
				if(hours<20 && hours>=19) f_19++;
				if(hours<21 && hours>=20) f_20++;
				if(hours<22 && hours>=21) f_21++;
			}
			
			
		}
		male.put("gender", "male");
		if(m_size == 0) {
			male.put("orders", "No male orders");
		}
		else {
		
		male.put("order8to9", (m_8/m_size)*100+" %");
		male.put("order9to10", (m_9/m_size)*100+" %");
		male.put("order10to11", (m_10/m_size)*100+" %");
		male.put("order11to12", (m_11/m_size)*100+" %");
		male.put("order12to13", (m_12/m_size)*100+" %");
		male.put("order13to14", (m_13/m_size)*100+" %");
		male.put("order14to15", (m_14/m_size)*100+" %");
		male.put("order15to16", (m_15/m_size)*100+" %");
		male.put("order16to17", (m_16/m_size)*100+" %");
		male.put("order17to18", (m_17/m_size)*100+" %");
		male.put("order18to19", (m_18/m_size)*100+" %");
		male.put("order19to20", (m_19/m_size)*100+" %");
		male.put("order20to21", (m_20/m_size)*100+" %");
		male.put("order21to22", (m_21/m_size)*100+" %");
		}
		
		female.put("gender", "female");
		if(f_size == 0) {
			female.put("orders", "No female orders");
		}
		else {
		
		female.put("order8to9", (f_8/f_size)*100+" %");
		female.put("order9to10", (f_9/f_size)*100+" %");
		female.put("order10to11", (f_10/f_size)*100+" %");
		female.put("order11to12", (f_11/f_size)*100+" %");
		female.put("order12to13", (f_12/f_size)*100+" %");
		female.put("order13to14", (f_13/f_size)*100+" %");
		female.put("order14to15", (f_14/f_size)*100+" %");
		female.put("order15to16", (f_15/f_size)*100+" %");
		female.put("order16to17", (f_16/f_size)*100+" %");
		female.put("order17to18", (f_17/f_size)*100+" %");
		female.put("order18to19", (f_18/f_size)*100+" %");
		female.put("order19to20", (f_19/f_size)*100+" %");
		female.put("order20to21", (f_20/f_size)*100+" %");
		female.put("order21to22", (f_21/f_size)*100+" %");
		}
		
		list.add(male);
		list.add(female);
		return list;
		
	}
	
	
	@Path("/getStatisticOnOnlineOfflineOrder")
	@Produces("application/json")
	@POST
	public HashMap<String,Integer> onlineOffline(){
		HashMap<String,Integer> result = new HashMap<String,Integer>();
		ordersList = orders.getCustomerOrderList();
		int online=0,offline=0;
		for(CustomerDeliveryInformation customers:ordersList) {
			if(customers.getOrderType() == "Online") online++;	
			else if(customers.getOrderType() == "Offline") offline++;
		}
		result.put("Online", online);
		result.put("Offline",offline);
		return result;
	}
	
	

}
