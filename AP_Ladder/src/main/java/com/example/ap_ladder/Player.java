package com.example.ap_ladder;

import javafx.scene.control.Button;

public class Player {
    private Token token;
    private int position;
    private boolean on_the_board;
    private boolean same_square;

    public Player(Button tok) {
        this.token = new Token(tok);
        this.position = 0;
        this.on_the_board = false;
        this.same_square = false;
    }   

    public Token getToken() {
        return token;
    }

    public boolean isSame_square() {
        return same_square;
    }
    public void setSame_square(boolean same_square) {
        this.same_square = same_square;
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

