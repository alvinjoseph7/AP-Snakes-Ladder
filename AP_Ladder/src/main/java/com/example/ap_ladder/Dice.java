package com.example.ap_ladder;

import javafx.animation.AnimationTimer;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.util.Random;

public class Dice {

    private int numb;
    private Button d;

    public Dice(Button dice) {
        this.numb = 0;
        this.d = dice;
    }

    public int roll_dice()  {

        Random rand = new Random();
        int r = rand.nextInt(6) + 1;
        Platform.runLater(new DiceAnimation(this.d, r));
        return r;
    }

}

class DiceAnimation extends AnimationTimer implements Runnable {
    private final long FRAMES_PER_SEC = 3L;
    private final long interval = 1000000000L / FRAMES_PER_SEC;
    private long last = 0;
    private int count;
    // private Button b;
    private Button button;
    // private int final;
    private int finalNo;

    DiceAnimation(Button b1, int r) {
        this.button = b1;
        this.count = 1;
        this.finalNo =r;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        scaleUpDice();
        DiceAnimation diceAnim = new DiceAnimation(this.button, finalNo);
        diceAnim.start();
    }

    @Override
    public void handle(long now) {
        if (now - last > interval) {
            Random rand = new Random();
            int r = rand.nextInt(6) + 1;
            rotateDice();

            String str = "-fx-background-image: url('file:C:/Users/alvin/Code/Java/ap-project/AP_Ladder/src/main/resources/com/example/ap_ladder/"
                    + String.valueOf(r) + ".png')";
            this.button.setStyle(str + "; -fx-background-size: cover;");
            last = now;
            ++count;
            System.out.println("Number: " + r);
            if (count >= 3) {
                scaleDownDice();
                str = "-fx-background-image: url('file:C:/Users/alvin/Code/Java/ap-project/AP_Ladder/src/main/resources/com/example/ap_ladder/"
                    + String.valueOf(finalNo) + ".png')";
            this.button.setStyle(str + "; -fx-background-size: cover;");
                this.stop();
            }
        }
    }

    
    

    private void scaleDownDice() {
        ScaleTransition scale = new ScaleTransition();
        scale.setFromX(1.5);
        scale.setFromY(1.5);
        scale.setToX(1);
        scale.setToY(1);

        // setting the duration for the Translate transition
        scale.setDuration(Duration.millis(200));

        // setting cycle count for the Translate transition
        scale.setCycleCount(1);

        // the transition will set to be auto reversed by setting this to true
        scale.setAutoReverse(true);
        scale.setNode(this.button);
        scale.play();
    }

    private void scaleUpDice() {
        ScaleTransition scale = new ScaleTransition();
        scale.setFromX(1);
        scale.setFromY(1);
        scale.setToX(1.2);
        scale.setToY(1.2);
        // setting the duration for the Translate transition
        scale.setDuration(Duration.millis(200));
        // setting cycle count for the Translate transition
        scale.setCycleCount(1);

        // the transition will set to be auto reversed by setting this to true
        scale.setAutoReverse(true);
        scale.setNode(this.button);
        scale.play();
    }

    private void rotateDice() {

        RotateTransition trans = new RotateTransition();
        trans.setDuration(Duration.millis(500));
        trans.setFromAngle(0.0);
        trans.setToAngle(360.0);
        // Let the animation run forever
        trans.setCycleCount(1);
        // Reverse direction on alternating cycles
        trans.setAutoReverse(true);
        
        trans.setNode(this.button);
        trans.play();
    }
    
    
}