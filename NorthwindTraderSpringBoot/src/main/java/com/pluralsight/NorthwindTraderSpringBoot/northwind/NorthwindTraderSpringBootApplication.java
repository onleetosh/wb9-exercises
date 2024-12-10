package com.pluralsight.NorthwindTraderSpringBoot.northwind;

import com.pluralsight.NorthwindTraderSpringBoot.Product;
import com.pluralsight.NorthwindTraderSpringBoot.dao.inferfaces.ProductDao;
import com.pluralsight.NorthwindTraderSpringBoot.util.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class NorthwindTraderSpringBootApplication {


	private static ProductDao productDao;
	private static ApplicationContext context;
	public static void main(String[] args) {

		// create a variable
		ApplicationContext appContext;



		// give variable value

		//approach  1
//		appContext = SpringApplication.run(NorthwindTraderSpringBootApplication.class, args);
//		productDao = appContext.getBean(productDao.getClass());

		//approach 2
		context = SpringApplication.run(NorthwindTraderSpringBootApplication.class, args);

//		Product p1 = new Product();
//		p1.setProductId(1);
//		p1.setName("Slinky");
//		p1.setCategory("toys");
//		p1.setPrice(10.99d);
//
//		Product p2 = new Product(1, "Slinky", "toys", 10.99d);


		for (String bean : context.getBeanDefinitionNames()){
			System.out.println(bean);
		}
		String options = """
				
				Please select an option :
				1- Add product
				2- list products
				99- exit
				
				
				>>>\\s""";

		int input;

		do  {
			input = Console.PromptForInt(options);
			switch (input) {
				case 1 -> processAddProduct();
				case 2 -> processGetAllProducts();
				case 99 -> System.exit(99);
				default -> System.out.println("Invalid selection. Please try again.");
			}
		}
		while (true);

	}

	private static void processGetAllProducts(){


		ProductDao productDao = context.getBean(ProductDao.class); //approach 2
		List<Product> products = productDao.getAll();
		for (Product p : products){
			System.out.println(p);
		}
	}
	private static void processAddProduct() {
		ProductDao productDao = context.getBean(ProductDao.class);

		int productId = Console.PromptForInt("Please enter the Product ID: ");
		String name = Console.PromptForString("Please enter the Product Name: ");
		String category = Console.PromptForString("Please enter the Category:" );
		double price = Console.PromptForDouble("Please enter the price: ");
		Product p1 = new Product(productId, name, category, price);

		productDao.add(p1);

	}

}