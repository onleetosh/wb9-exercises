package com.pluralsight.NorthwindTraderSpringBoot.dao.impl;

import com.pluralsight.NorthwindTraderSpringBoot.Product;
import com.pluralsight.NorthwindTraderSpringBoot.dao.inferfaces.ProductDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao implements ProductDao {
    private final List<Product> products;

    public SimpleProductDao(){
        products = new ArrayList<Product>();
        products.add(new Product(1, "Slinky", "toys", 10.99d));
        products.add(new Product(2, "Gyroscope", "toys", 18.99d));
        products.add(new Product(3, "Banana", "fruit", 1.99d));
        products.add(new Product(4, "Apple", "fruit", 0.99d));
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

}