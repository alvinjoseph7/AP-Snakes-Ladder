package com.example.ap_ladder;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Player {
    private Token token;
    private int position;
    private boolean on_the_board;

    public Player(Button tok) {
        this.token = new Token(tok);
        this.position = 0;
        this.on_the_board = false;
    }
/*
    public void move() {
        //move token here 
        if (this.position % 10 == 0)
            this.token.transY();
        else
            this.token.transX();

        this.position += 1;
    }

    */

    public Token getToken() {
        return token;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isOn_the_board() {
        return on_the_board;
    }

    public void setOn_the_board() {
        this.on_the_board = true;
    }
}

