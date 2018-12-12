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
      super( " ����1  " );
     
      Container container = getContentPane();
      container.setLayout( new GridLayout( 2 , 2 ) );

     
      container.add(
          new JLabel( "�������� ", SwingConstants.RIGHT ) );
      dayNumberField = new JTextField( 10 );
      container.add(dayNumberField);
     
      dayNumberField.addActionListener( this );

      
      container.add(new JLabel( "���ڼ� ", SwingConstants.RIGHT ) );
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
            BadDataDays.this, ex.toString(), "��Ч����", JOptionPane.WARNING_MESSAGE );
         }
         catch (NumberFormatException ex)
         {
           System.out.println("I detected Exception " + ex.toString());                               
         } 
    }  

    public String getDayName(int dayNumber) throws BadDataException
    {

    switch(dayNumber) {
    	case 1:return "����һ";
    	case 2:return "���ڶ�";
    	case 3:return "������";
    	case 4:return "������";
    	case 5:return "������";
    	case 6:return "������";
    	case 7:return "������";
    	default: throw new BadDataException();
    }
    	
    	
       
    } 

    public static void main( String args[] )
    {
      BadDataDays  application = new BadDataDays();
      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
}