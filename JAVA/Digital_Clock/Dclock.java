import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.*;
public class Dclock implements Runnable
{
    JFrame f;
    JButton b;
    JTextField t;
    Thread t1;
    String time="";
    Dclock()
    {
        f=new JFrame();
        t1=new Thread(this);
        t1.start();
        b=new JButton();
        b.setBounds(200,200,250,250);
        f.add(b);
        f.setSize(400,400);
        f.setVisible(true);
    }
    public void run()
    {
        try
        {
           while(true)
           {
               Calendar cal=Calendar.getInstance();
               SimpleDateFormat fr=new SimpleDateFormat("hh:mm:ss");
               Date t=cal.getTime();
               time=fr.format(t);
               printTime();
               t1.sleep(1000);
           }
       }
       catch(Exception e)
       {
       }
}
       public void printTime()
       {
            b.setText(time);
       }
       public static void main(String []args)
       {
            new Dclock();
       }

 }           