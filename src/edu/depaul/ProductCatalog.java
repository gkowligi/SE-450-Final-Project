package edu.depaul;

import edu.depaul.Products.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductCatalog
{
    private List<ProductCatalogItem> productCatalogItemList;
    private static final String PRODUCTS_FILE_PATH = "src/edu/depaul/products.txt";

    public ProductCatalog() {
        productCatalogItemList = new ArrayList<>();
        loadProductsFromFile();
    }

    private void loadProductsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PRODUCTS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String itemId = parts[0].trim();
                    String itemName = parts[1].trim();
                    String itemPrice = parts[2].trim();
                    productCatalogItemList.add(new ProductCatalogItem(itemId, itemName, itemPrice));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading product data from file: " + e.getMessage());
        }
    }

    public void displayProductCatalog() {
        System.out.println("Product Catalog:");
        for (ProductCatalogItem item : productCatalogItemList) {
            System.out.println("- " + item.toString());
        }
    }

}
