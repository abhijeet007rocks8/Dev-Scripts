import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tracert
{
  public static void runSystemCommand(String command)
  {
       try
       {
           Process p = Runtime.getRuntime().exec(command);
          BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

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
       String ip = "www.google.co.in";
       runSystemCommand("tracert " + ip);
  }
}
