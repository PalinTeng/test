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
System.out.println("文件不存在");
}

public void readFileAttributions(){//输出文件的相关属性
System.out.println("文件的名称："+fileName.getName());
System.out.println("文件的绝对路径："+fileName.getAbsolutePath());
System.out.println("文件的路径"+fileName.getPath());
System.out.println("文件的长度"+fileName.length());
}

public void readFileContent(){//读取文件的内容
try{
BufferedReader output=new BufferedReader(new FileReader(fileName));
StringBuffer buffer=new StringBuffer();
String text;

while((text=output.readLine())!=null)
buffer.append(text+"\n");
System.out.println(buffer);
output.close();//关闭文件；
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