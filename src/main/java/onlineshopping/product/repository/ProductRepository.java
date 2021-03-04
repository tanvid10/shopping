package onlineshopping.product.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import onlineshopping.document.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
	
	/* to find product by name */
	public Product findByName(String name);
	
	public Optional<Product> findById(String id);
}