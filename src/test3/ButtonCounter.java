package test3;

import javax.swing.*;
import java.awt.*;

public class ButtonCounter extends JFrame {

   public ButtonCounter() {
     super("显示按钮窗口");
     ImageIcon Icon = new ImageIcon("image/image.gif");
     
     Button jbt1 = new Button("按钮");
     JButton jbt2 = new JButton("2按钮",Icon);
     JButton jbt3 = new JButton("3按钮",Icon);
     JButton jbt4 = new JButton("4按钮",Icon);
     JButton jbt5 = new JButton("5按钮",Icon);
          
     JPanel p1 = new JPanel();
     p1.add(jbt1);
     JPanel p2 = new JPanel();
    p2.add(jbt2);
     JPanel p3 = new JPanel();
     p2.add(jbt3);
     JPanel p4=new JPanel();
     p4.add(jbt4);
    JPanel p5=new JPanel();
    p5.add(jbt5);
     getContentPane().setLayout(new FlowLayout());
     getContentPane().add(p1); 
     getContentPane().add(p2);
     getContentPane().add(p3);
     getContentPane().add(p4);
  getContentPane().add(p5);
   }

   public static void main(String[] args) {
     // Create a frame and set its properties
     JFrame frame = new ButtonCounter();
     frame.pack();
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
   }
}