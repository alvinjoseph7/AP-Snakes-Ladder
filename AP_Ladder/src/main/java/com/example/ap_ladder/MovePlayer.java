package com.example.ap_ladder;

public class MovePlayer extends Thread {
    Player player;
    Dice d1;
    Board b1;
    public MovePlayer(Player player, Board b, Dice d) {
        this.player = player;
        this.d1 = d;
        this.b1 = b;
    }

    @Override
    public void run() {
        int numb = this.d1.roll_dice();
        if(!(this.player.isOn_the_board())) {
            if(numb != 1) {
                //Label_updation
                return;
            }
            else {
                this.player.setOn_the_board();
            }
        }
        int semi_final_pos = numb + this.player.getPosition();
        if(semi_final_pos > 100) {
            //Label Updation
            return;
        }
        for(int i = this.player.getPosition(); i < semi_final_pos; ++i) {
            this.player.getToken().translate(this.b1.get_X(i), this.b1.get_Y(i));
            try {
                Thread.sleep(333);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.player.setPosition(semi_final_pos);
        if(semi_final_pos == 100) {
            this.player.setPosition(100);
            //Label Updation
            try {
                Thread.sleep(5000);}
            catch(Exception e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
        int final_pos = b1.get_position(semi_final_pos);
        if(final_pos == semi_final_pos) {
            return;
        }
        this.player.setPosition(final_pos);
        try {
            Thread.sleep(333);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.player.getToken().translate(this.b1.get_X(final_pos - 1), this.b1.get_Y(final_pos - 1));
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
