/**
 * The ProductsController class is a REST controller for managing Product entities.
 * It provides endpoints to perform CRUD operations (Create, Read, Update, Delete) on products.
 * This controller interacts with the ProductDao to fetch and manipulate product data.
 */

package com.pluralsight.NorthwindTraderAPI.controllers;

import com.pluralsight.NorthwindTraderAPI.dao.interfaces.ProductDao;
import com.pluralsight.NorthwindTraderAPI.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {
    private final ProductDao productDao;

    /**
     * Constructor for ProductsController.
     *
     * @param productDao the ProductDao instance to interact with the product data layer.
     */
    public ProductsController(ProductDao productDao){
        this.productDao = productDao;
    }

    /**
     * Handles GET requests to fetch all products.
     *
     * @return a List of all Product objects retrieved from the database.
     * Logs the operation to the console.
     */
    @RequestMapping(path="/products", method= RequestMethod.GET)
    public List<Product> getProducts() {
        System.out.println("Fetching all products.");
        return  productDao.getAll();

    }


    /**
     * Handles GET requests to fetch a single product by its ID.
     *
     * @param id the unique identifier of the product to retrieve.
     * @return the Product object matching the given ID.
     * Logs the operation to the console.
     */
    @RequestMapping(path="/products{id}", method= RequestMethod.GET)
    public Product getProduct(@PathVariable int id){
        System.out.println("Fetching product with ID: " + id);
        return  productDao.getByProductId(id);
    }


    /**
     * Handles POST requests to create a new product.
     *
     * @param product the Product object containing the details of the product to be added.
     * @return the created Product object with its generated ID.
     * Logs the details of the product being added to the console.
     * Responds with HTTP 201 (Created) status upon success.
     */
    @RequestMapping(path="/products", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product){
        // Log the product details that are being added
        System.out.println("Adding new product:");
        System.out.println("Product name: " + product.getProductName());
        System.out.println("Category ID: " + product.getCategoryId());
        System.out.println("Unit price: " + product.getUnitPrice());
        return  productDao.insertProduct(product);
    }

    /**
     * Handles PUT requests to update an existing product.
     *
     * @param id the unique identifier of the product to update.
     * @param product the Product object containing the updated details.
     * Logs the received product details and ID to the console.
     * Throws an exception if the product cannot be found or updated.
     */
    @RequestMapping(path = "/products/{id}", method = RequestMethod.PUT)
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {
        // Log the product details and ID that are being updated
        System.out.println("Received product name: " + product.getProductName());
        System.out.println("Received categoryId: " + product.getCategoryId());
        System.out.println("Received unit price: " + product.getUnitPrice());
        productDao.update(id, product);
    }

    /**
     * Handles DELETE requests to remove a product by its ID.
     *
     * @param id the unique identifier of the product to delete.
     * Logs the operation to the console.
     * Responds with HTTP 204 (No Content) status upon success.
     * Throws an exception if the product cannot be found or deleted.
     */
    @RequestMapping(path = "/products/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value =  HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id){
        System.out.println("Deleting product with ID: " + id);
        productDao.delete(id);
    }


}
