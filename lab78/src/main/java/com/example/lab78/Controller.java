package com.example.lab78;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Objects;

public class Controller {

    private KorisniciModel model;
    public ListView<Korisnik> listID;
    public PasswordField poljePass;
    public Button krajDugme;
    public Button dodajDugme;
    public TextField poljeIme;
    public TextField poljePrezime;
    public TextField poljeMail;
    public TextField poljeKime;
    @FXML
    private Label welcomeText;

    private SimpleStringProperty name;
    private SimpleStringProperty lastName;
    private SimpleStringProperty email;
    private SimpleStringProperty userName;
    private SimpleStringProperty password;

    @FXML
    public void initialize() {
        poljeIme.textProperty().bindBidirectional(name);
        poljePrezime.textProperty().bindBidirectional(lastName);
        poljeMail.textProperty().bindBidirectional(email);
        poljeKime.textProperty().bindBidirectional(userName);
        poljePass.textProperty().bindBidirectional(password);


        if (model != null) {
            listID.setItems(model.getKorisnici());
        }


        model.trenutniKorisnikProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            if (oldKorisnik != null) {
                poljeIme.textProperty().unbindBidirectional(
                        oldKorisnik.nameProperty());
                poljePrezime.textProperty().unbindBidirectional(
                        oldKorisnik.lastNameProperty());
                poljeMail.textProperty().unbindBidirectional(
                        oldKorisnik.emailProperty());
                poljeKime.textProperty().unbindBidirectional(
                        oldKorisnik.userNameProperty());
                poljePass.textProperty().unbindBidirectional(
                        oldKorisnik.passwordProperty());
            }
            if (newKorisnik == null) {
                poljeIme.setText("");
                poljePrezime.setText("");
                poljeMail.setText("");
                poljeKime.setText("");
                poljePass.setText("");


            } else {
                poljeIme.textProperty().bindBidirectional(
                        newKorisnik.nameProperty());
                poljePrezime.textProperty().bindBidirectional(
                        newKorisnik.lastNameProperty());
                poljeMail.textProperty().bindBidirectional(
                        newKorisnik.emailProperty());
                poljeKime.textProperty().bindBidirectional(
                        newKorisnik.userNameProperty());
                poljePass.textProperty().bindBidirectional(
                        newKorisnik.passwordProperty());
            }
        });
    }

   public Controller() {}
    public Controller(KorisniciModel m){
        model=m;
        name=new SimpleStringProperty();
        lastName=new SimpleStringProperty();
        email=new SimpleStringProperty();
        userName=new SimpleStringProperty();
        password=new SimpleStringProperty();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void pritisniKraj(ActionEvent actionEvent) {

       System.exit(0);
    }

    public void pritisniDodaj(ActionEvent actionEvent) {
        Korisnik noviKorisnik = new Korisnik(
                poljeIme.getText(),
                poljePrezime.getText(),
                poljeMail.getText(),
                poljeKime.getText(),
                poljePass.getText()
        );

        model.setTrenutniKorisnik(noviKorisnik);
        model.getKorisnici().add(noviKorisnik);

        // Očisti tekstualna polja
        poljeIme.clear();
        poljePrezime.clear();
        poljePass.clear();
        poljeKime.clear();
        poljeMail.clear();

        listID.refresh();
    }

}