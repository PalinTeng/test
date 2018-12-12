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
student=new Student[number];//�޶�ѧ��������
student=readFromFile();
    sort(student);
    System.err.println("�����");
    writeToFile(student);
    output();
  }

  public void sort(Student s[]){//��ѧ����¼���ɼ�����
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
//���ļ����ݶ��뵽���鲢�������飻
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
      JOptionPane.showMessageDialog(null,"�����ļ�ʧ�ܣ�");
    }
  }
  
public void output(){//����ļ����ݣ�
	Student[] s3=null;
    try{
     ObjectInputStream input=new ObjectInputStream(new FileInputStream("student.dat"));
     System.out.println("����ļ�student.dat�����ݣ�");
   s3=(Student[]) input.readObject();
   for(Student s :s3)
     {
    	 System.out.println("ѧ��:"+s.getId());
    	 System.out.println("����:"+s.getName());
    	 System.out.println("�ɼ�:"+s.getScore());
    	 }
    	 input.close();
     
   }
    catch(IOException ex){
      System.err.println("���ļ�ʧ��");
    }
    catch(ClassNotFoundException ex){
    }
  }

  public static void main(String[] args) {
    ScoreSort2 scoresort = new ScoreSort2();
    System.exit(0);
  }
}