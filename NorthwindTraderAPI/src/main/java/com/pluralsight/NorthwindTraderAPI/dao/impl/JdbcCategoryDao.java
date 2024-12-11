/**
 * JdbcCategoryDao is a JDBC-based implementation of the CategoryDao interface.
 * It provides methods for performing CRUD operations on Category objects in the database.
 */
package com.pluralsight.NorthwindTraderAPI.dao.impl;
import com.pluralsight.NorthwindTraderAPI.dao.interfaces.CategoryDao;
import com.pluralsight.NorthwindTraderAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcCategoryDao implements CategoryDao {

    private DataSource dataSource;

    /**
     * Constructs a new JdbcCategoryDao with the given DataSource.
     * The DataSource is used to establish connections to the database.
     *
     * @param dataSource the DataSource to be used for database connections
     */
    @Autowired
    public JdbcCategoryDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    /**
     * Retrieves a list of all categories from the database.
     *
     * @return a List of Category objects representing all categories in the database
     * @throws RuntimeException if a SQLException occurs during database access
     */
    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();

        try(Connection connection = dataSource.getConnection();
            PreparedStatement query = connection.prepareStatement(Queries.selectCategories());
            ResultSet results = query.executeQuery())
        {
            while (results.next()){
                int catId = results.getInt(1);
                String catName = results.getString(2);
                categories.add(new Category(catId, catName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return categories;
    }

    /**
     * Retrieves a category by its unique ID from the database.
     *
     * @param id the unique identifier of the category to be retrieved
     * @return the Category object matching the given ID, or null if no category is found
     * @throws RuntimeException if a SQLException occurs during database access
     */
    @Override
    public Category findByCategoryId(int id) {
        Category category;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement query = connection.prepareStatement(
                    Queries.selectCategoryWhereID()))
        {
            // Set the ID parameter for the query
            query.setInt(1, id);

            // Execute the query and process the results
            try( ResultSet results = query.executeQuery()){
                while (results.next()){
                    int catId = results.getInt(1);
                    String catName = results.getString(2);
                    return new Category(catId, catName);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null; // Return null if no matching category is found
    }

    /**
     * Inserts a new category into the database and sets its generated ID.
     *
     * @param category the Category object to be inserted
     * @return the inserted Category object with the generated ID
     * @throws RuntimeException if a SQLException occurs during database access
     */
    @Override
    public Category insert(Category category) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement query = connection.prepareStatement(Queries.insertCategory(), PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Set the parameter for the query
            query.setString(1, category.getCategoryName());

            // Execute the query
            int rowsAffected = query.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Insert failed, no rows affected.");
            }

            // Retrieve generated keys
            try (ResultSet generatedKeys = query.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    category.setCategoryId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Insert failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error inserting category", e);
        }

        return category;
    }

    /**
     * Updates an existing category in the database.
     *
     * @param id       the ID of the category to update
     * @param category the updated Category object containing the new details
     * @throws RuntimeException if a SQLException occurs during database access
     */
    @Override
    public void update(int id, Category category) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement query = connection.prepareStatement(Queries.postCategories())) {

            // Set the parameters for the query
            query.setString(1, category.getCategoryName());
            query.setInt(2, id);

            // Execute the update query
            int rowsAffected = query.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Update failed, no rows affected.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error updating category", e);
        }
    }

    /**
     * Deletes a category from the database by its ID.
     *
     * @param id the ID of the category to delete
     * @throws RuntimeException if a SQLException occurs during database access
     */
    @Override
    public void delete(int id){

        try (Connection connection = dataSource.getConnection();
             PreparedStatement query = connection.prepareStatement(Queries.deleteCategory())) {

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