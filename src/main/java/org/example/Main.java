package org.example;

import Human.Customer;
import Human.Staff.Cashier;
import Human.Staff.Manager;
import Product.product;
import fileService.ProductFile;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager("Princewill", "1");
        Cashier cashier = new Cashier("Sarah", "2");
        Customer customer = new Customer("ZARA", "101");
        List<product> inventory = ProductFile.readproducts();
        manager.addProductToSystem(inventory,"102", "Coffee", 3000.0, 20);
        Store myStore = new Store();
        inventory = ProductFile.readproducts();
        myStore.openForBusiness(customer, cashier, inventory);
    }
    }
