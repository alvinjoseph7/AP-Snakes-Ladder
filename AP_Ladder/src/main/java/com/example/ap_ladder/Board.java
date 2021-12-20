package com.example.ap_ladder;

public class Board {
    static public Dice dice;
    public Board() {
        dice = new Dice();
        
    }
    public int rollDice() {
         /*
        1. generate int random no
        2. show animation
        
        */
        
        //show animation here
        int diceResult = (int)java.lang.Math.random();
        return diceResult;
    }

}
