import java.util.Random;

public class Worker1 implements Runnable {
    Random random = new Random();
    int count = 0;
    @Override
    public void run() {
        while (true) {

            if (ThreadDemo.burgerDone <= 7) {
                ThreadDemo.burgerDone = ThreadDemo.burgerDone+ 1;
                System.out.println("Worker 1 Make a CheesBurger :" + ThreadDemo.burgerDone);
                notifyAll();
            }else{
                try {
                    wait();
                    System.out.println("Worker 1 can not make any more burger :"+ThreadDemo.burgerDone);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }


    }

}
