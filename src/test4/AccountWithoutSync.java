package test4;

public class AccountWithoutSync
{
  private Account bank = new Account();
  private Thread[] thread = new Thread[5];

  public static void main(String[] args)
  {
    AccountWithoutSync test = new AccountWithoutSync();
    System.out.println("最后存款是:  " + test.bank.getBalance());
  }

  public AccountWithoutSync()
  {
    for (int i=0; i<5; i++)
    {
      thread[i] = new Thread(new PayInThread("线程"+i));
      thread[i].start();
    }
  }

  class PayInThread extends Thread
  {
	  public PayInThread(String name){
		  super(name);
		  System.out.println("创建"+name);
	  }
    public void run()
    {
      int balance;
      balance = bank.getBalance();
      System.err.println(getName()+"取出存款"+balance);
      balance = bank.getBalance() + 1;
    

      try
      {
        Thread.sleep(10);
      }
      catch (InterruptedException ex)
      {
        System.out.println(ex);
      }

      bank.setBalance(balance);
      System.err.println(getName()+"增加存款为"+balance);

    }
  }
}

class Account
{
  private int balance = 0;

  public int getBalance()
  {
    return balance;
  }

  public void setBalance(int balance)
  {
    this.balance = balance;
  }
}
