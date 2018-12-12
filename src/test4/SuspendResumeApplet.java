package test4;

import javax.swing.*; // Japplet
import java.util.*;   // Calendar
import java.awt.*;    // Graphics

public class SuspendResumeApplet extends JApplet implements Runnable
{
  Thread appletThread;
  boolean suspendFlag;
  Calendar time, suspendTime, resumeTime;
  int hours, mins, secs,
      sushours, susmins, sussecs,
      rehours, remins, resecs;

  public void init() {
    suspendFlag = false;
    appletThread = new Thread(this);
    appletThread.start();   //启动线程appletThread
  } 

  public void start() {
    resumeThread();
  } 
  public void stop( )  {
      suspendThread();
      suspendTime = time;
      sushours = suspendTime.get(Calendar.HOUR);
      susmins = suspendTime.get(Calendar.MINUTE); //获取分钟
      sussecs = suspendTime.get(Calendar.SECOND); //获取表
   }

   public  synchronized void resumeThread()
     {
      if (suspendFlag)
      {
      suspendFlag = false;
         notify();
         resumeTime = Calendar.getInstance();
         rehours = resumeTime.get(Calendar.HOUR);
         remins =  resumeTime.get(Calendar.MINUTE);
         resecs =  resumeTime.get(Calendar.SECOND);
      }
     }  
 /* private  void waitForNotificationToResume()
          throws InterruptedException
    {
      while (suspendFlag)
          wait();
    }  */

   public synchronized void suspendThread()
     {
       suspendFlag = true;
     }  
   public void run() {
	   synchronized(this){
		      while (suspendFlag)
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }  
	   
    while (true) {
      try {
        Thread.sleep(500);  //线程休眠500毫秒
       // waitForNotificationToResume();
      }
      catch ( InterruptedException exception ) {
         exception.printStackTrace();
      }
      time = Calendar.getInstance();
      hours = time.get(Calendar.HOUR);
      mins = time.get(Calendar.MINUTE);
      secs = time.get(Calendar.SECOND);
      System.out.println("秒表: " + secs);
      repaint();
    } 
  } 
  public void paint(Graphics g)
  {
    super.paint(g);
    g.drawString("当前时间: " +
                 String.valueOf(hours) + ":" +
                 String.valueOf(mins)  + ":" +
                 String.valueOf(secs), 50 , 50);
    g.drawString("挂起时间: " +
                 String.valueOf(sushours) + ":" +
                 String.valueOf(susmins)  + ":" +
                 String.valueOf(sussecs), 50 , 80);
    g.drawString("恢复时间: " +
                 String.valueOf(rehours) + ":" +
                 String.valueOf(remins)  + ":" +
                 String.valueOf(resecs), 50 , 100);
  }  
}