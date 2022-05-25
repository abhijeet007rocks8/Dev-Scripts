package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Paytm extends JFrame
{   
    Paytm()
    {
        JEditorPane j = new JEditorPane();
        j.setEditable(false);
        
        try
        {
            j.setPage("https://paytm.com");
            
        }catch(Exception e)
        {
            
        }
        add(j);
        JScrollPane js = new JScrollPane(j);
        getContentPane().add(js);
        
        
        
        setBounds(650,250,800,600);
    }
    
    public static void main(String[] args)
    {
        new Paytm().setVisible(true);
    }
}
