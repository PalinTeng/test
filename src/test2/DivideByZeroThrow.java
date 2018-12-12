package test2;
import java.text.DecimalFormat;
public class DivideByZeroThrow {

	  private int denominator, numerator;
	double quotient;
	  public DivideByZeroThrow()
	  {
	    denominator = 7 ; numerator =  12;
	    try 
	    {

	    quotient =  quotient(  numerator, denominator );
	    DecimalFormat precision = new DecimalFormat("0.0000");
	   
		OutputField.setText(precision.format(quotient));
	      System.out.print("Quotient is " + quotient);
	    }
	    catch(ArithmeticException ex)
	    {
	    System.out.print("I found exception " + ex.toString());
	    }

	    System.out.print("Quotient is " + quotient);
	  } 
	  public double quotient ( int numerator, int denominator )
	  {
	    return  (double) numerator / denominator;
	  }  
	  public static void main( String args[] )
	  {
		  DivideByZeroThrow application = new DivideByZeroThrow();
	  }  
	}

