package test1;

class Circle {
	 static double pi = 3.14;
	   static int objectNo = 0;

	  
	   int    radius;   
	       Circle(int r) {
	      radius=r;
		  objectNo++;      
	    }
		  Circle( ) {
	      radius = 2;
		  objectNo++;      
	    }
	    double getArea( ) {
		         return pi*radius*radius;    
	    }
  void setPI(double p)  {
	          pi = p;     
	   }    
	     void setRadius(int r) {
		   radius = r;
	   }
	   static void displayNo( ) {
		   System.out.println("当前圆对象个数是: " + objectNo);
	   }
	}
	public class StaticTest {
	  public static void main( String args[] )
	   { double a=0;
	   Circle[]cirs=new Circle[5];
				for (int i=0;i<cirs.length;i++){
					cirs[i]=new Circle();
				}
	          Circle cir1 = new Circle(5);	
	      
	          System.out.println("cir1圆周率是: " + cir1.pi);
	     System.out.println("cir1的半径是: " + cir1.radius);
	     System.out.println("cir1的面积是: " + cir1.getArea());	 
	     cir1.displayNo();
	     cir1.setRadius(10);
		 	 Circle cir2 = new Circle( );
		 cir2.setPI(3.1415);
	     	 System.out.println("cir1圆周率是: " + cir1.pi);
	     System.out.println("cir1的半径是: " + cir1.radius);
	     System.out.println("cir2的半径是: " + cir2.radius);
		 System.out.println("cir2的面积是: " + cir2.getArea());
		 cir2.displayNo();
	   }
	}