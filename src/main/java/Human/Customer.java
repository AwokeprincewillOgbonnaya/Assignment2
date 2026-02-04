package Human;

import Product.product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person{
    private List<product> shoppingCart;
    public Customer(String name, String id){
        super(name, id);
        this.shoppingCart = new ArrayList<>();

    }

    public void addToCart(List<product> inventory, String productId, int quantityToBuy) {
        for (product item : inventory) {
            if (item.getId() == productId) {
                // We create a "temporary" product for the cart with the requested quantity
                product selectedItem = new product(item.getId(), item.getName(), item.getPrice(), quantityToBuy);
                shoppingCart.add(selectedItem);
                System.out.println(getName() + " added " + quantityToBuy + "x " + item.getName() + " to the cart.");
                return;
            }
        }
        System.out.println("Product ID " + productId + " not found in store!");
    }

    public List<product> getShoppingCart() {
        return shoppingCart;
    }
}
