import java.util.Random;

public class Worker2 implements Runnable {

    Random random = new Random();
    int count = 0;

    @Override
    public void run() {
        while (true) {


            try {
                wait();
                System.out.println("Worker 2 Serve a CheesBurger :" + ThreadDemo.burgerDone);
                ThreadDemo.burgerDone = ThreadDemo.burgerDone - 1;
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ThreadDemo.burgerDone == 8){

                    System.out.println("Worker 2 has no burger to serve");


            }
        }


    }
}