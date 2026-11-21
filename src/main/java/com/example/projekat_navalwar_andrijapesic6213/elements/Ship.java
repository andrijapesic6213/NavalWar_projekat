package com.example.projekat_navalwar_andrijapesic6213.elements;

import javafx.scene.image.Image;

import java.io.File;
import java.util.Set;
import java.util.Vector;

/**
 * Brodovi koji se koriste za igru
 */
public class Ship {
    /**
     * tip broda
     */
    private ShipTypes shipType;
    /**
     * Velicina broda
     */
    private int shipSize;
    /**
     * Osteceni delovi broda
     */
    private Set<Integer> damagedSections;
    /**
     * Orentacija broda. false znaci da je vertikalan, true da je horizontalan
     */
    private boolean isRotated = false;
    /**
     * Slike delova broda.
     */
    private Image[] shipImages;
    /**
     * Slike ostecenih delova broda.
     */
    private Image[] damagedShipImages;
    /**
     * Koordinacije broda.
     */
    private Vector<Integer>[] locationCoordinates;

    /**
     * Prvi brod prosledjenog tipa.
     */
    public Ship(ShipTypes shipType) {
        this.shipType = shipType;
        switch (shipType) {
            case BATTLESHIP:
                shipSize = 5;
                shipImages = new Image[5];
                shipImages[0] = new Image(new File("src/main/resources/images/ShipSectionStern.png").toURI().toString());
                shipImages[1] = new Image(new File("src/main/resources/images/ShipSection2.png").toURI().toString());
                shipImages[2] = new Image(new File("src/main/resources/images/ShipSection3.png").toURI().toString());
                shipImages[3] = new Image(new File("src/main/resources/images/ShipSection1.png").toURI().toString());
                shipImages[4] = new Image(new File("src/main/resources/images/ShipSectionBow.png").toURI().toString());
                damagedShipImages = new Image[5];
                damagedShipImages[0] = new Image(new File("src/main/resources/images/DestroyedShipSectionStern.png").toURI().toString());
                damagedShipImages[1] = new Image(new File("src/main/resources/images/DestroyedShipSection2.png").toURI().toString());
                damagedShipImages[2] = new Image(new File("src/main/resources/images/DestroyedShipSection3.png").toURI().toString());
                damagedShipImages[3] = new Image(new File("src/main/resources/images/DestroyedShipSection1.png").toURI().toString());
                damagedShipImages[4] = new Image(new File("src/main/resources/images/DestroyedShipSectionBow.png").toURI().toString());
                break;
            case CRUSER:
                shipSize = 4;
                shipImages = new Image[4];
                shipImages[0] = new Image(new File("src/main/resources/images/ShipSectionStern.png").toURI().toString());
                shipImages[1] = new Image(new File("src/main/resources/images/ShipSection2.png").toURI().toString());
                shipImages[2] = new Image(new File("src/main/resources/images/ShipSection1.png").toURI().toString());
                shipImages[3] = new Image(new File("src/main/resources/images/ShipSectionBow.png").toURI().toString());
                damagedShipImages = new Image[4];
                damagedShipImages[0] = new Image(new File("src/main/resources/images/DestroyedShipSectionStern.png").toURI().toString());
                damagedShipImages[1] = new Image(new File("src/main/resources/images/DestroyedShipSection2.png").toURI().toString());
                damagedShipImages[2] = new Image(new File("src/main/resources/images/DestroyedShipSection1.png").toURI().toString());
                damagedShipImages[3] = new Image(new File("src/main/resources/images/DestroyedShipSectionBow.png").toURI().toString());
                break;
            case DESTROYER:
                shipSize = 3;
                shipImages = new Image[3];
                shipImages[0] = new Image(new File("src/main/resources/images/ShipSectionStern.png").toURI().toString());
                shipImages[1] = new Image(new File("src/main/resources/images/ShipSection1.png").toURI().toString());
                shipImages[2] = new Image(new File("src/main/resources/images/ShipSectionBow.png").toURI().toString());
                damagedShipImages = new Image[3];
                damagedShipImages[0] = new Image(new File("src/main/resources/images/DestroyedShipSectionStern.png").toURI().toString());
                damagedShipImages[1] = new Image(new File("src/main/resources/images/DestroyedShipSection1.png").toURI().toString());
                damagedShipImages[2] = new Image(new File("src/main/resources/images/DestroyedShipSectionBow.png").toURI().toString());
                break;
            case PATROL_BOAT:
                shipSize = 2;
                shipImages = new Image[2];
                shipImages[0] = new Image(new File("src/main/resources/images/ShipSectionStern.png").toURI().toString());
                shipImages[1] = new Image(new File("src/main/resources/images/ShipSectionBow.png").toURI().toString());
                damagedShipImages = new Image[2];
                damagedShipImages[0] = new Image(new File("src/main/resources/images/DestroyedShipSectionStern.png").toURI().toString());
                damagedShipImages[1] = new Image(new File("src/main/resources/images/DestroyedShipSectionBow.png").toURI().toString());
                break;
            default:
                break;
        }
        locationCoordinates = new Vector[shipSize];
        for (int i = 0; i < shipSize; i++) {
            locationCoordinates[i] = new Vector<>(2);
            locationCoordinates[i].add(0);
            locationCoordinates[i].add(0);
        }

    }

    /**
     * vraca tip broda
     */
    public ShipTypes getShipType() {
        return shipType;
    }

    /**
     * vraca velicinu broda.
     */
    public int getShipSize() {
        return shipSize;
    }

    /**
     * vraca listu
     */
    public Set<Integer> getDamagedSections() {
        return damagedSections;
    }

    /**
     * Vraca odredjenu sliku broda od dela ciji je index prosledjen
     */
    public Image getShipImage(int sectionIndex) {
        return (damagedSections != null && damagedSections.contains(sectionIndex)) ? damagedShipImages[sectionIndex] : shipImages[sectionIndex];
    }

    /**
     * vraca da li je brod zarotiran ili ne
     */
    public boolean isRotated() {
        return isRotated;
    }

    /**
     * vraca vector koji sadrzi koordinate broda
     */
    public Vector<Integer>[] getLocationCoordinates() {
        return locationCoordinates;
    }

    /**
     * postavlja da li je brod rotiran ili ne
     */
    public void setIsRotated(boolean rotated) {
        isRotated = rotated;
        setLocationCoordinates(locationCoordinates[0].get(0), locationCoordinates[0].get(1));
    }

    /**
     * postavlja koordinate pocetne tacke broda na nove X i Y koordinate
     */
    public void setLocationCoordinates(int x, int y) {
        for (int i = 0; i < locationCoordinates.length; i++) {
            locationCoordinates[i].clear();
        }

        for (int i = 0; i < shipSize; i++) {
            if (i > 0) {
                if (isRotated) {
                    x++;
                } else {
                    y--;
                }
            }

            locationCoordinates[i].add(x);
            locationCoordinates[i].add(y);
        }
    }

    /**
     * oznacava odredjen deo broda kao ostecen
     */
    public void DamageSection(int sectionIndex) {
        damagedSections.add(sectionIndex);
    }
}
