package org.example;

import Human.Customer;
import Human.Staff.Cashier;
import Product.Product;
import fileService.ProductFile;

import java.util.Scanner;
import java.util.List;

public class Store {
    private Scanner scanner = new Scanner(System.in);

    public void openForBusiness(Customer shopper, Cashier cashier, List<Product> inventory) {
        System.out.println("--- WELCOME TO THE STORE ---");
        displayMenu(inventory);

        boolean shopping = true;
        while (shopping) {
            System.out.print("\nEnter Product ID to buy (or 0 to checkout): ");
            String id = scanner.next();

            if (id.equals("0")) {
                shopping = false;
            } else {
                System.out.print("Enter quantity: ");
                int qty = scanner.nextInt();
                shopper.addToCart(inventory, id, qty);
            }
        }


        cashier.sellProduct(shopper, shopper.getShoppingCart(), inventory);
        ProductFile.saveProductsToFile(inventory);
    }

    private void displayMenu(List<Product> inventory) {
        for (Product p : inventory) {
            System.out.println("ID: " + p.getId() + " | name: " + p.getName() + " | Price: " + p.getPrice());
        }
    }
}

