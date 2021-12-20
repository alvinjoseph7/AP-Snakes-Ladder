package com.example.ap_ladder;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    Board board;
    public Player player1;
    public Player player2;
    
    @FXML
    private Button dice;

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

    // boolean turn;

    
    @FXML
    public void bkgdTouch(MouseEvent event) {
        Platform.runLater(new BackgroundTouch());

    }
    
    @FXML    
    public void requestRoll(MouseEvent mouseEvent) throws InterruptedException {
        int diceResult = board.rollDice();
        MovePlayer m1 = new MovePlayer(player1, diceResult);
        // player1.move(diceResult);
        m1.join();
        yieldToComputer();
        // player1.roll(mouseEvent);
    }
    
    
    
    private void yieldToComputer() {
        int diceResult = board.rollDice();
        MovePlayer m2 = new MovePlayer(player2, diceResult);

        // player2.move(diceResult);
    }

    void initalize() {
        board = new Board();

        player1 = new Player(token_1);
        player2 = new Player(token_2);
        // turn = true;

        
    }
}

class BackgroundTouch implements Runnable {

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
            this.player.move(1);

            //pause for 100ms for animation feel
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
