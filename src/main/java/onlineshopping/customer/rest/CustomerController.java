package onlineshopping.customer.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import onlineshopping.customer.service.CustomerService;
import onlineshopping.document.Customer;
import onlineshopping.document.Order;

@RequestMapping("/customer")
@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;

	/* to save new customer details into the database */
	@PostMapping(value = "/create")
	public Customer create(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}

	/* fetches customers by name */
	@GetMapping(value="/getByName/{name}")
	public Customer getByName(@PathVariable("name") String name)
	{
		return customerService.getByName(name);
	}
	
	@GetMapping(value="/getById/{id}")
	public Customer getById(@PathVariable("id") int id)
	{
		return customerService.getById(id);
	}

	/* deletes customers by customer name(performing hard delete) */
	@DeleteMapping(value= "/delete/{name}") 
	public String delete(@PathVariable("name") String name) {
		return customerService.deleteCustomerByName(name); 
	}

	/* deletes all the customers(performing hard delete) */
	@DeleteMapping(value = "/deleteAll") 
	public String deleteAll() {
		customerService.deleteAllCustomers(); 
		return "All customer records deleted.";
	} 
	
	/* updates customer by name */
	@PutMapping(value= "/update/{name}") 
	public void update(@PathVariable(value= "name") String name, @RequestBody Customer customer) 
	{ 
		customerService.updateCustomer(customer); 
	}
	
	/* fetches customer by status */
	@GetMapping(value="getByStatus/{status}")
	public List<Customer> getByStatus(@PathVariable("status") String status)
	{
		return customerService.getByStatus(status);
	}
	 
	/* gets customers by pagination */
	@GetMapping(value = "/page/{pageno}")
	public Map<String, Object> getAllCustomersInPage(@PathVariable("pageno") int pageNo,
			@RequestParam(name= "pagesize", defaultValue ="2") int pageSize,
			@RequestParam(name= "sortby", defaultValue ="id") String sortBy) {
		return customerService.getAllCustomersInPage(pageNo, pageSize, sortBy);
	}
	
	@GetMapping(value="/getOrders/{id}")
	public List<Order> allOrdersOfCustomer(@PathVariable("id") int id) throws Exception
	{
		return customerService.allOrdersOfCustomer(id);
	}
}
