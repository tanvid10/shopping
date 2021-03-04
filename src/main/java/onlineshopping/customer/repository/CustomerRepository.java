package onlineshopping.customer.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import onlineshopping.document.Customer;
@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer>{
	/**
	 * finds customer by name
	 * @param name
	 * @return customer 
	 */
	public Customer findByName(String name);
	
	/**
	 * finds customer by status
	 * @param status
	 * @return Customer
	 */
	public List<Customer> findByStatus(String status);
	
	/**
	 * deletes customer by name
	 * @param name
	 */
	public void deleteByName(String name);
}
