package com.example.projekat_navalwar_andrijapesic6213.elements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
     * Podatak da li je ovo polje pogodjeno ili ne. Podrazumevana vrednost je false
     */
    private boolean isHit = false;

    /**
     * Podrazumevani konstruktor, pravi Pane i ImageView i stavlja imageView u Pane
     */
    public Tile() {
        tilePane = new Pane();
        imageView = new ImageView();
        File imageFile = new File("src/main/resources/images/EmptyTileImage.png");
        Image image = new Image(imageFile.toURI().toString());
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
     * Menja vrednost promenjive isHit na novu vrednost koja je prosledjena (newIsHit)
     */
    public void setIsHit(boolean newIsHit) {
        isHit = newIsHit;
    }

}
