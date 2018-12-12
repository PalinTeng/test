package test5;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

public class WebBrowser extends JFrame {
   private JLabel enterLabel;
   private JTextField enterField;
   private JPanel myPanel;
   private JEditorPane contentsArea;

   public WebBrowser()
   {
      super("浏览器"); //调用父类构造函数
      Container container = getContentPane();

      myPanel = new JPanel();
      myPanel.setLayout(new FlowLayout());
      enterLabel = new JLabel("地址(D)");

      enterField=new JTextField(100);  //创建JTextField对象enterField 
      enterField.addActionListener(
         new ActionListener() {

            public void actionPerformed( ActionEvent event )
            {
               getThePage( event.getActionCommand() );
            }
         }

      );

      myPanel.add(enterLabel);
      myPanel.add(enterField);
      container.add( myPanel, BorderLayout.NORTH);

      contentsArea = new JEditorPane();
      contentsArea.setEditable( false );
      contentsArea.addHyperlinkListener(
         new HyperlinkListener() {

            public void hyperlinkUpdate( HyperlinkEvent event )
            {
               if ( event.getEventType() ==
                    HyperlinkEvent.EventType.ACTIVATED )
                  getThePage( event.getURL().toString() );
            }
         }
      );

      container.add( new JScrollPane( contentsArea ),
         BorderLayout.CENTER );
      setSize( 400, 300 );
      setVisible( true );

   }

   private void getThePage( String location )
   {

      try {
         contentsArea.setPage( location );
         enterField.setText( location );
      }
      catch ( IOException ioException ) {
         JOptionPane.showMessageDialog( this,
            "获取指定URL错误", "非法URL",
            JOptionPane.ERROR_MESSAGE );
      }

   }

   public static void main( String args[] )
   {
	   WebBrowser application = new WebBrowser();  //创建WebBrowser应用程序对象application
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

}
