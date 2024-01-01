
package classes;

import javax.swing.*;

import utils.CustomerSignUp;
import utils.ProductAdd;

import java.awt.*;
import java.awt.event.*;

import static javax.swing.JOptionPane.showMessageDialog;


public class AddProduct extends JFrame {
    private ImageIcon i1;
    private JLabel l1, l2, l3, l4, l5, l6;
    private Container c;
    private JButton b1, b2;
    private JComboBox jc1;
    private JTextField tf1, tf2;


    public AddProduct(String username, boolean isManagerCreation) {
        setTitle("Add Product");

        // icon
        i1 = new ImageIcon("images/crm_logo.png");
        setIconImage(i1.getImage());


        // content pane
        c = getContentPane();

        l1 = new JLabel("Add Product");
        l1.setBounds(580, 120, 240, 60);
        // l1.setForeground(Color.white);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 35));

        c.add(l1);

        // labels
        l2 = new JLabel("Product");
        l2.setBounds(500, 200, 300, 40);
        // l2.setForeground(Color.white);
        l2.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        c.add(l2);

        l4 = new JLabel("________________________________________________________");
        l4.setBounds(500, 250, 400, 40);
        // l4.setForeground(Color.white);
        l4.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        c.add(l4);

        l3 = new JLabel("Category");
        l3.setBounds(500, 300, 150, 40);
        // l3.setForeground(Color.white);
        l3.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        c.add(l3);

        // l5 = new JLabel("________________________________________________________");
        // l5.setBounds(500, 350, 400, 40);
        // // l5.setForeground(Color.white);
        // l5.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        String[] items = {"--Select--", "Produce", "Meat", "Electornics", "Clothing"};
        jc1 = new JComboBox<>(items);
        jc1.setBounds(500, 350, 400, 40);
        // jc1.setBackground(Color.white);
        // jc1.setForeground(Color.black);
        jc1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jc1.setFocusable(false);
        
        c.add(jc1);

        l5 = new JLabel("Price");
        l5.setBounds(500, 400, 170, 40);
        // l3.setForeground(Color.white);
        l5.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        c.add(l5);

        l6 = new JLabel("________________________________________________________");
        l6.setBounds(500, 450, 400, 40);
        // l5.setForeground(Color.white);
        l6.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        c.add(l6);

        tf1 = new JTextField();
        tf1.setBounds(504, 240, 380, 30);
        tf1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        tf1.setForeground(Color.black);
        tf1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        tf1.setCaretColor(Color.black);
        tf1.setBorder(null);
        tf1.setOpaque(false);

        c.add(tf1);


        tf2 = new JTextField();
        tf2.setBounds(501, 440, 380, 30);
        tf2.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        tf2.setForeground(Color.black);
        tf2.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        tf2.setCaretColor(Color.black);
        tf2.setBorder(null);
        tf2.setOpaque(false);

        c.add(tf2);

        b1 = new JButton("Add Product");
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
                    String product = tf1.getText().toLowerCase();
                    String category = (String) jc1.getSelectedItem();
                    String price = tf2.getText().toLowerCase();
                    if(category.equals("--Select--")){
                        showMessageDialog(null, " Please select a category  ", "Message", 2);
                    } else {
                        if((!product.isEmpty() && !price.isEmpty())){
                            ProductAdd product1 = new ProductAdd();
                            boolean productCreated = product1.productAdd(product, category, price);
                            if(productCreated){
                                if(isManagerCreation) {
                                    new ManagerDashboard(username);
                                    setVisible(false);
                                } else {
                                    new OwnerDashboard(username);
                                    setVisible(false);
                                }
                            }
                    } else {
                        showMessageDialog(null, " Fill the blank fields ", "Message", 2);
                    }
                    }
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b2) {
                    if(isManagerCreation){
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
}
