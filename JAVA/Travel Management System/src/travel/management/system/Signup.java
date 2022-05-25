package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener
{
    JButton b1,b2;
    JTextField t1,t2,t3,t4;
    Choice c1;
    
    Signup()
    {
        setBounds(500,300,900,400);                                     //frame layout
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p1 = new JPanel();                                       //create division (panel) in the frame 
        p1.setBackground(new Color(132,192,232));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel l1 = new JLabel("UserName");                             //creating username labe inside the left panel
        l1.setBounds(40,30,125,25);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        l1.setForeground(new Color(0,0,0));
        p1.add(l1);        
        
        t1 = new JTextField();
        t1.setBounds(190,30,180,25);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t1);
        
        JLabel l2 = new JLabel("Name");                                 
        l2.setBounds(40,80,125,25);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        l2.setForeground(new Color(0,0,0));
        p1.add(l2);        
        
        t2 = new JTextField();
        t2.setBounds(190,80,180,25);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t2);
        
        JLabel l3 = new JLabel("Password");                                 
        l3.setBounds(40,130,125,25);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setForeground(new Color(0,0,0));
        p1.add(l3);        
        
        t3 = new JTextField();
        t3.setBounds(190,130,180,25);
        t3.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t3);
        
        JLabel l4 = new JLabel("Security Question");                                 
        l4.setBounds(40,180,125,25);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        l4.setForeground(new Color(0,0,0));
        p1.add(l4); 
        
        c1 = new Choice();                                   //dropdown menu for security question using choice
        c1.add("Name of your Hometown?");
        c1.add("Name of your Best-friend?");
        c1.add("Your Nickname?");
        c1.add("Your Birth-year?");
        c1.setBounds(190,180,180,125);
        p1.add(c1);
        
        JLabel l5 = new JLabel("Answer");                                 
        l5.setBounds(40,230,125,25);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        l5.setForeground(new Color(0,0,0));
        p1.add(l5);        
        
        t4 = new JTextField();
        t4.setBounds(190,230,180,25);
        t4.setBorder(BorderFactory.createEmptyBorder());
        p1.add(t4);
        
        b1 = new JButton("Create");
        b1.setBounds(80,280,100,30);
        b1.setBackground(Color.WHITE);
        b1.setForeground(new Color(0,0,0));
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(240,280,100,30);
        b2.setBackground(Color.WHITE);
        b2.setForeground(new Color(0,0,0));
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(600,65,200,200);
        add(l6);
        
    }
    
    public void actionPerformed(ActionEvent ae)                                 //method overriding of ActionListener
    {
        if(ae.getSource() == b1)
        {
            String username = t1.getText();                                     //extract data inside textfield of button-1 (Username)
            String name = t2.getText();
            String password = t3.getText();
            String security = c1.getSelectedItem();                             //it is a choice button
            String answer = t4.getText();
            
            //inserting the queries into the table in the form of strings
            String query = "INSERT INTO account VALUES('"+username+"','"+name+"','"+password+"','"+security+"','"+answer+"');";
            
            try
            {
                Conn c = new Conn();
                
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"ACcount created successfully");
                
                this.setVisible(false);
                new Login().setVisible(true);
                
            }catch(Exception e)
            {
                
            }
            
        }
        else if(ae.getSource() == b2)
        {
            new Login().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new Signup().setVisible(true);
    }
}
