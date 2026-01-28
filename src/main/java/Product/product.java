package Product;

public class product {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public product(String id, String name, double price,int quantity){
        this.id=id;
        this.name=name;
        this. price=price;
        this.quantity=quantity;
    }
    public void setId( String id){
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
