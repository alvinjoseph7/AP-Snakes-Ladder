package com.example.ap_ladder;

import javafx.scene.control.Button;

public class Dice_Animation implements Runnable {
    private String s;
    private Button d;
    Dice_Animation(String st, Button d1) {
        this.d = d1;
        this.s = st;
    }
    @Override
    public void run() {
        this.d.setText(this.s);
    }
}
