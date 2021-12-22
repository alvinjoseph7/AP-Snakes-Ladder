package com.example.ap_ladder;

import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;

public class Token {
    private Button button;
    private double x_curr;
    private double y_curr;
    private final double x_init;
    private final double y_init;
    
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
        Platform.runLater(new Token_translate(this));
    }

    public void scaledown() {
        Platform.runLater(new Scale_Button(this, 18, 33));
    }

    public void scalenormal() {
        Platform.runLater(new Scale_Button(this, 22, 38));
    }


    public Button getButton() {
        return button;
    }

    public double getX_curr() {
        return x_curr;
    }

    public double getY_curr() {
        return y_curr;
    }

    public double getX_init() {
        return x_init;
    }


    public double getY_init() {
        return y_init;
    }

}
