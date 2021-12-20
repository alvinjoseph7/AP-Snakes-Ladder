package com.example.ap_ladder;

public class MovePlayer extends Thread {
    Player player;
    Dice d1;
    Board b1
    public MovePlayer(Player player, Board b, Dice d) {
        this.player = player;
        this.d1 = d;
        this.b1 = b;

    }

    @Override
    public void run() {
        int numb = this.d1.roll_dice();
        if(!(this.player.isOn_the_board())) {
            if(numb == 1) {

            }
            else {
                //Label_updation
                return;
            }
        }
        /*
        while (number-- != 0) {
            // move once
            this.player.move();

            //pause for 100ms for animation feel
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

         */
    }
}
