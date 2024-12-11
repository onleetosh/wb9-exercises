/**
 * The CategoriesController class is a REST controller that handles HTTP requests
 * related to the Category entity. It provides endpoints for performing CRUD operations
 * on categories in the database.
 */
package com.pluralsight.NorthwindTraderAPI.controllers;

import com.pluralsight.NorthwindTraderAPI.dao.interfaces.CategoryDao;
import com.pluralsight.NorthwindTraderAPI.models.Category;
import com.pluralsight.NorthwindTraderAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {

    private final CategoryDao categoryDao;

    /**
     * Constructor for CategoriesController.
     * Initializes the controller with the provided CategoryDao dependency.
     *
     * @param categoryDao the DAO for accessing category data.
     */
    @Autowired
    public CategoriesController(CategoryDao categoryDao){
        this.categoryDao = categoryDao;
    }

    /**
     * Handles GET requests to fetch all categories.
     *
     * @return a list of all categories from the database.
     */
    @RequestMapping(path="/categories", method = RequestMethod.GET)
    public List<Category> getCategories(){
        System.out.println("Fetching all categories.");
        return categoryDao.getAll();
    }

    /**
     * Handles GET requests to fetch a specific category by its ID.
     *
     * @param id the unique identifier of the category to retrieve.
     * @return the Category object with the specified ID, or null if not found.
     */
    @RequestMapping(path="/categories/{id}", method= RequestMethod.GET)
    public Category getCategory(@PathVariable int id){
        System.out.println("Fetching product with ID: " + id);
        return categoryDao.findByCategoryId(id);
    }

    /**
     * Handles POST requests to create a new category.
     *
     * @param category the Category object to be added to the database.
     * @return the newly created Category object with its generated ID.
     */
    @RequestMapping(path="/categories", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category){
        // Log the product details that are being added
        System.out.println("Adding new product:");
        System.out.println("Product name: " + category.getCategoryName());
        return  categoryDao.insert(category);
    }


    /**
     * Handles PUT requests to update an existing category.
     *
     * @param id       the ID of the category to update.
     * @param category the updated Category object containing the new details.
     */
    @RequestMapping(path = "/categories/{id}", method = RequestMethod.PUT)
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
        // Log the category name
        System.out.println("Received category name: " + category.getCategoryName());
        categoryDao.update(id, category);
    }

    /**
     * Handles DELETE requests to remove a category by its ID.
     *
     * @param id the ID of the category to delete.
     */
    @RequestMapping(path = "/categories/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable int id){
        // Log the categoryId
        System.out.println("Deleting product with ID: " + id);
        categoryDao.delete(id);
    }


}