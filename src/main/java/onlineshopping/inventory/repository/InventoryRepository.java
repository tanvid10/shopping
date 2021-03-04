package onlineshopping.inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import onlineshopping.document.Inventory;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String>{

	/* finds product by name */
	Inventory findByProductName(String name);
}
