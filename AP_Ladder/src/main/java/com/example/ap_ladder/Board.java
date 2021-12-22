package com.example.ap_ladder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class Board {

    // static private Button dice;
    // private double[][] maps;
    //static private int diceNo = 1;
    public static Dice dice;
    private static final double X_BOX = 40; // = <fill it>;
    private static final double Y_BOX = 40; // = <fill it>;
    private Movable[] elements;
    private static HashMap<Integer, Coordinate> map;


    public Board(Button _dice) {
        dice = new Dice(_dice);
        this.elements = new Movable[20];
        map = new HashMap<>(); 
        this.init_mapping();
        this.init_elements();
    }

    // public static Dice getDice() {
    //     return dice;
    // }
    public int get_position(int pos) {
        int fin_pos = pos;
        for(int i = 0; i < 20; ++i) {
            if (pos == this.elements[i].getInit_pos()) {
                fin_pos = this.elements[i].getFinal_pos();
                break;
            }
        }
        return fin_pos;
    }
    
    static public double get_X(int pos) {
        // return this.maps[pos-1][0];
        return map.get(pos + 1).getX();
    }

    static public double get_Y(int pos) {
        // return this.maps[pos-1][0];
        return map.get(pos + 1).getY();
    }


    private void init_mapping() {
        double x_init = 10;
        double y_init = 360;
        boolean towardRight = true;

        for (int pos = 1; pos <= 100; pos++) {

            map.put(pos, new Coordinate(x_init, y_init));
            if (pos % 10 == 0) {
                y_init -= Y_BOX;
                towardRight = !towardRight;
                continue;
            }
            
            if (towardRight)
                x_init += X_BOX;
            else
                x_init -= X_BOX;

        }
    }


    private void init_elements() {
        this.elements[0] = new Ladder(4, 25);
        this.elements[1] = new Ladder(8, 31);
        this.elements[2] = new Ladder(21, 60);
        this.elements[3] = new Ladder(28, 46);
        this.elements[4] = new Ladder(32, 48);
        this.elements[5] = new Ladder(52, 68);
        this.elements[6] = new Ladder(69, 93);
        this.elements[7] = new Ladder(84, 98);
        this.elements[8] = new Ladder(58, 77);
        this.elements[9] = new Ladder(42, 80);
        this.elements[10] = new Snake(11, 9);
        this.elements[11] = new Snake(36, 14);
        this.elements[12] = new Snake(56, 18);
        this.elements[13] = new Snake(43, 22);
        this.elements[14] = new Snake(81, 63);
        this.elements[15] = new Snake(99, 78);
        this.elements[16] = new Snake(96, 65);
        this.elements[17] = new Snake(75, 54);
        this.elements[18] = new Snake(94, 53);
        this.elements[19] = new Snake(90, 50);
    }
}

/*  public static int getDiceNo() {
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
*/