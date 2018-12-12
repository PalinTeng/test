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
	      thread[i] = new Thread(g,new PayInThread("线程" + i));
	      thread[i].start();
	    }
	   while(!done)
	   if(g.activeCount()==0) done = true;
	  }
	
  private Account bank = new Account();

  public static void main(String[] args)
  {
    AccountWithSync test = new AccountWithSync();
    System.out.println("最后存款是: " + test.bank.getBalance());
  }
  
  private  void deposit(Account bank,String threadName)
  {synchronized(this) {
    int balance;

    balance = bank.getBalance();
    System.err.println(threadName + "取出存款为" + balance);
    balance = balance + 1;

    try {
       Thread.sleep(10);
    }
    catch (InterruptedException ex) {
      System.out.println(ex);
    }

    bank.setBalance(balance);
    System.err.println(threadName + "增加存款为" + balance);
  }
  }
  class PayInThread extends Thread
  {
    public PayInThread( String name ) {
     super(name);
     System.err.println("创建" + name);
    }

    public void run( ) {
      deposit(bank,getName());
    }
  }
}