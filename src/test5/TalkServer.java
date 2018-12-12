package test5;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TalkServer extends JFrame {

private JLabel enterLabel;
   private JTextField enterField;
   private JPanel myPanel;
   private JTextArea displayArea;
   private ObjectOutputStream output;
   private ObjectInputStream input;
   private ServerSocket server;
   private Socket connection;
   private int counter = 1;

   public TalkServer()
   {
      super( "��������" );

      Container container = getContentPane();

      myPanel = new JPanel();
      myPanel.setLayout(new FlowLayout());
      enterLabel = new JLabel("����");
      enterField = new JTextField(20);
      enterField.setEditable( false );
      enterField.addActionListener(
         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               sendData( event.getActionCommand() );
               enterField.setText( "" );
            }
         }
      );
      myPanel.add(enterLabel);
      myPanel.add(enterField);
      container.add( myPanel, BorderLayout.NORTH);

      displayArea = new JTextArea();
      container.add( new JScrollPane( displayArea ),
         BorderLayout.CENTER );

      setSize( 320, 180 );
      setVisible( true );

   }

   public void runServer()
   {

      try {
         server = new ServerSocket( 19999 );
         while ( true ) {

            try {
               listenConnection();
               getStream();
               communication();
            }

            catch ( EOFException eofException ) {
               System.err.println( "��������ֹ������" );
            }

            finally {
               closeConnection();
               ++counter;
            }

         }

      }


      catch ( IOException ioException ) {
         ioException.printStackTrace();
      }

   }


   private void listenConnection() throws IOException
   {
      displayMessage( "�������������ȴ�����...\n" );
      connection = server.accept();
      displayMessage( "�յ����� " + counter + " �� " +
         connection.getInetAddress().getHostName() + "\n" );
   }

   private void getStream() throws IOException
   {

      output = new ObjectOutputStream( connection.getOutputStream() );
      output.flush();
      input = new ObjectInputStream( connection.getInputStream() );

   }

   private void communication() throws IOException
   {

      String message = "���ӳɹ�!";
      sendData( message );

      setTextFieldEditable( true );

      do {

         try {
            message = ( String ) input.readObject();
            displayMessage( "\n" + message );
         }

         catch ( ClassNotFoundException classNotFoundException ) {
            displayMessage( "\n�յ��쳣��������" );
         }

      } while ( !message.equals( "�ͻ���>>> stop" ) );

   }

   private void closeConnection()
   {
      displayMessage( "\n��ֹ����\n" );
      setTextFieldEditable( false );

      try {
         output.close();
         input.close();
         connection.close();
      }
      catch( IOException ioException ) {
         ioException.printStackTrace();
      }
   }

   private void sendData( String message )
   {

      try {
         output.writeObject( "��������>>> " + message );
         output.flush();
         displayMessage( "\n��������>>> " + message );
      }

      catch ( IOException ioException ) {
         displayArea.append( "\n����д�����" );
      }
   }

   private void displayMessage( final String messageToDisplay )
   {

      SwingUtilities.invokeLater(
         new Runnable() {

            public void run()
            {
               displayArea.append( messageToDisplay );
               displayArea.setCaretPosition(
                  displayArea.getText().length() );
            }

         }

      );
   }

   private void setTextFieldEditable( final boolean editable )
   {

      SwingUtilities.invokeLater(
         new Runnable() {

            public void run()
            {
               enterField.setEditable( editable );
            }

         }

      );
   }

   public static void main( String args[] )
   {
      TalkServer application = new TalkServer();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      application.runServer();
   }

}