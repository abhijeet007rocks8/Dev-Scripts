import java.io.InputStream;
import java.util.Scanner;

public class Tracert
{
  public static void runSystemCommand(String command)
  {
       try
       {
           Process p = Runtime.getRuntime().exec(command);
           InputStream stream = p.getInputStream();
           Scanner inputStream= new Scanner(stream);

           String s = "";
           while ((s = inputStream.nextLine()) != null)
                System.out.println(s);
       }
       catch (Exception e)
       {
       }
  }

  public static void main(String[] args)
  {  
	  Scanner sc=new Scanner(System.in);
	  String ip= sc.next();
       runSystemCommand("tracert " + ip);
  }
}
