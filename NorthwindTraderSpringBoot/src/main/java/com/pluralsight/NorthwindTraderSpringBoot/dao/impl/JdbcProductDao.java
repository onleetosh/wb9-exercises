package com.pluralsight.NorthwindTraderSpringBoot.dao.impl;

import com.pluralsight.NorthwindTraderSpringBoot.Product;
import com.pluralsight.NorthwindTraderSpringBoot.db.DatabaseConfig;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.*;

import java.util.ArrayList;
import java.util.List;


@Component
@Primary
public class JdbcProductDao {


    private DataSource dataSource;

    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    

    @Override
    public void add(Product product){

    }

    @Override
    public List<Product> getAll(){

        ArrayList<Product> productArrayList = new ArrayList<>();
        //step 1. sql query for all products
        String query = """
                SELECT * FROM products 
                """;


        //step 2. connect to database using connection, preparedStatement and results


        //step 3. use variables to hold results and create product




        return productArrayList;
    }
}
