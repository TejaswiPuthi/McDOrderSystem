package test.rest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.rest.Customer;
import main.java.rest.CustomerList;
import main.java.rest.OnlineOfflineLogic;
import main.java.rest.OrderService;
import main.java.rest.ProductOrdersList;

class OnlineOfflineTest {

	OnlineOfflineLogic logic = new OnlineOfflineLogic();
	OrderService orderService = new OrderService();
	ProductOrdersList productOrders = new ProductOrdersList();
	static List<String> customerDeliveryInformation;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		customerDeliveryInformation =new ArrayList<>();
		customerDeliveryInformation.add("{\r\n" + 
				"	\"customerId\": 1,\r\n" + 
				"	 \r\n" + 
				"	\"mobileNumber\": 1234567890,\r\n" + 
				"	\"deliveryAddress\": \"dsfsdf sfsdfcsdfds\",\r\n" + 
				"	\"pincode\": \"sdfsdfsdf\",\r\n" + 
				"	\"email\": \"graut@nicesoftwaresolutions.com\",\r\n" + 
				"	\"orders\": [{\r\n" + 
				"		\"productId\": 1,\r\n" + 
				"		\"productQuntity\": 4\r\n" + 
				"	}, {\r\n" + 
				"		\"productId\": 2,\r\n" + 
				"		\"productQuntity\": 5\r\n" + 
				"	}]\r\n" + 
				"}");
		
		customerDeliveryInformation.add("{\r\n" + 
				"	\"customerId\": 4,\r\n" + 
				"	 \r\n" + 
				"	\"mobileNumber\": 1234567890,\r\n" + 
				"	\"deliveryAddress\": \"dsfsdf sfsdfcsdfds\",\r\n" + 
				"	\"pincode\": \"sdfsdfsdf\",\r\n" + 
				"	\"email\": \"graut@nicesoftwaresolutions.com\",\r\n" + 
				"	\"orders\": [{\r\n" + 
				"		\"productId\": 3,\r\n" + 
				"		\"productQuntity\": 3\r\n" + 
				"	}, {\r\n" + 
				"		\"productId\": 4,\r\n" + 
				"		\"productQuntity\": 4\r\n" + 
				"	}]\r\n" + 
				"}");
		
		
		customerDeliveryInformation.add("{\r\n" + 
				"	\"customerId\": 4,\r\n" + 
				"	 \r\n" + 
				"	\"mobileNumber\": 1234567890,\r\n" + 
				"	\"deliveryAddress\": \"dsfsdf sfsdfcsdfds\",\r\n" + 
				"	\"pincode\": \"sdfsdfsdf\",\r\n" + 
				"	\"email\": \"graut@nicesoftwaresolutions.com\",\r\n" + 
				"	\"orders\": [{\r\n" + 
				"		\"productId\": 5,\r\n" + 
				"		\"productQuntity\": 5\r\n" + 
				"	}, {\r\n" + 
				"		\"productId\": 6,\r\n" + 
				"		\"productQuntity\": 5\r\n" + 
				"	}]\r\n" + 
				"}");
		
		
		
		customerDeliveryInformation.add("{\r\n" + 
				"	\"customerId\": 4,\r\n" + 
				"	 \r\n" + 
				"	\"mobileNumber\": 1234567890,\r\n" + 
				"	\"deliveryAddress\": \"dsfsdf sfsdfcsdfds\",\r\n" + 
				"	\"pincode\": \"sdfsdfsdf\",\r\n" + 
				"	\"email\": \"graut@nicesoftwaresolutions.com\",\r\n" + 
				"	\"orders\": [{\r\n" + 
				"		\"productId\": 6,\r\n" + 
				"		\"productQuntity\": 4\r\n" + 
				"	}, {\r\n" + 
				"		\"productId\": 5,\r\n" + 
				"		\"productQuntity\": 5\r\n" + 
				"	}]\r\n" + 
				"}");
	
		
	}

	@Test
	void getAllCustomerList() {
		CustomerList list  = new CustomerList();
		List<Customer> customers = list.getCustomers();
		System.out.println("online "+customers.size());
		System.out.println("online "+customers.get(1).getName());
		Assertions.assertEquals(5, customers.size());
		Assertions.assertEquals("Sai Kumar", customers.get(1).getName());
	}
	
	@Test
	void repeatTest() {
		logic.repeat(customerDeliveryInformation.get(1));
		Assertions.assertTrue(logic.ifValidCustomer());
		Assertions.assertFalse(logic.ifValidCoupon());
	}
	
//	@Test
//	void addProductOrderTest() {
//		logic.repeat(customerDeliveryInformation.get(1));
//		logic.addProductOrder();
//		System.out.println(productOrders.getProductOrderList().get(1).getProductQuantity());
//		System.out.println(productOrders.getProductOrderList().size());
//		Assertions.assertEquals(4,productOrders.getProductOrderList().get(1).getProductQuantity());
//		Assertions.assertEquals(2,productOrders.getProductOrderList().size());
//	}
	
	@Test
	void getStatisticsOnOrderProductTest() {
		logic.repeat(customerDeliveryInformation.get(1));
		logic.addProductOrder();
		logic.repeat(customerDeliveryInformation.get(0));
		logic.addProductOrder();
		logic.repeat(customerDeliveryInformation.get(2));
		logic.addProductOrder();
		
		
	}
	

}
