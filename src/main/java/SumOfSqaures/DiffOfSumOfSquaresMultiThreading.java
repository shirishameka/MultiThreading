package SumOfSqaures;

public class DiffOfSumOfSquaresMultiThreading {
    public static void main(String[] args) throws InterruptedException {

        int num = 100;
        long start= System.currentTimeMillis();

        MyThread thread= new MyThread(num);
        thread.start();
        thread.join();
        System.out.println("The Difference between the sum of the squares is :"+ thread.result);

        System.out.println(System.currentTimeMillis()-start);

    }
    private static class MyThread extends Thread {
        int num;
        int result;

        public MyThread(int num) {
            this.num = num;
            result = 0;
        }

        @Override
        public void run() {
            differenceOfSumOfSquares();
        }

        public int differenceOfSumOfSquares() {

            for (int i = num; i >= 0; i--) {
                if (i % 2 == 0) {
                    result = result + (i * i);
                } else {
                    result = result - (i * i);
                }
                System.out.println("Printing difference"+result);
            }
            return result;
        }

        }
    }



