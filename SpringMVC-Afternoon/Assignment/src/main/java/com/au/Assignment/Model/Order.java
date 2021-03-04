package com.au.Assignment.Model;

public class Order {

	private Integer orderId;
	private String itemName;
	private Integer quantity;

	public Order() {
		super();
	}

	public Order(Integer orderId, String itemName, Integer quantity) {
		super();
		this.orderId = orderId;
		this.itemName = itemName;
		this.quantity = quantity;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
