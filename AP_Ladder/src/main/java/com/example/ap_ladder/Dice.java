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

    public int roll_dice() {

        Platform.runLater(new Dice_Animation(this.d));

        //display final result
        Random rand = new Random();
        int r = rand.nextInt(6) + 1;
        String st = "-fx-background-image: url('file:C:/Users/alvin/Code/Java/ap-project/AP_Ladder/src/main/resources/com/example/ap_ladder/"
                + String.valueOf(r) + ".png')";
        String str = st + "; -fx-background-size: cover;";

        Platform.runLater(new ShowFinalNo(this.d, str));
        return r;
    }

}

class Dice_Animation implements Runnable {
    private Button button;

    Dice_Animation(Button d1) {
        this.button = d1;
    }

    @Override
    public void run() {
        scaleUpDice();
        class trans extends AnimationTimer {
            private final long FRAMES_PER_SEC = 3L;
            private final long interval = 1000000000L / FRAMES_PER_SEC;
            private long last = 0;
            private int count;
            private Button b;

            trans(Button b1) {
                this.b = b1;
            }


            @Override
            public void handle(long now) {
                if (now - last > interval) {
                    Random rand = new Random();
                    int r = rand.nextInt(6) + 1;
                    rotateDice();
                    String str = "-fx-background-image: url('file:C:/Users/alvin/Code/Java/ap-project/AP_Ladder/src/main/resources/com/example/ap_ladder/"
                            + String.valueOf(r) + ".png')";
                    this.b.setStyle(str + "; -fx-background-size: cover;");
                    last = now;
                    ++count;
                    if (count >= 3) {
                        scaleDownDice();
                        this.stop();
                    }
                }
            }
        }
        trans diceAnim = new trans(this.button);
        diceAnim.start();
 
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

class ShowFinalNo implements Runnable {
    private Button button;
    private String imgVal;

    ShowFinalNo(Button button, String str) {
        this.button = button;
        this.imgVal = str;
    }

    @Override
    public void run() {
        this.button.setStyle(imgVal);
    }
}