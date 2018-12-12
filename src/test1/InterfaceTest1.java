package test1;
import java.util.Scanner;
interface moveable{
    public void move( );
    public void attack( );

}

class Car implements moveable{
	 public void move() { System.out.println(" 车可以走 ");}
	 public void attack( ){ System.out.println(" 车可以攻击");}
}
class Ship implements moveable{
	 public void move() { System.out.println(" 船可以走 ");}
	 public void attack( ){ System.out.println(" 船可以攻击");}
}
class Aircraft implements moveable{
	 public void move() { System.out.println(" 飞机可以走 ");}
	 public void attack( ){ System.out.println(" 飞机可以攻击");}
}
public class InterfaceTest1 {
	   public static void main(String[] args) {
 moveable [] trans=new moveable[3];
trans[0] = new Car();
trans[1] = new Ship();
trans[2] = new Aircraft();
}
}