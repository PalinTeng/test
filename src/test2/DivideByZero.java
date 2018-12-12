package test2;

public class DivideByZero
	{
	  private int denominator, numerator, quotient;
	  public DivideByZero()
	  {
	    denominator = 3; numerator =  12;
	    quotient = quotient(  numerator, denominator );

	    System.out.print("Quotient is " + quotient);
	  } 
	  public int quotient ( int numerator, int denominator )
	  {
	    return  numerator / denominator;
	  }  
	  public static void main( String args[] )
	  {
	    DivideByZero application = new DivideByZero();
	  }  
	}