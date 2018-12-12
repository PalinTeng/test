package test1;

import java.util.*;

public class CityVector {
   static String city[] = { "����", "�Ϻ�", "����", "����" };

   public CityVector( )
   {
      Vector vector = new Vector(6);
	  Scanner scanner = new Scanner(System.in);
	  String cityName;
	  int    index;

	  for ( int i = 0; i < city.length; i++ ) {
         vector.add( city[i] );
	  };
      // ��ʾ��������Ϣ
      displayVector(vector); 

      System.out.print("\n����������������: ");
	  index = scanner.nextInt( );
	  cityName = (String)vector.get(index);
      System.out.println("����["+index+"]��Ԫ��ֵ��: "+cityName);
      
      System.out.print("\n��������3����ϲ���ĳ���: ");
      
      for ( int i = 0; i < 3; i++ ) {           
	 
         cityName = scanner.next();
         vector.add(cityName);  	
	  }
      
      displayVector(vector);       
      
      System.out.print("\n������һ�������ѯ�ĳ�����: ");
      cityName = scanner.next( );

      if ( vector.contains(cityName) )
         System.out.println( "���������ҵ�: "+cityName+" �±���:" + vector.indexOf(cityName));
      else
         System.out.println( "��������û���ҵ�: "+cityName );

      System.out.print("\n������һ������ɾ���ĳ�����: ");
	  
      cityName = scanner.next( );
      vector.remove(cityName);
      System.out.println(cityName + " �ѱ�ɾ��");      
      displayVector(vector);     
   }
   
   public void displayVector( Vector vector )
   {
      System.out.println( "\n�����С: " + vector.size() + 
         "\n��������: " + vector.capacity() );
	  
	  if ( vector.isEmpty() ) 
         System.out.print( "����Ϊ��" ); 
      
      else { 
         System.out.print( "�������: " );      
         Enumeration contents = vector.elements(); 

         while ( contents.hasMoreElements() )
            System.out.print( contents.nextElement() + " " );
      }
      
      System.out.println( "\n" ); 
   }
   public static void main( String args[] ) {

      CityVector application = new CityVector( ); 
   } 
} 