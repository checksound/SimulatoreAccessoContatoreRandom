import java.time.Instant;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Contatore1Lock implements Contatore {

    private int value;
    private Random random = new Random(System.currentTimeMillis());
    public Contatore1Lock(int value) {
        this.value = value;
    }

    public void decrement() {

        synchronized(this) {
            Calendar cal = new GregorianCalendar();
            System.out.format("%1$tM:%1$tS:%1$tL %2$s %3$s -------------------> ENTRATO DECREMENT()\n", cal,
                    Thread.currentThread().getName(), Request.getRequest());

            value--;

            try {
                int valueT = random.nextInt() % 10;
                valueT = valueT >= 0? valueT: -valueT;
                for (int i = 0; i < valueT * 10; i++) {
                    Thread.sleep(100);
                    System.out.print(".");
                }
                System.out.println("");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            cal = new GregorianCalendar();
            System.out.format("%1$tM:%1$tS:%1$tL %2$s %3$s <------------------- EXIT DECREMENT()\n", cal,
                    Thread.currentThread().getName(), Request.getRequest());

        }
    }

    public int getValue() {

        synchronized(this) {
            Calendar cal = new GregorianCalendar();
            System.out.format("%1$tM:%1$tS:%1$tL %2$s %3$s -------------------> ENTRATO GET_VALUE()\n", cal,
                    Thread.currentThread().getName(), Request.getRequest());

            try {
                int valueT = random.nextInt() % 10;
                valueT = valueT >= 0? valueT: -valueT;
                for (int i = 0; i < valueT * 10; i++) {
                    Thread.sleep(100);
                    System.out.print("+");
                }
                System.out.println("");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            cal = new GregorianCalendar();
            System.out.format("%1$tM:%1$tS:%1$tL %2$s %3$s -------------------> EXIT GET_VALUE()\n", cal,
                    Thread.currentThread().getName(), Request.getRequest());

            return value;
        }
    }

}
