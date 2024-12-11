/**
 * The Product class represents a product entity with details such as
 * its ID, name, category ID, and unit price.
 */

package com.pluralsight.NorthwindTraderAPI.models;

public class Product {

    /**
     *     Properties of the Product
     */

    private int productId;
    private String productName;
    private int categoryId;
    private double unitPrice;

    /**
     * Default constructor for creating an empty Product object.
     */
    public Product(){}


    /**
     * Parameterized constructor for creating a Product object with specific details.
     *
     * @param productId   the unique identifier of the product
     * @param productName the name of the product
     * @param categoryId  the identifier of the category to which the product belongs
     * @param unitPrice   the price of a single unit of the product
     */
    public Product(int productId,
                   String productName,
                   int categoryId,
                   double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.unitPrice = unitPrice;
    }

    /**
     * Get the product's value.
     */
    public int getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public int getCategoryId() {
        return categoryId;
    }
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Set the product's value ID.
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setCategoryId(int categoryID) {
        this.categoryId = categoryID;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Returns a string representation of the Product object,
     * including its ID, name, category ID, and unit price.
     *
     * @return a string representation of the Product object
     */

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", categoryId=" + categoryId +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
