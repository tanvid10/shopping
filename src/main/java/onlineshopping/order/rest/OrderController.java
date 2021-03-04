package onlineshopping.order.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onlineshopping.document.Order;
import onlineshopping.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	/* to save new order details into the database */
	@PostMapping("/create")
	public String createOrder(@RequestBody Order order)
	{
		return orderService.createOrder(order);
	}

	/* get all the orders */
	@GetMapping("/getAll")
	public List<Order> getAll()
	{
		return orderService.getAll();
	}

	/* gets order by customer id */
	@GetMapping("/{id}")
	public Order get(@PathVariable("id") int id)
	{
		return orderService.get(id);
	}
	
	@GetMapping("/whoseOrder/{id}")
	public String whoseOrder(@PathVariable("id") String id) throws Exception
	{
		return orderService.whoseOrder(id);
	}
}
