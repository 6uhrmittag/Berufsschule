import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //Test Ausweis
        Ausweis ausweis1 = new Ausweis();
        System.out.println("Ausweis1 leer: " + ausweis1.getAblauf_datum().toString() + " " + ausweis1.getNummer().toString());

        Ausweis ausweis2 = new Ausweis();
        System.out.println("Ausweis2 leer: " + ausweis1.getAblauf_datum().toString() + " " + ausweis1.getNummer().toString());

        ausweis2.setAblauf_datum(LocalDate.now().plusYears(2));
        System.out.println("Ausweis2 Ablaudjahr + 2y: " + ausweis1.getAblauf_datum().toString() + " " + ausweis1.getNummer().toString());

        //Test Leser
        Leser leser1 = new Leser("heinz");
        System.out.println("Leser1, Name: Heinz: " + leser1.getName() + " " + leser1.ausweis.getNummer().toString() + " " + leser1.ausweis.getAblauf_datum());

        //Test Buch
        BuchExemplar buch1 = new BuchExemplar();
        System.out.println("Buch1, leeR: " + buch1.getLeser().getName().toString() + buch1.getRueckgabefrist().toString());

        buch1.ausleihen(leser1);
        System.out.println(buch1.getLeser().getName().toString());
        System.out.println(buch1.rueckgabe().toString());


    }
}
