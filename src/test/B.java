package test;

import test1.*;

class B { 

  public static void main(String[] args) {

	Clock c = new Clock(8,30,5);
	System.out.println(" ���� B �з��� Clock hour="c.hour);
	System.out.println(" ���� B �з��� Clock minute="+c.minute);
	System.out.println(" ���� B �з��� Clock second="+c.second);

  }
}