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
		System.out.println("�����������������:yyyy-MM-dd");
		birthday = scanner.next( );
		//����һ�����ڸ�ʽ����
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");		
		
		//���һ��������ǰ���ں�ʱ���Calendar�����ʵ��
        calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);

		//�������birthday����һ��Date����
		date = dateFormat.parse(birthday);
		//��date�����ֵ���ݸ�calendar����
		calendar.setTime(date);		

        int days = calendar.get(Calendar.DAY_OF_WEEK);       

		switch( days ) {

          case 1:  dayOfWeek = "������";break;
          case 2:  dayOfWeek = "����һ";//break;
          case 3:  dayOfWeek = "���ڶ�";break;
          case 4:  dayOfWeek = "������";break;
          case 5:  dayOfWeek = "������";break;
          case 6:  dayOfWeek = "������";break;
          case 7:  dayOfWeek = "������";//break;          
        }
		long daysOfYear = calendar1.getTimeInMillis()/86400000 - date.getTime()/86400000 -1;
        int currentMONTH = calendar1.get(Calendar.MONTH);
        System.out.println("��ǰʱ����·�:" + currentMONTH);
		System.out.println("���������:" + dayOfWeek);
        System.out.println("���"+ daysOfYear + "��");
		int birthYear = calendar.get(Calendar.YEAR);

		if (((birthYear%4==0)&&(birthYear%100!=0))||(birthYear%400==0)) 
              System.out.println(birthYear + "��: ������");
        else  
		      System.out.println(birthYear + "��: ��������");

        int age = currentYear-birthYear;
        System.out.println("��������: " + age + "��"); 
	}
}