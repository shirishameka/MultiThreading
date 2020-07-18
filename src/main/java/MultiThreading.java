public class MultiThreading {
    public static void main(String[] args) throws InterruptedException {
     MyThread obj1= new MyThread();
     //It means whenever main thread stops, stop Mythread also
        //Usecase:Your creating a temp file, after sometime delete automaticaly not to hamper application
        //Usecase2: Mythread has a heavy computation , and thread will not stop , to stop those
     //   obj1.setDaemon(true);
     obj1.start();

     /*
     //Gives illigal state thread exception, dont create thread object multiple times
             Thread.sleep(1000);
             obj1.start();
      */


        /*
         //instead of obj.start()--obj.run()
         It will only run in main thread , new thread will not be created, it is not achieving multithreading
         //obj.start0-- > should not call
         */


     //adding to thread
        //start0 -->run
        //run()


     //Does not work because Main class is not extending from Thread
     //   System.out.println("I am in the thread"+currentThread().getName());

        //Execution order changes , thread0 will run first or in parallel
        Thread.sleep(2000);

        System.out.println("I am in the thread"+Thread.currentThread().getName());

       //Error because get name is instant level function method not static method
       // System.out.println("I am in the thread"+Thread.getName());

        /*

        Thread o = new Thread();
        //It will not give main thread name, it will give thread which we created o
        System.out.println("I am in the thread"+o.getName());

        */

    }

    private static class MyThread  extends Thread{
        @Override
        public void run() {

            //Name the thread
           // currentThread().setName("First Thread");

            //Means it is considered as backgound thread (like garbage thread), ie, As long as application is running it will run , when its stops, thread will also stop
            //It will give error, because u should give this before starting the thread
           // currentThread().setDaemon(true);

            //Returns thread obj
            System.out.println("I am in the thread"+currentThread().getName());

            System.out.println("I am in the thread"+currentThread().getName());

        }
    }
}
