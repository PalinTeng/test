package test1;

import java.util.Scanner;

interface Soundable {
  
    public void increaseVolume( );
    public void decreaseVolume( );
    public void stopSound( );
    public void playSound( );

}
class Clock1 implements Soundable {

	public void increaseVolume(){}
	public void decreaseVolume(){}
	      public void stopSound() {
		
	System.out.println(" �ر����� ");
	}
public void playSound() {
	System.out.println(" ���ӷ����δ��� ");
}
}

class Radio implements Soundable {

  public void increaseVolume( ) {
	  System.out.println("��������������");
  }
  
  public void decreaseVolume( ) {
	  System.out.println("��С����������");
  }
  public void stopSound( ) {
	  System.out.println("�ر�������");
  }
  public void playSound( ) {
	  System.out.println("���������Ź㲥");
  }
}

class Walkman implements Soundable {

  public void increaseVolume( ) {
	  System.out.println("��������������");
  }
  
  public void decreaseVolume( ) {
	  System.out.println("��С����������");
  }
  public void stopSound( ) {
	  System.out.println("�ر�������");
  }
  public void playSound( ) {
	  System.out.println("��������������");
  }
}


class Mobilephones implements Soundable {

  public void increaseVolume( ) {
	  System.out.println("��������������");
  }
  
  public void decreaseVolume( ) {
	  System.out.println("��С����������");
  }
  public void stopSound( ) {
	  System.out.println("�ر�������");
  }
  public void playSound( ) {
	  System.out.println("��������������");
  }
}



class People {

   private String name;
   private int    age;
   
   
   public void listen(Soundable s) {
	  
	   s.playSound( );
   }
}
	

public class InterfaceTest {

   public static void main(String[] args) {
       
	   int i;
	   
	   People sportsman = new People( );
       Scanner scanner = new Scanner(System.in);
	   Soundable[] soundDevice = new Soundable[4];
     
       //�������豸�����з����ܷ������豸
	   soundDevice[0] = new Radio( );
	   soundDevice[1] = new Walkman( );
       soundDevice[2] = new Mobilephones( );
       soundDevice[3] = new Clock1( );
	   System.out.println("������ʲô? ������ѡ��0-������ 1-������ 2-�ֻ�");
       i = scanner.nextInt( );
       
	   //��ʼ������
	   sportsman.listen(soundDevice[i]);
	   soundDevice[i].increaseVolume( );
	   soundDevice[i].stopSound( );
   }

}