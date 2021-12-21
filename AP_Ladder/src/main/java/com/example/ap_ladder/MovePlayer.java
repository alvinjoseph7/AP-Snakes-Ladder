package com.example.ap_ladder;

public class MovePlayer extends Thread {
    private Player[] player;
    private Board b1;
    private int t;
    public MovePlayer(Player[] player, int turn, Board b) {
        this.player = player;
        this.t = turn;
        this.b1 = b;
    }

    @Override
    public void run() {
        int numb = Board.getDice().roll_dice();
        if(!(this.player[this.t].isOn_the_board())) {
            if(numb != 1) {
                //Label_updation
                return;
            }
            else {
                this.player[this.t].setOn_the_board();
            }
        }
        int semi_final_pos = numb + this.player[this.t].getPosition();
        if(semi_final_pos > 100) {
            //Label Updation
            return;
        }
        for(int i = this.player[this.t].getPosition(); i < semi_final_pos; ++i) {
            this.player[this.t].getToken().translate(this.b1.get_X(i), this.b1.get_Y(i));
            try {
                Thread.sleep(333);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.player[this.t].setPosition(semi_final_pos);
        if(semi_final_pos == 100) {
            this.player[this.t].setPosition(100);
            //l UpdaLabetion
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
        this.player[this.t].setPosition(final_pos);
        try {
            Thread.sleep(333);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.player[this.t].getToken().translate(this.b1.get_X(final_pos - 1), this.b1.get_Y(final_pos - 1));
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
