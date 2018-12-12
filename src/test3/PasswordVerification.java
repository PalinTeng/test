package test3;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class PasswordVerification extends JFrame implements ActionListener{

JLabel userLabel;//定义用户标签提示
JLabel passwordLabel;//定义密码标签提示
JTextField userText;//定义用户文本框
JPasswordField passwordText;//定义密码文本框

int count=1;//统计输入信息的次数

public PasswordVerification() {
super("请输入信息");

Container container=getContentPane();//得到容器对象container；
container.setLayout(new FlowLayout());//设置默认布局

userLabel=new JLabel("用户名");//创建用户标签
passwordLabel=new JLabel("密码");//创建密码标签
userText=new JTextField(10);//创建用户文本输入框
passwordText=new JPasswordField(10);//创建密码输入文本框
passwordText.setEchoChar('#');
passwordText.addActionListener(this);//注册事件监听者;


container.add(userLabel);
container.add(userText);
container.add(passwordLabel);
container.add(passwordText);

setSize(240,100);
setVisible(true);
}

public void actionPerformed(ActionEvent e){//事件处理
String userName=new String("陈三");//假设为正确的用户名;
String password=new String("12345678");//假设为正确的密码；

if(e.getSource()==passwordText){
count++;
char[] passwords=passwordText.getPassword();
if(userText.getText().equals(userName)&&password.equals(new String(passwords)))
{
JOptionPane.showMessageDialog(null, "欢迎您:" + userName);
System.exit(0);
}
else if(count>3)
System.exit(0);
else{
JOptionPane.showMessageDialog(null,userText.getText()+"请输入正确信息");
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