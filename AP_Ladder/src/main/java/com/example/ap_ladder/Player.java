package com.example.ap_ladder;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Player {
    private Token token;
    private Integer position;

    public Player(Button button) {
        this.token = new Token(button);
        this.position = 0;
    }

    // void rollDice() {
        
    // }

    public void move() {
        //move token here 
        if (this.position % 10 == 0)
            this.token.transY();
        else
            this.token.transX();

        this.position += 1;
    }

    
}

