package onlineshopping.order.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import onlineshopping.document.Order;

public interface OrderRepository extends MongoRepository<Order,String>{

	//finds order by customer name
	public Order findByCustomerId(int customerId);

	public List<Order> findAllByCustomerId(int id);
}
