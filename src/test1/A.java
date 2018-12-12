package test1;

class A { 

	  public static void main(String[] args) {

		Clock c = new Clock(5,20,10);
		System.out.println(" 从类 A 中访问 Clock hour="+c.hour);
		System.out.println(" 从类 A 中访问 Clock minute="+c.minute); 
		System.out.println(" 从类 A 中访问 Clock second=" + c.second);
	  }
}