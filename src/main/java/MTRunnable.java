public class MTRunnable {
    public static void main(String[] args) throws InterruptedException {
       /*
       //Use this when u dont declare a static class, this is object referance
        MTRunnable ob = new MTRunnable();
        MyThread obj1= ob.new MyThread();

        */

        MyThread obj1= new MyThread();
        //obj1.start--> this will not work because its not extending thread, hence we have to create an obj of thread
        //Initailizes the constructor and calls run
        Thread thread= new Thread(obj1);
        thread.start();
        System.out.println("I am in the thread"+Thread.currentThread().getName());

    }

    //You can use IRunnable when u want to extent someother class, because Java will not allow multiple inheritance
    //If we dont use statis, in main , we have to create a obj, if we write statis, we can directly call
//second way of creating a thread, implement runnable, or extend thread
    private static class MyThread extends BankObj implements Runnable {
       // extends BankObj extents Thread --> will not work

        public void run() {
            System.out.println("I am in the thread"+Thread.currentThread().getName());

        }
        //implements , you have to override all the ethods present in the infterface


    }
}
