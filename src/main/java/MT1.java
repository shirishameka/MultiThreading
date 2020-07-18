public class MT1 {
    public static void main(String[] args) throws InterruptedException {

        MT2 obj1= new MT2();
       obj1.start();

        System.out.println("I am in the thread"+Thread.currentThread().getName());

    }
}
