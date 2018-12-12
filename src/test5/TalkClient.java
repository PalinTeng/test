package test5;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TalkClient extends JFrame {
   private JLabel enterLabel;
   private JTextField enterField;
   private JPanel myPanel;
   private JTextArea displayArea;
   private ObjectOutputStream output;
   private ObjectInputStream input;
   private String message = "";
   private String chatServer;
   private Socket client;


   public TalkClient( String host )
   {
      super( "�ͻ���" );

      chatServer = host;

      Container container = getContentPane();

      myPanel = new JPanel();
      myPanel.setLayout(new FlowLayout());
      enterLabel = new JLabel("����");
      enterField = new JTextField( 20 );
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

   private void runClient()
   {
      try {
         connectServer();
         getStream();
         communication();
      }

      catch ( EOFException eofException ) {
         System.err.println( "�ͻ��˹ر�������" );
      }

      catch ( IOException ioException ) {
         ioException.printStackTrace();
      }

      finally {
         closeConnection();
      }
   }

   private void connectServer() throws IOException
   {
      displayMessage( "���ڳ�������...\n" );

      client = new Socket( InetAddress.getByName( chatServer ), 19999 );

      displayMessage( "�����ӵ�: " +
         client.getInetAddress().getHostName() + "\n" );
   }
   private void getStream() throws IOException
   {

      output = new ObjectOutputStream( client.getOutputStream() );
      output.flush();

      input = new ObjectInputStream( client.getInputStream() );

   }

   private void communication() throws IOException
   {

      setTextFieldEditable( true );
      do {
         try {
            message = ( String ) input.readObject();
            displayMessage( "\n" + message );
         }

         catch ( ClassNotFoundException classNotFoundException ) {
            displayMessage( "\n�յ��쳣��������" );
         }

      } while ( !message.equals( "��������>>> stop" ) );

   }

   private void closeConnection()
   {
      displayMessage( "\n�ر�����" );
      setTextFieldEditable( false );

      try {
         output.close();
         input.close();
         client.close();
      }
      catch( IOException ioException ) {
         ioException.printStackTrace();
      }
   }

   private void sendData( String message )
   {
      try {
         output.writeObject( "�ͻ���>>> " + message );
         output.flush();
         displayMessage( "\n�ͻ���>>> " + message );
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
      TalkClient application;

      if ( args.length == 0 )
         application = new TalkClient( "127.0.0.1" );
      else
         application = new TalkClient( args[ 0 ] );

      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      application.runClient();
   }
}
