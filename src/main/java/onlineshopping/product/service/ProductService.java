package onlineshopping.product.service;

import java.util.Map;
import java.util.Optional;

import onlineshopping.document.Product;

public interface ProductService {
	/* creates new product */
	public Product createProduct(Product product);

	/* gets product by id */
	public Optional<Product> getById(String id) throws Exception;

	/* gets product by name */
	public Product getByName(String name);

	/* gets products by pagination */
	public Map<String, Object> getAllProductsInPage(int pageNo, int pageSize, String sortBy);

	/* updates product details */
	public void updateProduct(Product product); 

	/* deletes product by id */
	public void deleteById(String id);

	/* deletes all products */
	public void deleteAllProducts();

	public Object getProductWithInventory(String name) throws Exception;
}
