package Factorial;

import java.math.BigInteger;

public class MT {
    public static void main(String[] args) throws InterruptedException {

        int[] arr= {10000,20000,30000,60000,77000,4000,5000,7000,15000,40000,50000,50000,50000,50000,50000};
        long start= System.currentTimeMillis();

        MyThread[]threads= new MyThread[arr.length];
        for(int i=0; i<threads.length;i++){
            threads[i]=new MyThread(arr[i]);
            threads[i].start();
            //calculate function in thread, not achieving multithreading , it should should run from run meathod
           // threads[i].calculate(arr[i]);
        }

        //Thread.sleep(1000):
        //t1,waits t1 to die, t2, t3-- t10
        for(int i=0; i<threads.length;i++){
            threads[i].join();
        }


        for(int i=0; i<threads.length;i++){
            System.out.println(threads[i].result);
        }

        System.out.println(System.currentTimeMillis()-start);

    }
    private static class MyThread extends Thread{
        int num;
        BigInteger result;

        public MyThread(int num) {
            this.num = num;
            result= BigInteger.valueOf(1);
        }

        @Override
        public void run() {
     calculate();
        }

        public void calculate(){
          //  BigInteger bi= BigInteger.valueOf(1);
            for(int i=2;i<=this.num;i++){
                result=result.multiply(BigInteger.valueOf(i));
            }

        }

        //this.result=bi
        //cltr+f12
    }
}
