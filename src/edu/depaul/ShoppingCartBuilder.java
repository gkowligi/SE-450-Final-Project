package edu.depaul;

import edu.depaul.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartBuilder {

    private List<Product> productList = new ArrayList<>(); // Represents the items in the cart
    private String customerName;
    private String shippingAddress;

    public List<Product> getProductList() {
        return productList;
    }

    public ShoppingCartBuilder addItem(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            productList.add(product);
        }
        System.out.println("Added item: " + product.getItemName() + ", Quantity: " + quantity);
        return this;
    }

    public ShoppingCartBuilder removeItem(int itemId) {
        productList.removeIf(product -> product.getItemId() == itemId);
        return this;
    }

    public ShoppingCartBuilder setCustomerInfo(String firstName, String lastName, String address) {
        this.customerName = firstName + " " + lastName;
        this.shippingAddress = address;
        return this;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product item : productList) {
            total += item.getItemPrice();
        }
        return total;
    }


    public void displayCart() {
        System.out.println("Shopping Cart Contents:");
        for (Product product : productList) {
            System.out.println("- " + product.getItemName());
        }
    }

    public void finalizeOrder() {
        System.out.println("Order finalized for customer: " + customerName);
        System.out.println("Shipping address: " + shippingAddress);
        System.out.println("Total amount: $" + calculateTotal());
    }

    public void clearCart() {
        this.productList = new ArrayList<>();
        this.customerName = "";
        this.shippingAddress = "";
    }

}
