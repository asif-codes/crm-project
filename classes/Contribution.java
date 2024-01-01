package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Contribution extends JFrame {
    private ImageIcon i1;
    private JLabel l1;
    private Container c;
    private JButton b1;


    public Contribution() {
        setTitle("Contributions");

        // icon
        i1 = new ImageIcon("images/crm_logo.png");
        setIconImage(i1.getImage());

        l1 = new JLabel();
        l1.setIcon(new ImageIcon("images/contributions.png"));
        Dimension size = l1.getPreferredSize();
        l1.setBounds(0, 0, size.width, size.height);

        // content pane
        c = getContentPane();
        

        // buttons
        b1 = new JButton("OK");
        b1.setBounds(220, 425, 120, 50);
        b1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b1.setBackground(new Color(23, 61, 123));
        b1.setForeground(new Color(255, 255, 255));
        b1.setFocusPainted(false);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == b1) {
                    new Welcome();
                    setVisible(false);
                }
            }
        });

        c.add(l1);
        c.add(b1);

        setSize(566, 530);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
