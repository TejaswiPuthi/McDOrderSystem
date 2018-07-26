package test.rest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.rest.*;

class StatisticsTest {
	StatisticsService statisticsTest = new StatisticsService();
	static OnlineOfflineLogic logic = new OnlineOfflineLogic();
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
				"	\"customerId\": 2,\r\n" + 
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
				"	\"customerId\": 2,\r\n" + 
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
	
		int i =1;
		ProductList productList = new ProductList();
		ProductOrdersList productOrdersList = new ProductOrdersList();
		List<Product> products = productList.getProducts();
		for (Product product:products) {
			product.setProductQuantity(i);
			productOrdersList.addProduct(product);
			i++;
		}
		Calendar cal = Calendar.getInstance();
		CustomerOrdersList customerOrders = new CustomerOrdersList();
		for (String deliveryInformation: customerDeliveryInformation) {
			CustomerDeliveryInformation customer = logic.repeat(deliveryInformation);
			customer.setOrderType("Online");
			cal.set(2018, 7, 21, 9, 10);
			customer.setOrderTime(cal.getTime());
			customerOrders.addCustomerOrder(customer);
		}
		
		
		
	}

	@Test
	void getStatisticsOnOrderProductTest() {
		List<Product> products = statisticsTest.productList();
		System.out.println("statistics "+products.size());
		System.out.println("statistics "+products.get(1).getProductQuantity());
		Assertions.assertEquals(12, products.size());
		Assertions.assertEquals(4, products.get(1).getProductQuantity());
	}
	
	@Test
	void getCustomerListTest() {
		List<Customer> customers = statisticsTest.customerList();
		Assertions.assertEquals(5, customers.size());
		Assertions.assertNotNull(customers);
	}
	
	@Test
	void getStatisticsOnHourBasisTest() {
		LinkedHashMap<String,String> statisticsOnHours = statisticsTest.staticsOnHourBasis();
		Assertions.assertEquals("0 %", statisticsOnHours.get("order8to9"));
		Assertions.assertEquals("100 %", statisticsOnHours.get("order9to10"));
	}
	
	@Test
	void getStatisticMenWomenOnHoursBasisTest() {
		List<LinkedHashMap<String,String>> genderStatistics = new ArrayList<>();
		genderStatistics = statisticsTest.menWomenStatictics();
		Assertions.assertEquals("male", genderStatistics.get(0).get("gender"));
		Assertions.assertEquals("0 %", genderStatistics.get(0).get("order10to11"));
		
	}
	
	@Test
	void getStatisticsOnOnlineOfflineOrderTest() {
		HashMap<String,Integer> onlineOfflineOrder = statisticsTest.onlineOffline();
		Assertions.assertEquals(0, onlineOfflineOrder.get("Offline").intValue());;
		Assertions.assertTrue(onlineOfflineOrder.get("Online").intValue() > 0);
		
	}

}
