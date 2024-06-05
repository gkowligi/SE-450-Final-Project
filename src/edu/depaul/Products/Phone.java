package edu.depaul.Products;

public class Phone implements Product {

    private int id = 3;
    private String name = "phone";
    private double price = 750;


    @Override
    public void create() {
        System.out.println("Creating a phone.");
    }

    @Override
    public int getItemId() {
        return this.id;
    }

    @Override
    public String getItemName() {
        return this.name;
    }
}
