package test1;
import java.util.Scanner;
interface moveable{
    public void move( );
    public void attack( );

}

class Car implements moveable{
	 public void move() { System.out.println(" �������� ");}
	 public void attack( ){ System.out.println(" �����Թ���");}
}
class Ship implements moveable{
	 public void move() { System.out.println(" �������� ");}
	 public void attack( ){ System.out.println(" �����Թ���");}
}
class Aircraft implements moveable{
	 public void move() { System.out.println(" �ɻ������� ");}
	 public void attack( ){ System.out.println(" �ɻ����Թ���");}
}
public class InterfaceTest1 {
	   public static void main(String[] args) {
 moveable [] trans=new moveable[3];
trans[0] = new Car();
trans[1] = new Ship();
trans[2] = new Aircraft();
}
}