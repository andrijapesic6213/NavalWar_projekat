package com.example.projekat_navalwar_andrijapesic6213;

import com.example.projekat_navalwar_andrijapesic6213.elements.Ship;
import com.example.projekat_navalwar_andrijapesic6213.elements.ShipTypes;
import com.example.projekat_navalwar_andrijapesic6213.elements.Tile;
import com.example.projekat_navalwar_andrijapesic6213.game_manager.GameManager;
import com.example.projekat_navalwar_andrijapesic6213.scene.SceneCreator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Zapocinje aplikaciju.
 */
public class Main extends Application {

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
        for (Ship ship : ships) {
            ship.setIsRotated(true);
        }
        GameManager gameManager = new GameManager(tiles,ships);

        Scene scene = SceneCreator.createReadyUpScene(tiles, ships);
        stage.setScene(scene);
        stage.setTitle("Naval War");
        stage.show();

        scene.setOnMouseClicked(mouseEvent -> {
           if(mouseEvent.getButton() == MouseButton.SECONDARY){
                if (gameManager.getSelectedShip() != null) {
                    gameManager.toggleSelectedShipRotation();
                }
           }
        });

        for (int i = 0; i < tiles.length; i++){
            for (int j = 0; j < tiles[i].length; j++){
                Tile tile = tiles[i][j];
                int xCord = i;
                int yCord = j;
                tiles[i][j].getTilePane().setOnMouseClicked(mouseEvent -> {
                    if((mouseEvent.getButton() == MouseButton.PRIMARY) && tile.getHasShip()){
                        if(gameManager.getSelectedShip() != null){
                            gameManager.moveSelectedShip(xCord, yCord);
                        }
                        else {
                            gameManager.setSelectedShip(tile.getShipOnTile());
                        }
                    }
                    else if ((mouseEvent.getButton() == MouseButton.PRIMARY) && gameManager.getSelectedShip() != null){
                        gameManager.moveSelectedShip(xCord, yCord);
                    }
                });
            }
        }


        gameManager.update();
    }

    public static void main(String[] args) {
        launch();
    }
}