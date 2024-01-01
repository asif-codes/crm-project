package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;

import utils.*;;


public class SignIn extends JFrame {
    private ImageIcon i1;
    private Container c;
    private JLabel l1, l2, l3, l4, l5, l6, l7;
    private JPanel p1;
    private JComboBox<String> jc1;
    private JTextField tf1;
    private JPasswordField pf1;
    private JButton b1, b2, b3, b4, b5;

    public SignIn(){
        setTitle("SignIn");
        setBounds(0, 0, 100, 100);
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // icon
        i1 = new ImageIcon("images/crm_logo.png");
        setIconImage(i1.getImage());

        c = getContentPane();

        l1 = new JLabel("Sign In");
        l1.setBounds(630, 120, 200, 60);
        // l1.setForeground(Color.white);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 35));


        // labels
        l2 = new JLabel("Username");
        l2.setBounds(500, 280, 300, 40);
        // l2.setForeground(Color.white);
        l2.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        l3 = new JLabel("Password");
        l3.setBounds(500, 380, 150, 40);
        // l3.setForeground(Color.white);
        l3.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        l4 = new JLabel("________________________________________________________");
        l4.setBounds(500, 330, 400, 40);
        // l4.setForeground(Color.white);
        l4.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        l5 = new JLabel("________________________________________________________");
        l5.setBounds(500, 430, 400, 40);
        // l5.setForeground(Color.white);
        l5.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        l6 = new JLabel("Role");
        l6.setBounds(500, 220, 150, 40);
        // l6.setForeground(Color.white);
        l6.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        String[] items = {"--Select--", "Owner", "Manager", "Customer"};
        jc1 = new JComboBox<>(items);
        jc1.setBounds(570, 220, 150, 40);
        // jc1.setBackground(Color.white);
        // jc1.setForeground(Color.black);
        jc1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jc1.setFocusable(false);

        tf1 = new JTextField();
        tf1.setBounds(504, 320, 380, 30);
        tf1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        tf1.setForeground(Color.black);
        tf1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        tf1.setCaretColor(Color.black);
        tf1.setBorder(null);
        tf1.setOpaque(false);

        pf1 = new JPasswordField();
        pf1.setBounds(501, 420, 380, 30);
        pf1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        pf1.setForeground(Color.black);
        pf1.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        pf1.setCaretColor(Color.black);
        pf1.setBorder(null);
        pf1.setOpaque(false);

        b1 = new JButton("Show");
        b1.setBounds(889, 415, 50, 50);
        b1.setForeground(Color.black);
        b1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setFocusPainted(false);
        b1.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b1.setContentAreaFilled(false);

        b2 = new JButton("Hide");
        b2.setBounds(889, 415, 50, 50);
        b2.setForeground(Color.black);
        b2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setFocusPainted(false);
        b2.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b2.setContentAreaFilled(false);
        b2.setVisible(false);

        b3 = new JButton("Sign In");
        b3.setBounds(500, 490, 400, 40);
        b3.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b3.setForeground(Color.white);
        b3.setBackground(Color.BLUE);
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.setFocusPainted(false);
        
        b4 = new JButton("Go Back");
        b4.setBounds(500, 550, 400, 40);
        b4.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b4.setForeground(Color.white);
        b4.setBackground(new Color(252, 76, 202));
        b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b4.setFocusPainted(false);

        l7 = new JLabel("Don't have an account?");
        l7.setBounds(500, 610, 240, 40);
        l7.setForeground(Color.black);
        l7.setFont(new Font("Segoe UI", Font.PLAIN, 22));

        b5 = new JButton("Sign Up");
        b5.setBounds(725, 605, 80, 50);
        b5.setForeground(Color.blue);
        b5.setFont(new Font("Segoe UI", Font.BOLD, 19));
        b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b5.setFocusPainted(false);
        b5.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        b5.setContentAreaFilled(false);


        // panel
        p1 = new JPanel();
        p1.setBounds(0, 0, 1366, 768);
        // p1.setBackground(new Color(25, 118, 211));

        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        c.add(l6);
        c.add(jc1);
        c.add(tf1);
        c.add(pf1);
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(b4);
        c.add(b5);
        c.add(l7);
        c.add(p1);

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b4) {
                    new Welcome();
                    setVisible(false);
                }
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b3) {
                    String selectedOption = (String) jc1.getSelectedItem();
                    String username = tf1.getText().toLowerCase();
                    String password = pf1.getText();
                    if (selectedOption.equals("Owner")){
                        if((!username.isEmpty() && !password.isEmpty())){
                            OwnerSignIn owner = new OwnerSignIn();
                            boolean ownerExists = owner.ownerSignIn(username, password);
                            if(ownerExists){
                                new OwnerDashboard(username);
                                setVisible(false);
                            }
                        } else {
                            showMessageDialog(null, " Fill the blank fields ", "Message", 2);
                        }
                    } else if (selectedOption.equals("Manager")){
                        if((!username.isEmpty() && !password.isEmpty())){
                            ManagerSignIn manager = new ManagerSignIn();
                            boolean managerExists = manager.managerSignIn(username, password);
                            if(managerExists){
                                new ManagerDashboard(username);
                                setVisible(false);
                            }
                        } else {
                            showMessageDialog(null, " Fill the blank fields ", "Message", 2);
                        }
                    } else if (selectedOption.equals("Customer")){
                        if((!username.isEmpty() && !password.isEmpty())){
                            CustomerSignIn customer = new CustomerSignIn();
                            boolean customerExists = customer.customerSignIn(username, password);
                            if(customerExists){
                                new CustomerDashboard(username);
                                setVisible(false);
                            }
                        } else {
                            showMessageDialog(null, " Fill the blank fields ", "Message", 2);
                        }
                    } else {
                        showMessageDialog(null, " Please select a role  ", "Message", 2);
                    }
                }
            }
        });

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b1) {
                    if (pf1.getEchoChar() != '\u0000') {
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
                }
            }
        });

        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b5) {
                    new SignUp();
                    setVisible(false);
                }
            }
        });


        setVisible(true);
    }
}
