package test;

import test1.*;

class B { 

  public static void main(String[] args) {

	Clock c = new Clock(8,30,5);
	System.out.println(" 从类 B 中访问 Clock hour="c.hour);
	System.out.println(" 从类 B 中访问 Clock minute="+c.minute);
	System.out.println(" 从类 B 中访问 Clock second="+c.second);

  }
}