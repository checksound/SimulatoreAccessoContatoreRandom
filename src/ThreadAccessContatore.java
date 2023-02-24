import java.time.Instant;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class ThreadAccessContatore extends Thread {
    private Contatore contatore;
    public ThreadAccessContatore(String name, Contatore contatore) {
        super(name);
        this.contatore = contatore;
    }

    public void run() {

        Random random = new Random(System.currentTimeMillis());
        while(true) {
            Request.setNewRequest();
            int value = random.nextInt() % 2;
            Calendar cal = new GregorianCalendar();
            if(value == 0) {

                System.out.format("\n%1$tM:%1$tS:%1$tL %2$s %3$s - TRY DECREMENT\n", cal, getName(), Request.getRequest());

                contatore.decrement();
            } else {

                System.out.format("\n%1$tM:%1$tS:%1$tL %2$s %3$s - TRY GET_VALUE\n", cal, getName(), Request.getRequest());

                int valContatore = contatore.getValue();
            }

            try {
                value = random.nextInt() % 5 * 1000;
                value = value >= 0? value: -value;
                Thread.sleep(value);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
