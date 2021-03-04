package onlineshopping.inventory.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import onlineshopping.document.Inventory;
import onlineshopping.document.Product;
import onlineshopping.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;
	
	/* to save new inventory details into the database */
	@PostMapping(value = "/create")
	public Inventory create(@RequestBody Inventory inventory) {
		return inventoryService.createInventory(inventory);
	} 
	
	/* deletes all the inventories */
	@DeleteMapping(value = "/deleteAll") 
	public String deleteAll() {
		inventoryService.deleteAll(); 
		return "All inventory records deleted.";
	} 
	
	/* updates inventory by product id */
	@PutMapping(value= "/update/{id}") 
	public void update(@PathVariable(value= "id") Product id, @RequestBody Inventory inventory) 
	{ 
		inventoryService.updateProduct(inventory); 
	}
	
	/* deletes inventory by product id */
	@DeleteMapping(value= "/delete/{id}") 
	public void delete(@PathVariable(value= "id") String id) 
	{ 
		inventoryService.deleteInventory(id); 
	}
	
	/* gets all the inventories */
	@GetMapping(value = "/getAll")
	public List<Inventory> getAll() {
		return inventoryService.getAll();
	}
	
	/* gets inventory by name*/
	@GetMapping("get/{name}")
	public Inventory getByName(@PathVariable("name") String productName) 
	{
		return inventoryService.getByName(productName);
	}
}
