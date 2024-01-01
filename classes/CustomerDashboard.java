package classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import utils.OrderAdd;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;




public class CustomerDashboard extends JFrame {
    private Container c;
    private ImageIcon i1;
    private JButton b1, b2, b3, b4, b15, b11, b12, b5, b6, b13, b14;
    private JLabel l6, l4, l1, l5, l2, l3;



    public CustomerDashboard(String username) {
        setTitle("Customer Dashboard");
        setBounds(0, 0, 100, 100);
        setSize(1200, 768);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // icon
        i1 = new ImageIcon("images/crm_logo.png");
        setIconImage(i1.getImage());

        // contant pane
        c = getContentPane();

        String filePath = ".\\data\\order_data.txt"; 
        String usernameS = username;
        
        try {
            int totalUserNames = countTextOccurrences(filePath, usernameS);
            System.out.println("The text '" + usernameS + "' appears " + totalUserNames + " times in the file.");
            // buttons
            b1 = new JButton("Your Total Orders: " + totalUserNames);
            b1.setBounds(400, 69, 250, 80);
            b1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            b1.setBackground(new Color(66, 135, 245));
            b1.setForeground(Color.white);
            b1.setFocusPainted(false);
            b1.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // b1.setContentAreaFilled(false);

            b1.setBorderPainted(false);
            c.add(b1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // buttons

        l6 = new JLabel("Signed in as: " + username);
        l6.setBounds(98, 27, 240, 40);
        l6.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        l6.setForeground(Color.black);

        c.add(l6);

        b15 = new JButton("Sign Out");
        b15.setBounds(770, 40, 150, 25);
        b15.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b15.setForeground(Color.white);
        b15.setBackground(new Color(222, 42, 60));
        b15.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b15.setFocusPainted(false);

        c.add(b15);

        b15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b15) {
                    new SignIn();
                    setVisible(false);
                }
            }
        });

        b2 = new JButton("Place An Order ");
        b2.setBounds(400, 238, 250, 80);
        b2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        b2.setBackground(new Color(66, 204, 53));
        b2.setForeground(Color.white);
        b2.setFocusPainted(false);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // b1.setContentAreaFilled(false);

        b2.setBorderPainted(false);
        c.add(b2);

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b2) {
                    new PlaceOrder(username);
                    setVisible(false);
                }
            }
        });
        

        setVisible(true);
    }

    private static int countTextOccurrences(String filePath, String searchText) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Count occurrences in the current line
                count += countOccurrencesInLine(line, searchText);
            }
        }
        return count;
    }

    private static int countOccurrencesInLine(String line, String searchText) {
        int count = 0;
        int index = line.indexOf(searchText);
        while (index != -1) {
            count++;
            index = line.indexOf(searchText, index + searchText.length());
        }
        return count;
    }
}

