package fileService;

import Product.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductFile {
    private static final String FILE_PATH = "/Users/mac/Downloads/products.csv";

    public static List<Product> readProducts() {

        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            br.readLine();
            System.out.println("skipped header");
            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                String[] data = line.split(",");


                if (data.length >= 4) {
                    Product p = new Product(data[0], data[1], Double.parseDouble(data[2]), Integer.parseInt(data[3]));
                    products.add(p);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        return products;
    }

    public static void saveProductsToFile(List<Product> products) {


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Product p : products) {

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
