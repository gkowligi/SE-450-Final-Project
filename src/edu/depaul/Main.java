package edu.depaul;


import edu.depaul.Products.Product;
import edu.depaul.Products.ProductFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to our shopping system for SE450! Please log in before accessing the system.");

        // initialize UserAuthenticationSystem, ProductCatalog

        UserAuthenticationSystem userAuthenticationSystem = new UserAuthenticationSystem();
        ProductCatalog productCatalog = new ProductCatalog();

        // prompt for user login
        boolean isValidLogin = false;

        while (isValidLogin != true) {
            System.out.println("Select an option:");
            System.out.println("1. Existing user");
            System.out.println("2. New user");

            int userChoice = scanner.nextInt();

            if (userChoice < 1 || userChoice > 2) {
                System.out.println("Error: Invalid option selected. Please either 1 for existing user or 2 for new user.");
                continue;
            }

            if (userChoice == 1) {
                System.out.println("Existing user login");
                System.out.println("Enter username:");
                String enteredUsername = scanner.next();

                System.out.println("Enter password:");
                String enteredPassword = scanner.next();

                if (userAuthenticationSystem.authenticateUser(enteredUsername, enteredPassword)) {
                    System.out.println("Authentication successful!");
                    isValidLogin = true;
                } else {
                    System.out.println("Authentication failed. Invalid username or password.");
                }
            }
            else {
                System.out.println("New user registration");
                System.out.println("Enter username:");
                String enteredUsername = scanner.next();

                System.out.println("Enter password:");
                String enteredPassword = scanner.next();

                userAuthenticationSystem.addUser(enteredUsername, enteredPassword);

                isValidLogin = true;
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
                    // Place Order
                    System.out.println("You selected option 5: Place Order");
                    placeOrder(scanner);
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
        System.out.println("\n Add Item to Cart");
        System.out.println("Enter the Product ID number (1-11):");

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
        ShoppingCartManager shoppingCartManager = ShoppingCartManager.getInstance();
        ShoppingCartBuilder shoppingCartBuilder = shoppingCartManager.getShoppingCartBuilder();
        // Prompt user to select product id to remove
        System.out.println("\n Remove Item from Cart");
        System.out.println("Enter the Product ID number (1-11):");

        int userItemId = scanner.nextInt();

        if (userItemId > 11 || userItemId < 1) {
            System.out.println("Error: Invalid Product ID. No item was removed from cart.");
            return;
        }

        shoppingCartBuilder.removeItem(userItemId);

        System.out.println("Item Removed (if present in Cart).");
    }

    private static void placeOrder(Scanner scanner) {
        ShoppingCartManager shoppingCartManager = ShoppingCartManager.getInstance();
        ShoppingCartBuilder shoppingCartBuilder = shoppingCartManager.getShoppingCartBuilder();

        System.out.println("\n Place Order");
        System.out.println("Enter Customer Name (press Enter when finished): ");

        String customerName = scanner.nextLine();

        System.out.println("Enter Shipping Address (press Enter when finished):");

        String shippingAddress = scanner.nextLine();

        shoppingCartBuilder.setCustomerInfo(customerName, shippingAddress);

        shoppingCartBuilder.finalizeOrder();

    }

}


// user auth

// product catalog

// order processing

// payment processing

// logging



