package com.example.ap_ladder;

public class MovePlayer extends Thread {
    private Player[] player;
    private Board b1;
    private Transtok tns;
    private int t;
    public MovePlayer(Player[] player, int turn, Board b, Transtok transt) {
        this.player = player;
        this.t = turn;
        this.b1 = b;
        this.tns = transt;
    }

    @Override
    public void run() {
        int numb = Board.dice.roll_dice();
        System.out.println(numb);
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
        this.tns.setparam(this.player[this.t], semi_final_pos);
        this.tns.start();
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
        //if(final_pos == semi_final_pos) {
        //    return;
        //}
        this.player[this.t].setPosition(final_pos - 1);
        this.tns.setparam(this.player[this.t], final_pos);
        this.tns.start();
        this.player[this.t].setPosition(final_pos);
        int tal = 0;
        if(this.t == 0) {
            tal = 1;
        }
        if(this.player[this.t].isSame_square()) {
            if(this.player[this.t].getPosition() != this.player[tal].getPosition()) {
                this.player[this.t].setSame_square(false);
                this.player[tal].setSame_square(false);
                this.player[tal].getToken().scalenormal();
                this.player[this.t].getToken().scalenormal();
                this.player[this.t].getToken().translate(Board.get_X(final_pos - 1), Board.get_Y(final_pos - 1));
                this.player[tal].getToken().translate(Board.get_X(this.player[tal].getPosition() - 1), Board.get_Y(this.player[tal].getPosition() - 1));
            }
        }

        if(this.player[this.t].getPosition() == this.player[tal].getPosition()) {
            this.player[this.t].setSame_square(true);
            this.player[tal].setSame_square(true);
            this.player[tal].getToken().scaledown();
            this.player[t].getToken().translate((Board.get_X(final_pos - 1) + 10), (Board.get_Y(final_pos - 1) + 5));
            this.player[t].getToken().scaledown();
            this.player[tal].getToken().translate((Board.get_X(final_pos - 1) - 10), (Board.get_Y(final_pos - 1) + 5));
        }
    }
}
