package com.example.ap_ladder;

import java.io.FileNotFoundException;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

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
    private Label welcomeText;

    @FXML
    private  ImageView arrow;

    // private boolean myTurn;
    // public Circle c;
    
    @FXML    
    public void requestRoll(MouseEvent mouseEvent) throws InterruptedException, FileNotFoundException {
        switchShadow();
        MovePlayer mp = new MovePlayer(player, turn, board);
        mp.start();
        mp.join();
        this.turn = (this.turn == 1 ? 0:1);
 
    }

    
    private void switchShadow() {
        boolean vis = leftShadow.isVisible();
        leftShadow.setVisible(!vis);
        rightShadow.setVisible(vis);
        
    }
    
    // @FXML
    public void bkgdTouch(MouseEvent event) {
        double x = event.getSceneX();
        double y = event.getSceneY();
        
        Platform.runLater(new BackgroundTouch(x, y, pane1));

    }
    
    

    public void initialize() {
        board = new Board(dice);
        turn = 0;
        player[0] = new Player(token_1);
        player[1] = new Player(token_2);
        trns = new Transtok();
        // d1 = new Dice(dice);
        // turn = true;

        
    }
    
}


