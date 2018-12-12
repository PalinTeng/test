package test3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ArtFont extends JFrame implements ActionListener{
  JComboBox fontType,fontSize;
  JCheckBox boldBx;//粗体按钮
  JCheckBox italicBx;//斜体按钮
  JButton colorBtn;//颜色按钮；
  String[] fontNames;//字体名称;
  String[] fontSizes;//字体尺寸；

  JLabel label;//输入提示标签；
  JTextField inputText;//文字输入框；
  JTextArea txtArea;//文字显示区;
  JPanel fontPanel;//字体设置；
  JPanel showPanel;//显示效果区

  Font font;
  int boldStyle,italicStyle,underlineStyle;
  int fontSizeStyle;
  String fontNameStyle;
  Color colorStyle=Color.black;//设置字体的默认颜色为黑色;

  public ArtFont() {
    super("字体设置");
    //设置默认字体
    boldStyle=0;
    italicStyle=0;
    underlineStyle=0;
    fontSizeStyle=10;
    fontNameStyle="宋体";
    font=new Font(fontNameStyle,boldStyle+italicStyle,fontSizeStyle);

    fontPanel=new JPanel();
    fontPanel.setLayout(new FlowLayout());
    //设置字体名字
    GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
    fontNames=ge.getAvailableFontFamilyNames();//获得系统中所有字体的名字；
    fontType=new JComboBox(fontNames);
    fontType.setEditable(false);
    fontType.setMaximumRowCount(10);
    fontType.addItemListener(new ItemListener(){
      public void itemStateChanged(ItemEvent e){
//实现监听字体名字改变的事件
        int num=new Integer(fontSize.getSelectedItem().toString()).intValue();
        font = new Font (fontType.getSelectedItem().toString(),Font.PLAIN,num);
        txtArea.setFont(font);
      }
    });

    //设置字体大小
    fontSizes=new String[63];
    for(int i=0;i<63;i++){
      fontSizes[i]=Integer.toString((i+10));
    }
    fontSize=new JComboBox(fontSizes);
    fontSize.setEditable(false);
    fontSize.setMaximumRowCount(10);
    fontSize.addItemListener(new ItemListener(){
      public void itemStateChanged(ItemEvent e){
//实现监听字体大小改变的方法
        int num =new Integer(fontSize.getSelectedItem().toString()).intValue();
        font =new Font(fontType.getSelectedItem().toString(),Font.PLAIN,num);
        txtArea.setFont(font);
      }
    });

    //设置粗体选择按钮；
    boldBx=new JCheckBox("粗体");
    boldBx.addItemListener(new ItemListener(){
     public void itemStateChanged(ItemEvent e){
//实现监听选择粗体状态改变的方法
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

    
    //设置斜体选择按钮；
    italicBx=new JCheckBox("斜体");
    italicBx.addItemListener(new ItemListener(){
     public void itemStateChanged(ItemEvent e){
     //实现监听选择斜体状态改变的方法
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
    //设置颜色选择；
    colorBtn=new JButton("颜色");
    colorBtn.addActionListener(this);
    //设置字体面板；
    fontPanel.add(fontType);
    fontPanel.add(fontSize);
    fontPanel.add(boldBx);
    fontPanel.add(italicBx);
    fontPanel.add(colorBtn);

    //设置输入提示标签
    label=new JLabel("输入");
    //设置文本输入框；
    inputText=new JTextField(30);
    inputText.addActionListener(this);
     //设置文本显示区；
    txtArea=new JTextArea(10,80);//20行80列；
    txtArea.setFont(font);

    //设置文本面板;
    showPanel=new JPanel();
    showPanel.add(label);
    showPanel.add(inputText);
    showPanel.setLayout(new FlowLayout());
    showPanel.add(new JScrollPane(txtArea));
    //设置容器;
    Container container=getContentPane();
    container.setLayout(new BorderLayout());
    container.add(fontPanel,BorderLayout.NORTH);
    container.add(showPanel,BorderLayout.CENTER);
    setSize(500,300);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e){
   if(e.getSource()==colorBtn){//改变颜色
     colorStyle=JColorChooser.showDialog(this,"选择字体颜色",colorStyle);
     colorBtn.setForeground(colorStyle);
     txtArea.setForeground(colorStyle);
   }
   else if(e.getSource()==inputText){//将输入文字在文字显示区表示；
     txtArea.setText(inputText.getText());
   }
  }
  public static void main(String args[]){
    ArtFont artFont=new ArtFont();
    artFont.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}