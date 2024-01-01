package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import interfaces.IOwnerSignInOperation;

import static javax.swing.JOptionPane.showMessageDialog;


public class OwnerSignIn implements IOwnerSignInOperation {
        public boolean ownerSignIn(String username, String password) {
            String userNameS = "User Name: " + username;
            String passwordS = "Password: " + password;
			String fileData = "";
            try{
                File file = new File(".\\data\\owner_data.txt");
                Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                fileData += scanner.nextLine() + "\n";
            }

            scanner.close();

            // Check if username and password match any registration data
            if (fileData.contains(userNameS) && fileData.contains(passwordS)) {
			    return true;
            }
			else
			{
                showMessageDialog(null, " Wrong User Name or Password ", "Message", 2);
			}
            } catch (FileNotFoundException ex) {
            showMessageDialog(null, " An error occured, check console for more details ", "Message", 2);
            System.out.println("File not found: " + ex.getMessage());
        }
        return false;
    }
}

