package test2;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class ScoreSort {
  Scanner scanner;
  Student[] student;
  int number;
  File filename;
  
  public ScoreSort(){
    scanner=new Scanner(System.in);
    System.out.print("����ѧ���ĸ�����");
    number = scanner.nextInt();
    try{
      if(number<=0) throw new NegativeException();
      input(number);
      writeToFile(student);
     }catch(NegativeException e){//������������С��1���׳��쳣��
      JOptionPane.showMessageDialog(null,"����С��1��");
    }    
  }
  public void input(int n){ 
   student=new Student[n];
   System.out.println("ѧ��         ����               �ɼ�");
   for(int i=0;i<student.length;i++){//����ѧ������Ϣ��
     int id=scanner.nextInt();
     String name=scanner.next();
     int score=scanner.nextInt();
     student[i]=new Student(id,name,score);
   }
  }

  public void writeToFile(Student[] s){
    try{
      ObjectOutputStream output=new ObjectOutputStream(new 
    		  FileOutputStream("Student.dat"));
     output.writeObject(s);
     
      output.close();
    }catch(IOException ex){
      JOptionPane.showMessageDialog(null,"�����ļ�ʧ�ܣ�");
    }
  }
 
  public static void main(String[] args) {  
    ScoreSort scoresort = new ScoreSort();   
    System.exit(0);
  }
}
class NegativeException extends Exception{//����һ�������쳣��
  NegativeException(){    
  }
  public String toString(){
    return "������С�ڻ����0";
  }
}
