package test1;

import java.util.*;
public class MathTest {

    public static void main(String args[]) {

      Scanner scanner = new Scanner(System.in);

	  int intData;
	  double doubleData;		 
	  String intString, doubleString;
      double suiji;
      System.out.print("请输入整数x和实数y: ");
	  intData = scanner.nextInt( );
	  //以字符串方式输入实数
	  doubleString = scanner.next( );
	 
      //创建整数对象intObject
	  Integer intObject = new Integer(intData);
	  //返回字符串所对应的数值	 
      doubleData = Double.parseDouble(doubleString);

	  intData = intObject.intValue( );
      //将整数对象的值以字符串形式输出
	  intString = intObject.toString( );
      suiji=Math.random();
      System.out.println("你的输入是：" + intString + ", "+ doubleData);

	  //开始调用Math类的方法进行运算
	  int intData1 = Math.abs(intData);
	  System.out.println("abs(x)x的绝对值: "+Math.abs(intData));
	  System.out.println("ceil(y)y向上取整: "+Math.ceil(doubleData));
	  System.out.println("floor(y)y向下取整："+Math.floor(doubleData));
	  System.out.println("exp(x)e的x次幂: " + Math.exp(intData));
	  System.out.println("log(x)x的自然对数："+ Math.log(intData1));

	  System.out.println("max(x,y)x和y中的较大者："+ Math.max(intData,doubleData));
	  System.out.println("min(x,y)x和y中的较小者："+ Math.min(intData,doubleData));
	  System.out.println("sin(x)x的正弦值：" + Math.sin(intData));
	  System.out.println("cos(x)x的余弦值：" + Math.cos(intData));
	  System.out.println("以x为半径的圆面积："+ Math.PI*intData*intData);
	  
	  System.out.println("随机数的正弦值：" + Math.sin(suiji));
	  System.out.println("随机数的余弦值：" + Math.cos(suiji));
	}
}