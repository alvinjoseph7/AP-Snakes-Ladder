package com.example.ap_ladder;

import java.io.FileNotFoundException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class HelloController {
    Board board;
    public Player player1;
    public Player player2;
    
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

    private boolean myTurn;

    
    @FXML    
    public void requestRoll(MouseEvent mouseEvent) throws InterruptedException, FileNotFoundException {
        
        switchShadow();
        int diceResult = board.rollDice();
        MovePlayer mp1 = new MovePlayer(player1, diceResult);
        
        mp1.join();
        yieldToComputer();
        // right_shadow.setV
    }


    private void yieldToComputer() throws FileNotFoundException {
        // leftShadow.setVisible(true);
        // rightShadow.setVisible(false);
        int diceResult = board.rollDice();
        MovePlayer mp2 = new MovePlayer(player2, diceResult);

        // player2.move(diceResult);
    }

    @FXML
    public void bkgdTouch(MouseEvent event) {
        double x = event.getSceneX();
        double y = event.getSceneY();
        Platform.runLater(new BackgroundTouch(x, y));

    }
    
    
    
    

    void initalize() {
        board = new Board(dice);
        player1 = new Player(token_1);
        player2 = new Player(token_2);
    }
}

class BackgroundTouch implements Runnable {
    private double x_pos;
    private double y_pos;

    public BackgroundTouch(double x, double y) {
        this.x_pos = x;
        this.y_pos = y;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
        //show touched animation here
        //circles flowing out

    }

}

class MovePlayer extends Thread {
    Player player;
    int result;
    public MovePlayer(Player player, int diceResult) {
        this.player = player;
        this.result = diceResult;

    }

    @Override
    public void run() {
        
        int number = result;
        // TODO Auto-generated method stub
        while (number-- != 0) {
            // move once
            this.player.move();

            //pause for 100ms for animation feel
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void switchShadow() {
        if (myTurn) {
            leftShadow.setVisible(false);
            rightShadow.setVisible(true);
        } else {
            leftShadow.setVisible(true);
            rightShadow.setVisible(false);
        }
    }
}
