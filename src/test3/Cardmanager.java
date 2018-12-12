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
super("��Ƭ¼�����");
Container c=getContentPane();
JPanel centerPanel=new JPanel();//�������
nameLabel=new JLabel("����");//����������ǩ
nameTxt=new JTextField(10);//���������ı������
centerPanel.add(nameLabel);
centerPanel.add(nameTxt);

sexLabel=new JLabel("�Ա�");//�����Ա��ǩ
sexBtn1=new JRadioButton("��");//�����Ա�ѡ��ť1
sexBtn2=new JRadioButton("Ů");//�����Ա�ѡ��ť2
ButtonGroup group=new ButtonGroup();
group.add(sexBtn1);
group.add(sexBtn2);
centerPanel.add(sexLabel);
centerPanel.add(sexBtn1);
centerPanel.add(sexBtn2);

titleLabel=new JLabel("��ν");//�����ν��ǩ
String title[]={"�ܲ�","�ܾ���","����","����","����","Ժ��","У��","�Ƴ�","����","��ʦ"};//�����ν����
titleBx=new JComboBox(title);//������ν�ı������
titleBx.setMaximumRowCount(5);
centerPanel.add(titleLabel);
centerPanel.add(titleBx);

unitLabel=new JLabel("������λ");//���幤����λ��ǩ
unitTxt=new JTextField(30);//���幤����λ�����
centerPanel.add(unitLabel);
centerPanel.add(unitTxt);

addressLabel=new JLabel("������ַ");//���幤����ַ��ǩ
addressTxt=new JTextField(30); //���幤����ַ�����
centerPanel.add(addressLabel);
centerPanel.add(addressTxt);

telLabel1=new JLabel("�绰");//����绰1��ǩ
telTxt1=new JTextField(15);//����绰1�����
centerPanel.add(telLabel1);
centerPanel.add(telTxt1);

telLabel2=new JLabel("�绰");//����绰2��ǩ
telTxt2=new JTextField(15); //����绰2�����
centerPanel.add(telLabel2);
centerPanel.add(telTxt2);

mobileLabel=new JLabel("�ֻ�");//�����ֻ���ǩ
mobileTxt=new JTextField(15); //�����ֻ������
centerPanel.add(mobileLabel);
centerPanel.add(mobileTxt);

faxLabel=new JLabel("����");//���崫���ǩ
faxTxt=new JTextField(15);//���崫�������
centerPanel.add(faxLabel);
centerPanel.add(faxTxt);

emailLabel=new JLabel("E-mail");//����email��ǩ
emailTxt=new JTextField(32);//����email�����
centerPanel.add(emailLabel);
centerPanel.add(emailTxt);

JPanel sPanel=new JPanel();//��ť���
okBtn=new JButton("ȷ��");//����ȷ����ť
cancelBtn=new JButton("ȡ��");//����ȡ����ť
cancelBtn.addActionListener(new ActionListener() {//����cancelBtn�Ķ���
public void actionPerformed(ActionEvent e){
if(e.getSource()==cancelBtn){//�ж��¼�Դ�Ƿ���cancelBtn;
System.exit(0);
}
}
});
sPanel.add(okBtn);
sPanel.add(cancelBtn);

c.setLayout(new BorderLayout());
c.add(centerPanel,BorderLayout.CENTER);//��centerPanel����c�е��м�λ�ã�
c.add(sPanel,BorderLayout.SOUTH);//��sPanel ����c�е������λ�ã�

setSize(1000,400);
setVisible(true);
}

public static void main(String args[]){
Cardmanager cm=new Cardmanager();
cm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
