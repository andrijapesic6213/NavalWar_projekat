package com.example.projekat_navalwar_andrijapesic6213;

import com.example.projekat_navalwar_andrijapesic6213.scene.SceneCreator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    /**
     * Zapocinje aplikaciju.
     */
    @Override
    public void start(Stage stage) throws IOException {


        stage.setScene(SceneCreator.createGameplayScene(stage));
        stage.setTitle("Naval War");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}