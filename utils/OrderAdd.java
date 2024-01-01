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

import interfaces.IOrderAddOperation;

import static javax.swing.JOptionPane.showMessageDialog;


public class OrderAdd implements IOrderAddOperation {
    public boolean orderAdd(String customer, String product, String status, boolean isCustomer) {
        try {

            File file = new File(".\\data\\order_data.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            String date = myDateObj.format(myFormatObj);

            pw.println("Customer: " + customer);
            pw.println("Product: " + product);
            pw.println("Status: " + status);
            pw.println("Date Ordered: " + date + "\n");
            pw.close();

            if(isCustomer){
                showMessageDialog(null,
                    "Order Placed Successfully \n",
                    "Order Placed", 1);
            } else {
                showMessageDialog(null,
                    "Order Added Successfully \n",
                    "Order Added", 1);
            }
            
            return true;

        } catch (Exception e) {
            System.out.print(e);
            showMessageDialog(null, " An Error Occured, Please Contact Support ", "Message", 2);
        }
        return false;
    }
}
