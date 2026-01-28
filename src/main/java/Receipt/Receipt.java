package Receipt;

public class Reciept {
    private String receiptId;

    private String customerName;

    private String productName;

    private double totalAmount;

    public Reciept(String receiptId, String customerName, String productName, double totalAmount) {
        this.receiptId = receiptId;
        this.customerName = customerName;
        this.productName = productName;
        this.totalAmount = totalAmount;
    }
    public void printReciept(){

    }
}
