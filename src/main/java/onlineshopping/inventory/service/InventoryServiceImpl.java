package onlineshopping.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlineshopping.document.Inventory;
import onlineshopping.inventory.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService{

	/* will help to use repository functions to perform operations */
	@Autowired
	InventoryRepository inventoryRepo;

	/* creates new inventory */
	public Inventory createInventory(Inventory inventory) {
		return inventoryRepo.insert(inventory);
	}

	/* deletes all inventories */
	public void deleteAll() {
		inventoryRepo.deleteAll();
	}

	/* updates product details */
	public void updateProduct(Inventory inventory) {
		inventoryRepo.save(inventory);
	}

	/* deletes inventory by id */
	public void deleteInventory(String id) {
		inventoryRepo.deleteById(id);
	}

	/* gets all inventories */
	public List<Inventory> getAll() {
		return inventoryRepo.findAll();
	}
	
	/* gets inventory by name */
	public Inventory getByName(String productName) 
	{
		return inventoryRepo.findByProductName(productName);
	}
}

