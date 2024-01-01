
package classes;

import javax.swing.*;

import utils.CustomerSignUp;
import utils.OrderAdd;
import utils.ProductAdd;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javax.swing.JOptionPane.showMessageDialog;


public class AddOrder extends JFrame {
    private ImageIcon i1;
    private JLabel l1, l2, l3, l4, l5, l6;
    private Container c;
    private JButton b1, b2;
    private JComboBox jc1, jc2, jc3;
    private JTextField tf1, tf2;


    public AddOrder(String username, boolean isManager) {
        setTitle("Add Order");

        // icon
        i1 = new ImageIcon("images/crm_logo.png");
        setIconImage(i1.getImage());


        // content pane
        c = getContentPane();

        l1 = new JLabel("Add Order");
        l1.setBounds(580, 120, 240, 60);
        // l1.setForeground(Color.white);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 35));

        c.add(l1);

        // labels
        l2 = new JLabel("Customer");
        l2.setBounds(500, 200, 300, 40);
        // l2.setForeground(Color.white);
        l2.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        c.add(l2);

        String filePath2 = ".\\data\\customer_data.txt"; 

        try {
            String content = readFile(filePath2);
            String[] names = extractNames2(content);


            for (String name : names) {
                System.out.println(name);
            }

        String[] items = names;
        jc1 = new JComboBox<>(items);
        jc1.setBounds(500, 250, 400, 40);
        // jc1.setBackground(Color.white);
        // jc1.setForeground(Color.black);
        jc1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jc1.setFocusable(false);
        
        c.add(jc1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        l3 = new JLabel("Product");
        l3.setBounds(500, 300, 150, 40);
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
        jc2.setBounds(500, 350, 400, 40);
        // jc1.setBackground(Color.white);
        // jc1.setForeground(Color.black);
        jc2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jc2.setFocusable(false);
        
        c.add(jc2);
        } catch (IOException e) {
            e.printStackTrace();
        }


        l5 = new JLabel("Status");
        l5.setBounds(500, 400, 170, 40);
        // l3.setForeground(Color.white);
        l5.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        c.add(l5);

        String[] items = {"--Select--", "Pending", "Out For Delivery", "Delivered"};
        jc3 = new JComboBox<>(items);
        jc3.setBounds(500, 443, 400, 40);
        // jc1.setBackground(Color.white);
        // jc1.setForeground(Color.black);
        jc3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jc3.setFocusable(false);
        
        c.add(jc3);


        b1 = new JButton("Add Order");
        b1.setBounds(500, 490, 400, 40);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b1.setForeground(Color.white);
        b1.setBackground(Color.BLUE);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setFocusPainted(false);

        c.add(b1);
        
        b2 = new JButton("Go Back");
        b2.setBounds(500, 545, 400, 40);
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
                    String customer = (String) jc1.getSelectedItem();
                    String status = (String) jc3.getSelectedItem();
                    if(product.equals("--Select--") || customer.equals("--Select--") || status.equals("--Select--")){
                        showMessageDialog(null, " Please select all fields  ", "Message", 2);
                    } else {
                        OrderAdd order = new OrderAdd();
                        boolean orderAdded = order.orderAdd(customer, product, status, false);
                        if(orderAdded){
                            if(isManager) {
                                new ManagerDashboard(username);
                                setVisible(false);
                            } else {
                                new OwnerDashboard(username);
                                setVisible(false);
                            }
                        }
                    }
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b2) {
                    if(isManager) {
                        new ManagerDashboard(username);
                        setVisible(false);
                    } else {
                        new OwnerDashboard(username);
                        setVisible(false);
                    }
                }
            }
        });
        
        

        setSize(1366, 768);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    private static String[] extractNames2(String content) {
        List<String> names = new ArrayList<>();
        Pattern pattern = Pattern.compile("User Name:\\s+(\\w+)");
        Matcher matcher = pattern.matcher(content);

        names.add("--Select--");

        while (matcher.find()) {
            names.add(matcher.group(1));
        }

        return names.toArray(new String[0]);
    }
}