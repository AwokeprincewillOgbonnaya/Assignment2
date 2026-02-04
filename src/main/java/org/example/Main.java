package org.example;

import Human.Customer;
import Human.Staff.Cashier;
import Human.Staff.Manager;
import Product.Product;
import fileService.ProductFile;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager("Princewill", "1");
        Cashier cashier = new Cashier("Sarah", "2");
        Customer customer = new Customer("ZARA", "101");
        List<Product> inventory = ProductFile.readProducts();
        Store myStore = new Store();
        myStore.openForBusiness(customer, cashier, inventory);
    }
}
