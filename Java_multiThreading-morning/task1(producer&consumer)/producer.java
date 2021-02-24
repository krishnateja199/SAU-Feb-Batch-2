import java.util.Scanner;

public class producer {
    public static void main(String args[])
    {
        final Consumer c= new Consumer();
        Thread t1=new Thread()
        {
            public void run()
            {
               // System.out.println("enter amount to withdraw");
                //Scanner s=new Scanner(System.in);
                //int am=s.nextInt();

                // Amount is being withdraw
                c.withdraw(5000);

                System.out.println("After withdraw the amount is :" + c.amount);
            }
        };

        Thread t2=new Thread()
        {
            public void run(){
               // System.out.println("enter amount to deposite");
                //Scanner s=new Scanner(System.in);
                //int am=s.nextInt();
                c.deposite(10000);
                System.out.println("After deposite Amount is: "+c.amount);
        }
        };
        // Inter thread communication between threads ,also called as producer and consumer
        // consumer will wait untill , the producer produces (int consumer class - withdraw )


        t1.start();
        t2.start();

    }
}
