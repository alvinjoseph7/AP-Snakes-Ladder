package com.example.ap_ladder;

import javafx.application.Platform;
import javafx.scene.control.Button;
import java.util.Random;

public class Dice {
    private int numb;
    private Button d;
    public Dice(Button dice) {
        this.numb = 0;
        this.d = dice;
    }
    public int roll_dice() {
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            int r = rand.nextInt(6) + 1;
            String s = "-fx-background-image: url('C:/Users/alvin/Code/Java/ap-project/AP_Ladder/src/main/resources/com/example/ap_ladder/" + String.valueOf(r) + ".png')";
            Platform.runLater(new Dice_Animation(s, this.d));
            try {
                Thread.sleep(300);}
            catch(Exception e) {
                e.printStackTrace();
            }
            // use this to show rolling animation
            // Image img = new Image(new FileInputStream("path"));
        }
        this.numb = rand.nextInt(6) + 1;
        String st = "-fx-background-image: url('C:/Users/alvin/Code/Java/ap-project/AP_Ladder/src/main/resources/com/example/ap_ladder/" + String.valueOf(this.numb) + ".png')";
        Platform.runLater(new Dice_Animation(st, this.d));
        return this.numb;
    }
}


class Dice_Animation implements Runnable {
    private String s;
    private Button d;
    Dice_Animation(String st, Button d1) {
        this.d = d1;
        this.s = st;
    }
    @Override
    public void run() {
        this.d.setStyle(this.s);
    }
}