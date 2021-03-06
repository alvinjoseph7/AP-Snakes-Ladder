package com.example.ap_ladder;

import java.io.FileNotFoundException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class HelloController {
    Board board;
    private Player[] player = new Player[2];
    private int turn;
    private Transtok trns;
    @FXML
    private Button dice;

    @FXML
    private Rectangle rightShadow;

    @FXML
    private Rectangle leftShadow;

    @FXML
    private ImageView img11;

    @FXML
    private AnchorPane pane1;

    @FXML
    private Button token_1;

    @FXML
    private Button token_2;

    @FXML
    private Rectangle winRect;

    @FXML
    private Text winText;

    
    @FXML    
    public void requestRoll(MouseEvent mouseEvent) throws InterruptedException, FileNotFoundException {
        MovePlayer mp = new MovePlayer(player, turn, board, trns, winRect, winText);
        switchShadow();
        mp.start();
        mp.join();
        this.turn = (this.turn == 1 ? 0:1);
 
    }

    
    private void switchShadow() throws InterruptedException {
        boolean vis = leftShadow.isVisible();
        leftShadow.setVisible(!vis);
        rightShadow.setVisible(vis);
        
    }
    
    @FXML
    public void bkgdTouch(MouseEvent event) {
        double x = event.getSceneX();
        double y = event.getSceneY();
        Circle c = new Circle(x, y, 7);
        c.setFill(Color.WHITE);
        c.setEffect(new Glow(3.0));
        pane1.getChildren().add(c); 

        
        Platform.runLater(new BackgroundTouch(c));

    }
    
    

    public void initialize() {
        board = new Board(dice);
        turn = 0;
        player[0] = new Player(token_1);
        player[1] = new Player(token_2);
        trns = new Transtok();

        
    }
    
}


