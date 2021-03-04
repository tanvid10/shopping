package onlineshopping.inventory.service;

import java.util.List;

import onlineshopping.document.Inventory;

public interface InventoryService {

	/* creates new inventory */
	public Inventory createInventory(Inventory inventory);
	
	/* deletes all inventories */
	public void deleteAll();
	
	/* updates inventory details */
	public void updateProduct(Inventory inventory);
	
	/* deletes inventory by id */
	public void deleteInventory(String id);
	
	/* gets all inventories */
	public List<Inventory> getAll();

	/* gets inventory by name */
	public Inventory getByName(String productName);
	
}
