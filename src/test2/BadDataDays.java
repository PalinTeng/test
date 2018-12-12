package test2;
import java.awt.*;                // Container, GridLayout
import java.awt.event.*;          // ActionListener
import javax.swing.*;

public class BadDataDays extends JFrame implements ActionListener
  {
    private JTextField dayNumberField, dayNameField;
    private int dayNumber;
    private String dayName;
   
    public BadDataDays()
    {
      super( " 代码1  " );
     
      Container container = getContentPane();
      container.setLayout( new GridLayout( 2 , 2 ) );

     
      container.add(
          new JLabel( "输入数字 ", SwingConstants.RIGHT ) );
      dayNumberField = new JTextField( 10 );
      container.add(dayNumberField);
     
      dayNumberField.addActionListener( this );

      
      container.add(new JLabel( "星期几 ", SwingConstants.RIGHT ) );
      dayNameField = new JTextField( 10 );
      container.add( dayNameField );

      setSize(425,100);
      setVisible( true );
    }  
    
    public void actionPerformed( ActionEvent event )
    {
      dayNameField.setText( "" ); 
      
        try
         {
          dayNumber = Integer.parseInt( dayNumberField.getText() );
          dayName = getDayName(dayNumber);
          dayNameField.setText(dayName);
         }
          catch (BadDataException ex)
         {
             JOptionPane.showMessageDialog(
            BadDataDays.this, ex.toString(), "无效日期", JOptionPane.WARNING_MESSAGE );
         }
         catch (NumberFormatException ex)
         {
           System.out.println("I detected Exception " + ex.toString());                               
         } 
    }  

    public String getDayName(int dayNumber) throws BadDataException
    {

    switch(dayNumber) {
    	case 1:return "星期一";
    	case 2:return "星期二";
    	case 3:return "星期三";
    	case 4:return "星期四";
    	case 5:return "星期五";
    	case 6:return "星期六";
    	case 7:return "星期日";
    	default: throw new BadDataException();
    }
    	
    	
       
    } 

    public static void main( String args[] )
    {
      BadDataDays  application = new BadDataDays();
      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
}