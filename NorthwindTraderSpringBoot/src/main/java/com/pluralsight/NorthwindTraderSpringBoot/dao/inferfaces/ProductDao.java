package com.pluralsight.NorthwindTraderSpringBoot.dao.inferfaces;

import com.pluralsight.NorthwindTraderSpringBoot.Product;

import java.util.List;

public interface ProductDao {
    void add(Product product);
    List<Product> getAll();
}