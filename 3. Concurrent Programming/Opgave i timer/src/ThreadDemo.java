public class ThreadDemo {

    private int antalBurgere = 0;
    static int burgerDone = 0;
    private final int MAX=8;
    public Slider(int startvalue) { antalBurgere =startvalue;}

    public int getAntalBurgere() {return antalBurgere; }
    public synchronized int addOne(){ //producer en, men kun op til MAX

        try {
            while (antalBurgere >= MAX) {
                wait();
            }
            antalBurgere++;
            notify();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return antalBurgere;
    }

    public static void main(String[] args) {
        Worker1 worker1 = new Worker1();
        Worker2 worker2 = new Worker2();

        Thread thread1 = new Thread(worker1);
        Thread thread2 = new Thread(worker2);
        thread1.start();
        thread2.start();
    }

    public synchronized int takeone(){
        try {
            while(antalBurgere == 0){
                wait();
            }
        }
    }
}
