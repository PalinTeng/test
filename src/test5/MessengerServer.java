package test5;

import java.util.*;
import java.net.*;
import java.io.*;

public class MessengerServer  {

   public void startServer()
   {

      try {

         ServerSocket serverSocket = new ServerSocket( 8011, 100 );
         System.out.println( "������������..." );

         while ( true ) {

            Socket clientSocket = serverSocket.accept();

            System.out.println( "�ѽ��յ��ͻ�����: " +
               clientSocket.getInetAddress() );

            ChatHandler handler = new ChatHandler (clientSocket);
            handler.start ();
            
         }
      }

      catch ( IOException ioException ) {
         ioException.printStackTrace();
      }
   }

   public static void main ( String args[] )
   {
     MessengerServer application = new MessengerServer();
     application.startServer();
   }
}
