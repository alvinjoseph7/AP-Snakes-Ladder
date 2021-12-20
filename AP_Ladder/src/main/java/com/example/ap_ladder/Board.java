package com.example.ap_ladder;
import javafx.scene.control.Button;


public class Board {

    // static public Dice dice;
    //static private Button dice;
    //static private int diceNo = 1;
    private static final double X_BOX=0; // = <fill it>;
    private static final double Y_BOX=0; // = <fill it>;
    private Movable[] elements;
    private double[][] maps;
    public Board(Button dice) {
        // this.dice = new Dice(dice);
        //this.dice = dice;
        this.elements = new Movable[20];
        this.maps = new double[100][2];
        this.initialise_mapping();
        this.initialise_elements();
    }
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
    public double get_X(int pos) {
        return this.maps[pos][0];
    }

    public double get_Y(int pos) {
        return this.maps[pos][1];
    }

    public double[][] getMaps() {
        return maps;
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
    private void initialise_mapping() {

    }
    private void initialise_elements() {
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
