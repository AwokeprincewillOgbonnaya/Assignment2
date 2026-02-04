package Human.Staff;

import Human.Person;
import Product.Product;
import fileService.ProductFile;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Person implements staffOperation {
    private List<Product> Products;

    public Manager(String name, String id){
        super(name, id);
        this.Products = new ArrayList<>();
    }
    public void addProduct(Product Product){
        Products.add(Product);
        System.out.println(Product.getName() + " added to inventory.");
    }


    public void addProductToSystem(List<Product> inventory, String id, String name, double price, int quantity) {

        Product newProduct = new Product(id, name, price, quantity);


        inventory.add(newProduct);


        ProductFile.saveProductsToFile(inventory);

        System.out.println("Manager " + getName() + " added " + name + " to the system.");
    }



    @Override
    public void performDuty() {
        System.out.println("Manager " + getName() + " is managing inventory.");
    }
}
