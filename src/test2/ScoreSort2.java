package test2;


import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class ScoreSort2 {
  int number=100;
  Student student[];
  File filename;

  public ScoreSort2(){
output();
student=new Student[number];//限定学生人数；
student=readFromFile();
    sort(student);
    System.err.println("排序后：");
    writeToFile(student);
    output();
  }

  public void sort(Student s[]){//将学生记录按成绩排序；
Student temp =null;
for(int i=0;i<s.length;i++)
  {
	for(int j=0;j<s.length;j++)
	{
		if(s[j].getScore()<s[i].getScore())
		{
			temp =s[i];
			s[i]= s[j];
			s[j] = temp;
		}
	}
  }
}

  public Student[] readFromFile(){
//将文件内容读入到数组并返回数组；
   Student s[]=null;
    try{
    	ObjectInputStream input=new ObjectInputStream(new FileInputStream("student.dat"));
     
    		s=(Student[])input.readObject();
    		input.close();
   }
  catch(IOException ex){
    System.err.println("ERROR");
  }
  catch(ClassNotFoundException ex){
    
  }
  return s;
  }//end readFromFile
  
  public void writeToFile(Student[] s){
    try{
      ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("student.dat"));
      output.writeObject(s);
      output.close();
    }catch(IOException ex){
      JOptionPane.showMessageDialog(null,"读入文件失败！");
    }
  }
  
public void output(){//输出文件内容；
	Student[] s3=null;
    try{
     ObjectInputStream input=new ObjectInputStream(new FileInputStream("student.dat"));
     System.out.println("输出文件student.dat的内容：");
   s3=(Student[]) input.readObject();
   for(Student s :s3)
     {
    	 System.out.println("学号:"+s.getId());
    	 System.out.println("姓名:"+s.getName());
    	 System.out.println("成绩:"+s.getScore());
    	 }
    	 input.close();
     
   }
    catch(IOException ex){
      System.err.println("打开文件失败");
    }
    catch(ClassNotFoundException ex){
    }
  }

  public static void main(String[] args) {
    ScoreSort2 scoresort = new ScoreSort2();
    System.exit(0);
  }
}