package com.au.Kafka.model;

public class Order {

	private int id, quantity, price;
	private String category;

	public Order() {
		super();
	}

	public Order(int id, int quantity, int price, String category) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
