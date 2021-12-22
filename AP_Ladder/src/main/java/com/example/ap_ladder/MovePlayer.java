package com.example.ap_ladder;

import javafx.application.Platform;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class MovePlayer extends Thread {
    private Player[] player;
    private Board b1;
    private Transtok tns;
    private int t;
    private Text winText;
    private Rectangle winRectangle;
    
    public MovePlayer(Player[] player, int turn, Board b, Transtok transt, Rectangle winRect, Text winText) {
        this.player = player;
        this.t = turn;
        this.b1 = b;
        this.tns = transt;
        this.winRectangle = winRect;
        this.winText = winText;
    }

    @Override
    public void run() {
        int numb = Board.dice.roll_dice();
        if(!(this.player[this.t].isOn_the_board())) {
            if(numb != 1) 
                return;
            else 
                this.player[this.t].setOn_the_board();
        }
        int semi_final_pos = numb + this.player[this.t].getPosition();
        if(semi_final_pos > 100) {
            return;
        }

        this.tns.setparam(this.player[this.t], semi_final_pos);
        this.tns.start();
        this.player[this.t].setPosition(semi_final_pos);

        // if finish line reached
        if(semi_final_pos == 100) {
            this.player[this.t].setPosition(100);
            Platform.runLater(new AfterWin(winText, winRectangle, this.t));
            
        }
        //-----------------------------------------------------------------------
        int final_pos = b1.get_position(semi_final_pos);

        //ladder or snake encountered
        if(final_pos != semi_final_pos) {
            this.player[this.t].setPosition(final_pos - 1);
            this.tns.setparam(this.player[this.t], final_pos);
            this.tns.start();

        }
        this.player[this.t].setPosition(final_pos);
        int tal = 0;
        if(this.t == 0) {
            tal = 1;
        }


        if(this.player[this.t].isSame_square()) {
            translationAfterSamePosition(final_pos, tal);
        }

        if(this.player[this.t].getPosition() == this.player[tal].getPosition()) {
            samePositionTranslation(final_pos, tal);
        }
    }




    private void samePositionTranslation(int final_pos, int tal) {
        this.player[this.t].setSame_square(true);
        this.player[tal].setSame_square(true);
        this.player[tal].getToken().scaledown();
        this.player[t].getToken().translate((Board.get_X(final_pos - 1) + 10), (Board.get_Y(final_pos - 1) + 5));
        this.player[t].getToken().scaledown();
        this.player[tal].getToken().translate((Board.get_X(final_pos - 1) - 10), (Board.get_Y(final_pos - 1) + 5));
    }

    private void translationAfterSamePosition(int final_pos, int tal) {
        if(this.player[this.t].getPosition() != this.player[tal].getPosition()) {
            this.player[this.t].setSame_square(false);
            this.player[tal].setSame_square(false);
            this.player[tal].getToken().scalenormal();
            this.player[this.t].getToken().scalenormal();
            this.player[this.t].getToken().translate(Board.get_X(final_pos - 1), Board.get_Y(final_pos - 1));
            this.player[tal].getToken().translate(Board.get_X(this.player[tal].getPosition() - 1), Board.get_Y(this.player[tal].getPosition() - 1));
        }
    }
}

class AfterWin implements Runnable {

    private Text winText;
    private Rectangle winRectangle;
    private int turn;

    public AfterWin(Text winText, Rectangle winRectangle, int t) {
        this.winText = winText;
        this.winRectangle = winRectangle;
        this.turn = t;
    }


    @Override
    public void run() {
        winRectangle.setVisible(true);
        if (turn == 0)
            winText.setText("Blue won!" );
        else
            winText.setText("Green won!" );
        winText.setVisible(true);
        Board.dice.getButton().setDisable(true);
        
    }

}

