package edu.depaul.Products;

public class Shirt implements Product {

    private int id = 5;
    private String name = "shirt";
    private double price = 20;


    @Override
    public void create() {
        System.out.println("Creating a shirt.");
    }

    @Override
    public int getItemId() {
        return this.id;
    }

    @Override
    public String getItemName() {
        return this.name;
    }

    @Override
    public double getItemPrice() {
        return this.price;
    }
}