package com.example.projekat_navalwar_andrijapesic6213.scene;

import com.example.projekat_navalwar_andrijapesic6213.elements.Ship;
import com.example.projekat_navalwar_andrijapesic6213.elements.Tile;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.File;

/**
 * Klasa koja metode za pravljenje scena
 */
public class SceneCreator {
    /**
     * Sirina scene.
     */
    private static int sceneWidth = 600;

    /**
     * Visina scene.
     */
    private static int sceneHeight = 800;

    /**
     * Pravi login scenu. Preko ove scene se igrac povezuje na server i ulazi u igru ili pravi nalog.
     */
    public static Scene createLoginScene(){

        BorderPane root = new BorderPane();

        Label gameTitleLabel = new Label("Naval War");
        Label usernameLabel = new Label("Username");
        Label passwordLabel = new Label("Password");
        Label signUpLabel  = new Label("Don't have an account?");
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Button signUpButton = new Button("Sign up");
        Button quitButton = new Button("Quit");

        gameTitleLabel.setFont(new Font(40));
        usernameLabel.setFont(new Font(20));
        passwordLabel.setFont(new Font(20));
        signUpLabel.setFont(new Font(20));

        loginButton.setFont(new Font(20));
        loginButton.setPrefSize(200, 40);
        signUpButton.setFont(new Font(20));
        quitButton.setFont(new Font(20));
        quitButton.setPrefSize(100, 20);

        loginButton.setOnAction(e -> {
            //uzima unete podatke, konektuje se na server, proverava podatke i daje odgovor
        });

        signUpButton.setOnAction(e -> {
            //otvara sign up scenu
        });

        quitButton.setOnAction(e -> {
            // zatvara aplikaciju
        });

        usernameField.setFont(new Font(20));
        passwordField.setFont(new Font(20));
        usernameField.setMaxWidth(400);
        passwordField.setMaxWidth(400);

        // rasporedjivanje
        VBox loginVBox = new VBox();
        VBox usernameVBox = new VBox();
        VBox passwordVBox = new VBox();
        HBox signUpHBox = new HBox();
        usernameVBox.getChildren().addAll(usernameLabel, usernameField);
        passwordVBox.getChildren().addAll(passwordLabel, passwordField);
        signUpHBox.getChildren().addAll(signUpLabel, signUpButton);

        loginVBox.getChildren().addAll(usernameVBox, passwordVBox, loginButton, signUpHBox);

        usernameVBox.setAlignment(Pos.CENTER);
        usernameVBox.setSpacing(15);
        passwordVBox.setAlignment(Pos.CENTER);
        passwordVBox.setSpacing(15);
        loginVBox.setAlignment(Pos.CENTER);
        loginVBox.setSpacing(50);

        signUpHBox.setAlignment(Pos.CENTER);
        signUpHBox.setPadding(new Insets(30));
        signUpHBox.setSpacing(20);

        root.setTop(gameTitleLabel);
        root.setCenter(loginVBox);
        root.setBottom(quitButton);

        root.setPadding(new Insets(30));
        root.setAlignment(gameTitleLabel, Pos.TOP_CENTER );
        root.setAlignment(quitButton, Pos.BOTTOM_CENTER);

        Scene loginScene = new Scene(root, sceneWidth, sceneHeight);
        return loginScene;
    }

    /**
     * Pravi Sign up scenu. Preko ove scene igrac pravi nalog i povezuje se na server ili se vraca na Login scenu.
     */
    public static Scene createSignUpScene(){

        BorderPane root = new BorderPane();

        Label gameTitleLabel = new Label("Naval War");
        Label usernameLabel = new Label("Username");
        Label passwordLabel = new Label("Password");
        Label signUpLabel  = new Label("Already have an account?");
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Button signUpButton = new Button("Sign up");
        Button quitButton = new Button("Quit");

        gameTitleLabel.setFont(new Font(40));
        usernameLabel.setFont(new Font(20));
        passwordLabel.setFont(new Font(20));
        signUpLabel.setFont(new Font(20));

        signUpButton.setFont(new Font(20));
        signUpButton.setPrefSize(200, 40);
        loginButton.setFont(new Font(20));
        quitButton.setFont(new Font(20));
        quitButton.setPrefSize(100, 20);

        signUpButton.setOnAction(e -> {
            //uzima unete podatke, konektuje se na server, proverava podatke i daje odgovor
        });

        loginButton.setOnAction(e -> {
            //otvara login scenu
        });

        quitButton.setOnAction(e -> {
            // zatvara aplikaciju
        });

        usernameField.setFont(new Font(20));
        passwordField.setFont(new Font(20));
        usernameField.setMaxWidth(400);
        passwordField.setMaxWidth(400);

        // rasporedjivanje
        VBox signUpVBox = new VBox();
        VBox usernameVBox = new VBox();
        VBox passwordVBox = new VBox();
        HBox loginHBox = new HBox();
        usernameVBox.getChildren().addAll(usernameLabel, usernameField);
        passwordVBox.getChildren().addAll(passwordLabel, passwordField);
        loginHBox.getChildren().addAll(signUpLabel, loginButton);

        signUpVBox.getChildren().addAll(usernameVBox, passwordVBox, signUpButton, loginHBox);

        usernameVBox.setAlignment(Pos.CENTER);
        usernameVBox.setSpacing(15);
        passwordVBox.setAlignment(Pos.CENTER);
        passwordVBox.setSpacing(15);
        signUpVBox.setAlignment(Pos.CENTER);
        signUpVBox.setSpacing(50);

        loginHBox.setAlignment(Pos.CENTER);
        loginHBox.setPadding(new Insets(30));
        loginHBox.setSpacing(20);

        root.setTop(gameTitleLabel);
        root.setCenter(signUpVBox);
        root.setBottom(quitButton);

        root.setPadding(new Insets(30));
        root.setAlignment(gameTitleLabel, Pos.TOP_CENTER );
        root.setAlignment(quitButton, Pos.BOTTOM_CENTER);

        Scene signUpScene = new Scene(root, sceneWidth, sceneHeight);
        return signUpScene;
    }

    /**
     * Pravi Main menu scenu. Ovo je scene koja se prikazuje nakon sto se igrac uloguje i iz ove scene se moze zapoceti mec.
     */
    public static Scene createMainMenuScene(){

        BorderPane root = new BorderPane();
        Label gameTitleLabel = new Label("Naval War");
        Label usernameLabel = new Label("Username placehodler");
        Button playButton = new Button("Play");
        Button quitButton = new Button("Quit");

        gameTitleLabel.setFont(new Font(40));
        usernameLabel.setFont(new Font(30));

        playButton.setFont(new Font(20));
        playButton.setPrefSize(200, 40);
        quitButton.setFont(new Font(20));
        quitButton.setPrefSize(100, 20);

        playButton.setOnAction(e -> {
            // salje zahtevu serveru za trazenje meca
        });
        quitButton.setOnAction(e -> {
           // zatvara aplikaciju
        });

        // rasporedjivanje
        VBox menuVBox = new VBox();
        menuVBox.getChildren().addAll(usernameLabel, playButton);

        menuVBox.setAlignment(Pos.TOP_CENTER);
        menuVBox.setSpacing(30);
        menuVBox.setPadding(new Insets(30));

        root.setTop(gameTitleLabel);
        root.setCenter(menuVBox);
        root.setBottom(quitButton);

        root.setPadding(new Insets(30));
        root.setAlignment(gameTitleLabel, Pos.TOP_CENTER );
        root.setAlignment(quitButton, Pos.BOTTOM_CENTER);

        Scene mainMenuScene = new Scene(root, sceneWidth, sceneHeight);
        return mainMenuScene;
    }

    /**
     * Scena koja se prikazuje dok se ceka na pronalazenje protivnika. Ovde igrac ceka na protivnika ili otkazuje trazenje.
     */
    public static Scene createMatchmakingScene() {
        BorderPane root = new BorderPane();
        Label matchmakingTextLabel = new Label("Looking for an Opponent...");
        Button cancelButton = new Button("Cancel");
        File imageFile = new File("src/main/resources/images/MatchmakingImage.png");
        Image image = new Image(imageFile.toURI().toString());
        ImageView imageView = new ImageView(image);

        matchmakingTextLabel.setFont(new Font(40));

        cancelButton.setFont(new Font(20));
        cancelButton.setPrefSize(200, 20);

        cancelButton.setOnAction(e -> {
           // vraca na main menu
        });

        imageView.setPreserveRatio(true);
        imageView.setFitWidth(500);

        // rasporedjivanje
        root.setTop(matchmakingTextLabel);
        root.setCenter(imageView);
        root.setBottom(cancelButton);

        root.setPadding(new Insets(30));
        root.setAlignment(matchmakingTextLabel, Pos.TOP_CENTER );
        root.setAlignment(cancelButton, Pos.BOTTOM_CENTER);

        Scene MatchmakingScene = new Scene(root, sceneWidth, sceneHeight);
        return MatchmakingScene;
    }

    /**
     * Scena koja se prikazuje kada se dva igraca povezu prenego da mec pocne. Ovde igraci redjaju svoje brodove na
     * svoje table i potvrdjuju kada su spremni ili napustaju mec.
     */
    public static Scene createReadyUpScene(Tile[][] tiles, Ship[] ships) {
        BorderPane root = new BorderPane();
        Label infoTextLabel = new Label("Ready up"); // ili "Waiting for the opponent"
        Button leaveButton = new Button("Leave");
        Button readyButton = new Button("Ready");
        Rectangle boardRectangle = new Rectangle(500, 500);

        infoTextLabel.setFont(new Font(40));

        boardRectangle.setFill(Color.NAVY);

        leaveButton.setFont(new Font(20));
        leaveButton.setPrefSize(100, 20);
        readyButton.setFont(new Font(20));
        readyButton.setPrefSize(200, 20);

        leaveButton.setOnAction(e -> {
            // vraca na main menu
        });

        readyButton.setOnAction(e -> {
            // daje znak da je igrac spreman
        });

        // rasporedjivanje
        GridPane gridPane = new GridPane();
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(boardRectangle, gridPane);
        HBox buttonsHBox = new HBox();
        buttonsHBox.getChildren().addAll(leaveButton, readyButton);

        for(int i = 0; i < 100; i++){
            tiles[i % 10][i / 10] = new Tile();
            gridPane.add(tiles[i % 10][i / 10].getTilePane(), i % 10, i / 10);
        }

        for(int i = 0, x = 0, y = 9; i < ships.length;){
           if (tiles[x][y].getHasShip()){
               x++;
               if(x > 9){
                   x = 0;
                   y--;
               }
               continue;
           }

           if ( x + ships[i].getShipSize() - 1 > 9){
               x = 0;
               y--;
               continue;
           }

            ships[i].setLocationCoordinates(x, y);
            for(int j = 0; j < ships[i].getShipSize(); j++){
                tiles[ships[i].getLocationCoordinates()[j].get(0)][ships[i].getLocationCoordinates()[j].get(1)].setShipOnTile(ships[i]);
            }

            i++;
        }

        buttonsHBox.setAlignment(Pos.CENTER_LEFT);
        buttonsHBox.setSpacing(200);
        buttonsHBox.setPadding(new Insets(20));

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(4);
        gridPane.setVgap(4);

        root.setTop(infoTextLabel);
        root.setCenter(stackPane);
        root.setBottom(buttonsHBox);

        root.setPadding(new Insets(30));
        root.setAlignment(infoTextLabel, Pos.TOP_CENTER );

        Scene readyUpScene = new Scene(root, sceneWidth, sceneHeight);
        return readyUpScene;
    }

    /**
     * Scena koja se prikazuje kada igra pocne. Ovde igraci igraju igru.
     */
    public static Scene createGameplayScene(Stage stage, Tile[][] tiles) {
        BorderPane root = new BorderPane();
        Label roundLabel = new Label("Round 0");
        Label timeLabel = new Label("Time left: 00");
        Label fleetInfoLabel = new Label("Enemy Fleet 6/6");
        Button confirmButton = new Button("Confirm");
        Button switchBoardsButton = new Button("⇄");
        Button menuButton = new Button("≡");
        Button surrenderButton = new Button("Surrender");
        Button resumeButton = new Button("Resume");
        Rectangle boardRectangle = new Rectangle(500, 500);
        Rectangle popUpRectangle = new Rectangle(300, 250);
        Popup menuPopup = new Popup();

        roundLabel.setFont(new Font(40));
        timeLabel.setFont(new Font(30));
        fleetInfoLabel.setFont(new Font(30));

        boardRectangle.setFill(Color.NAVY);

        popUpRectangle.setFill(Color.WHITE);
        popUpRectangle.setStroke(Color.BLACK);
        popUpRectangle.setStrokeWidth(3);

        confirmButton.setFont(new Font(20));
        confirmButton.setPrefSize(200, 20);
        switchBoardsButton.setFont(new Font(50));
        switchBoardsButton.setPadding(new Insets(0, 25,0,25));
        menuButton.setFont(new Font(40));
        menuButton.setPadding(new Insets(0, 15,0,15));
        resumeButton.setFont(new Font(20));
        resumeButton.setPrefSize(200, 20);
        surrenderButton.setFont(new Font(20));
        surrenderButton.setPrefSize(200, 20);

        switchBoardsButton.setOnAction(e -> {
            // menja da li se prikazuje protivnikova ili igraceva tabla
        });

        confirmButton.setOnAction(e -> {
            // potvrdjuje da je igrac zavrsio potez
        });

        menuButton.setOnAction(e -> {
            if (!menuPopup.isShowing()) {
                menuPopup.show(stage);
            } else  {
                menuPopup.hide();
            }
        });

        resumeButton.setOnAction(e -> {
            menuPopup.hide();
        });

        surrenderButton.setOnAction(e -> {
           // igrac se diskonektuje i drugi igrac postaje pobednik
        });

        // rasporedjivanje
        GridPane gridPane = new GridPane();
        StackPane gridStackPane = new StackPane();
        StackPane popupStackPane = new StackPane();
        HBox gameInfoHBox = new HBox();
        HBox boardInfoHBox = new HBox();
        VBox menuVBox = new VBox();
        VBox centerVBox = new VBox();

        gridStackPane.getChildren().addAll(boardRectangle, gridPane);
        gameInfoHBox.getChildren().addAll(menuButton, roundLabel, timeLabel);
        boardInfoHBox.getChildren().addAll(switchBoardsButton, fleetInfoLabel);
        menuVBox.getChildren().addAll(resumeButton, surrenderButton);
        popupStackPane.getChildren().addAll(popUpRectangle, menuVBox);
        centerVBox.getChildren().addAll(boardInfoHBox, gridStackPane);
        menuPopup.getContent().add(popupStackPane);

        for(int i = 0; i < 100; i++){
            tiles[i / 10][i % 10] = new Tile();
            gridPane.add(tiles[i / 10][i % 10].getTilePane(), i % 10, i / 10);
        }

        gameInfoHBox.setAlignment(Pos.CENTER);
        gameInfoHBox.setSpacing(80);
        gameInfoHBox.setPadding(new Insets(0,0,40,0));

        boardInfoHBox.setAlignment(Pos.CENTER_LEFT);
        boardInfoHBox.setSpacing(80);

        menuVBox.setAlignment(Pos.CENTER);
        menuVBox.setSpacing(30);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(4);
        gridPane.setVgap(4);

        root.setTop(gameInfoHBox);
        root.setCenter(centerVBox);
        root.setBottom(confirmButton);

        root.setPadding(new Insets(20,30,30,30));
        root.setAlignment(confirmButton, Pos.BOTTOM_CENTER);

        Scene readyUpScene = new Scene(root, sceneWidth, sceneHeight);
        return readyUpScene;
    }

}
