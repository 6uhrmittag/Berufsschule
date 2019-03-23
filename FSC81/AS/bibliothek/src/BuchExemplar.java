import java.time.LocalDate;
import java.util.Random;
import java.time.temporal.ChronoUnit;

public class BuchExemplar {

    public Integer nummer = null;
    private Leser leser = null;
    public LocalDate rueckgabefrist = null;


    public LocalDate getRueckgabefrist() {
        return rueckgabefrist;
    }

    public BuchExemplar() {
        Random rand = new Random();
        this.nummer = rand.nextInt();
    }


    public Leser getLeser() {
        if (leser == null) {
            return new Leser("dummy");
        }
        return this.leser;
    }

    public void ausleihen(Leser leser) {
        this.leser = leser;
        this.rueckgabefrist = LocalDate.now().plusWeeks(4);
    }

    public Integer rueckgabe() {
        Integer gebuer = 1;
        Integer gebuertoal = 0;

        Integer weeks = (int) (ChronoUnit.WEEKS.between(rueckgabefrist, LocalDate.now()) + 1);

        if (weeks >= 0) {
            System.out.println("test");
            return 0;
        }

        gebuertoal = gebuer * weeks;

        return gebuertoal;
    }

}
