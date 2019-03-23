public class Account {

    private Vor

    public Ausweis ausweis;

    public Account(String lesername) {


    }

    public String getName() {
        return name;
    }

    private Ausweis erstelleAusweis() {

        Ausweis ausweis = new Ausweis();
        return ausweis;
    }
}
