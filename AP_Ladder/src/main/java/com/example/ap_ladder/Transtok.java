package com.example.ap_ladder;

import javafx.animation.AnimationTimer;

public class Transtok extends AnimationTimer {
    private final long FRAMES_PER_SEC = 3L;
    private final long interval = 1000000000L / FRAMES_PER_SEC;
    private long last = 0;
    private int count;
    private Player p1;
    private int poss;
    
    public void setparam(Player p1, int p) {
        this.p1 = p1;
        this.poss = p;
        this.last = 0;
        this.count = this.p1.getPosition();
    }

    @Override
    public void handle(long now) {
        if(now - last > interval) {
            this.p1.getToken().translate(Board.get_X(count), Board.get_Y(count));
            last = now;
            ++count;
            if(count >= poss) {
                this.stop();
            }
        }
    }
}
