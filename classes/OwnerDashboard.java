package classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
import java.util.List;



public class OwnerDashboard extends JFrame {
    private Container c;
    private ImageIcon i1;
    private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15;
    private JTable t1, t2, t3, t4, t5;
    private static DefaultTableModel m1, m2, m3, m4, m5;
    private JScrollPane s1, s2, s3, s4, s5;
    private JLabel l1, l2, l3, l4, l5, l6;


    private String[] c1 = { "Customer", "Password", "Date Added" };
    private String[] c2 = { "Owner", "Password", "Date Added" };
    private String[] c3 = { "Manager", "Password", "Date Added" };
    private String[] c4 = { "Customer", "Product", "Status", "Date Ordered" };
    private String[] c5 = { "Product", "Category", "Price" };




    public OwnerDashboard(String username) {
        setTitle("Owner Dashboard");
        setBounds(0, 0, 100, 100);
        setSize(3000, 3000);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        // icon
        i1 = new ImageIcon("images/crm_logo.png");
        setIconImage(i1.getImage());

        // contant pane
        c = getContentPane();

        String filePath = ".\\data\\order_data.txt"; 
        String product = "Product"; 
        String pending = "Pending";
        String outForDelivery = "Out For Delivery";
        String delivered = "Delivered";

        try {
            int totalOrders = countTextOccurrences(filePath, product);
            System.out.println("The text '" + product + "' appears " + totalOrders + " times in the file.");
            // buttons
            b1 = new JButton("Total Orders: " + totalOrders);
            b1.setBounds(99, 69, 180, 80);
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

        try {
            int totalPending = countTextOccurrences(filePath, pending);
            System.out.println("The text '" + pending + "' appears " + totalPending + " times in the file.");
            
            b2 = new JButton("Pending: " + totalPending);
            b2.setBounds(300, 69, 180, 80);
            b2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            b2.setBackground(new Color(117, 217, 98));
            b2.setForeground(Color.white);
            b2.setFocusPainted(false);
            b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            b2.setBorderPainted(false);
            c.add(b2);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            int totalOutForDelivery = countTextOccurrences(filePath, outForDelivery);
            System.out.println("The text '" + outForDelivery + "' appears " + totalOutForDelivery + " times in the file.");
            
            b3 = new JButton("Out for Delivery: " + totalOutForDelivery);
            b3.setBounds(501, 69, 200, 80);
            b3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            b3.setBackground(new Color(72, 217, 212));
            b3.setForeground(Color.white);
            b3.setFocusPainted(false);
            b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            b3.setBorderPainted(false);
            c.add(b3);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            int totalDelivered = countTextOccurrences(filePath, delivered);
            System.out.println("The text '" + outForDelivery + "' appears " + totalDelivered + " times in the file.");
            
            b4 = new JButton("Delivered: " + totalDelivered);
            b4.setBounds(721, 69, 200, 80);
            b4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            b4.setBackground(new Color(222, 62, 91));
            b4.setForeground(Color.white);
            b4.setFocusPainted(false);
            b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
            b4.setBorderPainted(false);
            c.add(b4);

        } catch (IOException e) {
            e.printStackTrace();
        }
        


        // table
        t1 = new JTable();
        m1 = new DefaultTableModel();
        m1.setColumnIdentifiers(c1);
		c.add(t1);

        
        t1.setModel(m1);
        t1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        t1.setSelectionBackground(Color.decode("#8AC5FF"));
        t1.setBackground(Color.WHITE);
        t1.setRowHeight(30);
        t1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        t1.getColumnModel().getColumn(0).setPreferredWidth(150);
        t1.getColumnModel().getColumn(1).setPreferredWidth(150);
        t1.getColumnModel().getColumn(2).setPreferredWidth(150);


        s1 = new JScrollPane(t1);
        s1.setBounds(100, 190, 450, 300);
        s1.setBackground(Color.WHITE);
        c.add(s1);
		DefaultTableModel m1 = (DefaultTableModel) t1.getModel();

        try  
			{  
			//the file to be opened for reading  
			FileInputStream fis=new FileInputStream(".\\data\\customer_data.txt");   
			Scanner sc=new Scanner(fis);    //file to be scanned  
			//returns true if there is another line to read  
			int i =0;
			String[] valueToshowOntable = new String[3];
			while(sc.hasNextLine())  
			{ 
			if(i>= 0 && i<=2){
		   String value = sc.nextLine();
		   if(value == ""){
			   i=-1;
		   }
			String[] parts = value.split(":");
			System.out.println("ARRAY : "+i);
			
			if(parts.length>1){
				System.out.println(parts[1]); 
				valueToshowOntable[i]=parts[1];
			}
			
				
			}else if(i==3){
			m1.addRow(new Object[]{valueToshowOntable[0],valueToshowOntable[1], valueToshowOntable[2]});		
			valueToshowOntable=null;
			valueToshowOntable= new String[3];
			i=-1;
			}
			
			  i++;   //returns the line that was skipped  
			} 
            m1.addRow(new Object[]{valueToshowOntable[0],valueToshowOntable[1], valueToshowOntable[2]});		
						
			sc.close();     //closes the scanner  
			}  
		catch(IOException ae) {  
			    ae.printStackTrace();  
		}

        t2 = new JTable();
        m2 = new DefaultTableModel();
        m2.setColumnIdentifiers(c2);
		c.add(t2);

        
        t2.setModel(m2);
        t2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        t2.setSelectionBackground(Color.decode("#8AC5FF"));
        t2.setBackground(Color.WHITE);
        t2.setRowHeight(30);
        t2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        t2.getColumnModel().getColumn(0).setPreferredWidth(150);
        t2.getColumnModel().getColumn(1).setPreferredWidth(150);
        t2.getColumnModel().getColumn(2).setPreferredWidth(150);


        s2 = new JScrollPane(t2);
        s2.setBounds(567, 190, 450, 300);
        s2.setBackground(Color.WHITE);
        c.add(s2);
		DefaultTableModel m2 = (DefaultTableModel) t2.getModel();

        try  
			{  
			//the file to be opened for reading  
			FileInputStream fis1=new FileInputStream(".\\data\\owner_data.txt");   
			Scanner sc1=new Scanner(fis1);    //file to be scanned  
			//returns true if there is another line to read  
			int j =0;
			String[] valueToshowOntable1 = new String[3];
			while(sc1.hasNextLine())  
			{ 
			if(j>= 0 && j<=2){
		   String value = sc1.nextLine();
		   if(value == ""){
			   j=-1;
		   }
			String[] parts1 = value.split(":");
			System.out.println("ARRAY : "+j);
			
			if(parts1.length>1){
				System.out.println(parts1[1]); 
				valueToshowOntable1[j]=parts1[1];
			}
			
				
			}else if(j==3){
			m2.addRow(new Object[]{valueToshowOntable1[0],valueToshowOntable1[1], valueToshowOntable1[2]});		
			valueToshowOntable1=null;
			valueToshowOntable1= new String[3];
			j=-1;
			}
			
			  j++;   //returns the line that was skipped  
			} 
            m2.addRow(new Object[]{valueToshowOntable1[0],valueToshowOntable1[1], valueToshowOntable1[2]});		
						
			sc1.close();     //closes the scanner  
			}  
		catch(IOException ae) {  
			    ae.printStackTrace();  
		}

        t3 = new JTable();
        m3 = new DefaultTableModel();
        m3.setColumnIdentifiers(c3);
		c.add(t3);

        
        t3.setModel(m3);
        t3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        t3.setSelectionBackground(Color.decode("#8AC5FF"));
        t3.setBackground(Color.WHITE);
        t3.setRowHeight(30);
        t3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        t3.getColumnModel().getColumn(0).setPreferredWidth(150);
        t3.getColumnModel().getColumn(1).setPreferredWidth(150);
        t3.getColumnModel().getColumn(2).setPreferredWidth(150);


        s3 = new JScrollPane(t3);
        s3.setBounds(1031, 190, 450, 300);
        s3.setBackground(Color.WHITE);
        c.add(s3);
		DefaultTableModel m3 = (DefaultTableModel) t3.getModel();

        try  
			{  
			//the file to be opened for reading  
			FileInputStream fis2=new FileInputStream(".\\data\\manager_data.txt");   
			Scanner sc2=new Scanner(fis2);    //file to be scanned  
			//returns true if there is another line to read  
			int k =0;
			String[] valueToshowOntable2 = new String[3];
			while(sc2.hasNextLine())  
			{ 
			if(k>= 0 && k<=2){
		   String value = sc2.nextLine();
		   if(value == ""){
			   k=-1;
		   }
			String[] parts2 = value.split(":");
			System.out.println("ARRAY : "+k);
			
			if(parts2.length>1){
				System.out.println(parts2[1]); 
				valueToshowOntable2[k]=parts2[1];
			}
			
				
			}else if(k==3){
			m3.addRow(new Object[]{valueToshowOntable2[0],valueToshowOntable2[1], valueToshowOntable2[2]});		
			valueToshowOntable2=null;
			valueToshowOntable2= new String[3];
			k=-1;
			}
			
			  k++;   //returns the line that was skipped  
			} 
            m3.addRow(new Object[]{valueToshowOntable2[0],valueToshowOntable2[1], valueToshowOntable2[2]});		
						
			sc2.close();     //closes the scanner  
			}  
		catch(IOException ae) {  
			    ae.printStackTrace();  
		}

        t4 = new JTable();
        m4 = new DefaultTableModel();
        m4.setColumnIdentifiers(c4);
		c.add(t4);

        
        t4.setModel(m4);
        t4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        t4.setSelectionBackground(Color.decode("#8AC5FF"));
        t4.setBackground(Color.WHITE);
        t4.setRowHeight(30);
        t4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        t4.getColumnModel().getColumn(0).setPreferredWidth(150);
        t4.getColumnModel().getColumn(1).setPreferredWidth(150);
        t4.getColumnModel().getColumn(2).setPreferredWidth(170);
        t4.getColumnModel().getColumn(3).setPreferredWidth(150);


        s4 = new JScrollPane(t4);
        s4.setBounds(99, 570, 622, 300);
        s4.setBackground(Color.WHITE);
        c.add(s4);
		DefaultTableModel m4 = (DefaultTableModel) t4.getModel();

        try  
			{  
			//the file to be opened for reading  
			FileInputStream fis=new FileInputStream(".\\data\\order_data.txt");   
			Scanner sc=new Scanner(fis);    //file to be scanned  
			//returns true if there is another line to read  
			int i =0;
			String[] valueToshowOntable = new String[6];
			while(sc.hasNextLine())  
			{ 
			if(i>= 0 && i<=3){
		   String value = sc.nextLine();
		   if(value == ""){
			   i=-1;
		   }
			String[] parts = value.split(":");
			System.out.println("ARRAY : "+i);
			
			if(parts.length>1){
				System.out.println(parts[1]); 
				valueToshowOntable[i]=parts[1];
			}
			
				
			}else if(i==4){
			m4.addRow(new Object[]{valueToshowOntable[0],valueToshowOntable[1], valueToshowOntable[2], valueToshowOntable[3], valueToshowOntable[4]});		
			valueToshowOntable=null;
			valueToshowOntable= new String[6];
			i=-1;
			}
			
			  i++;   //returns the line that was skipped  
			} 
    m4.addRow(new Object[]{valueToshowOntable[0],valueToshowOntable[1], valueToshowOntable[2], valueToshowOntable[3], valueToshowOntable[4]});		
						
			sc.close();     //closes the scanner  
			}  
			catch(IOException ae)  
			{  
			ae.printStackTrace();  
			}

        t5 = new JTable();
        m5 = new DefaultTableModel();
        m5.setColumnIdentifiers(c5);
		c.add(t5);

        
        t5.setModel(m5);
        t5.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        t5.setSelectionBackground(Color.decode("#8AC5FF"));
        t5.setBackground(Color.WHITE);
        t5.setRowHeight(30);
        t5.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        t5.getColumnModel().getColumn(0).setPreferredWidth(150);
        t5.getColumnModel().getColumn(1).setPreferredWidth(150);
        t5.getColumnModel().getColumn(2).setPreferredWidth(150);

        s5 = new JScrollPane(t5);
        s5.setBounds(733, 570, 450, 300);
        s5.setBackground(Color.WHITE);
        c.add(s5);
		DefaultTableModel m5 = (DefaultTableModel) t5.getModel();

        try  
			{  
			//the file to be opened for reading  
			FileInputStream fis=new FileInputStream(".\\data\\product_data.txt");   
			Scanner sc=new Scanner(fis);    //file to be scanned  
			//returns true if there is another line to read  
			int i =0;
			String[] valueToshowOntable = new String[6];
			while(sc.hasNextLine())  
			{ 
			if(i>= 0 && i<=2){
		   String value = sc.nextLine();
		   if(value == ""){
			   i=-1;
		   }
			String[] parts = value.split(":");
			System.out.println("ARRAY : "+i);
			
			if(parts.length>1){
				System.out.println(parts[1]); 
				valueToshowOntable[i]=parts[1];
			}
			
				
			}else if(i==3){
			m5.addRow(new Object[]{valueToshowOntable[0],valueToshowOntable[1], valueToshowOntable[2], valueToshowOntable[3]});		
			valueToshowOntable=null;
			valueToshowOntable= new String[6];
			i=-1;
			}
			
			  i++;   //returns the line that was skipped  
			} 
    m5.addRow(new Object[]{valueToshowOntable[0],valueToshowOntable[1], valueToshowOntable[2], valueToshowOntable[3]});		
						
			sc.close();     //closes the scanner  
			}  
			catch(IOException ae)  
			{  
			ae.printStackTrace();  
			}


        b5 = new JButton("Add Customer");
        b5.setBounds(100, 489, 225, 40);
        b5.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b5.setForeground(Color.white);
        b5.setBackground(new Color(50, 215, 227));
        b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b5.setFocusPainted(false);

        b6 = new JButton("Delete Customer");
        b6.setBounds(324, 489, 225, 40);
        b6.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b6.setForeground(Color.white);
        b6.setBackground(new Color(201, 8, 56));
        b6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b6.setFocusPainted(false);

        b7 = new JButton("Add Owner");
        b7.setBounds(567, 489, 225, 40);
        b7.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b7.setForeground(Color.white);
        b7.setBackground(new Color(50, 215, 227));
        b7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b7.setFocusPainted(false);

        b8 = new JButton("Delete Owner");
        b8.setBounds(792, 489, 225, 40);
        b8.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b8.setForeground(Color.white);
        b8.setBackground(new Color(201, 8, 56));
        b8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b8.setFocusPainted(false);

        b9 = new JButton("Add Manager");
        b9.setBounds(1031, 489, 225, 40);
        b9.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b9.setForeground(Color.white);
        b9.setBackground(new Color(50, 215, 227));
        b9.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b9.setFocusPainted(false);

        b10 = new JButton("Delete Manager");
        b10.setBounds(1256, 489, 225, 40);
        b10.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b10.setForeground(Color.white);
        b10.setBackground(new Color(201, 8, 56));
        b10.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b10.setFocusPainted(false);

        b11 = new JButton("Add Order");
        b11.setBounds(100, 869, 311, 40);
        b11.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b11.setForeground(Color.white);
        b11.setBackground(new Color(50, 215, 227));
        b11.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b11.setFocusPainted(false);

        b12 = new JButton("Delete Order");
        b12.setBounds(411, 869, 311, 40);
        b12.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b12.setForeground(Color.white);
        b12.setBackground(new Color(201, 8, 56));
        b12.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b12.setFocusPainted(false);

        b13 = new JButton("Add Product");
        b13.setBounds(733, 868, 225, 40);
        b13.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b13.setForeground(Color.white);
        b13.setBackground(new Color(50, 215, 227));
        b13.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b13.setFocusPainted(false);

        b14 = new JButton("Delete Product");
        b14.setBounds(958, 869, 225, 40);
        b14.setFont(new Font("Segoe UI", Font.BOLD, 25));
        b14.setForeground(Color.white);
        b14.setBackground(new Color(201, 8, 56));
        b14.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b14.setFocusPainted(false);

        l1 = new JLabel("Customers");
        l1.setBounds(102, 164, 225, 20);
        l1.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        l1.setForeground(Color.BLACK);
        // l1.setBackground(new Color(201, 8, 56));
        l1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // l1.setFocusPainted(false);
        
        l2 = new JLabel("Owners");
        l2.setBounds(568, 164, 225, 20);
        l2.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        l2.setForeground(Color.BLACK);
        // l1.setBackground(new Color(201, 8, 56));
        l2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // l1.setFocusPainted(false);

        l3 = new JLabel("Managers");
        l3.setBounds(1032, 166, 225, 24);
        l3.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        l3.setForeground(Color.BLACK);
        // l1.setBackground(new Color(201, 8, 56));
        l3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // l1.setFocusPainted(false);

        l4 = new JLabel("Orders");
        l4.setBounds(100, 545, 225, 24);
        l4.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        l4.setForeground(Color.BLACK);
        // l1.setBackground(new Color(201, 8, 56));
        l4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // l1.setFocusPainted(false);

        l5 = new JLabel("Products");
        l5.setBounds(733, 545, 225, 24);
        l5.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        l5.setForeground(Color.BLACK);
        // l1.setBackground(new Color(201, 8, 56));
        l5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // l1.setFocusPainted(false);

        l6 = new JLabel("Signed in as: " + username);
        l6.setBounds(98, 27, 240, 40);
        l6.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        l6.setForeground(Color.black);

        b15 = new JButton("Sign Out");
        b15.setBounds(770, 40, 150, 25);
        b15.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b15.setForeground(Color.white);
        b15.setBackground(new Color(222, 42, 60));
        b15.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b15.setFocusPainted(false);

        c.add(b5);
        c.add(b6);
        c.add(b7);
        c.add(b8);
        c.add(b9);
        c.add(b10);
        c.add(b11);
        c.add(b12);
        c.add(b13);
        c.add(b14);
        c.add(b15);
        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(l5);
        c.add(l6);
        
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b6) {
                    deleteCustomerRow(m1, t1, ".\\data\\customer_data.txt");
                }
            }
        });

        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b5) {
                    new AddCustomer(username, false);
                    setVisible(false);
                }
            }
        });

        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b7) {
                    new AddOwner(username);
                    setVisible(false);
                }
            }
        });

        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b8) {
                    deleteOwnerRow(m2, t2, ".\\data\\owner_data.txt");
                }
            }
        });

        b9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b9) {
                    new AddManager(username);
                    setVisible(false);
                }
            }
        });

        b10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b10) {
                    deleteManagerRow(m3, t3, ".\\data\\manager_data.txt");
                }
            }
        });

        b11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b11) {
                    new AddOrder(username, false);
                    setVisible(false);
                }
            }
        });

        b12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b12) {
                    deleteOrderRow(m4, t4, ".\\data\\order_data.txt");
                }
            }
        });

        b13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b13) {
                    new AddProduct(username, false);
                    setVisible(false);
                }
            }
        });

        b14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b14) {
                    deleteProductRow(m5, t5, ".\\data\\product_data.txt");
                }
            }
        });

        b15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b15) {
                    new SignIn();
                    setVisible(false);
                }
            }
        });


        setVisible(true);
    }


    private static void deleteCustomerRow(DefaultTableModel model, JTable table, String filename){
        int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                    writeCustomerDataToFile(filename, model);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete.");
                }
    }

    private static void deleteOwnerRow(DefaultTableModel model, JTable table, String filename){
        int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                    writeOwnerDataToFile(filename, model);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete.");
                }
    }

    private static void deleteManagerRow(DefaultTableModel model, JTable table, String filename){
        int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                    writeManagerDataToFile(filename, model);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete.");
                }
    }

    private static void deleteOrderRow(DefaultTableModel model, JTable table, String filename){
        int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                    writeOrderDataToFile(filename, model);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete.");
                }
    }

    private static void deleteProductRow(DefaultTableModel model, JTable table, String filename){
        int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                    writeProductDataToFile(filename, model);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete.");
                }
    }

    private static void writeCustomerDataToFile(String filename, DefaultTableModel model){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (int i = 0; i < model.getRowCount(); i++) {
                   StringBuilder row = new StringBuilder();
                   for (int j = 0; j < model.getColumnCount(); j++) {
                       if(model.getValueAt(i, j) != null){
                           if(j==0){
                       row.append("User Name: "+ model.getValueAt(i, j));
                           row.append("\n");
                       }
                       if(j==1){
                       row.append("Password: "+ model.getValueAt(i, j));
                           row.append("\n");
                       }
                       if(j==2){
                       row.append("Date Added: "+ model.getValueAt(i, j));
                           row.append("\n");
                       }
                       }
                       
                      
                   }
                   writer.write(row.toString());
                   writer.newLine();
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
        }

    private static void writeOwnerDataToFile(String filename, DefaultTableModel model){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < model.getColumnCount(); j++) {
                    if(model.getValueAt(i, j) != null){
                        if(j==0){
                    row.append("User Name: "+ model.getValueAt(i, j));
                        row.append("\n");
                    }
                    if(j==1){
                    row.append("Password: "+ model.getValueAt(i, j));
                        row.append("\n");
                    }
                    if(j==2){
                    row.append("Date Added: "+ model.getValueAt(i, j));
                        row.append("\n");
                    }
                    }
                    
                    
                }
                writer.write(row.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeManagerDataToFile(String filename, DefaultTableModel model){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < model.getColumnCount(); j++) {
                    if(model.getValueAt(i, j) != null){
                        if(j==0){
                    row.append("User Name: "+ model.getValueAt(i, j));
                        row.append("\n");
                    }
                    if(j==1){
                    row.append("Password: "+ model.getValueAt(i, j));
                        row.append("\n");
                    }
                    if(j==2){
                    row.append("Date Added: "+ model.getValueAt(i, j));
                        row.append("\n");
                    }
                    }
                    
                    
                }
                writer.write(row.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeOrderDataToFile(String filename, DefaultTableModel model){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < model.getColumnCount(); j++) {
                    if(model.getValueAt(i, j) != null){
                        if(j==0){
                    row.append("Customer: "+ model.getValueAt(i, j));
                        row.append("\n");
                    }
                    if(j==1){
                    row.append("Product: "+ model.getValueAt(i, j));
                        row.append("\n");
                    }
                    if(j==2){
                    row.append("Date Ordered: "+ model.getValueAt(i, j));
                        row.append("\n");
                    }
                    if(j==3){
                    row.append("Status: "+ model.getValueAt(i, j));
                        row.append("\n");
                    }
                    }
                    
                    
                }
                writer.write(row.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeProductDataToFile(String filename, DefaultTableModel model){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < model.getColumnCount(); j++) {
                    if(model.getValueAt(i, j) != null){
                        if(j==0){
                    row.append("Product: "+ model.getValueAt(i, j));
                        row.append("\n");
                    }
                    if(j==1){
                    row.append("Category: "+ model.getValueAt(i, j));
                        row.append("\n");
                    }
                    if(j==2){
                    row.append("Price: "+ model.getValueAt(i, j));
                        row.append("\n");
                    }
                    }
                    
                    
                }
                writer.write(row.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

