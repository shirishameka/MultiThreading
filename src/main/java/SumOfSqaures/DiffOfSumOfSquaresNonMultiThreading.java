package SumOfSqaures;

public class DiffOfSumOfSquaresNonMultiThreading {
    public static void main(String[] args){
        int num=4;
        long start= System.currentTimeMillis();

        System.out.println(differenceOfSumOfSquares(num));

        System.out.println(System.currentTimeMillis()-start);
}
    private static int differenceOfSumOfSquares(int num){

            int result = 0;
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
