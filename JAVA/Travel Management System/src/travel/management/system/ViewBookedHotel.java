package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener
{
    JButton b1,b2,b3;
    
    ViewBookedHotel(String username)
    {
        setBounds(550,250,1000,540);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l110 = new JLabel(i3);
        l110.setBounds(450,30,500,400);
        add(l110);
        
        JLabel heading = new JLabel("VIEW HOTEL DETAILS");
        heading.setBounds(80,0,300,25);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Yu Mincho",Font.BOLD,21));
        add(heading);
        
        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(30,50,100,30);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l1);
        
        JLabel l11 = new JLabel();
        l11.setBounds(250,50,100,30);
        l11.setForeground(Color.BLACK);
        l11.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l11);
        
        JLabel l2 = new JLabel("Hotel : ");
        l2.setBounds(30,90,100,30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l2);
        
        JLabel l12 = new JLabel();
        l12.setBounds(250,90,100,30);
        l12.setForeground(Color.BLACK);
        l12.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l12);
        
        JLabel l3 = new JLabel("Total Persons : ");
        l3.setBounds(30,130,150,30);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l3);
        
        JLabel l13 = new JLabel();
        l13.setBounds(250,130,100,30);
        l13.setForeground(Color.BLACK);
        l13.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l13);
        
        JLabel l4 = new JLabel("Total Days : ");
        l4.setBounds(30,170,100,30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l4);
        
        JLabel l14 = new JLabel();
        l14.setBounds(250,170,100,30);
        l14.setForeground(Color.BLACK);
        l14.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l14);
        
        JLabel l5 = new JLabel("Swimming Pool : ");
        l5.setBounds(30,210,150,30);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l5);
        
        JLabel l15 = new JLabel();
        l15.setBounds(250,210,100,30);
        l15.setForeground(Color.BLACK);
        l15.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l15);
        
        JLabel l6 = new JLabel("Food Included : ");
        l6.setBounds(30,250,150,30);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l6);
        
        JLabel l16 = new JLabel();
        l16.setBounds(250,250,100,30);
        l16.setForeground(Color.BLACK);
        l16.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l16);
        
        JLabel l7 = new JLabel("ID : ");
        l7.setBounds(30,290,100,30);
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l7);
        
        JLabel l17 = new JLabel();
        l17.setBounds(250,290,100,30);
        l17.setForeground(Color.BLACK);
        l17.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l17);
        
        
        JLabel l8 = new JLabel("Number : ");
        l8.setBounds(30,330,100,30);
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l8);
        
        JLabel l18 = new JLabel();
        l18.setBounds(250,330,100,30);
        l18.setForeground(Color.BLACK);
        l18.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l18);
        
        JLabel l9 = new JLabel("Phone : ");
        l9.setBounds(30,370,100,30);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l9);
        
        JLabel l19 = new JLabel();
        l19.setBounds(250,370,100,30);
        l19.setForeground(Color.BLACK);
        l19.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l19);
        
        JLabel l10 = new JLabel("Total Cost : ");
        l10.setBounds(30,410,100,30);
        l10.setForeground(Color.BLACK);
        l10.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l10);
        
        JLabel l20 = new JLabel();
        l20.setBounds(250,410,100,30);
        l20.setForeground(Color.BLACK);
        l20.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(l20);
        
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bookhotel where username = '"+username+"'");
            while(rs.next())
            {
                l11.setText(rs.getString(1));
                l12.setText(rs.getString(2));
                l13.setText(rs.getString(3));
                l14.setText(rs.getString(4));
                l15.setText(rs.getString(5));
                l16.setText(rs.getString(6));
                l17.setText(rs.getString(7));
                l18.setText(rs.getString(8));
                l19.setText(rs.getString(9));
                l20.setText(rs.getString(10));
            }
        }catch (Exception e)
        {
            
        }
        
        b1 = new JButton("BACK");
        b1.setBackground(new Color(135,195,235));
        b1.setForeground(Color.BLACK);
        b1.setBounds(150,450,150,25);
        b1.setFont(new Font("Tahoma",Font.PLAIN,17));
        b1.addActionListener(this);
        add(b1);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        this.setVisible(false);
    }
    
    public static void main(String[] args)
    {
        new ViewBookedHotel("").setVisible(true);
    }
}