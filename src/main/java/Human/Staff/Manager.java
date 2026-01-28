package Human.Staff;

import Human.Person;
import Product.product;

import java.util.ArrayList;
import java.util.List;

public class Maneger extends Person implements staffOperation {
    private List<product> products;

    public Maneger(String name, String id){
        super(name, id);
        this.products= new ArrayList<>();
    }
    public void addProduct(product Product){
        products.add(Product);
        System.out.println(Product.getName() + " added to inventory.");
    }


    @Override
    public void performDuty() {
        System.out.println("Manager " + getName() + " is managing inventory.");
    }
}
