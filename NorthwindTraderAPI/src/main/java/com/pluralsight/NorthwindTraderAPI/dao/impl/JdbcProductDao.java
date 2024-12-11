/**
 * JdbcProductDao is a JDBC-based implementation of the ProductDao interface.
 * It provides methods for retrieving and interacting with Product data from the database.
 */
package com.pluralsight.NorthwindTraderAPI.dao.impl;

import com.pluralsight.NorthwindTraderAPI.dao.interfaces.ProductDao;
import com.pluralsight.NorthwindTraderAPI.models.Category;
import com.pluralsight.NorthwindTraderAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {

    private DataSource dataSource;

    /**
     * Constructs a new JdbcProductDao with the given DataSource.
     * The DataSource is used to establish database connections.
     *
     * @param dataSource the DataSource to be used for database connections
     */
    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Retrieves a list of all products from the database.
     *
     * @return a List of Product objects representing all products in the database
     * @throws RuntimeException if a SQLException occurs during database access
     */
    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement query = connection.prepareStatement(Queries.selectProducts());
            ResultSet results = query.executeQuery())
        {
            while (results.next()){
                int productId = results.getInt(1);
                String name = results.getString(2);
                int categoryId = results.getInt(3);
                double price = results.getDouble(4);

                products.add(new Product(productId, name, categoryId, price));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }


    /**
     * Retrieves a product by its unique ID from the database.
     *
     * @param id the unique identifier of the product to be retrieved
     * @return the Product object that matches the given ID, or null if no product is found
     */

    @Override
    public Product getByProductId(int id) {
        return null;
    }

    /**
     * Inserts a new product into the database and sets its generated ID.
     *
     * @param product the Product object to be inserted
     * @return the inserted Product object with the generated ID
     * @throws RuntimeException if a SQLException occurs during database access
     */
    @Override
    public Product insertProduct(Product product) {
        // Establish connection
        try (Connection connection = dataSource.getConnection()) {


            // Insert product
            String insertProductQuery = Queries.insertProduct();
            try (PreparedStatement query = connection.prepareStatement(insertProductQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
                query.setString(1, product.getProductName());
                query.setInt(2, product.getCategoryId());
                query.setDouble(3, product.getUnitPrice());

                int rowsAffected = query.executeUpdate();
                if (rowsAffected == 0) {
                    throw new SQLException("Insert failed, no rows affected.");
                }

                // Retrieve generated keys
                try (ResultSet generatedKeys = query.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        product.setProductId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Insert failed, no ID obtained.");
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error inserting product", e);
        }

        return product;
    }


    /**
     * Updates an existing product in the database.
     *
     * @param id      the ID of the product to update
     * @param product the updated Product object containing new details
     * @throws RuntimeException if a SQLException occurs during database access
     */
    @Override
    public void update(int id, Product product) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement query = connection.prepareStatement(Queries.postProducts())) {

            query.setString(1, product.getProductName());
            query.setInt(2, product.getCategoryId());
            query.setDouble(3, product.getUnitPrice());
            query.setInt(4, id);

            int rowsUpdated = query.executeUpdate();
            if (rowsUpdated == 0) {
                throw new RuntimeException("Product with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error updating product with ID " + id, e);
        }
    }

    /**
     * Deletes a product from the database by its ID.
     *
     * @param id the ID of the product to delete
     * @throws RuntimeException if a SQLException occurs during database access
     */
    @Override
    public void delete(int id){

        try (Connection connection = dataSource.getConnection();
             PreparedStatement query = connection.prepareStatement(Queries.deleteProduct())) {

            // Set the parameters for the query
            query.setInt(1, id);

            // Execute the update query
            int rowsAffected = query.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Update failed, no rows affected.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error updating category", e);
        }
    }

}