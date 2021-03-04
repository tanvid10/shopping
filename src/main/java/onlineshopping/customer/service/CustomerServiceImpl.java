package onlineshopping.customer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import onlineshopping.customer.repository.CustomerRepository;
import onlineshopping.document.Customer;
import onlineshopping.document.Order;
import onlineshopping.order.repository.OrderRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	/* will help to use repository functions to perform operations */
	@Autowired
	CustomerRepository customerRepo;

	/* creates new customer */
	public Customer createCustomer(Customer customer) {
		return customerRepo.insert(customer);
	}

	/* gets customers by name */
	public Customer getByName(String name) {
		Customer customer=customerRepo.findByName(name);
		if(customer.isDeleted==false)
			return customer;
		else 
			return null;
	}
	
	public Customer getById(int id)
	{
		Customer customer=customerRepo.findById(id).get();
		if(customer.isDeleted==false)
			return customer;
		else 
			return null;
	}

	/* deletes customer by id */
	public String deleteCustomerByName(String name) {
		if(customerRepo.findByName(name).isDeleted==false)
		{
			customerRepo.deleteByName(name);
			String deleted="deleted";
			return deleted;
		}
		else
		{
			String string="not eligible for deleting";
			return string;
		}	
	}

	/* deletes all customers */
	public void deleteAllCustomers() { 
		customerRepo.deleteAll(); 
	}

	/* updates customer details */
	public void updateCustomer(Customer customer) {
		customerRepo.save(customer);
	}

	/* gets customers by status */
	public List<Customer> getByStatus(String status)
	{
		return customerRepo.findByStatus(status);
	}

	/* gets customers by pagination */
	public Map<String, Object> getAllCustomersInPage(int pageNo, int pageSize, String sortBy) {
		Map<String, Object> response= new HashMap<String, Object>();
		Sort sort= Sort.by(sortBy);
		Pageable page= PageRequest.of(pageNo, pageSize, sort);
		Page<Customer> customerPage=customerRepo.findAll(page);
		response.put("data", customerPage.getContent());
		response.put("total no. of pages ", customerPage.getTotalPages());
		response.put("total no, of elements ", customerPage.getNumberOfElements());
		response.put("current page no. ", customerPage.getNumber());
		return response;
	}
	
	@Autowired
	OrderRepository orderRepo;
	
	public List<Order> allOrdersOfCustomer(int id) throws Exception
	{
		Optional<Customer> customer=customerRepo.findById(id);
		if(!customer.isPresent())
			throw new Exception("customer not present");
		else
		{
			return orderRepo.findAllByCustomerId(customer.get().getId());
		}
	}
}
