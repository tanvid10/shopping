package onlineshopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class OnlineShoppingApplication{
	
	//starts our project
	public static void main(String[] args)
	{
		SpringApplication.run(OnlineShoppingApplication.class, args);
	}
}
