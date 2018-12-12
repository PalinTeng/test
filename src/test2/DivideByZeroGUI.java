package test2;
import java.awt.*;                // Container, GridLayout
import java.awt.event.*;          // ActionListener
import javax.swing.*;             // JFrame
import java.text.DecimalFormat;
public class DivideByZeroGUI extends JFrame
    implements ActionListener
{
  private JTextField numeratorField, denominatorField, outputField;
  private int denominator, numerator;


  
  public DivideByZeroGUI()
  {
    super( "除数为0异常" );

    
    Container container = getContentPane();
    container.setLayout( new GridLayout( 3, 2 ) );

    
    container.add(
        new JLabel( "输入被除数 ", SwingConstants.RIGHT ) );
    numeratorField = new JTextField( 10 );
    container.add( numeratorField );

    container.add(
        new JLabel( "输入除数并回车 ",
        SwingConstants.RIGHT ) );
    denominatorField = new JTextField( 10 );
    container.add( denominatorField );
    denominatorField.addActionListener( this );

    container.add(
        new JLabel( "结果 ", SwingConstants.RIGHT ) );
    outputField = new JTextField();
    container.add( outputField );

    setSize( 425, 100 );
    setVisible( true );
  }  

  
  public void actionPerformed( ActionEvent event )
  {
    outputField.setText( "" );    

    numerator = Integer.parseInt( numeratorField.getText() );
   try{denominator= Integer.parseInt( denominatorField.getText() );
  double quotient = quotient(  numerator, denominator );
   
    DecimalFormat precision = new DecimalFormat("0.0000");
    outputField.setText(precision.format(quotient));
  
   }catch (NumberFormatException ex) 
   {
	   System.out.print("I detected exception " + ex.toString());
	}
    
  }   

  public double quotient( int numerator, int denominator )throws ArithmeticException
  {if (denominator == 0) throw new ArithmeticException();
    return (double) numerator / denominator;
  }  

  public static void main( String args[] )
  {
    DivideByZeroGUI application = new DivideByZeroGUI();
    application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }  

}  
