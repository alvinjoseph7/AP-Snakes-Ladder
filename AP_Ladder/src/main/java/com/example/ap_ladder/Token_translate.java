package com.example.ap_ladder;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class Token_translate implements Runnable {
        Token t1;
        Token_translate(Token t) {
            this.t1 = t;
        }
        @Override
        public void run() {
            TranslateTransition transanim = new TranslateTransition();
            transanim.setDuration(Duration.millis(300));
            transanim.setNode(t1.getButton());
            transanim.setToX(t1.getX_curr() - t1.getX_init());
            transanim.setToY(t1.getY_curr() - t1.getY_init());
            transanim.play();
        }
}
