package com.example.projekat_navalwar_andrijapesic6213;

import com.example.projekat_navalwar_andrijapesic6213.elements.Tile;
import com.example.projekat_navalwar_andrijapesic6213.scene.SceneCreator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    /**
     * Zapocinje aplikaciju.
     */
    @Override
    public void start(Stage stage) throws IOException {

        Tile[][] tiles = new Tile[10][10];

        Scene scene = SceneCreator.createGameplayScene(stage, tiles);
        stage.setScene(scene);
        stage.setTitle("Naval War");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}