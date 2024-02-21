package com.foodorder.services;

import java.util.List;

import com.foodorder.entities.Customer;
import com.foodorder.entities.Order;

public interface OrderService {

	Order saveOrder(Order order);
	List<Order> getAllOrders();
	List<Order> getCustomerOrders(Customer customer);
	Order findById(int id);
}
