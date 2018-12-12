package test3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ArtFont extends JFrame implements ActionListener{
  JComboBox fontType,fontSize;
  JCheckBox boldBx;//���尴ť
  JCheckBox italicBx;//б�尴ť
  JButton colorBtn;//��ɫ��ť��
  String[] fontNames;//��������;
  String[] fontSizes;//����ߴ磻

  JLabel label;//������ʾ��ǩ��
  JTextField inputText;//���������
  JTextArea txtArea;//������ʾ��;
  JPanel fontPanel;//�������ã�
  JPanel showPanel;//��ʾЧ����

  Font font;
  int boldStyle,italicStyle,underlineStyle;
  int fontSizeStyle;
  String fontNameStyle;
  Color colorStyle=Color.black;//���������Ĭ����ɫΪ��ɫ;

  public ArtFont() {
    super("��������");
    //����Ĭ������
    boldStyle=0;
    italicStyle=0;
    underlineStyle=0;
    fontSizeStyle=10;
    fontNameStyle="����";
    font=new Font(fontNameStyle,boldStyle+italicStyle,fontSizeStyle);

    fontPanel=new JPanel();
    fontPanel.setLayout(new FlowLayout());
    //������������
    GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
    fontNames=ge.getAvailableFontFamilyNames();//���ϵͳ��������������֣�
    fontType=new JComboBox(fontNames);
    fontType.setEditable(false);
    fontType.setMaximumRowCount(10);
    fontType.addItemListener(new ItemListener(){
      public void itemStateChanged(ItemEvent e){
//ʵ�ּ����������ָı���¼�
        int num=new Integer(fontSize.getSelectedItem().toString()).intValue();
        font = new Font (fontType.getSelectedItem().toString(),Font.PLAIN,num);
        txtArea.setFont(font);
      }
    });

    //���������С
    fontSizes=new String[63];
    for(int i=0;i<63;i++){
      fontSizes[i]=Integer.toString((i+10));
    }
    fontSize=new JComboBox(fontSizes);
    fontSize.setEditable(false);
    fontSize.setMaximumRowCount(10);
    fontSize.addItemListener(new ItemListener(){
      public void itemStateChanged(ItemEvent e){
//ʵ�ּ��������С�ı�ķ���
        int num =new Integer(fontSize.getSelectedItem().toString()).intValue();
        font =new Font(fontType.getSelectedItem().toString(),Font.PLAIN,num);
        txtArea.setFont(font);
      }
    });

    //���ô���ѡ��ť��
    boldBx=new JCheckBox("����");
    boldBx.addItemListener(new ItemListener(){
     public void itemStateChanged(ItemEvent e){
//ʵ�ּ���ѡ�����״̬�ı�ķ���
    	 int num =new Integer(fontSize.getSelectedItem().toString()).intValue();
    	 if(italicBx.isSelected()&&boldBx.isSelected()) {
         font =new Font(fontType.getSelectedItem().toString(),Font.ITALIC+Font.BOLD,num);
         txtArea.setFont(font);}
    	 else if (boldBx.isSelected()) {
    		 font = new Font(fontType.getSelectedItem().toString(),Font.BOLD,num);
    		 txtArea.setFont(font);
       }
     }
    });

    
    //����б��ѡ��ť��
    italicBx=new JCheckBox("б��");
    italicBx.addItemListener(new ItemListener(){
     public void itemStateChanged(ItemEvent e){
     //ʵ�ּ���ѡ��б��״̬�ı�ķ���
    	 int num =new Integer(fontSize.getSelectedItem().toString()).intValue();
    	 if(italicBx.isSelected()&&boldBx.isSelected()) {
         font =new Font(fontType.getSelectedItem().toString(),Font.ITALIC+Font.BOLD,num);
         txtArea.setFont(font);}
    	 else if (boldBx.isSelected()) {
    		 font = new Font(fontType.getSelectedItem().toString(),Font.ITALIC,num);
    		 txtArea.setFont(font);
       }
     }
     });
    //������ɫѡ��
    colorBtn=new JButton("��ɫ");
    colorBtn.addActionListener(this);
    //����������壻
    fontPanel.add(fontType);
    fontPanel.add(fontSize);
    fontPanel.add(boldBx);
    fontPanel.add(italicBx);
    fontPanel.add(colorBtn);

    //����������ʾ��ǩ
    label=new JLabel("����");
    //�����ı������
    inputText=new JTextField(30);
    inputText.addActionListener(this);
     //�����ı���ʾ����
    txtArea=new JTextArea(10,80);//20��80�У�
    txtArea.setFont(font);

    //�����ı����;
    showPanel=new JPanel();
    showPanel.add(label);
    showPanel.add(inputText);
    showPanel.setLayout(new FlowLayout());
    showPanel.add(new JScrollPane(txtArea));
    //��������;
    Container container=getContentPane();
    container.setLayout(new BorderLayout());
    container.add(fontPanel,BorderLayout.NORTH);
    container.add(showPanel,BorderLayout.CENTER);
    setSize(500,300);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e){
   if(e.getSource()==colorBtn){//�ı���ɫ
     colorStyle=JColorChooser.showDialog(this,"ѡ��������ɫ",colorStyle);
     colorBtn.setForeground(colorStyle);
     txtArea.setForeground(colorStyle);
   }
   else if(e.getSource()==inputText){//������������������ʾ����ʾ��
     txtArea.setText(inputText.getText());
   }
  }
  public static void main(String args[]){
    ArtFont artFont=new ArtFont();
    artFont.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}