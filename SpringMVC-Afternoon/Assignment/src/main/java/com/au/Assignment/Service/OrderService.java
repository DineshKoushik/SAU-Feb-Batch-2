package com.au.Assignment.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.au.Assignment.Model.Order;

@Service
public class OrderService {

	static List<Order> or = new ArrayList<Order>();

	public String createOrder() {
		return "Order Created Successfully";
	}

	public Order addOrder(Order order) {
		or.add(order);
		return order;
	}

	public Order getOrderById(int id) {
		
        Optional<Order> order = or.stream().filter( helper-> id == helper.getOrderId()).findFirst();
		
		if(order.isPresent()) {
			return order.get();
		}
		else{
			return null;
		}
	}
	public void updateOrder(Order order) {
		or.add(order);
	}

	public String deleteOrder(int id) {
		Optional<Order> order = or.stream().filter(helper -> id == helper.getOrderId()).findFirst();

		if (order.isPresent()) {
			or.remove(id);
			return "Deleted Successfully";
		}
		return "No such order";
	}
}

