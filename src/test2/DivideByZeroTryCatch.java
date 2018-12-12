package test2;

public class DivideByZeroTryCatch {


	  private int denominator, numerator, quotient;
	  public DivideByZeroTryCatch()
	  {
	    denominator = 0; numerator =  12;
	    try 
	    {

	    quotient = quotient(  numerator, denominator );
	      System.out.print("Quotient is " + quotient);
	    }
	    catch(ArithmeticException ex)
	    {
	    System.out.print("I found exception " + ex.toString());
	    }

	    System.out.print("Quotient is " + quotient);
	  } 
	  public int quotient ( int numerator, int denominator )
	  {
	    return  numerator / denominator;
	  }  
	  public static void main( String args[] )
	  {
		  DivideByZeroTryCatch application = new DivideByZeroTryCatch();
	  }  
	}