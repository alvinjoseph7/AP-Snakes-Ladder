package com.example.ap_ladder;

public class Token_translate implements Runnable {
        Token t1;
        Token_translate(Token t) {
            this.t1 = t;
        }
        @Override
        public void run() {
            t1.getButton().setTranslateX(t1.getX_curr() - t1.getX_init());
            t1.getButton().setTranslateY(t1.getY_curr() - t1.getY_init());
        }
}
