package test3;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class PasswordVerification extends JFrame implements ActionListener{

JLabel userLabel;//�����û���ǩ��ʾ
JLabel passwordLabel;//���������ǩ��ʾ
JTextField userText;//�����û��ı���
JPasswordField passwordText;//���������ı���

int count=1;//ͳ��������Ϣ�Ĵ���

public PasswordVerification() {
super("��������Ϣ");

Container container=getContentPane();//�õ���������container��
container.setLayout(new FlowLayout());//����Ĭ�ϲ���

userLabel=new JLabel("�û���");//�����û���ǩ
passwordLabel=new JLabel("����");//���������ǩ
userText=new JTextField(10);//�����û��ı������
passwordText=new JPasswordField(10);//�������������ı���
passwordText.setEchoChar('#');
passwordText.addActionListener(this);//ע���¼�������;


container.add(userLabel);
container.add(userText);
container.add(passwordLabel);
container.add(passwordText);

setSize(240,100);
setVisible(true);
}

public void actionPerformed(ActionEvent e){//�¼�����
String userName=new String("����");//����Ϊ��ȷ���û���;
String password=new String("12345678");//����Ϊ��ȷ�����룻

if(e.getSource()==passwordText){
count++;
char[] passwords=passwordText.getPassword();
if(userText.getText().equals(userName)&&password.equals(new String(passwords)))
{
JOptionPane.showMessageDialog(null, "��ӭ��:" + userName);
System.exit(0);
}
else if(count>3)
System.exit(0);
else{
JOptionPane.showMessageDialog(null,userText.getText()+"��������ȷ��Ϣ");
userText.setText("");
passwordText.setText("");
}
}
}

public static void main(String args[]){
PasswordVerification pv=new PasswordVerification();
System.exit(0);
pv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
} 
}