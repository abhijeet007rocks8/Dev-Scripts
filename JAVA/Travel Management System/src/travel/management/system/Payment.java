package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener
{
    JButton b1,b2;
    
    Payment()
    {
        setBounds(630,250,800,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,800,600);
        add(l1);
        
        b1 = new JButton("PAY");
        b1.setBounds(320,0,80,40);
        b1.addActionListener(this);
        b1.setFont(new Font("Tahoma",Font.PLAIN,18));
        b1.setForeground(Color.BLACK);
        l1.add(b1);
        
        b2 = new JButton("BACK");
        b2.setBounds(420,0,80,40);
        b2.addActionListener(this);
        b2.setFont(new Font("Tahoma",Font.PLAIN,18));
        b2.setForeground(Color.BLACK);
        l1.add(b2);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            this.setVisible(false);
            new Paytm().setVisible(true);
        }
        else if(ae.getSource() == b2)
        {
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new Payment().setVisible(true);
    }
}

