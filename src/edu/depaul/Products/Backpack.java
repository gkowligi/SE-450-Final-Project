package edu.depaul.Products;

public class Backpack implements Product {

    private int id = 9;
    private String name = "backpack";
    private double price = 35;


    @Override
    public void create() {
        System.out.println("Creating a backpack.");
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