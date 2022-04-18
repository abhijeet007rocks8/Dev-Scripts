package CriminalManagementSystem;

import java.sql.*;  
class SQLConnection
{  
	public static void main(String args[])
	{  
		try{  
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CriminalApplication","root","");  
            System.out.println("Connection Successfull"); 
          }
		catch(Exception e)
		{ 
			System.out.println(e); 
		}  
	}  
}  
