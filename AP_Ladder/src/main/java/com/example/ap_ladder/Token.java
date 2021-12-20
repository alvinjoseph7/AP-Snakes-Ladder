package com.example.ap_ladder;

import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;

public class Token {
    private Button button;
    private double x_curr;
    private double y_curr;
    private double x_init;
    private double y_init;
    
    Token(Button button) {
        Bounds bis = button.localToScene(button.getBoundsInLocal());
        this.x_init = bis.getMinX();
        this.y_init = bis.getMinY();
        this.x_curr  =this.x_init;
        this.y_curr  =this.y_init;
        this.button = button;
    }
    public void translate(double x, double y) {
        this.x_curr = x;
        this.y_curr = y;
        Platform.runLater(new Runnable Token_translate(this));
    }
/*
    public void transX() {
        this.button.setTranslateX(Board.X_BOX);
    }

	public void transY() {
        this.button.setTranslateY(Board.Y_BOX);
    }


 */
}
