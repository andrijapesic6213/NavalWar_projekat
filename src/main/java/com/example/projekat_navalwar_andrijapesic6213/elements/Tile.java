package com.example.projekat_navalwar_andrijapesic6213.elements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;

import java.io.File;

/**
 * Polje od kojih se sastoji tabla
 */
public class Tile extends Pane {
    /**
     * Pane ovog polja
     */
    private Pane tilePane;
    /**
     * ImageView ovog polja na kome se prikazuje odredjena slika
     */
    private ImageView imageView;
    /**
     * brod koji svojom pozicijom zahvata ovo polje
     */
    private Ship shipOnTile;

    /**
     * Podatak da li je ovo polje pogodjeno ili ne. Podrazumevana vrednost je false
     */
    private boolean isHit = false;
    /**
     * vrednost da li ovo polje ima deo broda na njemu ili ne
     */
    private boolean hasShip = false;

    /**
     * Podrazumevani konstruktor, pravi Pane i ImageView i stavlja imageView u Pane
     */
    public Tile() {
        tilePane = new Pane();
        imageView = new ImageView();
        Image image = new Image(new File("src/main/resources/images/EmptyTileImage.png").toURI().toString());
        imageView.setImage(image);
        imageView.setFitHeight(45);
        imageView.setFitWidth(45);
        tilePane.getChildren().add(imageView);

    }

    /**
     * Vraca Pane ovog polja
     */
    public Pane getTilePane() {
        return tilePane;
    }
    /**
     * Vraca vrednost promenjive isHit
     */
    public boolean getIsHit() {
        return isHit;
    }

    /**
     * vraca da li ovo polje ima deo broda na sebi ili ne
     */
    public boolean getHasShip() {
        return hasShip;
    }
    /**
     * Menja vrednost promenjive isHit na novu vrednost koja je prosledjena (newIsHit)
     */
    public void setIsHit(boolean newIsHit) {
        isHit = newIsHit;
    }

    /**
     * cuva informaciju o prosedjeni brod kao i da se neki brod nalazi na ovom polju
     */
    public void setShipOnTile(Ship ship) {
        shipOnTile = ship;
        hasShip = true;
    }
    /**
     * uklanja informaciju o brodu na ovom polju i oznacava da ovo polje nema brod na njemu
     */
    public void removeShip() {
        shipOnTile = null;
        hasShip = false;
    }
    /**
     * vraca brod koji se nalazi na ovom polju, ukoliko nema informacije o brodu na ovom polju vraca null
     */
    public Ship getShipOnTile() {
        return shipOnTile;
    }

    /**
     * postavlja novu sliku na polju i rotira je ako je potrebno
     */
    public void setTileImage(Image newTileImage, boolean rotation) {
        imageView.setImage(newTileImage);
        if (rotation) {
            imageView.setRotate(90);
        }
        else {
            imageView.setRotate(0);
        }
    }
}
