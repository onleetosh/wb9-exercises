package com.pluralsight.NorthwindTraderSpringBoot.util;

public class Queries {

    public static String selectProductsWithCategoryName(){

        return """
                SELECT 
                    Products.ProductID
                    Products.ProductName
                    Categories.CategoryName
                    Products.UnitPrice
                FROM 
                    Products
                JOIN 
                    Categories 
                ON 
                    Products.CategoryID = Categories.CategoryID
                """;
    }

    public static String insertNewProduct(){
        return """
                INSERT INTO 
                    Products(ProductName, CategoryID, UnitPrice)
                VALUES
                    (?, ?, ?) 
                """;
    }
}
