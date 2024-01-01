package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Welcome extends JFrame {
    private Container c;
    private ImageIcon i1;
    private JButton b1, b2;
    private JLabel l1;

    public Welcome() {
        setTitle("Welcome");
        setBounds(0, 0, 100, 100);
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // icon
        i1 = new ImageIcon("images/crm_logo.png");
        setIconImage(i1.getImage());

        // contant pane
        c = getContentPane();

        l1 = new JLabel("Customer Relationship Management");
        l1.setBounds(380, 200, 650, 60);
        // l1.setForeground(Color.white);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 35));

        c.add(l1);

        // buttons
        b1 = new JButton("Get Started");
        b1.setBounds(490, 312, 400, 40);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b1.setBackground(new Color(71, 74, 237));
        b1.setForeground(new Color(245, 245, 250));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setFocusPainted(false);

        b2 = new JButton("Contributions");
        b2.setBounds(490, 375, 400, 40);
        b2.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b2.setBackground(new Color(242, 29, 217));
        b2.setForeground(new Color(245, 245, 250));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setFocusPainted(false);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b1) {
                    new SignIn();
                    setVisible(false);
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b2) {
                    new Contribution();
                    setVisible(false);
                }
            }
        });

        c.add(b1);
        c.add(b2);


        setVisible(true);
    }
}
