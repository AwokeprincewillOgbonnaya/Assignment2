package org.example;

import Human.Customer;
import Human.Staff.Cashier;
import Human.Staff.Manager;
import Product.product;


public class Main {
    public static void main(String[] args) {

            Manager manager = new Manager("Princewill", "1");
            Cashier cashier = new Cashier("Sarah", "2");
            Customer customer = new Customer("ZARA", "101");
            product bread = new product("501", "Wheat Bread", 800.0, 10);


            manager.performDuty();
            cashier.performDuty();
            manager.addProduct(bread);


            System.out.println("\n--- Starting Transaction ---");
            cashier.sellProduct(customer, bread);
        }
    }
