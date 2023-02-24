public class SimulatorAccessContatore1Lock {
    public static void main(String[] args) throws InterruptedException {

        Contatore contatore = new Contatore1Lock(1000);

        ThreadAccessContatore thread1 = new ThreadAccessContatore("Thread_A", contatore);
        ThreadAccessContatore thread2 = new ThreadAccessContatore("Thread_B", contatore);

        thread1.start();
        thread2.start();
    }
}