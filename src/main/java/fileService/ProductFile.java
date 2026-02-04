package fileService;

import Product.product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductFile {
    public static void myFile(){

    File myFile = new File("Products.CSV");

        try {
            if (myFile.createNewFile()) {
                System.out.println(myFile.getName() + "Successfully created");
            } else {
                System.out.println(myFile.getName() + " Can't be created");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(myFile.getAbsoluteFile());

    }
    public static List<product> readproducts() {
        List<product> products = new ArrayList<>();

      File myFile = new File("Products.CSV");

        try (BufferedReader br = new BufferedReader(new FileReader(myFile))) {
            String line;
            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                String[] data = line.split(",");


                if (data.length >= 4) {
                    product p = new product(
                            data[1].trim(),              // Name
                            data[0].trim(),              // ID
                            Double.parseDouble(data[2]), // Price
                            Integer.parseInt(data[3])    // Quantity
                    );
                    products.add(p);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        return products;
    }

    public static void saveProductsToFile(List<product> products) {


        try (BufferedWriter bw = new BufferedWriter(new FileWriter("products.CSV"))) {
            for (product p : products) {

                String line = p.getId() + "," + p.getName() + "," + p.getPrice() + "," + p.getQuantity();
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Database successfully updated.");
        } catch (IOException e) {
            System.out.println("Critical Error: Could not write to the database file.");
        }
    }


}
