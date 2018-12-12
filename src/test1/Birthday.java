package test1;

import java.util.*;   // Date,Calendar,Scanner
import java.text.*;   // SimpleDateFormat

public class Birthday {

	public static void main(String args[]) throws ParseException {
		 
        String   birthday, dayOfWeek=" ";
		Date     date;
		Calendar calendar;
		Scanner scanner = new Scanner(System.in);
		Calendar calendar1 = Calendar.getInstance();
		System.out.println("请输入你的生日日期:yyyy-MM-dd");
		birthday = scanner.next( );
		//创建一个日期格式对象
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");		
		
		//获得一个包含当前日期和时间的Calendar子类的实例
        calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);

		//按输入的birthday产生一个Date对象
		date = dateFormat.parse(birthday);
		//将date对象的值传递给calendar对象
		calendar.setTime(date);		

        int days = calendar.get(Calendar.DAY_OF_WEEK);       

		switch( days ) {

          case 1:  dayOfWeek = "星期日";break;
          case 2:  dayOfWeek = "星期一";//break;
          case 3:  dayOfWeek = "星期二";break;
          case 4:  dayOfWeek = "星期三";break;
          case 5:  dayOfWeek = "星期四";break;
          case 6:  dayOfWeek = "星期五";break;
          case 7:  dayOfWeek = "星期六";//break;          
        }
		long daysOfYear = calendar1.getTimeInMillis()/86400000 - date.getTime()/86400000 -1;
        int currentMONTH = calendar1.get(Calendar.MONTH);
        System.out.println("当前时间的月份:" + currentMONTH);
		System.out.println("你的生日是:" + dayOfWeek);
        System.out.println("相距"+ daysOfYear + "天");
		int birthYear = calendar.get(Calendar.YEAR);

		if (((birthYear%4==0)&&(birthYear%100!=0))||(birthYear%400==0)) 
              System.out.println(birthYear + "年: 是闰年");
        else  
		      System.out.println(birthYear + "年: 不是闰年");

        int age = currentYear-birthYear;
        System.out.println("你现在是: " + age + "岁"); 
	}
}