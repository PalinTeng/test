package test5;
import java.io.*;
import java.net.*;

public class CurrencyServer
{
  public static void main(String[] args)
  {
    try
    {
      ServerSocket serverSocket = new ServerSocket(8006);
      System.out.println("������������...");
      Socket connection = serverSocket.accept();

      DataInputStream dataInput = new DataInputStream(
        connection.getInputStream());

      DataOutputStream dataOutput = new DataOutputStream(
        connection.getOutputStream());
      Boolean c=true;
      String s="true";
      while (c)
      {
        double dollar = dataInput.readDouble();
        if(dollar==100) {c=false;s="false";}
        System.out.println("�ͻ�Ҫת������Ԫ: " + dollar);
        
        double RMB = (dollar * 8.27);

        dataOutput.writeDouble(RMB);
        dataOutput.writeUTF(s);
        dataOutput.flush();

        System.out.println("�����: " + RMB);
      }
   
    dataOutput.close();
    dataInput.close();
    connection.close();
    }
    catch(IOException ex)
    {
      System.err.println(ex);
    }
  }
}