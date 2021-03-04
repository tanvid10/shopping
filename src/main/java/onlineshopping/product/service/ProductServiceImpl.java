package onlineshopping.product.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import onlineshopping.document.Inventory;
import onlineshopping.document.Product;
import onlineshopping.inventory.repository.InventoryRepository;
import onlineshopping.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	/* will help to use repository functions to perform operations */
	@Autowired
	ProductRepository productRepo;

	/* creates new product */
	public Product createProduct(Product product) {
		return productRepo.save(product);

	}

	/* gets products by id */
	public Optional<Product> getById(String id) throws Exception {
		if(!productRepo.findById(id).isPresent())
			throw new Exception("product not present");
		else 
			return productRepo.findById(id);
		
	}

	/* gets products by name */
	public Product getByName(String name) {
		return productRepo.findByName(name);
	}

	/* gets products by pagination */
	public Map<String, Object> getAllProductsInPage(int pageNo, int pageSize, String sortBy) {
		Map<String, Object> response= new HashMap<String, Object>();
		Sort sort= Sort.by(sortBy);
		Pageable page= PageRequest.of(pageNo, pageSize, sort);
		Page<Product> productPage=productRepo.findAll(page);
		response.put("data", productPage.getContent());
		response.put("total no. of pages ", productPage.getTotalPages());
		response.put("total no, of elements ", productPage.getNumberOfElements());
		response.put("current page no. ", productPage.getNumber());
		return response;
	}

	/* updates product details */
	public void updateProduct(Product product) {
		productRepo.save(product);
	}

	/* deletes product by id */
	public void deleteById(String id) {
		productRepo.deleteById(id);
	}

	/* deletes all products */
	public void deleteAllProducts() {
		productRepo.deleteAll();
	}
	
	@Autowired
	InventoryRepository inventoryRepo;

	public Object getProductWithInventory(String name) throws Exception{
		Product product=productRepo.findByName(name);
		Inventory inventory=inventoryRepo.findByProductName(product.getName());
		if(product.getName().equalsIgnoreCase(product.getName()))
			return inventory;
		else
			return null;
		}
}