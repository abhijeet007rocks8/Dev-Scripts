package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash 
{
    public static void main(String[] args)
    {
        SplashFrame frame = new SplashFrame();                              //object of the main frame
        frame.setVisible(true);
        
        int i,x=1;
        for(i=2 ; i <= 600 ; i+=10 , x += 7)
        {
            frame.setLocation(900 - ((i+x)/2), 500 - (i/2));                //location of the frame i.e. image (x,y)
            frame.setSize(i+x , i);                                         //for settin size of the frame
            try
            {
                Thread.sleep(8);
            }
            catch(Exception e){}
        }                 
        
    }
}

//frame is coded inside this class
class SplashFrame extends JFrame implements Runnable         //extends will make  the scope of Jframe in the whole class      
{
    Thread t1;
    //JFrame f = new JFrame();                //to add image in the main Frame
    
    SplashFrame()                             //constructor
    {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/icons/splash2.jpg")); 
        
        Image i2 = i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);           //for proper allignment of the image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);           //image is placed inside the label
        add(l1);                              //label is now added to the frame       
        
        setUndecorated(true);
      
        t1 = new Thread(this);
        t1.start();
        
    }          
    
    //ImageIcon class is used to work with images
    //ClassLoader is used to work with images inside hard-disk
    
    public void run()
    {
        try
        {
            Thread.sleep(5000);
            this.setVisible(false);
            
            Login l = new Login();
            l.setVisible(true);
           
        }catch(Exception e)
        {
            
        }
    }
}