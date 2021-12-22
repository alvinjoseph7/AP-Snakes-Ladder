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


    private Circle c;
    public BackgroundTouch(Circle c) {
        this.c = c;
    }

    @Override
    public void run() {
        

        ScaleTransition scale = new ScaleTransition();   
        scale.setByX(1);  
        scale.setByY(1);  
        scale.setDuration(Duration.millis(500));  
        scale.setCycleCount(1);  
        scale.setAutoReverse(true);  
        
        FadeTransition fade = new FadeTransition();  
        fade.setDuration(Duration.millis(500));  
        fade.setFromValue(0.8);  
        fade.setToValue(0); 
        fade.setCycleCount(1);  
        fade.setAutoReverse(true);  
            
        
        // Create and start a Parallel Transition
        ParallelTransition parTransition = new ParallelTransition();
        parTransition.setNode(c);
        // Add the Children to the ParallelTransition
        parTransition.getChildren().addAll(fade, scale);
        // Let the animation run forever
        parTransition.setCycleCount(1);
        parTransition.play(); 

    }

}
