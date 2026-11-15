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
     * Prvaljenje broda prosledjenog tipa.
     */
    public Ship(ShipTypes shipType) {
        this.shipType = shipType;
        switch (shipType) {
            case BATTLESHIP:
                shipSize = 5;
                shipImages = new Image[5];
                shipImages[0] = new Image(new File("src/main/resources/images/ShipSectionBow.png").toURI().toString());
                shipImages[1] = new Image(new File("src/main/resources/images/ShipSection2.png").toURI().toString());
                shipImages[2] = new Image(new File("src/main/resources/images/ShipSection3.png").toURI().toString());
                shipImages[3] = new Image(new File("src/main/resources/images/ShipSection1.png").toURI().toString());
                shipImages[4] = new Image(new File("src/main/resources/images/ShipSectionStern.png").toURI().toString());
                damagedShipImages = new Image[5];
                damagedShipImages[0] = new Image(new File("src/main/resources/images/DestroyedShipSectionBow.png").toURI().toString());
                damagedShipImages[1] = new Image(new File("src/main/resources/images/DestroyedShipSection2.png").toURI().toString());
                damagedShipImages[2] = new Image(new File("src/main/resources/images/DestroyedShipSection3.png").toURI().toString());
                damagedShipImages[3] = new Image(new File("src/main/resources/images/DestroyedShipSection1.png").toURI().toString());
                damagedShipImages[4] = new Image(new File("src/main/resources/images/DestroyedShipSectionStern.png").toURI().toString());
                break;
            case CRUSER:
                shipSize = 4;
                shipImages = new Image[4];
                shipImages[0] = new Image(new File("src/main/resources/images/ShipSectionBow.png").toURI().toString());
                shipImages[1] = new Image(new File("src/main/resources/images/ShipSection2.png").toURI().toString());
                shipImages[2] = new Image(new File("src/main/resources/images/ShipSection1.png").toURI().toString());
                shipImages[3] = new Image(new File("src/main/resources/images/ShipSectionStern.png").toURI().toString());
                damagedShipImages = new Image[4];
                damagedShipImages[0] = new Image(new File("src/main/resources/images/DestroyedShipSectionBow.png").toURI().toString());
                damagedShipImages[1] = new Image(new File("src/main/resources/images/DestroyedShipSection2.png").toURI().toString());
                damagedShipImages[2] = new Image(new File("src/main/resources/images/DestroyedShipSection1.png").toURI().toString());
                damagedShipImages[3] = new Image(new File("src/main/resources/images/DestroyedShipSectionStern.png").toURI().toString());
                break;
            case DESTROYER:
                shipSize = 3;
                shipImages = new Image[3];
                shipImages[0] = new Image(new File("src/main/resources/images/ShipSectionBow.png").toURI().toString());
                shipImages[1] = new Image(new File("src/main/resources/images/ShipSection1.png").toURI().toString());
                shipImages[2] = new Image(new File("src/main/resources/images/ShipSectionStern.png").toURI().toString());
                damagedShipImages = new Image[3];
                damagedShipImages[0] = new Image(new File("src/main/resources/images/DestroyedShipSectionBow.png").toURI().toString());
                damagedShipImages[1] = new Image(new File("src/main/resources/images/DestroyedShipSection1.png").toURI().toString());
                damagedShipImages[2] = new Image(new File("src/main/resources/images/DestroyedShipSectionStern.png").toURI().toString());
                break;
            case PATROL_BOAT:
                shipSize = 2;
                shipImages = new Image[2];
                shipImages[0] = new Image(new File("src/main/resources/images/ShipSectionBow.png").toURI().toString());
                shipImages[1] = new Image(new File("src/main/resources/images/ShipSectionStern.png").toURI().toString());
                damagedShipImages = new Image[2];
                damagedShipImages[0] = new Image(new File("src/main/resources/images/DestroyedShipSectionBow.png").toURI().toString());
                damagedShipImages[1] = new Image(new File("src/main/resources/images/DestroyedShipSectionStern.png").toURI().toString());
                break;
            default:
                break;
        }
        locationCoordinates = new Vector[shipSize];
        for (int i = 0; i < shipSize; i++) {
            locationCoordinates[i] = new Vector<>(2);
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
    }

    /**
     * postavlja koordinate pocetne tacke broda na nove X i Y koordinate
     */
    public void setLocationCoordinates(int x, int y) {
        for (int i = 0; i < locationCoordinates.length; i++) {
            if (isRotated) {
                x += i;
            }
            else {
                y += i;
            }

            locationCoordinates[i].add(x, y);
        }
    }

    /**
     * oznacava odredjen deo broda kao ostecen
     */
    public void DamageSection(int sectionIndex) {
        damagedSections.add(sectionIndex);
    }
}
