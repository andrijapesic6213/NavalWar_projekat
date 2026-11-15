package com.example.projekat_navalwar_andrijapesic6213;

import com.example.projekat_navalwar_andrijapesic6213.elements.Ship;
import com.example.projekat_navalwar_andrijapesic6213.elements.ShipTypes;
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
        Ship[] ships = new Ship[6];
        ships[0] = new Ship(ShipTypes.BATTLESHIP);
        ships[1] = new Ship(ShipTypes.CRUSER);
        ships[2] = new Ship(ShipTypes.DESTROYER);
        ships[3] = new Ship(ShipTypes.DESTROYER);
        ships[4] = new Ship(ShipTypes.PATROL_BOAT);
        ships[5] = new Ship(ShipTypes.PATROL_BOAT);

        Scene scene = SceneCreator.createReadyUpScene(tiles, ships);
        stage.setScene(scene);
        stage.setTitle("Naval War");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}