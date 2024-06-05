package edu.depaul.Products;

public class Hat implements Product {

    private int id = 8;
    private String name = "hat";
    private double price = 10;


    @Override
    public void create() {
        System.out.println("Creating a hat.");
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