package test3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Cardmanager extends JFrame{
JLabel nameLabel,sexLabel,titleLabel,unitLabel;
JLabel addressLabel,telLabel1,telLabel2,mobileLabel,faxLabel,emailLabel;
JTextField nameTxt,unitTxt,addressTxt;
JTextField telTxt1,telTxt2,mobileTxt,faxTxt,emailTxt;
JRadioButton sexBtn1,sexBtn2;
JComboBox titleBx;
JButton okBtn,cancelBtn;

public Cardmanager() {
super("名片录入管理");
Container c=getContentPane();
JPanel centerPanel=new JPanel();//输入面板
nameLabel=new JLabel("姓名");//定义姓名标签
nameTxt=new JTextField(10);//定义姓名文本输入框
centerPanel.add(nameLabel);
centerPanel.add(nameTxt);

sexLabel=new JLabel("性别");//定义性别标签
sexBtn1=new JRadioButton("男");//定义性别单选按钮1
sexBtn2=new JRadioButton("女");//定义性别单选按钮2
ButtonGroup group=new ButtonGroup();
group.add(sexBtn1);
group.add(sexBtn2);
centerPanel.add(sexLabel);
centerPanel.add(sexBtn1);
centerPanel.add(sexBtn2);

titleLabel=new JLabel("称谓");//定义称谓标签
String title[]={"总裁","总经理","经理","主任","处长","院长","校长","科长","教授","讲师"};//定义称谓内容
titleBx=new JComboBox(title);//创建称谓文本输入框
titleBx.setMaximumRowCount(5);
centerPanel.add(titleLabel);
centerPanel.add(titleBx);

unitLabel=new JLabel("工作单位");//定义工作单位标签
unitTxt=new JTextField(30);//定义工作单位输入框
centerPanel.add(unitLabel);
centerPanel.add(unitTxt);

addressLabel=new JLabel("工作地址");//定义工作地址标签
addressTxt=new JTextField(30); //定义工作地址输入框
centerPanel.add(addressLabel);
centerPanel.add(addressTxt);

telLabel1=new JLabel("电话");//定义电话1标签
telTxt1=new JTextField(15);//定义电话1输入框
centerPanel.add(telLabel1);
centerPanel.add(telTxt1);

telLabel2=new JLabel("电话");//定义电话2标签
telTxt2=new JTextField(15); //定义电话2输入框
centerPanel.add(telLabel2);
centerPanel.add(telTxt2);

mobileLabel=new JLabel("手机");//定义手机标签
mobileTxt=new JTextField(15); //定义手机输入框
centerPanel.add(mobileLabel);
centerPanel.add(mobileTxt);

faxLabel=new JLabel("传真");//定义传真标签
faxTxt=new JTextField(15);//定义传真输入框
centerPanel.add(faxLabel);
centerPanel.add(faxTxt);

emailLabel=new JLabel("E-mail");//定义email标签
emailTxt=new JTextField(32);//定义email输入框
centerPanel.add(emailLabel);
centerPanel.add(emailTxt);

JPanel sPanel=new JPanel();//按钮面板
okBtn=new JButton("确定");//定义确定按钮
cancelBtn=new JButton("取消");//定义取消按钮
cancelBtn.addActionListener(new ActionListener() {//监视cancelBtn的动作
public void actionPerformed(ActionEvent e){
if(e.getSource()==cancelBtn){//判断事件源是否是cancelBtn;
System.exit(0);
}
}
});
sPanel.add(okBtn);
sPanel.add(cancelBtn);

c.setLayout(new BorderLayout());
c.add(centerPanel,BorderLayout.CENTER);//将centerPanel放置c中的中间位置；
c.add(sPanel,BorderLayout.SOUTH);//将sPanel 放置c中的南面的位置；

setSize(1000,400);
setVisible(true);
}

public static void main(String args[]){
Cardmanager cm=new Cardmanager();
cm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
