package com.example.ap_ladder;

import java.io.FileNotFoundException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class HelloController {
    Board board;
    private Player[] player = new Player[2];
    private int turn;
    // private Dice d1;
    
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

    // private boolean myTurn;
    // public Circle c;
    
    @FXML    
    public void requestRoll(MouseEvent mouseEvent) throws InterruptedException, FileNotFoundException {
        switchShadow();
        MovePlayer mp = new MovePlayer(player[turn]);
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
        Circle c = new Circle(x, y, 10.0);
        c.setFill(Color.WHITE);
        c.setEffect(new Glow(1.0));
        pane1.getChildren().add(c); 
        
        // try {
        //     Thread.sleep(2000);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // c.setVisible(false);
        
        Circle circ2 = new Circle(x, y, 70);
        circ2.setFill(Color.TRANSPARENT);
        circ2.setStroke(Color.WHITE);
        pane1.getChildren().add(circ2); 
        
        // try {
        //     Thread.sleep(100);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        circ2.setRadius(circ2.getRadius()*1.5);
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // c.setVisible(false);
        // circ2.setVisible(false);

        // Platform.runLater(new BackgroundTouch(x, y));

    }
    
    

    void initalize() {
        board = new Board(dice);
        turn = 0;
        player[0] = new Player(token_1);
        player[1] = new Player(token_2);
        // d1 = new Dice(dice);
        // turn = true;

        
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
        Circle c = new Circle(x_pos, y_pos, 8);
        c.setFill(Color.WHITE);
        c.setEffect(new Glow(1.0));

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        c.setVisible(false);

        Circle circ2 = new Circle(x_pos, y_pos, 12);
        circ2.setFill(Color.TRANSPARENT);
        circ2.setStroke(Color.WHITE);
        
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        circ2.setRadius(circ2.getRadius()*1.5);
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        circ2.setVisible(false);

    }

}
