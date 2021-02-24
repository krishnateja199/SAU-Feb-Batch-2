public class Consumer
{
    int amount=0;
    int balance=0;
    public synchronized int withdraw(int amount)
    {
        //Thread which is going to withdraw
        System.out.println(Thread.currentThread().getName()+"is going to withdraw");
        if(balance==0)
        {
            try{
                System.out.println("wait ");
                Thread.sleep(1000);
                wait();
                // As two threads are started at a time,when the thread try to access the amount before it gets
                //deposited , it waits untill the amount gets deposited

            }
            catch(InterruptedException e)
            {
                System.out.println("Interrupted exception has occured");
            }
        }
        //remaining amount
        this.amount-=amount;
        System.out.println("Withdrawal amount is "+amount);
        System.out.println("Withdrawal is completed");
        return amount;
    }
    public synchronized void deposite(int amount){
        //deposited method,thread gets notification when amount gets deposited
        //Thread which is going to deposite
        System.out.println(Thread.currentThread().getName()+" going to deposite");
        this.amount+=amount;
        notify();
        System.out.println("deposited amount is :"+" "+ amount);
        System.out.println("Deposite is completed");
        // After the desposite
    }
}
