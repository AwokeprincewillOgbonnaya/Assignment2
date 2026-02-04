package org.example;

import Human.Customer;
import Human.Staff.Cashier;
import Product.product;

import java.util.Scanner;
import java.util.List;

public class Store {
    private Scanner scanner = new Scanner(System.in);

    public void openForBusiness(Customer shopper, Cashier cashier, List<product> inventory) {
        System.out.println("--- WELCOME TO THE STORE ---");
        displayMenu(inventory);

        boolean shopping = true;
        while (shopping) {
            System.out.print("\nEnter Product ID to buy (or 0 to checkout): ");
            int id = scanner.nextInt();

            if (id == 0) {
                shopping = false;
            } else {
                System.out.print("Enter quantity: ");
                int qty = scanner.nextInt();
                shopper.addToCart(inventory, "", qty);
            }
        }


        cashier.sellProduct(shopper, shopper.getShoppingCart(), inventory);
    }

    private void displayMenu(List<product> inventory) {
        for (product p : inventory) {
            System.out.println("ID: " + p.getId() + " | name: " + p.getName() + " | Price: " + p.getPrice());
        }
    }
}

