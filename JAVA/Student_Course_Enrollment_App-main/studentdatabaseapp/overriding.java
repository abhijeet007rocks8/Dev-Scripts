package studentdatabaseapp;

// Overriding method
public class overriding{
   public void myMethod()
   {
	System.out.println("***************************************************");
   }	   
}

//Inheritance
class Demo extends overriding{
   public void myMethod(){
	//Super keyword
	super.myMethod();
   }
}