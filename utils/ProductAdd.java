package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import interfaces.IProductAddOperation;

import static javax.swing.JOptionPane.showMessageDialog;


public class ProductAdd implements IProductAddOperation {
    public boolean productAdd(String product, String category, String price) {
        try {

            File file = new File(".\\data\\product_data.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);


            pw.println("Product: " + product);
            pw.println("Category: " + category);
            pw.println("Price: $" + price + "\n");
            pw.close();

            showMessageDialog(null,
                    "Product Added Successfully \n",
                    "Product Added", 1);
            return true;

        } catch (Exception e) {
            System.out.print(e);
            showMessageDialog(null, " An Error Occured, Please Contact Support ", "Message", 2);
        }
        return false;
    }
}
