package test2;

import java.io.*;
public class TextViewer1 {
File fileName;
public TextViewer1() {
fileName=new File("C:\\Users\\asus\\Desktop\\SongListMore.txt");
if(fileName.exists()){
readFileAttributions();
readFileContent();
}
else
System.out.println("�ļ�������");
}

public void readFileAttributions(){//����ļ����������
System.out.println("�ļ������ƣ�"+fileName.getName());
System.out.println("�ļ��ľ���·����"+fileName.getAbsolutePath());
System.out.println("�ļ���·��"+fileName.getPath());
System.out.println("�ļ��ĳ���"+fileName.length());
}

public void readFileContent(){//��ȡ�ļ�������
try{
BufferedReader output=new BufferedReader(new FileReader(fileName));
StringBuffer buffer=new StringBuffer();
String text;

while((text=output.readLine())!=null)
buffer.append(text+"\n");
System.out.println(buffer);
output.close();//�ر��ļ���
} 
catch(IOException exception){
System.out.println("IOException happened");
}
}

public static void main(String[] args) {
TextViewer1 textviewer1 = new TextViewer1();
System.exit(0);
}
}