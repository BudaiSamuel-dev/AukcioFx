package classes;

public class AukcioTetel {

    protected String kod;
    protected String nev;
    protected int kikialtasiAr;

    public AukcioTetel(String kod, String nev, int kikialtasiAr) {
        this.kod = kod;
        this.nev = nev;
        this.kikialtasiAr = kikialtasiAr;
    }

    public String getKod() {
        return kod;
    }

    public String getNev() {
        return nev;
    }

    public int getKikialtasiAr() {
        return kikialtasiAr;
    }

    public String getInfo(){
        return String.format("Kód: %s\nKikiáltási ár: %d Ft\\n", kod, kikialtasiAr);
    }

    @Override
    public String toString() {
        return nev;
    }
}
