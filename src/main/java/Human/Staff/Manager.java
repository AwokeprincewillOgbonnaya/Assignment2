package Human.Staff;

import Human.Person;
import Product.product;
import fileService.ProductFile;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Person implements staffOperation {
    private List<product> products;

    public Manager(String name, String id){
        super(name, id);
        this.products= new ArrayList<>();
    }
    public void addProduct(product Product){
        products.add(Product);
        System.out.println(Product.getName() + " added to inventory.");
    }


    public void addProductToSystem(List<product> inventory, String id, String name, double price, int quantity) {

        product newProduct = new product(id, name, price, quantity);


        inventory.add(newProduct);


        ProductFile.saveProductsToFile(inventory);

        System.out.println("Manager " + getName() + " added " + name + " to the system.");
    }



    @Override
    public void performDuty() {
        System.out.println("Manager " + getName() + " is managing inventory.");
    }
}
