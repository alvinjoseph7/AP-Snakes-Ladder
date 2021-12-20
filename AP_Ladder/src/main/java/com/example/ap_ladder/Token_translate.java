package com.example.ap_ladder;

import javafx.scene.control.Label;

public class Token_translate implements Runnable {


        player p;
        Label locval;

        (player p,Label locval){

            this.p=p;
            this.locval=locval;
        }
        @Override
        public void run() {
            p.btn.bt.setTranslateX(p.desx-p.btn.orgx);
            p.btn.bt.setTranslateY(p.desy-p.btn.orgy);
            locval.setText("Distance Moved:"+String.valueOf(p.btn.dc));
        }

}
