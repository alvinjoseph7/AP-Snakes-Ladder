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
        MovePlayer mp = new MovePlayer(player, turn, board);
        mp.start();
        mp.join();
        this.turn = (this.turn == 1 ? 0:1);
        switchShadow();
 
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
        Circle c = new Circle(x, y, 7);

        c.setFill(Color.WHITE);
        c.setEffect(new Glow(3.0));
        pane1.getChildren().add(c); 

        ScaleTransition scale = new ScaleTransition();   
        //shifting the X coordinate of the centre of the circle by 400   
        scale.setByX(1);  
        scale.setByY(1);  
          
        //setting the duration for the Translate transition   
        scale.setDuration(Duration.millis(500));  
          
        //setting cycle count for the Translate transition   
        scale.setCycleCount(1);  
          
        //the transition will set to be auto reversed by setting this to true   
        scale.setAutoReverse(true);  
        
        FadeTransition fade = new FadeTransition();  
        //setting the duration for the Fade transition   
        fade.setDuration(Duration.millis(500));  
          
        //setting the initial and the target opacity value for the transition   
        fade.setFromValue(0.8);  
        fade.setToValue(0); 
        // c.setRadius(c.getRadius()*1.2); 
          
        //setting cycle count for the Fade transition   
        fade.setCycleCount(1);  
          
        //the transition will set to be auto reversed by setting this to true   
        fade.setAutoReverse(true);  
          
        //setting Circle as the node onto which the transition will be applied  
          
          
        //playing the transition   
        // fade.play();  
        // Create and start a Parallel Transition
        ParallelTransition parTransition = new ParallelTransition();
        parTransition.setNode(c);
        // Add the Children to the ParallelTransition
        parTransition.getChildren().addAll(fade, scale);
        // Let the animation run forever
        parTransition.setCycleCount(1);
        // Play the Animation
        parTransition.play(); 


        // Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), ev -> {
            
        //     // c.setCenterX(random((int) scene.getX()));
        //     // c.setCenterY(random((int) scene.getY()));
        //     c.setRadius(c.getRadius()*1.2);
            
        //     c.setOpacity(0.25);
            
        // }));
        // timeline.setCycleCount(4);
        // timeline.play();
        
        
        // pane1.getChildren().remove(c);
        // c.setOpacity(0);
        // Circle circ2 = new Circle(x, y, 15);
        // circ2.setFill(Color.TRANSPARENT);
        // circ2.setStroke(Color.WHITE);
        // pane1.getChildren().add(circ2); 

        // Timeline timeline = new Timeline();
        // timeline.setCycleCount(Timeline.INDEFINITE);
        // timeline.setAutoReverse(true);
        // circ2.setRadius(circ2.getRadius()*1.5);

        // Duration duration = Duration.millis(2000);
        // try {
        //     Thread.sleep(2000);
        //     c.setOpacity(0);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // c.setVisible(false);
        // circ2.setVisible(false);

        // Platform.runLater(new BackgroundTouch(x, y));

    }
    
    

    public void initialize() {
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

        // try {
        //     Thread.sleep(100);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // c.setVisible(false);

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
