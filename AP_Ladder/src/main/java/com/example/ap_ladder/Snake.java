package com.example.ap_ladder;

public class Snake implements Movable {
    private int init_pos;
    private int final_pos;
    Snake(int init, int fin) {
        this.final_pos = fin;
        this.init_pos = init;
    }
    @Override
    public int getInit_pos() {
        return init_pos;
    }
    @Override
    public int getFinal_pos() {
        return final_pos;
    }
}
