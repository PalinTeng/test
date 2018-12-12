package test1;

public class Ring {  
	  private double innerRadius;
	  private double outerRadius;
	  public String color;
	    public Ring(double iRadius, double oRadius, String c) {
	    innerRadius = iRadius;
		outerRadius = oRadius;
	    color = c;
	  }
	    public Ring (){ 
	    	innerRadius=1.0;outerRadius=2.0; color="white";}

	  public double getInnerRadius( ) {
		  return innerRadius;
	  }
	  public double getOuterRadius( ) {
	    return outerRadius;
	  }
	
	    public void setInnerRadius(double iRadius) {
	    innerRadius = iRadius;
	  }
	  public void setOuterRadius(double oRadius) {
	    outerRadius = oRadius;
	  }
	  public void setColor(String c) {
	    color=c;
	  }
	  public double getArea() {
	    return (outerRadius * outerRadius - 
			    innerRadius * innerRadius) * 3.1415;
	  }
	  public double getInnerPeri(){
		return  2*innerRadius * 3.1415;
	  }
	  public double getOuterPeri(){
			return  2*outerRadius * 3.1415;
		  }
	    public static void main(String[] args) {
	    Ring ring = new Ring();	
	    Ring ring1 = new Ring();
	    Ring ring2 = new Ring();
	    System.out.println("内圆的周长: " + ring1.getInnerPeri());
	    System.out.println("外圆的周长: " + ring2.getOuterPeri());
		System.out.println("圆环的内半径: " + ring.getInnerRadius( ));
		System.out.println("圆环的外半径: " + ring.getOuterRadius( ));
		System.out.println("圆环的颜色: " + ring.color);
	    System.out.println("圆环的面积: " + ring.getArea() + "\n");
			ring.setInnerRadius(4);
		    ring.setOuterRadius(6);
		    ring.setColor("blue");
		System.out.println("圆环的内半径: " + ring.innerRadius);
		System.out.println("圆环的外半径: " + ring.outerRadius);
		System.out.println("圆环的颜色: " + ring.color);
	    System.out.println("圆环的面积: " + ring.getArea());
	      }
	}
