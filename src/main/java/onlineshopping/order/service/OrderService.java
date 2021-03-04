package onlineshopping.order.service;

import java.util.List;

import onlineshopping.document.Order;

public interface OrderService {

	/* creates new order */
	public String createOrder(Order order);
	
	/* gets all the orders */
	public List<Order> getAll();

	/* gets order by id */
	public Order get(int id);

	public String whoseOrder(String customerId) throws Exception;

}
