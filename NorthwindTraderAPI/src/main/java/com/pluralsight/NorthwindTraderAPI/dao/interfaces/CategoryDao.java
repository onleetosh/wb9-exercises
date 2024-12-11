/**
 * The CategoryDao interface provides methods for CRUD operations on Category entities.
 * It defines the contract for interacting with the data layer for Category objects.
 */

package com.pluralsight.NorthwindTraderAPI.dao.interfaces;
import com.pluralsight.NorthwindTraderAPI.models.Category;
import java.util.List;

public interface CategoryDao {

    /**
     * Retrieves a list of all categories from a data source.
     * @return List of Category objects representing all categories in the database.
     */
    List<Category> getAll();

    /**
     * Finds and retrieves a category by its unique ID.
     *
     * @param id the unique identifier of the category to be retrieved.
     * @return the Category object matching the given ID, or null if no category is found.
     */
    Category findByCategoryId(int id);

    /**
     * Inserts a new category into the data source.
     *
     * @param category the Category object to be added to the database.
     * @return the inserted Category object, potentially with its generated ID set.
     */
    Category insert(Category category);


    /**
     * Updates an existing category in the data source.
     *
     * @param id the unique identifier of the category to be updated.
     * @param category the Category object containing the updated details (e.g., name).
     *                 The ID in the Category object is ignored as the target category is
     *                 identified by the provided ID parameter.
     */
    void update(int id, Category category);

    /**
     * Deletes a category from the data source.
     *
     * @param id the unique identifier of the category to delete.
     */
    void delete(int id);
}