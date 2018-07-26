package main.java.api;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;




public class OnlineOfflineLogic {
	
	
	CustomerOrdersList list = new CustomerOrdersList();
	//converting string to object
	CustomerDeliveryInformation delivery = new CustomerDeliveryInformation();
	public OnlineOfflineLogic() {
		
	}
//	
//	public OnlineOfflineLogic(String customerDeliveryInformation){
//
//		delivery = new CustomerDeliveryInformation();
//		System.out.println(customerDeliveryInformation);
//		System.out.println("jaykishan");
//		ObjectMapper mapper = new ObjectMapper();
////		
//		System.out.println("varaa");
//
//			try {
//				delivery = mapper.readValue(customerDeliveryInformation,CustomerDeliveryInformation.class);
//			} catch (JsonParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (JsonMappingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
	
	
	public CustomerDeliveryInformation repeat(String hello) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			delivery = mapper.readValue(hello,CustomerDeliveryInformation.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delivery;
		
//		System.out.println(hello);
		
		
	}
//to check if the customer is valid or not
	public boolean ifValidCustomer() {
		
	//check the id of the customer;
		CustomerList customerList = new CustomerList();
		for(Customer customer:customerList.getCustomers()) {
		
			if(delivery.getCustomerId() == customer.getId()) {
				return true;
			}
		
	}
		return false;

}
	public boolean ifValidCoupon() {
		
		if(delivery.getCouponCode() != null) {
		
		if (delivery.getCouponCode().equals("McDCoupon")){
			return true;
		}
		}
		return false;
	}
	
	public int addCustomerOrder(Date date,String type) {
		
		
		delivery.setOrderTime(date);
//		System.out.println(list.getCustomerOrderList().size());
		int order_id = (list.getCustomerOrderList().size())+1;
		delivery.setOrderId(order_id);
		delivery.setOrderType(type);
		list.addCustomerOrder(delivery);
		return order_id;
		
	}
	
	public void addProductOrder() {
		int flag;
		List<Order> orders = delivery.getOrders();
		ProductList list = new ProductList();
		List<Product> products = list.getProducts();
		ProductOrdersList ordersList = new ProductOrdersList();
		List<Product> orderList_products = ordersList.getProductOrderList();
		for (Order order: orders) {
			flag = 0;
			int id = order.getProductId();
			for (Product p: orderList_products) {
				if(p.getProductId() == id) {
					p.setProductQuantity(p.getProductQuantity()+order.getProductQuntity());
					flag = 1;
					break;
				}
			}
			if(flag == 0) {
			for(Product product: products) {
				if(product.getProductId() == id) {
					product.setProductQuantity(product.getProductQuantity()+order.getProductQuntity());
					ordersList.addProduct(product);
				}
			}
		}
	}
	
	}
}
