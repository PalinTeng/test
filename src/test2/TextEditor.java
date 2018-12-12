package test2;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.text.Document;
public class TextEditor extends JFrame{
  JDesktopPane desktopPane;
  //����˵����
  JMenuBar menuBar;
  JMenu fileMenu,helpMenu;//�����ļ��˵��������˵�
  JMenuItem newItem,openItem,saveItem,othersaveItem,closeItem,exitItem;
  //�����ļ��˵��ģ��½��˵���򿪲˵������˵�����˵���رղ˵��//�˳��˵���
  JMenuItem aboutItem;//��������˵��ģ����ڲ˵���
  StringBuffer buffer=new StringBuffer();//����һ���ַ�����������
  File currentFile;//��ǰ������ļ���
  int status;//��¼��ǰ״̬0:�½���1���򿪡�2�����桢3����棻4���رգ�
  DisplayFrame currentFrame;//��ǰ�򿪵Ĵ���
  
  public TextEditor() {
  super("�ı��༭��");
  Container container=getContentPane();
  desktopPane=new JDesktopPane();
  container.add(desktopPane);
  createMenu();
  setJMenuBar(menuBar);
  }
  public void createMenu(){
    //����˵�����
    menuBar=new JMenuBar();
    //�����ļ��˵�
    fileMenu=new JMenu("�ļ�");
    //�����ļ��˵��ģ��½��˵���򿪲˵������˵�����˵���رղ˵�
//�˳��˵���
    //�����½��˵���
    newItem=new JMenuItem("�½�");
    newItem.addActionListener(new NewFileListener());
    //����򿪲˵���
    openItem=new JMenuItem("��");
openItem.addActionListener(new OpenFileListener());

    saveItem=new JMenuItem("����");
saveItem.addActionListener(new SaveFileListener());

    othersaveItem=new JMenuItem("���Ϊ");
othersaveItem.addActionListener(new OtherSaveFileListener());

    closeItem=new JMenuItem("�ر�");
    closeItem.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent e){
       if(e.getSource()==closeItem){
       currentFrame.dispose();
       }
     }
    });
  
    exitItem=new JMenuItem("�˳�");
    exitItem.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        System.exit(0);
      }
    });
    //��Ӳ˵���ļ��˵��У�
    fileMenu.add(newItem);
    fileMenu.add(openItem);
    fileMenu.addSeparator();
    fileMenu.add(saveItem);
    fileMenu.add(othersaveItem);
    fileMenu.addSeparator();
    fileMenu.add(closeItem);
    fileMenu.add(exitItem);

    //��������˵�
    helpMenu=new JMenu("����");
    //��������˵��ģ����ڲ˵���
    aboutItem=new JMenuItem("����");
    aboutItem.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        if(e.getSource()==aboutItem){
         JOptionPane.showMessageDialog(null,"TextEditor 1.1",
"�汾",JOptionPane.INFORMATION_MESSAGE);
        }
      }
    });
    //��Ӳ˵�������˵��У�
    helpMenu.add(aboutItem);

    //���ļ��˵��Ͱ����˵����뵽�˵����У�
    menuBar.add(fileMenu);
    menuBar.add(helpMenu);
  }//end createMenu method;

  public File chooseFile(int chooseMode){
    //��ѡ���ļ��Ի�����ѡ���ļ���chooseModeΪѡ��ģʽ
    //1��Ϊ�ļ��򿪶Ի���ģʽ��2��Ϊ�ļ�����Ի���ģʽ��
   JFileChooser filechooser=new JFileChooser();
   filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
   int result=0;
   switch(chooseMode){
     case 1:
       result =filechooser.showOpenDialog(currentFrame);
//�����ļ��򿪶Ի���ģʽѡ���ļ�
       break;
     case 2:
        result=filechooser.showOpenDialog(currentFrame);
      //�����ļ�����Ի���ģʽѡ���ļ�
        break;
   }
   if(result==filechooser.CANCEL_OPTION) return null;
   File fileName=filechooser.getSelectedFile();//�ӶԻ�����ѡ���ļ�����ֵ��fileName;
   return fileName;//����ѡ�����ļ���
  }
  
  public void saveFile(File file,int saveMode) throws IOException{
    //�����ļ�fileName��saveMode�Ǳ����ļ�ģʽ��
    //1���½��ļ��ı��棻2�����޸ĵ������ļ����棻    
    File fileName=null;
    switch(saveMode){
      case 0:fileName=chooseFile(2);
             if(fileName.createNewFile()!=true) return;
             break;
      case 1:fileName=file;break;
      default:return;
    }    
    currentFile=fileName;
    if(fileName.exists()!=true) return;//�ļ������ڣ��򷵻أ�
      BufferedWriter input=new BufferedWriter(new FileWriter(fileName));
      //���ļ�fileNameд�뵽�ַ�����д����input�У�
      input.write(buffer.toString(),0,buffer.length()-1);
//��buffer�ַ���д�뵽�ַ�����д����input��
      System.err.println(buffer.length());
      if(input!=null)
         input.close();
     status=1;
  }
  
  public void showFile(File fileName,DisplayFrame contentFrame){
    //��ָ���ļ�fileName�������ڴ���contentFrame����ʾ������
    try{
       BufferedReader output=new BufferedReader(new FileReader(fileName));
       //���ļ�fileName�����ַ������ȡ��output�У�
       String text;
       buffer=new StringBuffer();
       while((text=output.readLine())!=null)//���η����ļ���ÿһ�У�
       buffer.append(text+"\n");//��ÿһ����ӵ�buffer�У�

       contentFrame.displayArea.setText(buffer.toString());
//��buffer���ַ�����contentFrame��������ʾ������
contentFrame.setTitle(fileName.getName());//�ı䴰�ڵı��⣻
       output.close();//�ر��ַ�������output;
       }
       catch(IOException ex){
         JOptionPane.showMessageDialog(null,"��������");
       }
       catch(NullPointerException ex3){
         JOptionPane.showMessageDialog(null,"���棡");
       }
  }
  
  public static void main(String[] args) {
    TextEditor texteditor = new TextEditor();
    texteditor.setSize(400,300);
    texteditor.setVisible(true);
    texteditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }//end main
  
  class NewFileListener implements ActionListener{
  public void actionPerformed(ActionEvent e){//�½�
        DisplayFrame txtFrame=new DisplayFrame();
        currentFrame=txtFrame;
txtFrame.setTitle("�½��ļ�");
        desktopPane.add(txtFrame);
        status=0;
  }
}//end class newFileListener;

class OpenFileListener implements ActionListener{
   public void actionPerformed(ActionEvent e){//���ļ����ӽӿڣ�
   File fileName=chooseFile(1);//��ģʽ���ļ���
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
     public void actionPerformed(ActionEvent e){//���洦��
       if (e.getSource() == saveItem) {
         try {
           saveFile(currentFile, status);
         }
         catch (IOException ex) {
           JOptionPane.showMessageDialog(null, "�����ļ�ʧ�ܣ�������");
         }
         catch(Exception ex){ }
       }
     }
   }//end class SaveFileListener;
   
  class OtherSaveFileListener implements ActionListener{
    public void actionPerformed(ActionEvent e){//��洦��
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
          currentFrame.dispose();//��Դ�ļ���ʾ���ڹرգ�
          DisplayFrame contentFrame=new DisplayFrame();
          desktopPane.add(contentFrame);//�����µ���ʾ���ڣ�
          currentFrame=contentFrame;//�´�������Ϊ��ǰ��ʾ���ڣ�
          currentFile=fileName;
          showFile(fileName,contentFrame);
//�ڴ���contentFrame����ʾ�ļ�fileName;
       }catch(IOException ex){
        JOptionPane.showMessageDialog(null,"�ļ����ʧ�ܣ�������");
      }
     }//end outer if
    }//end actionPerformed method;
  }//end class OtherSaveListener;
  
  class DisplayFrame extends JInternalFrame implements DocumentListener{
   JTextArea displayArea;
   public DisplayFrame() {
   super("�ı�����:", true, true, true, true);
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