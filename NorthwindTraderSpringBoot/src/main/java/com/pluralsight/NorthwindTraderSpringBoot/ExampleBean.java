package com.pluralsight.NorthwindTraderSpringBoot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class ExampleBean {

    @Bean
    public String nameBean() {
        return "Tosh";
    }

    public Product chocolate(){
        return new Product(1,"Chocolate", "Sweets", 5.75);
    }

    public Product apple(){
        return new Product(3,"Apple", "Fruit", 2.75);
    }

}
