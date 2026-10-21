package classes;

public class Erme extends AukcioTetel{

    private String kiadasEve;
    private String anyag;

    public Erme(String kod, String nev, int kikialtasiAr, String kiadasEve, String anyag) {
        super(kod, nev, kikialtasiAr);
        this.kiadasEve = kiadasEve;
        this.anyag = anyag;
    }

    public String getKiadasEve() {
        return kiadasEve;
    }

    public Erme setKiadasEve(String kiadasEve) {
        this.kiadasEve = kiadasEve;
        return this;
    }

    public String getAnyag() {
        return anyag;
    }

    public Erme setAnyag(String anyag) {
        this.anyag = anyag;
        return this;
    }

    public String getXML(){
        return String.format("<erme kod=\"%s\" nev=\"%s\" kiadas_eve=\"%s\" ar=\"%d\" anyag=\"%s\" />", kod, nev, kiadasEve, kikialtasiAr, anyag);
    }

    @Override
    public String getInfo() {
        return String.format("Kód: %s\nKiadás éve: %s\nAnyag: %s\nKikiáltási ár: %d Ft", kod, kiadasEve, anyag, kikialtasiAr);
    }

    @Override
    public String toString() {
        return String.format("Érme: %s", super.toString());
    }
}
