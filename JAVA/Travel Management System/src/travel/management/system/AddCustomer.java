package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener
{
    
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    JComboBox c1;
    JRadioButton r1,r2;
    JButton b1,b2;
    
    AddCustomer()
    {
        setBounds(600,250,850,580);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(30,20,150,25);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l1);
        
        t1 = new JTextField();
        t1.setBounds(220,20,150,25);
        add(t1);
        
        JLabel l2 = new JLabel("ID : ");
        l2.setBounds(30,70,150,25);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l2);
        
        c1 = new JComboBox(new String[] {"Passport" , "Aadhar Card" , "Pan Card" , "Voter ID"});
        c1.setBounds(220,70,150,25);
        add(c1);
        
        
        JLabel l3 = new JLabel("ID Number : ");
        l3.setBounds(30,120,150,25);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l3);
        
        t2 = new JTextField();
        t2.setBounds(220,120,150,25);
        add(t2);
        
        
        JLabel l4 = new JLabel("Name : ");
        l4.setBounds(30,170,150,25);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l4);
        
        t3 = new JTextField();
        t3.setBounds(220,170,150,25);
        add(t3);
        
        
        JLabel l5 = new JLabel("Gender : ");
        l5.setBounds(30,220,150,25);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l5);
        
        r1 = new JRadioButton("Male");
        r1.setBounds(220,220,70,25);
        r1.setBackground(Color.WHITE);
        r1.setForeground(Color.BLACK);
        r1.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(r1);
        r2 = new JRadioButton("Female");
        r2.setBounds(300,220,150,25);
        r2.setForeground(Color.BLACK);
        r2.setFont(new Font("Tahoma",Font.PLAIN,15));
        r2.setBackground(Color.WHITE);
        add(r2);
        
        JLabel l6 = new JLabel("Country : ");
        l6.setBounds(30,270,150,25);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l6);
        
        t4 = new JTextField();
        t4.setBounds(220,270,150,25);
        add(t4);
        
        
        JLabel l7 = new JLabel("Address : ");
        l7.setBounds(30,320,150,25);
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l7);
        
        t5 = new JTextField();
        t5.setBounds(220,320,150,25);
        add(t5);
        
        JLabel l8 = new JLabel("Phone : ");
        l8.setBounds(30,370,150,25);
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l8);
        
        t6 = new JTextField();
        t6.setBounds(220,370,150,25);
        add(t6);
        
        
        JLabel l9 = new JLabel("Email : ");
        l9.setBounds(30,420,150,25);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Tahoma",Font.BOLD,15));
        add(l9);
        
        t7 = new JTextField();
        t7.setBounds(220,420,150,25);
        add(t7);
        
        
        b1 = new JButton("ADD");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(70,470,100,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("BACK");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(220,470,100,30);
        b2.addActionListener(this);
        add(b2);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450 , 550 ,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(420,50,400,400);
        add(l10);
        
        // -----------------------------------
        this.setVisible(true);            
// ------------------------------------------------
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            String username = t1.getText();
            String id = (String)c1.getSelectedItem();
            String number = t2.getText();
            String name = t2.getText();
            String radio = null;
            if(r1.isSelected())
            {
                radio = "Male";
            }
            else if(r2.isSelected())
            {
                radio = "Female";
            }
            String country = t4.getText();
            String address = t5.getText();
            String phone = t6.getText();
            String email = t7.getText();

            String q = "insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+radio+"','"+country+"','"+address+"','"+phone+"','"+email+"')";

            try
            {
               Conn c = new Conn();
               c.s.executeUpdate(q);

               JOptionPane.showMessageDialog(null,"Customer Details Added !");
               this.setVisible(false);
            }catch(Exception e)
            {

            }

        }
        
        else if(ae.getSource() == b2)
        {
            this.setVisible(false);
            
        }
    }  
    
    public static void main(String[] args)
    {
        new AddCustomer().setVisible(true);
    }
    
}
