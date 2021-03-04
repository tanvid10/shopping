package onlineshopping.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="inventory")
public class Inventory {
	
	@Id
	private String id;
	private String productName;
	private int quantity;
	private boolean available;
	Inventory()
	{
		
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public boolean getAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getId() {
		return id;
	}
	
	public void setiId(String id) {
		this.id = id;
	}
	
	public int calculateQty(int qty1, int qty2)
	{
		return (qty1-qty2);
	}
}
