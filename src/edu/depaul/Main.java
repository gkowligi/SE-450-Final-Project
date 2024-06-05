package edu.depaul;


import edu.depaul.Products.Product;
import edu.depaul.Products.ProductFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // initialize UserAuthenticationSystem, ProductCatalog

        UserAuthenticationSystem userAuthenticationSystem = new UserAuthenticationSystem();
        ProductCatalog productCatalog = new ProductCatalog();

        // prompt for user login

        // temp, for now
        String enteredUsername = "test";
        String enteredPassword = "test";

        boolean isValidLogin = false;

        while (isValidLogin != true) {
            if (userAuthenticationSystem.authenticateUser(enteredUsername, enteredPassword)) {
                System.out.println("Authentication successful!");
                isValidLogin = true;
            } else {
                System.out.println("Authentication failed. Invalid username or password.");
            }
        }

        // login is valid

        // initialize ShoppingCartManager
        ShoppingCartManager shoppingCartManager = ShoppingCartManager.getInstance();
        ShoppingCartBuilder shoppingCartBuilder = shoppingCartManager.getShoppingCartBuilder();


        // display options
        // 1. View Product Catalog
        // 2. Add item to Cart
        // 3. View Cart
        // 4. Remove item from Cart
        // 5. Place Order
        // 6. Quit

        while (true) {
            displayMenu();

            int currentChoice = getUserChoice(scanner);

            switch (currentChoice) {
                case 1:
                    // View Product Catalog
                    System.out.println("You selected option 1: View Product Catalog");
                    productCatalog.displayProductCatalog();
                    break;
                case 2:
                    // Add item to Cart
                    System.out.println("You selected option 2: Add item to Cart");
                    addItemToCart(scanner);
                    break;
                case 3:
                    // View Cart
                    System.out.println("You selected option 3: View Cart");
                    shoppingCartBuilder.displayCart();
                    break;
                case 4:
                    // Remove item from Cart
                    System.out.println("You selected option 4: Remove item from Cart");
                    removeItemFromCart(scanner);
                    break;
                case 5:
                    System.out.println("You selected option 5: Place Order");
                    break;
                case 6:
                    System.out.println("You selected option 6: Quit");
                    System.out.println("Exiting Program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select 1-6.");
            }

        }

    }

    private static void displayMenu() {
        System.out.println("\n\nChoose an option:");
        System.out.println("1. View Product Catalog");
        System.out.println("2. Add item to Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Remove item from Cart");
        System.out.println("5. Place Order");
        System.out.println("6. Quit");
    }

    private static int getUserChoice(Scanner scanner) {
        System.out.print("\nEnter your choice: ");
        return scanner.nextInt();
    }

    private static void addItemToCart(Scanner scanner) {
        ShoppingCartManager shoppingCartManager = ShoppingCartManager.getInstance();
        ShoppingCartBuilder shoppingCartBuilder = shoppingCartManager.getShoppingCartBuilder();
        // Prompt user to select product id to add
        System.out.println("\n Enter the Product ID number (1-11)");

        int userItemId = scanner.nextInt();

        if (userItemId > 11 || userItemId < 1) {
            System.out.println("Error: Invalid Product ID. No item was added to cart.");
            return;
        }

        System.out.println("Enter Quantity: ");

        int quantity = scanner.nextInt();

        // add item from product catalog

        Product itemToAdd = ProductFactory.createProduct(userItemId);

        shoppingCartBuilder.addItem(itemToAdd, quantity);
    }

    private static void removeItemFromCart(Scanner scanner) {
    }

}


// user auth

// product catalog

// order processing

// payment processing

// logging



