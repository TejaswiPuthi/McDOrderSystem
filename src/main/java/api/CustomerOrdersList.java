package main.java.api;

import java.util.ArrayList;
import java.util.List;


public class CustomerOrdersList {
public static List<CustomerDeliveryInformation> customerOrderList = new ArrayList<CustomerDeliveryInformation>();
	
	public List<CustomerDeliveryInformation> getCustomerOrderList() {
		return customerOrderList;
	}

	public void addCustomerOrder(CustomerDeliveryInformation customerDelivery) {
		customerOrderList.add(customerDelivery);
//		System.out.println(customerOrderList);
	}
}
