public class Leser {

    private String name;
    public Ausweis ausweis;

    public Leser(String lesername) {

        this.name = lesername;
        this.ausweis = erstelleAusweis();

    }

    public String getName() {
        return name;
    }

    private Ausweis erstelleAusweis() {

        Ausweis ausweis = new Ausweis();
        return ausweis;
    }
}
