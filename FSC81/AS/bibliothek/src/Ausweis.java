import java.time.LocalDate;

public class Ausweis {

    private Integer nummer;
    private LocalDate ablauf_datum;
    private Boolean gesperrt;
    static Integer letzteNummer = 1000;

    public Ausweis() {
        this.entsperren();
        this.ablauf_datum = LocalDate.now().plusYears(1);
        this.nummer = this.getLetzteNummer() + 1;
        this.setLetzteNummer();
    }

    public Integer getNummer() {
        return this.nummer;
    }

    public LocalDate getAblauf_datum() {
        return this.ablauf_datum;
    }

    public void setAblauf_datum(LocalDate ablauf_datum) {
        this.ablauf_datum = ablauf_datum;
    }

    public void sperren() {
        this.gesperrt = true;
    }

    public void entsperren() {
        this.gesperrt = false;
    }

    public boolean istGesperrt() {
        return this.gesperrt;
    }

    private Integer getLetzteNummer() {
        return letzteNummer;
    }

    private void setLetzteNummer() {
        this.letzteNummer = this.nummer;
    }
}
