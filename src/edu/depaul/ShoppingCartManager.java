package edu.depaul;

import edu.depaul.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartManager {

    private static ShoppingCartManager instance;
    private ShoppingCartBuilder shoppingCartBuilder;

    private ShoppingCartManager() {
        shoppingCartBuilder = new ShoppingCartBuilder();
    }

    public static ShoppingCartManager getInstance() {
        if (instance == null) {
            instance = new ShoppingCartManager();
        }
        return instance;
    }

    public ShoppingCartBuilder getShoppingCartBuilder() {
        return shoppingCartBuilder;
    }
}
