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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;




public class PlaceOrder extends JFrame {
    private Container c;
    private ImageIcon i1;
    private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15;
    private JTable t1, t2, t3, t4, t5;
    private static DefaultTableModel m1, m2, m3, m4, m5;
    private JScrollPane s1, s2, s3, s4, s5;
    private JLabel l1, l2, l3, l4, l5, l6;
    private JComboBox jc2;


    private String[] c1 = { "Customer", "Password", "Date Added" };
    private String[] c2 = { "Owner", "Password", "Date Added" };
    private String[] c3 = { "Manager", "Password", "Date Added" };
    private String[] c4 = { "Customer", "Product", "Status", "Date Ordered" };
    private String[] c5 = { "Product", "Category", "Price" };




    public PlaceOrder(String username) {
        setTitle("Place An Order");
        setBounds(0, 0, 100, 100);
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        // icon
        i1 = new ImageIcon("images/crm_logo.png");
        setIconImage(i1.getImage());

        // contant pane
        c = getContentPane();

        l1 = new JLabel("Place An Order");
        l1.setBounds(550, 120, 260, 60);
        // l1.setForeground(Color.white);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 35));

        c.add(l1);
        
        l3 = new JLabel("Product");
        l3.setBounds(500, 200, 150, 40);
        // l3.setForeground(Color.white);
        l3.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        c.add(l3);


        String filePath = ".\\data\\product_data.txt"; 

        try {
            String content = readFile(filePath);
            String[] names = extractNames(content);


            for (String name : names) {
                System.out.println(name);
            }

        String[] items = names;
        jc2 = new JComboBox<>(items);
        jc2.setBounds(500, 243, 400, 40);
        // jc1.setBackground(Color.white);
        // jc1.setForeground(Color.black);
        jc2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jc2.setFocusable(false);
        
        c.add(jc2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        b1 = new JButton("Place Order");
        b1.setBounds(500, 304, 400, 40);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b1.setForeground(Color.white);
        b1.setBackground(Color.BLUE);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setFocusPainted(false);

        c.add(b1);

        b2 = new JButton("Go Back");
        b2.setBounds(500, 357, 400, 40);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b2.setForeground(Color.white);
        b2.setBackground(new Color(252, 76, 202));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setFocusPainted(false);

        c.add(b2);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b1) {
                    String product =  (String) jc2.getSelectedItem();
                    if(product.equals("--Select--")){
                        showMessageDialog(null, " Please select all fields  ", "Message", 2);
                    } else {
                        OrderAdd order = new OrderAdd();
                        boolean orderAdded = order.orderAdd(username, product, "Pending", true);
                        if(orderAdded){
                            new CustomerDashboard(username);
                            setVisible(false);
                        }
                    }
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b2) {
                    new CustomerDashboard(username);
                    setVisible(false);
                }
            }
        });

        setVisible(true);
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static String[] extractNames(String content) {
        List<String> names = new ArrayList<>();
        Pattern pattern = Pattern.compile("Product:\\s+(\\w+)");
        Matcher matcher = pattern.matcher(content);

        names.add("--Select--");

        while (matcher.find()) {
            names.add(matcher.group(1));
        }

        return names.toArray(new String[0]);
    }

}


