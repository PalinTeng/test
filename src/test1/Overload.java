package test1;

class Overload {
	  int m,n;
		Overload( ) {
		m = 0;
		n = 0;
	  }
	Overload(int a, int b) {
	    m=a;
		n=b;
	  }
	  int add( ) {
		System.out.println("�޲μӷ� "+m+"+"+n+"="+(m+n));
	return m+n; }
	 // int add(int a, int b) {
		//System.out.println("���ͼӷ� "+a+"+"+b+"="+(a+b));
		//return a+b;
	 // }
	  double add(double a, double b) {
		System.out.println("ʵ�ͼӷ� "+a+"+"+b+"="+(a+b));
		return a+b;
	  }
	  double add(int a, int b, double c) {
		System.out.println("��ϼӷ� "+a+"+"+b+"+"+c+"="+(a+b+c));
		return a+b+c;
	  }
	  double add(int a,int b){
		  System.out.println(" ���ͼӷ�������ʵ��ֵ "+a+"+"+b+"="+(a+b));
		   return (double)(a+b);}

	  public static void main(String[] args) {
	    int ix,iy;
		double dx,dy;
		Overload ov=new Overload();
		ix = ov.add();
		//iy = ov.add(3,6);
		ov.add((int)2.1,(int) 5.3 );
		dy = ov.add(3, 6, 2.2);
	  }
	}
