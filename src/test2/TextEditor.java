package test2;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.text.Document;
public class TextEditor extends JFrame{
  JDesktopPane desktopPane;
  //定义菜单组件
  JMenuBar menuBar;
  JMenu fileMenu,helpMenu;//定义文件菜单、帮助菜单
  JMenuItem newItem,openItem,saveItem,othersaveItem,closeItem,exitItem;
  //定义文件菜单的：新建菜单项、打开菜单项、保存菜单项、另存菜单项、关闭菜单项、//退出菜单项
  JMenuItem aboutItem;//定义帮助菜单的：关于菜单项
  StringBuffer buffer=new StringBuffer();//定义一个字符串缓冲区；
  File currentFile;//当前处理的文件；
  int status;//记录当前状态0:新建、1：打开、2：保存、3：另存；4：关闭；
  DisplayFrame currentFrame;//当前打开的窗口
  
  public TextEditor() {
  super("文本编辑器");
  Container container=getContentPane();
  desktopPane=new JDesktopPane();
  container.add(desktopPane);
  createMenu();
  setJMenuBar(menuBar);
  }
  public void createMenu(){
    //定义菜单条；
    menuBar=new JMenuBar();
    //定义文件菜单
    fileMenu=new JMenu("文件");
    //定义文件菜单的：新建菜单项、打开菜单项、保存菜单项、另存菜单项、关闭菜单
//退出菜单项
    //定义新建菜单项
    newItem=new JMenuItem("新建");
    newItem.addActionListener(new NewFileListener());
    //定义打开菜单项
    openItem=new JMenuItem("打开");
openItem.addActionListener(new OpenFileListener());

    saveItem=new JMenuItem("保存");
saveItem.addActionListener(new SaveFileListener());

    othersaveItem=new JMenuItem("另存为");
othersaveItem.addActionListener(new OtherSaveFileListener());

    closeItem=new JMenuItem("关闭");
    closeItem.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent e){
       if(e.getSource()==closeItem){
       currentFrame.dispose();
       }
     }
    });
  
    exitItem=new JMenuItem("退出");
    exitItem.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        System.exit(0);
      }
    });
    //添加菜单项到文件菜单中；
    fileMenu.add(newItem);
    fileMenu.add(openItem);
    fileMenu.addSeparator();
    fileMenu.add(saveItem);
    fileMenu.add(othersaveItem);
    fileMenu.addSeparator();
    fileMenu.add(closeItem);
    fileMenu.add(exitItem);

    //定义帮助菜单
    helpMenu=new JMenu("帮助");
    //定义帮助菜单的：关于菜单项
    aboutItem=new JMenuItem("关于");
    aboutItem.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        if(e.getSource()==aboutItem){
         JOptionPane.showMessageDialog(null,"TextEditor 1.1",
"版本",JOptionPane.INFORMATION_MESSAGE);
        }
      }
    });
    //添加菜单项到帮助菜单中；
    helpMenu.add(aboutItem);

    //将文件菜单和帮助菜单加入到菜单条中；
    menuBar.add(fileMenu);
    menuBar.add(helpMenu);
  }//end createMenu method;

  public File chooseFile(int chooseMode){
    //从选择文件对话框中选择文件，chooseMode为选择模式
    //1：为文件打开对话框模式，2：为文件保存对话框模式；
   JFileChooser filechooser=new JFileChooser();
   filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
   int result=0;
   switch(chooseMode){
     case 1:
       result =filechooser.showOpenDialog(currentFrame);
//按照文件打开对话框模式选择文件
       break;
     case 2:
        result=filechooser.showOpenDialog(currentFrame);
      //按照文件保存对话框模式选择文件
        break;
   }
   if(result==filechooser.CANCEL_OPTION) return null;
   File fileName=filechooser.getSelectedFile();//从对话框中选择文件，赋值给fileName;
   return fileName;//返回选定的文件；
  }
  
  public void saveFile(File file,int saveMode) throws IOException{
    //保存文件fileName，saveMode是保存文件模式：
    //1：新建文件的保存；2：将修改的已有文件保存；    
    File fileName=null;
    switch(saveMode){
      case 0:fileName=chooseFile(2);
             if(fileName.createNewFile()!=true) return;
             break;
      case 1:fileName=file;break;
      default:return;
    }    
    currentFile=fileName;
    if(fileName.exists()!=true) return;//文件不存在，则返回；
      BufferedWriter input=new BufferedWriter(new FileWriter(fileName));
      //将文件fileName写入到字符缓冲写入器input中；
      input.write(buffer.toString(),0,buffer.length()-1);
//将buffer字符串写入到字符缓冲写入器input中
      System.err.println(buffer.length());
      if(input!=null)
         input.close();
     status=1;
  }
  
  public void showFile(File fileName,DisplayFrame contentFrame){
    //将指定文件fileName的内容在窗口contentFrame内显示出来。
    try{
       BufferedReader output=new BufferedReader(new FileReader(fileName));
       //将文件fileName读到字符缓冲读取器output中；
       String text;
       buffer=new StringBuffer();
       while((text=output.readLine())!=null)//依次访问文件的每一行；
       buffer.append(text+"\n");//将每一行添加到buffer中；

       contentFrame.displayArea.setText(buffer.toString());
//将buffer的字符串在contentFrame窗口中显示出来；
contentFrame.setTitle(fileName.getName());//改变窗口的标题；
       output.close();//关闭字符缓冲流output;
       }
       catch(IOException ex){
         JOptionPane.showMessageDialog(null,"错误发生！");
       }
       catch(NullPointerException ex3){
         JOptionPane.showMessageDialog(null,"警告！");
       }
  }
  
  public static void main(String[] args) {
    TextEditor texteditor = new TextEditor();
    texteditor.setSize(400,300);
    texteditor.setVisible(true);
    texteditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }//end main
  
  class NewFileListener implements ActionListener{
  public void actionPerformed(ActionEvent e){//新建
        DisplayFrame txtFrame=new DisplayFrame();
        currentFrame=txtFrame;
txtFrame.setTitle("新建文件");
        desktopPane.add(txtFrame);
        status=0;
  }
}//end class newFileListener;

class OpenFileListener implements ActionListener{
   public void actionPerformed(ActionEvent e){//打开文件监视接口；
   File fileName=chooseFile(1);//打开模式打开文件；
   currentFile=fileName;
  try{
   if(fileName.exists()){
    DisplayFrame contentFrame=new DisplayFrame();
    currentFrame=contentFrame;
    desktopPane.add(contentFrame);
    showFile(fileName,contentFrame);
      }//end if
      status=1;
   }catch(Exception ex){}
   }//end actionPerformed
   }//end class openFileListener;

   class SaveFileListener implements ActionListener{
     public void actionPerformed(ActionEvent e){//保存处理
       if (e.getSource() == saveItem) {
         try {
           saveFile(currentFile, status);
         }
         catch (IOException ex) {
           JOptionPane.showMessageDialog(null, "保存文件失败！！！！");
         }
         catch(Exception ex){ }
       }
     }
   }//end class SaveFileListener;
   
  class OtherSaveFileListener implements ActionListener{
    public void actionPerformed(ActionEvent e){//另存处理；
      if(e.getSource()==othersaveItem){
      File fileName=chooseFile(2);
      BufferedOutputStream output=null;
      BufferedInputStream input=null;
      try{
          if(fileName.exists()!=true) fileName.createNewFile();
          input = new BufferedInputStream(new FileInputStream(currentFile));
          output = new BufferedOutputStream(new FileOutputStream(fileName));       
          String ch;
          while ((ch=input.readLine())!=null) {
             output.write(ch);
            output.newLine();
          }
          input.close();
          output.close();
          currentFrame.dispose();//将源文件显示窗口关闭；
          DisplayFrame contentFrame=new DisplayFrame();
          desktopPane.add(contentFrame);//创建新的显示窗口；
          currentFrame=contentFrame;//新窗口设置为当前显示窗口；
          currentFile=fileName;
          showFile(fileName,contentFrame);
//在窗口contentFrame中显示文件fileName;
       }catch(IOException ex){
        JOptionPane.showMessageDialog(null,"文件另存失败！！！！");
      }
     }//end outer if
    }//end actionPerformed method;
  }//end class OtherSaveListener;
  
  class DisplayFrame extends JInternalFrame implements DocumentListener{
   JTextArea displayArea;
   public DisplayFrame() {
   super("文本内容:", true, true, true, true);
   displayArea = new JTextArea(8, 30);
   displayArea.getDocument().addDocumentListener(this);
   getContentPane().add(displayArea);
   pack();
   setVisible(true);
  }
  public void insertUpdate(DocumentEvent e) {
   buffer=new StringBuffer(displayArea.getText());
   displayArea.setCaretPosition(displayArea.getDocument().getLength());
  }
  public void removeUpdate(DocumentEvent e) {
   buffer=new StringBuffer(displayArea.getText());
   displayArea.setCaretPosition(displayArea.getDocument().getLength());
  }
  public void changedUpdate(DocumentEvent e) {
   //Plain text components don't fire these events.
   }
  }//end DisplayFrame.java
}//end class TextEditor.java