package edu.depaul;

import edu.depaul.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartBuilder {
    private List<Product> productList = new ArrayList<>(); // Represents the items in the cart
    private String customerName;
    private String shippingAddress;


    public ShoppingCartBuilder addItem(Product product, int quantity) {
        productList.add(product);
        System.out.println("Added item: " + product.getItemName() + ", Quantity: " + quantity);
        return this;
    }

    public ShoppingCartBuilder removeItem(int itemId) {
        productList.removeIf(product -> product.getItemId() == itemId);
        return this;
    }


    public void displayCart() {
        System.out.println("Shopping Cart Contents:");
        for (Product product : productList) {
            System.out.println("- " + product.getItemName());
        }
    }

}
