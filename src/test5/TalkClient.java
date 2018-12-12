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
      super( "客户端" );

      chatServer = host;

      Container container = getContentPane();

      myPanel = new JPanel();
      myPanel.setLayout(new FlowLayout());
      enterLabel = new JLabel("输入");
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
         System.err.println( "客户端关闭了连接" );
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
      displayMessage( "正在尝试连接...\n" );

      client = new Socket( InetAddress.getByName( chatServer ), 19999 );

      displayMessage( "已连接到: " +
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
            displayMessage( "\n收到异常对象类型" );
         }

      } while ( !message.equals( "服务器端>>> stop" ) );

   }

   private void closeConnection()
   {
      displayMessage( "\n关闭连接" );
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
         output.writeObject( "客户端>>> " + message );
         output.flush();
         displayMessage( "\n客户端>>> " + message );
      }

      catch ( IOException ioException ) {
         displayArea.append( "\n发生写入错误" );
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
