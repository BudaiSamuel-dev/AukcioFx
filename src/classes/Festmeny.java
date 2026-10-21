package classes;

public class Festmeny extends AukcioTetel{

    private String alkoto;
    private double magassag;
    private double szelesseg;

    public Festmeny(String kod, String nev, int kikialtasiAr, String alkoto, double magassag, double szelesseg) {
        super(kod, nev, kikialtasiAr);
        this.alkoto = alkoto;
        this.magassag = magassag;
        this.szelesseg = szelesseg;
    }

    public String getAlkoto() {
        return alkoto;
    }

    public void setAlkoto(String alkoto) {
        this.alkoto = alkoto;
    }

    public double getMagassag() {
        return magassag;
    }

    public void setMagassag(double magassag) {
        this.magassag = magassag;
    }

    public double getSzelesseg() {
        return szelesseg;
    }

    public void setSzelesseg(double szelesseg) {
        this.szelesseg = szelesseg;
    }


    public double getFelulet(){
        return magassag * szelesseg;
    }

    @Override
    public String getInfo() {
        return String.format("Kód: %s\nAlkoto: %s\nFelület: %.2f cm x %.2f cm (%.2f cm2)\nKikiáltási ár: %d Ft", kod, alkoto, magassag, szelesseg, getFelulet(), kikialtasiAr);
    }

    @Override
    public String toString() {
        return String.format("Festmény: %s", super.toString());
    }
}
