package com.au.Assignment.controllers;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.au.Assignment.Model.Order;
import com.au.Assignment.Service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService os;

	@PostMapping("/create")
	public ResponseEntity<String> createOrder() {
		String response = os.createOrder();
		return ResponseEntity.ok(response);
	}

	@PostMapping("/add")
	public ResponseEntity<Order> createOrder(@RequestBody @Validated Order order) {
		Order order2 = os.addOrder(order);
		if (Objects.nonNull(order)) {
			return ResponseEntity.ok(order2);
		} else {
			System.out.println("Error handling  put all required feilds");
			return ResponseEntity.ok(order2);
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable("id") @NonNull Integer id, @RequestBody Map<String, Integer> orderdet2) {
		Integer quantity = orderdet2.get("quantity");
		Order order = (Order) os.getOrderById(id);
		order.setQuantity(quantity);
		os.updateOrder(order);

		return ResponseEntity.ok(order);

	}

	@GetMapping("get/{id}")
	public Object getOrderById(@PathVariable("id") @NonNull int id) {
		Order order = (Order) os.getOrderById(id);
		if (Objects.nonNull(order)) {
			return ResponseEntity.ok(order);
		} else {
			return new ResponseEntity<>(order, HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/delete/{id}")
	public String deleteOrder(@PathVariable("id") @NonNull int id) {
		return os.deleteOrder(id);
	}

}
