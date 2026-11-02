package com.example.projekat_navalwar_andrijapesic6213;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        VBox root = new VBox();
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Naval War");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}