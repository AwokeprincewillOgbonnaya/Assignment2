package Human.Staff;

import Human.Customer;
import Human.Person;
import Product.Product;
import Receipt.Receipt;
import fileService.ProductFile;

import java.util.List;

public class Cashier extends Person implements staffOperation {

    public Cashier(String name, String id) {
        super(name, id);
    }

    public void sellProduct(Customer customer, List<Product> cart, List<Product> inventory) {
        double totalBill = 0;
        boolean atLeastOneItemSold = false;

        System.out.println("Processing order for: " + customer.getName());

        for (Product cartItem : cart) {

            for (Product invItem : inventory) {
                if (invItem.getId() == cartItem.getId()) {


                    if (invItem.getQuantity() >= cartItem.getQuantity()) {


                        invItem.setQuantity(invItem.getQuantity() - cartItem.getQuantity());

                        totalBill += (invItem.getPrice() * cartItem.getQuantity());
                        atLeastOneItemSold = true;

                        System.out.println("Sold " + cartItem.getQuantity() + "x " + invItem.getName());
                    } else {
                        System.out.println("Insufficient stock for " + invItem.getName() +
                                ". Available: " + invItem.getQuantity());
                    }
                }
            }
        }

        if (atLeastOneItemSold) {

            ProductFile.saveProductsToFile(inventory);


            System.out.println("--- TRANSACTION COMPLETE ---");
            Receipt receipt = new Receipt("REC-" + System.currentTimeMillis(), customer.getName(), "Multiple Items", totalBill);
            receipt.printReceipt();

            System.out.println("Inventory file (products.csv) has been updated with new stock levels.");
        } else {
            System.out.println("Transaction aborted: No items were available for sale.");
        }
    }

    @Override
    public void performDuty() {
        System.out.println("Cashier " + getName() + " is currently at the counter processing customer sales.");
    }

}
