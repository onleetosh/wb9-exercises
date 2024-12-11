/**
 * The Category class represents a category entity in the application.
 * It includes attributes for the category's unique identifier and name,
 * along with getters, setters, constructors, and a string representation method.
 */
package com.pluralsight.NorthwindTraderAPI.models;

public class Category {

    private String categoryName;
    private int categoryId;

    /**
     * Default constructor for the Category class.
     * Initializes an empty Category object.
     */
    public Category(){ }

    /**
     * Parameterized constructor for the Category class.
     * Allows initializing a Category object with an ID and a name.
     *
     * @param categoryId   the unique identifier for the category
     * @param categoryName the name of the category
     */
    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    /**
     * Get categories value.
     */
    public String getCategoryName() {
        return categoryName;
    }
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Set categories value.
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Returns a string representation of the Category object.
     * Useful for debugging and logging purposes.
     *
     * @return a string representation of the Category object
     */
    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
