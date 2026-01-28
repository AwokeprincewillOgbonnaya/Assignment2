package Receipt;

public class Receipt{
    private String receiptId;

    private String customerName;

    private String productName;

    private double totalAmount;

    public Receipt(String receiptId, String customerName, String productName, double totalAmount) {
        this.receiptId = receiptId;
        this.customerName = customerName;
        this.productName = productName;
        this.totalAmount = totalAmount;
    }
    public void printReceipt(){
        System.out.println("Receipt ID:    " + receiptId);
        System.out.println("Customer:      " + customerName);
        System.out.println("Product:       " + productName);
        System.out.println("Total Paid:    $" + totalAmount);
        System.out.println("THANK YOU!");
    }
}
