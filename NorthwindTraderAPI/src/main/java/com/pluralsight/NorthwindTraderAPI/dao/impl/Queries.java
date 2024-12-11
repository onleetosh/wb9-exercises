/**
 * The Queries class provides reusable SQL query strings for interacting with the database.
 * These queries are used by DAO classes to perform operations on the Categories table.
 */
package com.pluralsight.NorthwindTraderAPI.dao.impl;


public class Queries {

    /**
     * Returns a SQL query string to select all categories from the Categories table.
     *
     * @return a SQL query string to retrieve all categories
     */
    public static String selectCategories(){

        return """
                SELECT CategoryId, CategoryName
                FROM Categories;
                """;
    }


    /**
     * Returns a SQL query string to select a category by its ID from the Categories table.
     * The query uses a placeholder (?) for the ID parameter.
     *
     * @return a SQL query string to retrieve a category by its ID
     */
    public static String selectCategoryWhereID(){
        return """
                SELECT CategoryId, CategoryName
                FROM Categories
                WHERE CategoryId = ?;
                """;
    }


    /**
     * Returns a SQL query string to insert a new category into the Categories table.
     * The query uses a placeholder (?) for the category name to prevent SQL injection.
     *
     * @return a SQL query string to insert a new category.
     */
    public static String insertCategory(){
        return """
            INSERT INTO 
                Categories (CategoryName)
            VALUES 
                (?)
            """;
    }

    /**
     * Returns a SQL query string to select all products from the Products table and
     *
     * @return a SQL query string to retrieve all products.
     */
    public static String selectProducts(){
        return """
                SELECT 
                    ProductId, ProductName, CategoryId, UnitPrice
                FROM 
                    Products;
                """;
    }

    /**
     * Returns a SQL query string to insert a new product into the Products table.
     *
     * @return a SQL query string to insert a new product.
     */
    public static String insertProduct(){
        return """
            INSERT INTO 
                Products (ProductName, CategoryId, UnitPrice)
            VALUES 
                (?, ?, ?)
            """;
    }

    /**
     * Returns a SQL query string to update a category in the Categories table.
     *
     * @return a SQL query string to update a category.
     */
    public static String postCategories(){
        return """
               UPDATE Categories
               SET  CategoryName = ?,
               WHERE CategoryId = ?
                """;
    }

    /**
     * Returns a SQL query string to update a product in the Products table.
     *
     * @return a SQL query string to update a product.
     */
    public static String postProducts(){
        return """
               UPDATE Products
               SET ProductName = ?, CategoryID = ?, UnitPrice = ? 
               WHERE ProductId = ?
                """;
    }

    /**
     * Returns a SQL query string to delete a product from the Products table.
     *
     * @return a SQL query string to delete a product.
     */
    public static String deleteProduct(){
        return """
                DELETE FROM Products WHERE ProductId = ?
                """;
    }

    /**
     * Returns a SQL query string to delete a category from the Categories table.
     *
     * @return a SQL query string to delete a category.
     */
    public static String deleteCategory(){
        return """
                DELETE FROM Categories WHERE CategoryID = ?
                """;
    }
}
