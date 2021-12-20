package com.example.ap_ladder;

import javafx.scene.control.Button;

public class Token {
    private Button button;
    
    private double x_curr;
    private double y_curr;
    private double x_init;
    private double y_init;
    
    Token(Button button) {
        this.button = button;

    }

    public void transX() {
        this.button.setTranslateX(value);
    }

	public void transY() {
        this.button.setTranslateY(value);
    }
    
    
}
