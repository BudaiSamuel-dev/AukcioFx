package application;

import classes.AukcioTetel;
import classes.Belyeg;
import classes.Erme;
import classes.Festmeny;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AukcioController {

    private static final File FILE_IN = new File("C:\\Dev\\FeladatForrasok\\BudaiS\\Aukcio\\aukcios_tetelek.dat");
    private ArrayList<AukcioTetel> tetelek = new ArrayList<>();

    @FXML
    private CheckBox chbBelyeg;

    @FXML
    private CheckBox chbErme;

    @FXML
    private CheckBox chbFestmeny;

    @FXML
    private CheckBox chbMinden;

    @FXML
    private Label lbKikialtasiAr;

    @FXML
    private Label lbTetel;

    @FXML
    private ListView<AukcioTetel> lvTetelek;

    @FXML
    private TextArea taReszletek;


    @FXML
    void selectBelyeg(ActionEvent event) {
        listaFrissites();
    }

    @FXML
    void selectErme(ActionEvent event) {
        listaFrissites();
    }

    @FXML
    void selectFestmenyek(ActionEvent event) {
        listaFrissites();
    }

    @FXML
    void selectMinden(ActionEvent event) {
        listaFrissites();
    }

    @FXML
    void initialize() {
        assert chbBelyeg != null : "fx:id=\"chbBelyeg\" was not injected: check your FXML file 'aukcio-pane.fxml'.";
        assert chbErme != null : "fx:id=\"chbErme\" was not injected: check your FXML file 'aukcio-pane.fxml'.";
        assert chbFestmeny != null : "fx:id=\"chbFestmeny\" was not injected: check your FXML file 'aukcio-pane.fxml'.";
        assert chbMinden != null : "fx:id=\"chbMinden\" was not injected: check your FXML file 'aukcio-pane.fxml'.";
        assert lbKikialtasiAr != null : "fx:id=\"lbKikialtasiAr\" was not injected: check your FXML file 'aukcio-pane.fxml'.";
        assert lbTetel != null : "fx:id=\"lbTetel\" was not injected: check your FXML file 'aukcio-pane.fxml'.";
        assert lvTetelek != null : "fx:id=\"lvTetelek\" was not injected: check your FXML file 'aukcio-pane.fxml'.";
        assert taReszletek != null : "fx:id=\"taReszletek\" was not injected: check your FXML file 'aukcio-pane.fxml'.";

        fajlBeolvasas(FILE_IN);

        chbMinden.setSelected(true);
        listaFrissites();

        lvTetelek.getSelectionModel().select(0);
        infoFrissites(lvTetelek.getSelectionModel().getSelectedItem());

        lvTetelek.getSelectionModel().selectedItemProperty().addListener((_)->{
            infoFrissites(lvTetelek.getSelectionModel().getSelectedItem());
        });

    }

    private void fajlBeolvasas(File file){
        try {
            Scanner fileScanner = new Scanner(file);

            while(fileScanner.hasNextLine()){
                String record = fileScanner.nextLine();

                if (!record.isEmpty() && !record.startsWith(";")){
                    String[] data = record.split(";");

                    String kod = data[1];
                    String nev = data[2];
                    int kikialtasiAr = Integer.parseInt(data[3]);

                    switch (data[0]){
                        case "E" : tetelek.add(new Erme(kod, nev, kikialtasiAr, data[4], data[5]));break;
                        case "B" : tetelek.add(new Belyeg(kod, nev, kikialtasiAr, data[4]));break;
                        default: tetelek.add(new Festmeny(kod, nev, kikialtasiAr, data[4], Double.parseDouble(data[5]), Double.parseDouble(data[6])));
                    }
                }
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("A fájl beolvasása sikertelen volt");
            e.printStackTrace();
            System.exit(0);
        }

    }

    private void listaFrissites(){
        lvTetelek.getItems().clear();
        if (chbBelyeg.isSelected() && chbErme.isSelected() && chbFestmeny.isSelected()){
            chbMinden.setSelected(true);
            chbBelyeg.setSelected(false);
            chbErme.setSelected(false);
            chbFestmeny.setSelected(false);
        }

        if (chbBelyeg.isSelected() || chbErme.isSelected() || chbFestmeny.isSelected()){
            chbMinden.setSelected(false);
        }

        if (chbMinden.isSelected()){
            lvTetelek.getItems().addAll(tetelek);
        }

        if (chbBelyeg.isSelected()){
            for (AukcioTetel tetel : tetelek){
                if (tetel instanceof Belyeg){
                    lvTetelek.getItems().add(tetel);
                }
            }
        }

        if (chbErme.isSelected()){
            for (AukcioTetel tetel : tetelek){
                if (tetel instanceof Erme){
                    lvTetelek.getItems().add(tetel);
                }
            }
        }

        if (chbFestmeny.isSelected()){
            for (AukcioTetel tetel : tetelek){
                if (tetel instanceof Festmeny){
                    lvTetelek.getItems().add(tetel);
                }
            }
        }
    }

    private void infoFrissites(AukcioTetel tetel){
        lbTetel.setText(tetel.toString());
        lbKikialtasiAr.setText("Kikiáltási ár: "+String.valueOf(tetel.getKikialtasiAr()) + " Ft");

        taReszletek.setText(tetel.getInfo());
    }

}
