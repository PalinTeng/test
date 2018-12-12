package test4;

public class AccountWithSync
{
	public  AccountWithSync()
	  {
	    ThreadGroup g = new ThreadGroup("group");
	    Boolean done = false;
	    Thread[] thread = new Thread[5];
	    for (int i=0; i<5; i++)
	    {
	      thread[i] = new Thread(g,new PayInThread("�߳�" + i));
	      thread[i].start();
	    }
	   while(!done)
	   if(g.activeCount()==0) done = true;
	  }
	
  private Account bank = new Account();

  public static void main(String[] args)
  {
    AccountWithSync test = new AccountWithSync();
    System.out.println("�������: " + test.bank.getBalance());
  }
  
  private  void deposit(Account bank,String threadName)
  {synchronized(this) {
    int balance;

    balance = bank.getBalance();
    System.err.println(threadName + "ȡ�����Ϊ" + balance);
    balance = balance + 1;

    try {
       Thread.sleep(10);
    }
    catch (InterruptedException ex) {
      System.out.println(ex);
    }

    bank.setBalance(balance);
    System.err.println(threadName + "���Ӵ��Ϊ" + balance);
  }
  }
  class PayInThread extends Thread
  {
    public PayInThread( String name ) {
     super(name);
     System.err.println("����" + name);
    }

    public void run( ) {
      deposit(bank,getName());
    }
  }
}