package test5;
import java.io.*;
import java.net.*;
import java.util.*;


public class CurrencyClient
{
  static Scanner scanner = new Scanner(System.in);
  public static void main(String[] args)
  {
    try
    {
      Socket connection = new Socket("localhost", 8010);

      DataInputStream dataInput = new DataInputStream(
        connection.getInputStream());

      DataOutputStream dataOutput =
        new DataOutputStream(connection.getOutputStream());
      Boolean c=true;
      while (c)
      {

        System.out.print("请输入美元: ");
      int dollar = scanner.nextInt();
        if(dollar==0) c=false;  
        dataOutput.writeDouble(dollar);
        dataOutput.flush();

        double RMB = dataInput.readDouble();
        String s = dataInput.readUTF();
        System.out.println("服务器返回人民币: " + RMB );
        System.out.println("服务器是否运行: " + s );
        
      }
      dataOutput.close();
      dataInput.close();
      connection.close();
    }
    catch (IOException ex)
    {
      System.err.println(ex);
    }
  }
}
