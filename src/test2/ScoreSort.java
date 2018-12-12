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
    System.out.print("输入学生的个数：");
    number = scanner.nextInt();
    try{
      if(number<=0) throw new NegativeException();
      input(number);
      writeToFile(student);
     }catch(NegativeException e){//如果输入的人数小于1，抛出异常；
      JOptionPane.showMessageDialog(null,"人数小于1！");
    }    
  }
  public void input(int n){ 
   student=new Student[n];
   System.out.println("学号         姓名               成绩");
   for(int i=0;i<student.length;i++){//输入学生的信息；
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
      JOptionPane.showMessageDialog(null,"读入文件失败！");
    }
  }
 
  public static void main(String[] args) {  
    ScoreSort scoresort = new ScoreSort();   
    System.exit(0);
  }
}
class NegativeException extends Exception{//定义一个负数异常；
  NegativeException(){    
  }
  public String toString(){
    return "数字是小于或等于0";
  }
}
