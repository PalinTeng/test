package test5;

	import java.io.*;
	import java.net.*;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import javax.swing.border.*;

	public class MessengerClient extends JFrame implements Runnable {

	   private JTextArea messageArea;
	   private JTextArea inputArea;

	   private JButton connectButton;
	   private JButton disconnectButton;
	   private JButton sendButton;
	   private JLabel statusBar;

	   private String userName;
	   private String chatServer;
	   private ObjectOutputStream output;
	   private ObjectInputStream  input;

	   private Socket   client;
	   private boolean  connected;
	   private Thread   processConnection;

	   public MessengerClient(String host )
	   {
	      super( "聊天客户端" );
	      chatServer = host;

	      connectButton = new JButton( "登陆" );
	      connectButton.setEnabled( true );
	      ActionListener connectListener = new ConnectListener();
	      connectButton.addActionListener( connectListener ); //创建登录按钮并设置事件侦听器

	      disconnectButton = new JButton( "退出" );
	      disconnectButton.setEnabled( false );
	      ActionListener disconnectListener = new DisconnectListener();
	      disconnectButton.addActionListener( disconnectListener );

	      messageArea = new JTextArea();
	      messageArea.setEditable( false );
	      messageArea.setWrapStyleWord( true );
	      messageArea.setLineWrap( true );

	      JPanel messagePanel = new JPanel();
	      messagePanel.setLayout( new BorderLayout( 10, 10 ) );
	      messagePanel.add( new JScrollPane( messageArea ),BorderLayout.CENTER );

	      inputArea = new JTextArea( 4, 20 );
	      inputArea.setWrapStyleWord( true );
	      inputArea.setLineWrap( true );
	      inputArea.setEditable( false );

	      sendButton = new JButton( "发送" );
	      sendButton.setEnabled( false );
	      sendButton.addActionListener(

	         new ActionListener() {

	            public void actionPerformed( ActionEvent event )
	            {
	               sendMessage( userName + ">" + inputArea.getText());
	               inputArea.setText("");
	            }
	         }
	      );

	      JPanel buttonPanel = new JPanel();
	      buttonPanel.setLayout(new GridLayout(3, 1));
	      buttonPanel.add( sendButton );
	      buttonPanel.add( connectButton );
	      buttonPanel.add( disconnectButton );

	      Box box = new Box( BoxLayout.X_AXIS );
	      box.add( new JScrollPane( inputArea ));
	      box.add( buttonPanel );

	      messagePanel.add( box, BorderLayout.SOUTH );

	      statusBar = new JLabel( "离线" );
	      statusBar.setBorder( new BevelBorder( BevelBorder.LOWERED ) );

	      Container container = getContentPane();

	      container.add( messagePanel, BorderLayout.CENTER );
	      container.add( statusBar, BorderLayout.SOUTH );

	      addWindowListener (

	         new WindowAdapter () {

	            public void windowClosing ( WindowEvent event )
	            {
	               if (connected) {
	                  sendMessage("DISCONNECT");
	                  do {
	                } while (connected);
	                }
	               System.exit( 0 );
	            }
	         }
	      );
	   }

	   private void sendMessage( String message )
	   {
	      try {
	         output.writeObject(message); // 发送message到output对象
	         output.flush();
	       }

	      catch ( IOException ioException ) {
	         ioException.printStackTrace();
	      }
	   }

	   public void run() {

	        String message = "";
	        do {
	         try {
	            message = ( String ) input.readObject();
	         }

	         catch ( ClassNotFoundException classNotFoundException ) {
	            displayMessage( "\n收到异常对象类型" );
	         }

	         catch ( EOFException eofException ) {
	            System.err.println( "连接终止" );
	         }

	         catch ( IOException ioException ) {
	            ioException.printStackTrace();
	         }
	         if (message.equals("DISCONNECT")) {

	            try {
	                 output.close();
	                 input.close();// 关闭输入输出流
	                 client.close();
	              }
	            catch( IOException ioException ) {
	                ioException.printStackTrace();
	            }
	                connected = false;}
	         else  displayMessage( message + "\n" );

	      } while ( connected );
	   }

	   private class ConnectListener implements ActionListener {

	      public void actionPerformed( ActionEvent event )
	      {
	         try {

	            client = new Socket( chatServer , 8011 );
	            output = new ObjectOutputStream( client.getOutputStream() );
	            output.flush();
	            input = new ObjectInputStream(client.getInputStream()); //创建对象输入流
	         }

	      catch ( IOException ioException ) {
	         ioException.printStackTrace();
	       }

	        userName = JOptionPane.showInputDialog( "请输入你的内容:"); //使用JOptionPane弹出输入对话框

	         messageArea.setText( "" );
	         connectButton.setEnabled( false );
	         disconnectButton.setEnabled( true );

	         sendButton.setEnabled( true );
	         inputArea.setEditable( true );
	         inputArea.requestFocus();
	         statusBar.setText( "在线: " + userName );
	         connected = true;

	         processConnection = new Thread ( MessengerClient.this );
	         processConnection.start();
	      }
	   }

	   private class DisconnectListener implements ActionListener {

	      public void actionPerformed( ActionEvent event )
	      {
	         sendMessage("DISCONNECT");

	         sendButton.setEnabled( false );
	         disconnectButton.setEnabled( false );

	         inputArea.setEditable( false );
	         connectButton.setEnabled( true );

	         statusBar.setText( "离线" );
	      }
	   }

	   private void displayMessage( final String messageToDisplay )
	   {
	      SwingUtilities.invokeLater(
	         new Runnable() {
	            public void run()
	            {
	               messageArea.append( messageToDisplay );
	               messageArea.setCaretPosition(
	                  messageArea.getText().length() );
	            }
	         }
	      );
	   }

	   public static void main( String args[] )
	   {
	      MessengerClient application;

	      if ( args.length == 0 )
	         application = new MessengerClient( "127.0.0.1" );
	      else
	         application = new MessengerClient( args[ 0 ] );

	      application.setSize( 300, 400 );
	      application.setResizable( false );
	      application.setVisible( true );
	   }

	}
