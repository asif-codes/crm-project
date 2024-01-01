
package classes;

import javax.swing.*;

import utils.CustomerSignUp;
import utils.OwnerAdd;
import utils.ProductAdd;

import java.awt.*;
import java.awt.event.*;

import static javax.swing.JOptionPane.showMessageDialog;


public class AddOwner extends JFrame {
    private ImageIcon i1;
    private JLabel l1, l2, l3, l4, l5, l6, l8;
    private Container c;
    private JButton b1, b2, b6, b7, b3, b4;
    private JComboBox jc1;
    private JTextField tf1, tf2;
    private JPasswordField pf1, pf2;


    public AddOwner(String username) {
        setTitle("Add Owner");

        // icon
        i1 = new ImageIcon("images/crm_logo.png");
        setIconImage(i1.getImage());


        // content pane
        c = getContentPane();

        l1 = new JLabel("Add Owner");
        l1.setBounds(610, 120, 250, 60);
        // l1.setForeground(Color.white);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 35));
        
        c.add(l1);

        l2 = new JLabel("Username");
        l2.setBounds(500, 200, 300, 40);
        // l2.setForeground(Color.white);
        l2.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        c.add(l2);

        l3 = new JLabel("Password");
        l3.setBounds(500, 300, 150, 40);
        // l3.setForeground(Color.white);
        l3.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        c.add(l3);

        l6 = new JLabel("ReType Password");
        l6.setBounds(500, 400, 170, 40);
        // l3.setForeground(Color.white);
        l6.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        c.add(l6);

        l4 = new JLabel("________________________________________________________");
        l4.setBounds(500, 250, 400, 40);
        // l4.setForeground(Color.white);
        l4.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        c.add(l4);

        l5 = new JLabel("________________________________________________________");
        l5.setBounds(500, 350, 400, 40);
        // l5.setForeground(Color.white);
        l5.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        c.add(l5);

        l8 = new JLabel("________________________________________________________");
        l8.setBounds(500, 450, 400, 40);
        // l5.setForeground(Color.white);
        l8.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        c.add(l8);

        tf1 = new JTextField();
        tf1.setBounds(504, 240, 380, 30);
        tf1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        tf1.setForeground(Color.black);
        tf1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        tf1.setCaretColor(Color.black);
        tf1.setBorder(null);
        tf1.setOpaque(false);

        c.add(tf1);

        pf1 = new JPasswordField();
        pf1.setBounds(501, 340, 380, 30);
        pf1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        pf1.setForeground(Color.black);
        pf1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        pf1.setCaretColor(Color.black);
        pf1.setBorder(null);
        pf1.setOpaque(false);

        c.add(pf1);

        pf2 = new JPasswordField();
        pf2.setBounds(501, 440, 380, 30);
        pf2.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        pf2.setForeground(Color.black);
        pf2.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        pf2.setCaretColor(Color.black);
        pf2.setBorder(null);
        pf2.setOpaque(false);

        c.add(pf2);

        b1 = new JButton("Show");
        b1.setBounds(889, 335, 50, 50);
        b1.setForeground(Color.black);
        b1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);

        c.add(b1);

        b2 = new JButton("Hide");
        b2.setBounds(889, 335, 50, 50);
        b2.setForeground(Color.black);
        b2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setFocusPainted(false);
        b2.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b2.setContentAreaFilled(false);
        b2.setVisible(false);

        c.add(b2);

        b6 = new JButton("Show");
        b6.setBounds(889, 435, 50, 50);
        b6.setForeground(Color.black);
        b6.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        b6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b6.setFocusPainted(false);
        b6.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b6.setContentAreaFilled(false);

        c.add(b6);

        b7 = new JButton("Hide");
        b7.setBounds(889, 435, 50, 50);
        b7.setForeground(Color.black);
        b7.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        b7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b7.setFocusPainted(false);
        b7.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b7.setContentAreaFilled(false);
        b7.setVisible(false);

        c.add(b7);

        b3 = new JButton("Add Owner");
        b3.setBounds(500, 490, 400, 40);
        b3.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b3.setForeground(Color.white);
        b3.setBackground(Color.BLUE);
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.setFocusPainted(false);
        
        c.add(b3);

        b4 = new JButton("Go Back");
        b4.setBounds(500, 550, 400, 40);
        b4.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b4.setForeground(Color.white);
        b4.setBackground(new Color(252, 76, 202));
        b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b4.setFocusPainted(false);

        c.add(b4);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b1) {
                    if (pf1.getEchoChar() != '\u0000') {
                        pf1.setEchoChar('\u0000');
                        b1.setVisible(false);
                        b2.setVisible(true);
                        pf2.setEchoChar('\u0000');
                        b6.setVisible(false);
                        b7.setVisible(true);
                    }
                }
            }
        });

        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b6) {
                    if (pf2.getEchoChar() != '\u0000') {
                        pf2.setEchoChar('\u0000');
                        b6.setVisible(false);
                        b7.setVisible(true);
                        pf1.setEchoChar('\u0000');
                        b1.setVisible(false);
                        b2.setVisible(true);
                    }
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b2) {
                    pf1.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
                    b2.setVisible(false);
                    b1.setVisible(true);
                    pf2.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
                    b7.setVisible(false);
                    b6.setVisible(true);
                }
            }
        });

        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b7) {
                    pf2.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
                    b7.setVisible(false);
                    b6.setVisible(true);
                    pf1.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
                    b2.setVisible(false);
                    b1.setVisible(true);
                }
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b4) {
                    new OwnerDashboard(username);
                    setVisible(false);
                }
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b3) {
                    String username = tf1.getText().toLowerCase();
                    String password = pf1.getText();
                    String password1 = pf2.getText();
                    if((!username.isEmpty() && !password.isEmpty() && !password1.isEmpty())){
                        if(password.equals(password1)){
                            OwnerAdd owner = new OwnerAdd();
                            boolean customerCreated = owner.ownerAdd(username, password1);
                            if(customerCreated){
                                new OwnerDashboard(username);
                                setVisible(false);
                            }
                        } else {
                            showMessageDialog(null, " Passwords do not match ", "Message", 2);
                        }
                    } else {
                        showMessageDialog(null, " Fill the blank fields ", "Message", 2);
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
