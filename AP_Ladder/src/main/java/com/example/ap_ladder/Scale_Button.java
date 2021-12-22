package com.example.ap_ladder;

public class Scale_Button implements Runnable {
    private Token t1;
    private double x;
    private double y;
    Scale_Button(Token t, double x, double y) {
        this.t1 = t;
        this.x = x;
        this.y = y;
    }
    @Override
    public void run() {
        t1.getButton().setPrefSize(x, y);
    }
}