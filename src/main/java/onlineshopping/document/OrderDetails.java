package onlineshopping.document;

public class OrderDetails {

	private String productName;
	private int orderQty;
	
	public OrderDetails()
	{
		
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	
}
