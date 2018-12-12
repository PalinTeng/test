package test1;

class Telephone {
	  String brand, number;
	  double dialledTime;
	  double rate;
	  Telephone (String b ,String n,double r){ 
		  this(b,n);
		  rate =r;
		  }

	  Telephone(String b, String n) {
	    brand = b;
		number = n;
	  }
	//  Telephone(){};
	  String getBrand( ) { return brand; }
	  String getNumber( ) { return number; }
	  double getRate( ) { return rate; }
	  double getDialledTime( ) { return dialledTime; }
	  void setBrand(String b) {
	    brand = b;
	  }
	  void setNumber(String n) {
		  number = n;
	  }
	  void setRate(double r) {
	    rate = r;
	  }
	  void setDialledTime(double d) {
	    dialledTime = d;
	  }
	  double callCost( ) {
	    return dialledTime * rate;
	  }
	    void display( ) {
		System.out.println("�绰Ʒ��: "+ brand +" �绰����: "+ number);
	    System.out.println("ͨ��ʱ��: "+ dialledTime +" ����: "+ rate);
	    System.out.println("����: "+ callCost( ));
	  }
	}
class Xiaolingtong extends Telephone{
	 String network;
	  double receivedTime;
	  Xiaolingtong(String b, String num, String net) {
			super(b, num);
		network = net;
	  }
	  String getNetwork( ) { return network; }
	  double getReceivedTime( ) { return receivedTime; }
	  void setNetwork(String n) {
	    network = n;
	  }
	  void setReceivedTime(double d) {
		  receivedTime = d;
	  }
	  double callCost( ) {
	    return (dialledTime + 0.8*receivedTime) * rate;
	  }
	  void display( ) {
		System.out.println("�绰Ʒ��: "+ brand +" �绰����: "+ number
			                +" ����: "+ network);
	    System.out.println("����ʱ��: "+ dialledTime +" ����ʱ��: " +
			               receivedTime +" ����: "+ rate);
	    System.out.println("����: "+ super.callCost( ));
	  }
	
}
	class Mobilephone extends Telephone {
	    String network;
	  double receivedTime;
	  Mobilephone(String b, String num, String net) {
			super(b, num);
		network = net;
	  }
	  String getNetwork( ) { return network; }
	  double getReceivedTime( ) { return receivedTime; }
	  void setNetwork(String n) {
	    network = n;
	  }
	  void setReceivedTime(double d) {
		  receivedTime = d;
	  }
	  double callCost( ) {
	    return (dialledTime + 0.5*receivedTime) * rate;
	  }
	  void display( ) {
		System.out.println("�绰Ʒ��: "+ brand +" �绰����: "+ number
			                +" ����: "+ network);
	    System.out.println("����ʱ��: "+ dialledTime +" ����ʱ��: " +
			               receivedTime +" ����: "+ rate);
	    System.out.println("����: "+ super.callCost( ));
	  }
	}
	public class Inheritance {
	  public static void main(String[] args) {
		Telephone tel;
		Mobilephone mobile;
		Mobilephone mobile1;
		tel = new Telephone("TCL", "8309600");
		mobile = new Mobilephone("Nokia", "13007091010","CDMA");
		mobile1 = new Mobilephone("Noki", "1300709101","CDM");
		tel.setRate(0.2);
		tel.setDialledTime(150);
		mobile.setRate(0.4);
	    mobile.setReceivedTime(80);
	    mobile.setReceivedTime(120);
		tel.display( );
	    System.out.println( );
	    mobile.display();
	    mobile1.display();
	  }
	}
