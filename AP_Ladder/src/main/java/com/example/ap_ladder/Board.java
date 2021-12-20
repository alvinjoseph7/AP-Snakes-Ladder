package com.example.ap_ladder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class Board {

    // static public Dice dice;
    static private Button dice;
    static private int diceNo = 1; 
    static final public double X_BOX; // = <fill it>; 
    static final public double Y_BOX; // = <fill it>; 

    public Board(Button dice) {
        // this.dice = new Dice(dice);
        this.dice = dice;
    }

    public static int getDiceNo() {
        return diceNo;
    }


    public static void setDiceNo(int diceNo) {
        Board.diceNo = diceNo;
    }

    public int rollDice() throws FileNotFoundException {
        for (int i = 0; i < 6; i++) {
            // use this to show rolling animation
            // Image img = new Image(new FileInputStream("path"));
        }
        
        Random rand = new Random();
        int diceResult = rand.nextInt(6) + 1;
        return diceResult;
    }



}
