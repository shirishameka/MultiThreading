public class BankOperatons {
    public static void main(String[] args) throws InterruptedException {
        BankObj obj1=new BankObj(1,200);
        BankObj obj2=new BankObj(2,100);

        //three threads will operate on obj1 and 3 threads will operate on obj2
        MyThread[] threads=new MyThread[6];
        threads[0]= new MyThread(obj1,true,100);
        threads[1]= new MyThread(obj1,false,150);
        threads[2]= new MyThread(obj1,true,50);
        //200 is the result for obj1

        threads[3]= new MyThread(obj2,false,50);
        threads[4]= new MyThread(obj2,true,200);
        threads[5]= new MyThread(obj2,false,100);
        //150 is the result of the obj2

        for(int i=0 ; i<6;i++){
            threads[i].start();
        }

        for(int i=0 ; i<6; i++){
            threads[i].join();

        }
        System.out.println("Balance for obj1  " + obj1.getBalance());
        System.out.println("Balance for obj2  " + obj2.getBalance());



    }

    private static class MyThread extends Thread{
        private BankObj bankObj;

        public MyThread(BankObj bankObj, boolean isDeposite, int amount) {
            this.bankObj = bankObj;
            this.isDeposite = isDeposite;
            this.amount = amount;
        }

        boolean isDeposite;
        private int amount;

        @Override
        public void run() {
            if(this.isDeposite){
                try {
                    deposite();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    withdraw();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void deposite() throws InterruptedException {

        //    synchronized (BankObj.class)  --> this will delay the process for other threads , on syncronization on class then it will allow only on thread , this is a synchronization but not multithreading
            //Ex: in Bank , if we are using this , and putting a lock , menas we will bloack other users untill one person is done

            //this is block level synchronization
            //object level locking
            synchronized (this.bankObj) {
                Thread.sleep(1000);
                System.out.println("In Deposite function, obj name is :" + this.bankObj + "Thread name is :" + currentThread().getName());
                int prev_bal = this.bankObj.getBalance();
                int new_bal = prev_bal + this.amount;
                this.bankObj.setBalance(new_bal);
            }
        }

        private void withdraw() throws InterruptedException {
            // beacuse of this sleep we get different results
            Thread.sleep(3000);
            System.out.println("In Withdraw function, obj name is :" + this.bankObj+ "Thread name is :"+ currentThread().getName());
            int prev_bal= this.bankObj.getBalance();
            int new_bal= prev_bal- this.amount;
            this.bankObj.setBalance(new_bal);

        }


        /*
        synchronization can be block level or method level or class level

          //method level
          private synchronized void deposite() throws InterruptedException
          But this is not recommended as the we are not achieving multithreading
          therefore , its better to use block level
         */

    }
}
