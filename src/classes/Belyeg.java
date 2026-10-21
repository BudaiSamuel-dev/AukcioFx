package classes;

public class Belyeg extends AukcioTetel{

    private String kiadasEve;

    public Belyeg(String kod, String nev, int kikialtasiAr, String kiadasEve) {
        super(kod, nev, kikialtasiAr);
        this.kiadasEve = kiadasEve;
    }

    public String getKiadasEve() {
        return kiadasEve;
    }

    public Belyeg setKiadasEve(String kiadasEve) {
        this.kiadasEve = kiadasEve;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Bélyeg: %s", super.toString());
    }

    @Override
    public String getInfo() {
        return String.format("Kód: %s\nKiadás éve: %s\nKikiáltási ár: %d Ft", kod, kiadasEve, kikialtasiAr);
    }
}
