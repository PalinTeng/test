package test1;

abstract class Student {
    final static int CourseNo = 3;  
    String name;
	String type;
    int[]  courses;    
    String  courseGrade;    
        public Student(String name)
    {
        this.name = name;
        courses = new int[CourseNo];
        courseGrade = null;
    }    
    public abstract void calculateGrade();     
	    public String getName( )
    {
      return name;
    }
	public String getType( )
    {
      return type;
    }
	public String getCourseGrade( )
    {
      return courseGrade;
    }
   
    public int getCourseScore(int courseNumber)
    {
      return courses[courseNumber];
    }    
    
    public void setName(String name)
    {
      this.name = name;
    }

	public void setType(String type)
    {
      this.type = type;
    }
  
    public void setCourseScore(int courseNumber, int courseScore)
    {
    	courseScore = courses[courseNumber];
    }

}

class Undergraduate extends Student {  
   
    public Undergraduate(String name ) 
	{
        super(name);
		type = "本科生";
    }

      public void calculateGrade() {
      int total = 0;
	  double average = 0;
      for (int i = 0; i < CourseNo; i++) {
        total+=courses[i];
      };
      average = total / CourseNo;
      if (average>=80&&average<100) courseGrade = "优秀";
	   else if (average>=70&&average<80) courseGrade = "良好";
	   else if (average>=60&&average<70) courseGrade = "一般";
	   else if (average>=50&&average<60) courseGrade = "及格";
	   else courseGrade = "不及格";  
	  
    }
}


class highschoolstudent extends Student {  
	   
    public highschoolstudent(String name ) 
	{
        super(name);
		type = "高中生";
    }

      public void calculateGrade() {
      int total = 0;
	  double average = 0;
      for (int i = 0; i < CourseNo; i++) {
        total+=courses[i];
      };
      average = total / CourseNo;
 
     if (average>=80&&average<100) courseGrade = "好";
	  else if (average>=60&&average<80) courseGrade = "中";
	  else courseGrade = "差";  
	  
    }
}

class Postgraduate extends Student {  
   public Postgraduate(String name)
   {
      super(name);
	  type = "研究生";
   }
   
public void calculateGrade()
    {
        int total = 0;
        double average = 0;
        for (int i = 0; i < CourseNo; i++) {
           total += courses[i];
        };
       average = total / CourseNo;
	  if (average>=90&&average<100) courseGrade = "优秀";
	   else if (average>=80&&average<90) courseGrade = "良好";
	   else if (average>=70&&average<80) courseGrade = "一般";
	   else if (average>=60&&average<70) courseGrade = "及格";
	   else courseGrade = "不及格";
        
    }
}

public class Polymorphism {
  
  public static void main(String[] args) {

     Student[] students = new Student[5];
     students[0] = new Undergraduate("陈建平");
     students[1] = new Undergraduate("鲁向东");
	 students[2] = new Postgraduate("匡晓华");
	 students[3] = new Undergraduate("周丽娜");
	 students[4] = new Postgraduate("梁欣欣");
	

	 for (int i=0; i<5 ;i++) {

		 students[i].setCourseScore(0,87);
         students[i].setCourseScore(1,90);
		 students[i].setCourseScore(2,78);
	 }

     for (int i=0; i<5 ;i++) {

		 students[i].calculateGrade();
	 }

     System.out.println("姓名" + "     类型" +"    成绩");
	 System.out.println("-----------------------");

	 for (int i=0; i<5 ;i++) {	 
	   
       System.out.println(students[i].getName( )+"   "+
		                  students[i].getType( )+"  "+
		                  students[i].getCourseGrade( ));
	 }
	 for (int i=0;i<5;i++){
			if (students[i] instanceof Undergraduate)
			{System.out.println(students[i].getName()+" 是本科生 ");}
		else
			{System.out.println(students[i].getName()+" 是研究生 ");}
  }
	 Student[] high = new Student[3];
	 high[0] =new highschoolstudent("张三");
	 high[1] =new highschoolstudent("李四");
	 high[2] =new highschoolstudent("张三");

	 for (int i=0; i<3 ;i++) {

		 high[i].setCourseScore(0,87);
		 high[i].setCourseScore(1,90);
		 high[i].setCourseScore(2,78);
	 } 
	 for (int i=0; i<3 ;i++) {

		 high[i].calculateGrade();
	 }
	 for (int i=0; i<3 ;i++) {	 
		   
	       System.out.println(high[i].getName( )+"   "+
	    		   high[i].getType( )+"  "+
	    		   high[i].getCourseGrade( ));
		 }
	 
}
}