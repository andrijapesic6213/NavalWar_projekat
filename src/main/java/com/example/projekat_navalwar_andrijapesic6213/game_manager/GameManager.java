package com.example.projekat_navalwar_andrijapesic6213.game_manager;

import com.example.projekat_navalwar_andrijapesic6213.elements.Ship;
import com.example.projekat_navalwar_andrijapesic6213.elements.Tile;
import javafx.scene.image.Image;

import java.io.File;
import java.util.Vector;

/**
 * Barata funkcionalnoscu gameplay-a igre
 */
public class GameManager {
    /**
     * polja table u igri
     */
    private Tile[][] tiles;

    /**
     * brodovi u igri
     */
    private Ship[] ships;

    /**
     * sacuvani brod koji je izabran
     */
    private Ship selectedShip;

    /**
     * oznacava da li se izabrani brod treba rotirati prenego da se pomeri
     */
    private boolean selectedShipRotation;

    /**
     * pravi gamemanager-a
     */
    public GameManager(Tile[][] tiles, Ship[] ships){
        this.tiles = tiles;
        this.ships = ships;
    }

    /**
     * azurira stanje igre
     */
    public void update(){

        // iscrtavanje
        for(Ship ship : ships) {
            for(int i = 0; i < ship.getShipSize(); i++){
                Image image = ship.getShipImage(i);
                tiles[ship.getLocationCoordinates()[i].getFirst()][ship.getLocationCoordinates()[i].getLast()].setTileImage(image, ship.isRotated());
            }
        }
    }

    /**
     * vraca polja sa kojima barata
     */
    public Tile[][] getTiles() {
        return tiles;
    }

    /**
     * vraca brodove sa kojima barata
     */
    public Ship[] getShips() {
        return ships;
    }

    /**
     * vraca sacuvani brod ili null ako nema sacuvanog broda
     */
    public Ship getSelectedShip() {
        return selectedShip;
    }

    /**
     * cuva prosledjen brod kao izabran
     */
    public void setSelectedShip(Ship ship) {
        selectedShip = ship;
        selectedShipRotation = ship.isRotated();
    }

    /**
     * oznacava da li treba ili ne da se rotira izabrani sacuvani brod tokom pomeranja
     */
    public void toggleSelectedShipRotation() {
        if (selectedShip != null) {
            selectedShipRotation = !selectedShipRotation;
        }
    }

    /**
     * pomera sacuvani brod na novu poziciju i prestaje da ga cuva
     */
    public void moveSelectedShip(int x, int y){
        if(selectedShip != null){
            for (int i = 0; i < selectedShip.getShipSize(); i++){
                tiles[selectedShip.getLocationCoordinates()[i].get(0)][selectedShip.getLocationCoordinates()[i].get(1)].setTileImage(
                        new Image(new File("src/main/resources/images/EmptyTileImage.png").toURI().toString()), false);
                tiles[selectedShip.getLocationCoordinates()[i].get(0)][selectedShip.getLocationCoordinates()[i].get(1)].removeShip();
            }

            Ship tempShip = new Ship(selectedShip.getShipType());
            tempShip.setLocationCoordinates(x, y);
            tempShip.setIsRotated(selectedShipRotation);
            boolean validPlacement = true;
            for (int i = 0; i < tempShip.getShipSize(); i++){
                int tempXCord = tempShip.getLocationCoordinates()[i].get(0);
                int tempYCord = tempShip.getLocationCoordinates()[i].get(1);
                if ((tempXCord < 0 || tempXCord > 9) || (tempYCord < 0 || tempYCord > 9) || tiles[tempXCord][tempYCord].getHasShip()){
                    validPlacement = false;
                    break;
                }
            }

            if (validPlacement){
                selectedShip.setLocationCoordinates(x, y);
                selectedShip.setIsRotated(selectedShipRotation);
            }

            for (int i = 0; i < selectedShip.getShipSize(); i++){
                tiles[selectedShip.getLocationCoordinates()[i].get(0)][selectedShip.getLocationCoordinates()[i].get(1)].setShipOnTile(selectedShip);
            }

            selectedShip = null;
            this.update();
        }
    }

}
