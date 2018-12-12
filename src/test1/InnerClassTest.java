package test1;

class Outer {
	  
 int data[];
  Outer(int x[]) {
	 data = x;
  }

  void checkInner() {
	Inner innerObj = new Inner();
	innerObj.show();
    System.out.println("内部类计算的平均值: " + innerObj.average());
	  }

  void checkLocal() {
	  class Local {
         void show() {
	       System.out.print("从局部类显示数组元素:");
	       for (int i=0; i<data.length; i++ ) {
		      System.out.print(data[i]+" ");   
	       };
	       System.out.println("1231");
         }

         int average() {
           int sum=0;
	       for (int i=1; i<data.length; i++ ) {
		     sum += data[i];
	       };
	       return sum/data.length;
         }	     
	  };

	  Local localObj = new Local();
	  localObj.show( );
      System.out.println("局部类计算的平均值: " + localObj.average());
  }

 class Inner {    
	  int result;
   void show() {
	  System.out.println("从内部类显示数组元素:");
	  for (int i=0; i<data.length; i++ ) {
		  System.out.print(data[i]); 
	  };
	  System.out.println();
   }

   int average() {
      int sum=0;
	  for (int i=1; i<data.length; i++ ) {
		  sum += data[i];
	  };
	  result=sum/data.length;
			  return result;
   }
  }
}

public class InnerClassTest {

  public static void main(String[] args) {
    int a[] = {6,8,9,22,34,7,2,1,15};
	Outer outerObj = new Outer(a);
	outerObj.checkInner();
	outerObj.checkLocal();

  }
}