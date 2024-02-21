package com.foodorder.services;

import java.util.List;

import com.foodorder.entities.Order;
import com.foodorder.entities.OrderDetails;

public interface OrderdetailService {

	void saveOrderDetails(OrderDetails od);
	OrderDetails findById(int id);
	List<OrderDetails> findByOrder(Order order);
}
