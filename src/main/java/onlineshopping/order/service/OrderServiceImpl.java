package onlineshopping.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlineshopping.customer.repository.CustomerRepository;
import onlineshopping.document.Customer;
import onlineshopping.document.Inventory;
import onlineshopping.document.Order;
import onlineshopping.document.OrderDetails;
import onlineshopping.inventory.repository.InventoryRepository;
import onlineshopping.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	String str1="order created";
	String str2="order not created due to ";
	String str3= "this order is made by ";
	boolean flag;
	/* will help to use repository functions to perform operations */
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	InventoryRepository inventoryRepo;

	/* creates new order */
	public String createOrder(Order order) {
		String s=null;
		Inventory inventory;
		List<OrderDetails> orderDetails=order.getOrderDetails();
		for(OrderDetails ord:orderDetails)
		{
			int qty=ord.getOrderQty();/*stores the quantity of the product ordered*/
			inventory=inventoryRepo.findByProductName(ord.getProductName());
			if(qty==0||qty>inventory.getQuantity())
			{
				flag=false;/*to not save the order*/
				s=(str2+ord.getProductName());
				break;
			}
			else 
			{
				flag=true; /*to save the order*/
				s=str1;
			}
		}
		if(flag)/*if it is true, order is to created in the database, else not*/
		{
			for(OrderDetails ord:orderDetails)
			{
				inventory=inventoryRepo.findByProductName(ord.getProductName());
				inventory.setQuantity(inventory.calculateQty(inventory.getQuantity(), ord.getOrderQty()));
				inventoryRepo.save(inventory);
			}
			orderRepo.save(order);
		}
		return s;
	}
	
	/*to know whose order it is by order id*/
	public String whoseOrder(String id) throws Exception
	{
		Optional<Order> order=orderRepo.findById(id);
		if(!order.isPresent())
			throw new Exception("no such order");
		else
		{
			Optional<Customer> customer=customerRepo.findById(order.get().getCustomerId());
			if(!customer.isPresent())
				throw new Exception("customer not present");
			else
				return str3+customer.get().getName();
		}
	}

	/* gets all the orders */
	public List<Order> getAll() {
		return orderRepo.findAll();
	}

	/* gets order by id */
	public Order get(int id)
	{
		return orderRepo.findByCustomerId(id);
	}
}
