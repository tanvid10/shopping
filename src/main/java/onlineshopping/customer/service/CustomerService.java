package onlineshopping.customer.service;

import java.util.List;
import java.util.Map;

import onlineshopping.document.Customer;
import onlineshopping.document.Order;

public interface CustomerService {

	/* creates new customer */
	public Customer createCustomer(Customer customer);
	
	/* gets customers by name */
	public Customer getByName(String name);
	
	public Customer getById(int id);
	
	/*deletes customer by id*/
	public String deleteCustomerByName(String name);
	
	/* deletes all customers */ 
	public void deleteAllCustomers();
	
	/* updates customer details */
	public void updateCustomer(Customer customer);

	/* gets customers by status */
	public List<Customer> getByStatus(String status);
	
	/* gets customers by pagination */
	public Map<String, Object> getAllCustomersInPage(int pageNo, int pageSize, String sortBy);

	public List<Order> allOrdersOfCustomer(int id) throws Exception;
}
