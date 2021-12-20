package com.example.ap_ladder;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Player {
    private Token token;

    public Player(Button button) {
        this.token = new Token(button);
    }

    // void rollDice() {
        
    // }

    public void move(int diceResult) {
        //move token here 
        this.token.translate(diceResult);

    }

    
}

