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

import interfaces.ICustomerSignUpOperation;

import static javax.swing.JOptionPane.showMessageDialog;


public class CustomerSignUp implements ICustomerSignUpOperation {
    public boolean customerSignUp(String username, String password, boolean isOwnerCreation) {
        try {

            File file = new File(".\\data\\customer_data.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            String date = myDateObj.format(myFormatObj);

            pw.println("User Name: " + username);
            pw.println("Password: " + password);
            pw.println("Date Added: " + date + "\n");
            pw.close();

            if(isOwnerCreation) {
                showMessageDialog(null,
                    "Customer Added Successfully \n ",
                    "Customer Added", 1);
            } else {
                showMessageDialog(null,
                    "     Sign Up Successful \n     You Can Sign In now ",
                    "Sign Up Complete", 1);
            }
            
            return true;

        } catch (Exception e) {
            System.out.print(e);
            showMessageDialog(null, " An Error Occured, Please Contact Support ", "Message", 2);
        }
        return false;
    }
}
