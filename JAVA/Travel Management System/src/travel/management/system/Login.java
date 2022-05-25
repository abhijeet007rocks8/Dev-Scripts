package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener     //to implement actions when button is pressed,using ActionLister interface
{     
    JButton b1,b2,b3;
    JTextField t1;
    JPasswordField t2;
            
    Login()
    {
        setLayout(null);                                         //to specify swing that no predefined layout is to be selected
        
        getContentPane().setBackground(Color.WHITE);             //to set the background colour of the pane
        setBounds(500,300,900,400);
        
        JPanel p1 = new JPanel();                                 //used to create division inside the panel
        p1.setBounds(0,0,400,400);                                //to set the location and size of the division
        p1.setBackground(new Color (130,192,232));
        p1.setLayout(null);
        add(p1);                                                  //frame added to the panel
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);                               //creating label to add image as a label
        l1.setBounds(100,120,200,200);
        p1.add(l1);                                               //adding the  abel to the Frame
        
        JPanel p2 = new JPanel();                                 //adding the second label where the details is to written
        p2.setLayout(null);
        p2.setBounds(400,25,450,300);                           
        add(p2);       
                
        JLabel l2 = new JLabel("User Name");
        l2.setBounds(50,20,150,25);
        l2.setFont(new Font("SAN_SERIF",Font.PLAIN,21));
        p2.add(l2);
        
        t1 = new JTextField();
        t1.setBounds(50,50,300,30);
        p2.add(t1);
        
        JLabel l3 = new JLabel("Password");
        l3.setBounds(50,100,150,25);
        l3.setFont(new Font("SAN_SERIF",Font.PLAIN,21));
        p2.add(l3);
        
        t2= new JPasswordField();
        t2.setBounds(50,130,300,30);
        p2.add(t2);
        
        b1 = new JButton("Login");
        b1.setBounds(50,180,136,30);
        b1.setBackground(new Color(135,195,235));
        b1.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);                                         //reference of the current class
        p2.add(b1);
        
        b2 = new JButton("Sign Up");
        b2.setBounds(210,180,136,30);
        b2.setBackground(Color.WHITE);
        b2.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
        b2.setForeground(new Color(128,188,228));
        b2.addActionListener(this);                                         //reference of the current class
        p2.add(b2);
        
        b3 = new JButton("Forget Password?");
        b3.setBounds(90,230,180,30);
        b3.setBackground(Color.WHITE);
        b3.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);                                         //reference of the current class
        p2.add(b3);
        
        JLabel l4 = new JLabel("Trouble in Login");
        l4.setBounds(280,230,180,30);
        l4.setForeground(Color.RED);
        l4.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
        p2.add(l4);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)                                 //method overriding of Action Listener method
    {
        if(ae.getSource() == b1)                                                // getSource will return the button which is clicked
        {
           try
           {
               String username = t1.getText();
               String password = t2.getText();
               String sql = "select * from account where username = '"+username+"' AND password = '"+password+"'";
               
               Conn c = new Conn();
               
               ResultSet rs = c.s.executeQuery(sql);
               
               if(rs.next())
               {
                   this.setVisible(false);
                   new Dashboard(username).setVisible(true);
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"Invalid Login !");
               }
           }catch(Exception e)
           {
               
           }
        }
        
        else if(ae.getSource() == b2)
        {
            new Signup().setVisible(true);                                      //object of signup frame
            this.setVisible(false);                                             //to diable the current frame i.e. Login Frame
        }
        
        else if(ae.getSource() == b3)
        {
            this.setVisible(false);
            new ForgotPassword().setVisible(true);                                      //object of signup frame
        }
    }
    
    
    public static void main(String[] args)
    {
        new Login().setVisible(true);
        
    }


}
