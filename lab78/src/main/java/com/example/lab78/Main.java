package com.example.lab78;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
      /*  KorisniciModel korisniciModel = new KorisniciModel();
        korisniciModel.napuni();*/

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("izgled.fxml"));
       /* Controller controller = new Controller(korisniciModel);
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();*/
        //fxmlLoader.setController(new KorisniciModel(model));
        Scene scene = new Scene(fxmlLoader.load(), 500, 250);
        stage.setTitle("Korisnici");
        stage.setScene(scene);
        stage.setMinHeight(250);
        stage.setMinWidth(450);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}