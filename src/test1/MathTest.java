package test1;

import java.util.*;
public class MathTest {

    public static void main(String args[]) {

      Scanner scanner = new Scanner(System.in);

	  int intData;
	  double doubleData;		 
	  String intString, doubleString;
      double suiji;
      System.out.print("����������x��ʵ��y: ");
	  intData = scanner.nextInt( );
	  //���ַ�����ʽ����ʵ��
	  doubleString = scanner.next( );
	 
      //������������intObject
	  Integer intObject = new Integer(intData);
	  //�����ַ�������Ӧ����ֵ	 
      doubleData = Double.parseDouble(doubleString);

	  intData = intObject.intValue( );
      //�����������ֵ���ַ�����ʽ���
	  intString = intObject.toString( );
      suiji=Math.random();
      System.out.println("��������ǣ�" + intString + ", "+ doubleData);

	  //��ʼ����Math��ķ�����������
	  int intData1 = Math.abs(intData);
	  System.out.println("abs(x)x�ľ���ֵ: "+Math.abs(intData));
	  System.out.println("ceil(y)y����ȡ��: "+Math.ceil(doubleData));
	  System.out.println("floor(y)y����ȡ����"+Math.floor(doubleData));
	  System.out.println("exp(x)e��x����: " + Math.exp(intData));
	  System.out.println("log(x)x����Ȼ������"+ Math.log(intData1));

	  System.out.println("max(x,y)x��y�еĽϴ��ߣ�"+ Math.max(intData,doubleData));
	  System.out.println("min(x,y)x��y�еĽ�С�ߣ�"+ Math.min(intData,doubleData));
	  System.out.println("sin(x)x������ֵ��" + Math.sin(intData));
	  System.out.println("cos(x)x������ֵ��" + Math.cos(intData));
	  System.out.println("��xΪ�뾶��Բ�����"+ Math.PI*intData*intData);
	  
	  System.out.println("�����������ֵ��" + Math.sin(suiji));
	  System.out.println("�����������ֵ��" + Math.cos(suiji));
	}
}