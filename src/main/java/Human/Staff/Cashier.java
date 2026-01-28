package Human.Staff;

import Human.Customer;
import Human.Person;
import Product.product;
import Receipt.Receipt;

public class Cashier extends Person implements staffOperation {
    public Cashier(String name,String id){
        super(name, id);
    }
    public void sellProduct(Customer customer, product Product){
       if (Product.getQuantity() >0){

           System.out.println("Processing " + Product.getName() + " for " + customer.getName());

           int newQuantity = Product.getQuantity() -1;
           Product.setQuantity(newQuantity);

           Receipt receipt = new Receipt("REC001", customer.getName(), Product.getName(), Product.getPrice());

           System.out.println("--- GENERATING RECEIPT ---");
           receipt.printReceipt();
       }else {

           System.out.println("Sorry, " + Product.getName() + " is out of stock!");
       }
    }

    @Override
    public void performDuty() {
        System.out.println("Cashier " + getName() + " is currently at the counter processing customer sales.");
    }
    }

