package travel.management.system;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Dashboard extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
    String username;
    Dashboard(String username)
    {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);                            //to get the frame in full size i.e. fit to screen
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBounds(0,0,1950,65);
        p1.setBackground(new Color(0,0,100));
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/dashboard3.jpg"));
        Image i5 = i4.getImage().getScaledInstance(70 , 70 , Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        
        JLabel l2 = new JLabel(i6);
        l2.setBounds(5,0,70,70);
        p1.add(l2);
        
        JLabel l3 = new JLabel("DASHBOARD");
        l3.setFont(new Font("Tahoma",Font.BOLD,30));
        l3.setForeground(Color.WHITE);
        l3.setBounds(80,10,300,40);
        p1.add(l3);
       
        
        JPanel p2 = new JPanel();
        p2.setBounds(0,65,300,1000);
        p2.setBackground(new Color(0,0,100));
        p2.setLayout(null);
        add(p2);
        
        
        b1 = new JButton("Add Personal Details");
        b1.setBackground(new Color(0,0,100));
        b1.setFont(new Font("Tahoma",Font.PLAIN,21));
        b1.setForeground(Color.WHITE);
        b1.setBounds(0,0,300,50);
        b1.addActionListener(this);
        p2.add(b1);
        
        
        b2 = new JButton("View Personal Details");
        b2.setBackground(new Color(0,0,100));
        b2.setFont(new Font("Tahoma",Font.PLAIN,21));
        b2.setForeground(Color.WHITE);
        b2.setBounds(0,50,300,50);
        b2.addActionListener(this);
        p2.add(b2);
        
        
        b3 = new JButton("Check Package");
        b3.setBackground(new Color(0,0,100));
        b3.setFont(new Font("Tahoma",Font.PLAIN,21));
        b3.setForeground(Color.WHITE);
        b3.setBounds(0,100,300,50);
        b3.addActionListener(this);
        p2.add(b3);
        
        
        b4 = new JButton("Book Package");
        b4.setBackground(new Color(0,0,100));
        b4.setFont(new Font("Tahoma",Font.PLAIN,21));
        b4.setForeground(Color.WHITE);
        b4.setBounds(0,150,300,50);
        b4.addActionListener(this);
        p2.add(b4);
        
        b5 = new JButton("View Package");
        b5.setBackground(new Color(0,0,100));
        b5.setFont(new Font("Tahoma",Font.PLAIN,21));
        b5.setForeground(Color.WHITE);
        b5.setBounds(0,200,300,50);
        b5.addActionListener(this);
        p2.add(b5);
        
        b6 = new JButton("Book Hotels");
        b6.setBackground(new Color(0,0,100));
        b6.setFont(new Font("Tahoma",Font.PLAIN,21));
        b6.setForeground(Color.WHITE);
        b6.setBounds(0,250,300,50);
        b6.addActionListener(this);
        p2.add(b6);
        
        b7 = new JButton("View Booked Hotel");
        b7.setBackground(new Color(0,0,100));
        b7.setFont(new Font("Tahoma",Font.PLAIN,21));
        b7.setForeground(Color.WHITE);
        b7.setBounds(0,300,300,50);
        b7.addActionListener(this);
        p2.add(b7);
        
        
        b8 = new JButton("Payment");
        b8.setBackground(new Color(0,0,100));
        b8.setFont(new Font("Tahoma",Font.PLAIN,21));
        b8.setForeground(Color.WHITE);
        b8.setBounds(0,350,300,50);
        b8.addActionListener(this);
        p2.add(b8);
        
        b9 = new JButton("Calculator");
        b9.setBackground(new Color(0,0,100));
        b9.setFont(new Font("Tahoma",Font.PLAIN,21));
        b9.setForeground(Color.WHITE);
        b9.setBounds(0,400,300,50);
        b9.addActionListener(this);
        p2.add(b9);
        
        
        b10 = new JButton("NotePad");
        b10.setBackground(new Color(0,0,100));
        b10.setFont(new Font("Tahoma",Font.PLAIN,21));
        b10.setForeground(Color.WHITE);
        b10.setBounds(0,450,300,50);
        b10.addActionListener(this);
        p2.add(b10);
        
        
        b11 = new JButton("About");
        b11.setBackground(new Color(0,0,100));
        b11.setFont(new Font("Tahoma",Font.PLAIN,21));
        b11.setForeground(Color.WHITE);
        b11.setBounds(0,500,300,50);
        b11.addActionListener(this);
        p2.add(b11);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1950,1000);
        add(l1);
        
        JLabel l4 = new JLabel("TRAVEL & TOUR MANAGEMENT");
        l4.setBounds(600,100,1000,70);
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Tahoma",Font.PLAIN,60));
        l1.add(l4);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            new AddCustomer().setVisible(true);
        }
        else if(ae.getSource() == b2)
        {
            new ViewCustomer(username).setVisible(true);
        }
        else if(ae.getSource() == b3)
        {
            new CheckPackage().setVisible(true);
        }
        else if(ae.getSource() == b4)
        {
            new BookPackage(username).setVisible(true);
        }
        else if(ae.getSource() == b5)
        {
            new ViewPackage(username).setVisible(true);
        }
        else if(ae.getSource() == b6)
        {
            new BookHotel(username).setVisible(true);
        }
        else if(ae.getSource() == b7)
        {
            new ViewBookedHotel(username).setVisible(true);
        }
        else if(ae.getSource() == b11)
        {
            new About().setVisible(true);
        }
        else if(ae.getSource() == b8)
        {
            new Payment().setVisible(true);    
        }
        else if(ae.getSource() == b9)
        {
            try
            {
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception e)
            {
                
            }
        }
        else if(ae.getSource() == b10)
        {
            try
            {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception e)
            {
                
            }
        }
        
    }
    
    public static void main(String[] args)
    {
        new Dashboard("").setVisible(true);
    }
}
