package onlineshopping.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//mongo database annotation
@Document(collection="customers")
public class Customer {
	@Id
	private int id;
	private String name;
	private String status;
	public boolean isDeleted;


	public boolean getIsDeleted() { 
		return isDeleted; 
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer()
	{

	}
}
