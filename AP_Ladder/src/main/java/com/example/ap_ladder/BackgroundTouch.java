package com.example.ap_ladder;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

class BackgroundTouch implements Runnable {
    private double x_pos;
    private double y_pos;
    private AnchorPane pane;

    public BackgroundTouch(double x, double y, AnchorPane pane1) {
        this.x_pos = x;
        this.y_pos = y;
        this.pane = pane1;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        Circle c = new Circle(x_pos, y_pos, 7);

        c.setFill(Color.WHITE);
        c.setEffect(new Glow(3.0));
        pane.getChildren().add(c); 

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
            
        
        // Create and start a Parallel Transition
        ParallelTransition parTransition = new ParallelTransition();
        parTransition.setNode(c);
        // Add the Children to the ParallelTransition
        parTransition.getChildren().addAll(fade, scale);
        // Let the animation run forever
        parTransition.setCycleCount(1);
        // Play the Animation
        parTransition.play(); 

    }

}
