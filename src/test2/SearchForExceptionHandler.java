package test2;

class MyException extends Throwable
{
  public MyException()
  {
    System.out.println("Exception thrown in MyException ");
  }
}

public class SearchForExceptionHandler
{
  static public void main(String[] args)
  {
    try
    {
      System.out.println("Method main called ");
    methodA();}
    catch(MyException ex)
    {
      System.out.println("Exception caught in Main ");
    }    finally {System.out.println("1 ");}
  }  //  end main

  static void methodA()  throws MyException
  {
    System.out.println("Method A called ");
    try { methodB();} 
    catch(MyException e) {
    	System.out.println("Exception caught in Main A");}  
   finally {System.out.println("2");}}

  static void methodB() throws MyException
  {
    System.out.println("Method B called ");
    methodC();
  }

  static void methodC() throws MyException
  {
    System.out.println("Method C called ");
    throw new MyException();
  }
}  