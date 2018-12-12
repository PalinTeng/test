package test4;

public class AccountWithoutSync
{
  private Account bank = new Account();
  private Thread[] thread = new Thread[5];

  public static void main(String[] args)
  {
    AccountWithoutSync test = new AccountWithoutSync();
    System.out.println("�������:  " + test.bank.getBalance());
  }

  public AccountWithoutSync()
  {
    for (int i=0; i<5; i++)
    {
      thread[i] = new Thread(new PayInThread("�߳�"+i));
      thread[i].start();
    }
  }

  class PayInThread extends Thread
  {
	  public PayInThread(String name){
		  super(name);
		  System.out.println("����"+name);
	  }
    public void run()
    {
      int balance;
      balance = bank.getBalance();
      System.err.println(getName()+"ȡ�����"+balance);
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
      System.err.println(getName()+"���Ӵ��Ϊ"+balance);

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
