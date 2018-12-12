package test2;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class CardManagement2 extends JFrame implements ActionListener{

 JLabel nameLabel,sexLabel,titleLabel,unitLabel;
  JLabel addressLabel,telLabel1,telLabel2,mobileLabel,faxLabel,emailLabel;
  JTextField nameTxt,unitTxt,addressTxt,telTxt1,telTxt2,mobileTxt,faxTxt,emailTxt;
  JRadioButton sexBtn1,sexBtn2;
  JComboBox titleBx;
   String title[]={"总裁","总经理","经理","主任","处长","院长","校长","科长","教授","讲师"};
  JButton firstBtn,nextBtn,addBtn,lastBtn,perBtn;
  JPanel centerPanel,sPanel;
  GridBagLayout layout;
  GridBagConstraints constraints;

  RandomAccessFile file;

  public CardManagement2() { 
	  super("名片管理");
    try{
      file=new RandomAccessFile("card.dat","rw");
      //利用RandomAccessFile，以读写方式打开文件card.dat
    }catch(IOException ex){
      System.err.println(ex.getMessage());
      System.exit(0);
//同程序清单14-7的构造方法； 
}//构造方法
    Container c=getContentPane();
    c.setLayout(new BorderLayout());
    layout=new GridBagLayout();
    centerPanel=new JPanel(layout);
    sPanel=new JPanel();
    setComponent();//设置在centerPanel和sPanel的组件; 
    c.add(centerPanel,BorderLayout.CENTER);
    c.add(sPanel,BorderLayout.SOUTH);

    pack();
    setVisible(true);
    }
  public void setComponent(){//设置GUI组件
  constraints=new GridBagConstraints();//创建网格包限制对象；
  nameLabel=new JLabel("姓名");
  nameTxt=new JTextField(10);
  addComponent(nameLabel,0,0,1,1);
  addComponent(nameTxt,0,1,1,2);

  sexLabel=new JLabel("性别");
  sexBtn1=new JRadioButton("男",false);
  sexBtn2=new JRadioButton("女",true);
  ButtonGroup group=new ButtonGroup();
  group.add(sexBtn1);
  group.add(sexBtn2);
  addComponent(sexLabel,0,4,1,1);
  addComponent(sexBtn1,0,5,1,1);
  addComponent(sexBtn2,0,6,1,1);

  titleLabel=new JLabel("称谓");

  titleBx=new JComboBox(title);
  titleBx.setMaximumRowCount(5);
  addComponent(titleLabel,0,7,1,1);
  addComponent(titleBx,0,8,1,1);

  unitLabel=new JLabel("工作单位");
  unitTxt=new JTextField(30);
  addComponent(unitLabel,1,0,1,1);
  addComponent(unitTxt,1,2,1,8);

  addressLabel=new JLabel("工作地址");
  addressTxt=new JTextField(30);
  addComponent(addressLabel,2,0,1,1);
  addComponent(addressTxt,2,2,1,8);

  telLabel1=new JLabel("电话");
  telTxt1=new JTextField(15);
  addComponent(telLabel1,3,0,1,1);
  addComponent(telTxt1,3,1,1,4);

  telLabel2=new JLabel("电话");
  telTxt2=new JTextField(15);
  addComponent(telLabel2,3,5,1,1);
  addComponent(telTxt2,3,6,1,4);

  mobileLabel=new JLabel("手机");
  mobileTxt=new JTextField(15);
  addComponent(mobileLabel,4,0,1,1);
  addComponent(mobileTxt,4,1,1,4);

  faxLabel=new JLabel("传真");
  faxTxt=new JTextField(15);
  addComponent(faxLabel,4,5,1,1);
  addComponent(faxTxt,4,6,1,4);

  emailLabel=new JLabel("E-mail");
  emailTxt=new JTextField(32);
  addComponent(emailLabel,5,0,1,1);
  addComponent(emailTxt,5,1,1,8);

  firstBtn=new JButton("第一个");
  firstBtn.addActionListener(this);
  nextBtn=new JButton("下一个");
  nextBtn.addActionListener(this);
  addBtn=new JButton("添加记录");
  addBtn.addActionListener(this);
  perBtn=new JButton("上一个");
  perBtn.addActionListener(this);
  lastBtn=new JButton("最后一个");
  lastBtn.addActionListener(this);
  
		  
  
  sPanel.add(addBtn);
  sPanel.add(firstBtn);
  sPanel.add(nextBtn);
  sPanel.add(perBtn);
  sPanel.add(lastBtn);
  }//end of 设置组件

  void addComponent(Component component, int col, int row,int height,int width){
	//将组件component放置到行row列col，占据宽width高height的位置；
	   constraints.gridx=row;
	   constraints.gridy=col;
	  
	   constraints.gridwidth=width;
	   constraints.gridheight=height;
	  
	   constraints.fill=GridBagConstraints.BOTH;
	  
	   constraints.weightx=100;
	   constraints.weighty=200;
	  
	   layout.setConstraints(component,constraints);
	   centerPanel.add(component);
	 }


  public void clearCardGUI(){
    nameTxt.setText("");
    unitTxt.setText("");
    addressTxt.setText("");
    telTxt1.setText("");
    telTxt2.setText("");
    mobileTxt.setText("");
    faxTxt.setText("");
    emailTxt.setText("");
  }

  public void writeCard() throws IOException{//将记录写入文件；
	   file.seek(file.length());//指向文件的尾部
	   file.writeChars(nameTxt.getText()+"\n");
	   if(sexBtn1.isSelected())
	    file.writeInt(1);
	   else
	   file.writeInt(2);
	   file.writeInt(titleBx.getSelectedIndex());
	   file.writeChars(unitTxt.getText()+"\n");
	   file.writeChars(addressTxt.getText()+"\n");
	   file.writeChars(telTxt1.getText()+"\n");
	   file.writeChars(telTxt2.getText()+"\n");
	   file.writeChars(mobileTxt.getText()+"\n");
	   file.writeChars(faxTxt.getText()+"\n");
	   file.writeChars(emailTxt.getText()+"\n");
	   }//end of writeCard;
	  public void readCard(long position)throws IOException{
		//读记录position所指的记录；
		file.seek(position);//确定文件指针的位置
		file.readUTF();
		file.readInt();
		file.readInt();
		file.readUTF();
		file.readUTF();
		file.readUTF();
		file.readUTF();
		file.readUTF();
		file.readUTF();
		file.readUTF();
		}

  public void actionPerformed(ActionEvent e){

    try{
      if(e.getSource()==addBtn){
      writeCard();
      clearCardGUI();
      }
      else if(e.getSource()==firstBtn){
        if(file.length()>0)
        readCard(0);
      }
      else if(e.getSource()==nextBtn){
       long currentPosition=file.getFilePointer();
       if(currentPosition<file.length())
         readCard(currentPosition);
     }
      else if(e.getSource()==perBtn){
    	  long currentPosition=file.getFilePointer();
    	      if(currentPosition==0)
    	    readCard(currentPosition);
    	      else{
    	         readCard(currentPosition-1);
    	         }
    	  }
    	  else if(e.getSource()==lastBtn){
    	  long currentPosition=file.getFilePointer();
    	  if(currentPosition==file.length())
    	         readCard(currentPosition);
    	  else{
    	         long length=file.length();
    	         readCard(length);
    	      }
     
    }
    }catch(IOException ex){
      System.err.println("写入/读取数据失败");
  }
  }//end of actioniPerformed

  public static void main(String[] args) {
    CardManagement2 card = new CardManagement2();
    card.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }//end of main
}
