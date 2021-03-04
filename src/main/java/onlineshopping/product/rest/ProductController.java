package onlineshopping.product.rest;

import java.util.Map;
import java.util.Optional;

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

import onlineshopping.document.Product;
import onlineshopping.product.service.ProductService;
@RequestMapping("/product")
@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	/* to save new product details into the database */
	@PostMapping(value = "/create")
	public Product create(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	/* fetches product by id */
	@GetMapping(value = "/getById/{id}")
	public Optional<Product> getById(@PathVariable(name= "id") String id) throws Exception {
		return productService.getById(id);
	}

	/* fetches product by name */
	@GetMapping(value = "/{name}")
	public Product getByName(@PathVariable("name") String name) {
		return productService.getByName(name);
	}

	/* gets products by pagination */
	@GetMapping(value = "/page/{pageno}")
	public Map<String, Object> getAllProductsInPage(@PathVariable("pageno") int pageNo,
			@RequestParam(name= "pagesize", defaultValue ="2") int pageSize,
			@RequestParam(name= "sortby", defaultValue ="id") String sortBy) {
		return productService.getAllProductsInPage(pageNo, pageSize, sortBy);
	}

	/* updates product by id */
	@PutMapping(value= "/update/{id}") 
	public void update(@PathVariable(value= "id") Product id, @RequestBody Product product) 
	{ 
		productService.updateProduct(product); 
	}

	/* deletes product by id */
	@DeleteMapping(value= "/delete/{id}") 
	public void delete(@PathVariable(name= "id") String id) {
		productService.deleteById(id); 
	}

	/* deletes all product */
	@DeleteMapping(value = "/deleteAll") 
	public String deleteAll() {
		productService.deleteAllProducts(); 
		return "All Product records deleted.";
	} 
	
	@GetMapping(value="/productInventory/{name}")
	public Object getProductWithInventory(@PathVariable("name") String name) throws Exception
	{
		return productService.getProductWithInventory(name);
	}
}