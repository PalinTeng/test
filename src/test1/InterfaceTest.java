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
		
	System.out.println(" 关闭闹钟 ");
	}
public void playSound() {
	System.out.println(" 闹钟发出滴答声 ");
}
}

class Radio implements Soundable {

  public void increaseVolume( ) {
	  System.out.println("增大收音机音量");
  }
  
  public void decreaseVolume( ) {
	  System.out.println("减小收音机音量");
  }
  public void stopSound( ) {
	  System.out.println("关闭收音机");
  }
  public void playSound( ) {
	  System.out.println("收音机播放广播");
  }
}

class Walkman implements Soundable {

  public void increaseVolume( ) {
	  System.out.println("增大随声听音量");
  }
  
  public void decreaseVolume( ) {
	  System.out.println("减小随声听音量");
  }
  public void stopSound( ) {
	  System.out.println("关闭随声听");
  }
  public void playSound( ) {
	  System.out.println("随声听发出音乐");
  }
}


class Mobilephones implements Soundable {

  public void increaseVolume( ) {
	  System.out.println("增大随声听音量");
  }
  
  public void decreaseVolume( ) {
	  System.out.println("减小随声听音量");
  }
  public void stopSound( ) {
	  System.out.println("关闭随声听");
  }
  public void playSound( ) {
	  System.out.println("随声听发出音乐");
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
     
       //往声音设备数组中放入能发声的设备
	   soundDevice[0] = new Radio( );
	   soundDevice[1] = new Walkman( );
       soundDevice[2] = new Mobilephones( );
       soundDevice[3] = new Clock1( );
	   System.out.println("你想听什么? 请输入选择：0-收音机 1-随声听 2-手机");
       i = scanner.nextInt( );
       
	   //开始听声音
	   sportsman.listen(soundDevice[i]);
	   soundDevice[i].increaseVolume( );
	   soundDevice[i].stopSound( );
   }

}