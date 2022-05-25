package travel.management.system;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BookPackage extends JFrame implements ActionListener
{
    Choice c1;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l11,l12,l13,l14,l15;
    JTextField t1;
    JButton b1,b2,b3;
    
    BookPackage(String  username)
    {
        
        setBounds(500,230,1050,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel l10 = new JLabel(i3);
        l10.setBounds(500,55,500,300);
        add(l10);
       
        
        l1 = new JLabel("BOOK PACKAGE");
        l1.setBounds(110,10,200,30);
        l1.setFont(new Font("Yu Mincho",Font.BOLD,22));
        add(l1);
        
        l2 = new JLabel("Username:");
        l2.setBounds(40,70,100,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l2);
        
        l11 = new JLabel();
        l11.setBounds(250,70,200,30);
        l11.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l11);
        
        l3 = new JLabel("Select Package:");
        l3.setBounds(40,110,150,30);
        l3.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l3);
        
        c1 = new Choice();
        c1.add("Gold Package");
        c1.add("Silver Package");
        c1.add("Bronze Package");
        c1.setBounds(250,110,200,30);
        c1.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(c1);
        
        l4 = new JLabel("Total Persons:");
        l4.setBounds(40,150,150,30);
        l4.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l4);
        
        t1 = new JTextField("1");
        t1.setBounds(250,150,200,25);
        add(t1);
        
        l5 = new JLabel("ID:");
        l5.setBounds(40,190,100,30);
        l5.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l5);
        
        l12 = new JLabel();
        l12.setBounds(250,190,100,30);
        l12.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l12);
        
        l6 = new JLabel("Number:");
        l6.setBounds(40,230,200,30);
        l6.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l6);
        
        l13 = new JLabel();
        l13.setBounds(250,230,100,30);
        l13.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l13);
        
        l7 = new JLabel("Phone:");
        l7.setBounds(40,270,200,30);
        l7.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l7);
        
        l14 = new JLabel();
        l14.setBounds(250,270,100,30);
        l14.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l14);
        
        l8 = new JLabel("Total Price:");
        l8.setBounds(40,310,200,30);
        l8.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l8);
        
        l15 = new JLabel();
        l15.setBounds(250,310,100,30);
        l15.setForeground(Color.red);
        l15.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(l15);
        
        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next())
            {
                l11.setText(rs.getString("username"));
                l12.setText(rs.getString("id"));
                l13.setText(rs.getString("number"));
                l14.setText(rs.getString("phone"));
            }
            
        }catch(Exception e)
        {
            
        }
        
        b1 = new JButton("Check Price");
        b1.setBackground(new Color(135,195,235));
        b1.setForeground(Color.BLACK);
        b1.setBounds(60,380,130,25);
        b1.setFont(new Font("Tahoma",Font.PLAIN,17));
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Book Package");
        b2.setBackground(new Color(135,195,235));
        b2.setForeground(Color.BLACK);
        b2.setBounds(200,380,140,25);
        b2.setFont(new Font("Tahoma",Font.PLAIN,17));
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("BACK");
        b3.setBackground(new Color(135,195,235));
        b3.setForeground(Color.BLACK);
        b3.setBounds(350,380,110,25);
        b3.setFont(new Font("Tahoma",Font.PLAIN,17));
        b3.addActionListener(this);
        add(b3);
      
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            String p = c1.getSelectedItem();
            int cost = 0;
            
            if(p.equals("Gold Package"))
                cost = cost + 12000;
            else if(p.equals("Silver Package"))
                cost = cost + 24000;
            else if(p.equals("Bronze Package"))
                cost = cost + 32000;
            
            int persons = Integer.parseInt(t1.getText());
            
            cost*= persons;
            
            l15.setText("Rs = "+cost);
            
        }
        else if(ae.getSource() == b2)
        {
            try
            {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookPackage values('"+l11.getText()+"','"+c1.getSelectedItem()+"','"+t1.getText()+"','"+l12.getText()+"','"+l13.getText()+"','"+l14.getText()+"','"+l15.getText()+"')");
                
                JOptionPane.showMessageDialog(null,"Package Booked Successfully!");
                this.setVisible(false);
                
            }catch(Exception e)
            {
                
            }
        }
        else if(ae.getSource() == b3)
        {
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new BookPackage("").setVisible(true);
    }
}
