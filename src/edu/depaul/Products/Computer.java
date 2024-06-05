package edu.depaul.Products;

public class Computer implements Product {

    private int id = 2;
    private String name = "computer";
    private double price = 1000;


    @Override
    public void create() {
        System.out.println("Creating a computer.");
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
