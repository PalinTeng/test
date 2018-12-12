package test1;

import java.util.*;

public class CityVector {
   static String city[] = { "北京", "上海", "广州", "深圳" };

   public CityVector( )
   {
      Vector vector = new Vector(6);
	  Scanner scanner = new Scanner(System.in);
	  String cityName;
	  int    index;

	  for ( int i = 0; i < city.length; i++ ) {
         vector.add( city[i] );
	  };
      // 显示出数组信息
      displayVector(vector); 

      System.out.print("\n请输入数组索引号: ");
	  index = scanner.nextInt( );
	  cityName = (String)vector.get(index);
      System.out.println("数组["+index+"]的元素值是: "+cityName);
      
      System.out.print("\n请再输入3个你喜欢的城市: ");
      
      for ( int i = 0; i < 3; i++ ) {           
	 
         cityName = scanner.next();
         vector.add(cityName);  	
	  }
      
      displayVector(vector);       
      
      System.out.print("\n请输入一个你想查询的城市名: ");
      cityName = scanner.next( );

      if ( vector.contains(cityName) )
         System.out.println( "在数组中找到: "+cityName+" 下标是:" + vector.indexOf(cityName));
      else
         System.out.println( "在数组中没有找到: "+cityName );

      System.out.print("\n请输入一个你想删除的城市名: ");
	  
      cityName = scanner.next( );
      vector.remove(cityName);
      System.out.println(cityName + " 已被删除");      
      displayVector(vector);     
   }
   
   public void displayVector( Vector vector )
   {
      System.out.println( "\n数组大小: " + vector.size() + 
         "\n数组容量: " + vector.capacity() );
	  
	  if ( vector.isEmpty() ) 
         System.out.print( "数组为空" ); 
      
      else { 
         System.out.print( "数组包含: " );      
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