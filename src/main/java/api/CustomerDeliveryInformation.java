package main.java.api;

import java.util.Date;
import java.util.List;
//import com.fasterxml.jackson.core.JsonParser;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;




public class CustomerDeliveryInformation {
	
	@JsonProperty("customerId")
	private int customerId;
	
	@JsonProperty("mobileNumber")
	private int mobileNumber;
	
	@JsonProperty("deliveryAddress")
	private String deliveryAddress;
	
	@JsonProperty("pincode")
	private String pincode;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("couponCode")
	private String couponCode;
	
	@JsonProperty("orders")
	private List<Order> orders = null;
	
	@JsonIgnore
	private int orderId;
	@JsonIgnore
	private Date orderTime;
	@JsonIgnore
	private String orderType;

	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	@JsonProperty("customerId")
	public int getCustomerId() {
		return customerId;
	}

	@JsonProperty("customerId")
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	
	@JsonProperty("mobileNumber")
	public int getMobileNumber() {
		return mobileNumber;
	}

	@JsonProperty("mobileNumber")
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@JsonProperty("deliveryAddress")
	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	@JsonProperty("deliveryAddress")
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	@JsonProperty("pincode")
	public String getPincode() {
		return pincode;
	}

	@JsonProperty("pincode")
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("orders")
	public List<Order> getOrders() {
		return orders;
	}

	@JsonProperty("orders")
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	
	@Override
	public String toString() {
		return "CustomerDeliveryInformation [customerId=" + customerId + ", mobileNumber=" + mobileNumber
				+ ", deliveryAddress=" + deliveryAddress + ", pincode=" + pincode + ", email=" + email
				+ ", orders=" + orders + "]";
	}
	

}
