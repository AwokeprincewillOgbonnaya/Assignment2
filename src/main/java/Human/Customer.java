package Human;

import Product.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person{
    private List<Product> shoppingCart;
    public Customer(String name, String id){
        super(name, id);
        this.shoppingCart = new ArrayList<>();

    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }


    public void addToCart(List<Product> inventory, String productId, int quantityToBuy) {
        for (Product item : inventory) {
            if (item.getId().equals(productId)) {
                shoppingCart.add(item);
                System.out.println(getName() + " added " + quantityToBuy + "x " + item.getName() + " to the cart.");
                return;
            }
        }
        System.out.println("Product ID " + productId + " not found in store!");
    }
}
