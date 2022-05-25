package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener
{
    String s;
    JButton b1;
    
    About()
    {
        setBounds(730,250,500,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel ("Travel Management System");
        l1.setBounds(60,10,400,80);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Yu Mincho",Font.BOLD,25));
        add(l1);
        
        s = "This project is developed by Ankit Rao, student of CU (CSE_20BCS6862)."
                + ""
                + "The objective of the Travel and Tourism Management System project"
                + " is to develop a system that automates the processes "
                + "and activities of a travel and tourism agency. The purpose is to design a system using which one can perform "
                + "all operations related to traveling and sight-seeing. The system allows one to easily access the relevant"
                + " information and make necessary travel arrangements. "
                + "Users can decide about places they want to visit and make bookings "
                + "online for travel and accommodation.";
        
        TextArea t1 = new TextArea(s,10,40,Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setFont(new Font("Yu Mincho",Font.PLAIN,17));
        t1.setBounds(20,100,450,300);
        add(t1);
        
        b1 = new JButton("BACK");
        b1.setBackground(new Color(135,195,235));
        b1.setForeground(Color.BLACK);
        b1.setBounds(170,430,150,25);
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
        new About().setVisible(true);
    }
}
