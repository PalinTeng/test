package test4;

public class FourThreads {

	   public static void main( String [] args ) throws InterruptedException
	   {
	      MyThread thread1 = new MyThread( "thread1" );
	      MyThread thread2 = new MyThread( "thread2" );
	      MyThread thread3 = new MyThread( "thread3" );
	      MyThread thread4 = new MyThread( "thread4" );

	      System.err.println( "׼�������߳�..." );

	      thread1.start();
	      thread2.start();
	      thread3.start();
	      thread4.start(); 
	      try {
	    	  while(thread1.isAlive()||thread2.isAlive()||thread3.isAlive()||thread4.isAlive()) {
	      
	    		  Thread.sleep(2000);
	    		  }
	      }catch(Exception e) {}
	      System.err.println( "���߳���ȫ�����������߳̽���\n" );
	   }
	}

	class MyThread extends Thread {
	   private int sleepTime;

	   public MyThread( String name )
	   {
	      super( name );

	      // �������ʱ����0--5��֮��
	     // sleepTime = ( int ) ( Math.random() * 5001 );
	      sleepTime = 2000;
	   }
   public void run()
	   {
	     //���߳̽�������״̬������ָ����ʱ��
	      try {
	         System.err.println(
	            getName() + " ������" + sleepTime + "����");

	         Thread.sleep( sleepTime );
	      }

	      catch ( InterruptedException exception ) {
	         exception.printStackTrace();
	      }

	      System.err.println( getName() + " ��������" );
	      
	   }
	}