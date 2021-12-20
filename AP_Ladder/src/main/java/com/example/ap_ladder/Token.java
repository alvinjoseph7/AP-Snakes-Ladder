package com.example.ap_ladder;

import javafx.scene.control.Button;

public class Token {
    Button button;
    private double x_curr;
    private double y_curr;
    private double x_init;
    private double y_init;
    
    Token(Button button) {
        this.button = button;
    }

    public double getX_curr() {
        return x_curr;
    }

    public void setX_curr(double x_curr) {
        this.x_curr = x_curr;
    }

    public double getY_curr() {
        return y_curr;
    }

    public void setY_curr(double y_curr) {
        this.y_curr = y_curr;
    }

    public double getX_init() {
        return x_init;
    }

    public void setX_init(double x_init) {
        this.x_init = x_init;
    }

    public double getY_init() {
        return y_init;
    }

    public void setY_init(double y_init) {
        this.y_init = y_init;
    }

    // public void move() {

    // }

    public void translate(int diceResult) {
        
    }
}
