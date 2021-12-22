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
   
        //scaleUpDice();
        Platform.runLater(new Dice_Animation(this.d));
        //scaleDownDice();
        /* 
        for (int i = 0; i < 6; i++) {
            int r = rand.nextInt(6) + 1;
            // String s = "-fx-background-image: url('C:/Users/alvin/Code/Java/ap-project/AP_Ladder/src/main/resources/com/example/ap_ladder/" + String.valueOf(r) + ".png')";
            // String s = "-fx-background-image: url('ap_ladder/../../../resources/com/example/ap_ladder/" + String.valueOf(r) + ".png')";
            String s = String.valueOf(r);
            Platform.runLater(new Dice_Animation(s, this.d));

        */
        //display final number
        Random r = new Random();
        this.numb = r.nextInt(6) + 1;
        String st = "-fx-background-image: url('C:/Users/alvin/Code/Java/ap-project/AP_Ladder/src/main/resources/com/example/ap_ladder/" + String.valueOf(this.numb) + ".png')";
        String str = st + "; -fx-background-size: cover;";
        Platform.runLater(new Dice_Animation2(this.d, st));
        return this.numb; 
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
//        Random rand = new Random();
        // if (i == 0) scaleUpDice();
        scaleUpDice();
        // AnimationTimer timer = new AnimationTimerExtension(this.button);
        // timer.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }  
        
        scaleDownDice();
        /* for (int i = 0; i < 2; i++) {
        
        
//            int r = rand.nextInt(6) + 1;
//            try {
//                Thread.sleep(500);
//            } catch (Exception e) {
//                // TODO: handle exception
//                e.printStackTrace();
//            }
            class trans extends AnimationTimer {
                private final long FRAMES_PER_SEC = 3L;
                private final long interval = 1000000000L / FRAMES_PER_SEC;
                private long last = 0;
                private int count;
                private Button b;
                trans(Button b1) {
                    this.b = b1;
                }
//                public void setparam(Player p1, int p) {
//                    this.p1 = p1;
//                    this.poss = p;
//                    this.last = 0;
//                    this.count = this.p1.getPosition();
//                }

                @Override
                public void handle(long now) {
                    if(now - last > interval) {
                        Random rand = new Random();
                        int r = rand.nextInt(6) + 1;
                        rotateDice();
                        String str = "-fx-background-image: url('file:C:/Users/alvin/Code/Java/ap-project/AP_Ladder/src/main/resources/com/example/ap_ladder/" + String.valueOf(r) + ".png')";
                        this.b.setStyle (str + "; -fx-background-size: cover;");
                        last = now;
                        ++count;
                        if(count >= 5) {
                            this.stop();
                        }
                    }
                }
            }
            trans danim = new trans(this.button);
            danim.start();
            scaleDownDice();
            //otateDice();
            
//            String str = "-fx-background-image: url('file:C:/Users/alvin/Code/Java/ap-project/AP_Ladder/src/main/resources/com/example/ap_ladder/" + String.valueOf(r) + ".png')";
//            this.button.setStyle (str + "; -fx-background-size: cover;");
           
        
            // PauseTransition pause = new PauseTransition(Duration.seconds(0.1));
            // pause.setOnFinished(event -> {
            //     rotateDice(); 
            //     String str = "-fx-background-image: url('file:C:/Users/alvin/Code/Java/ap-project/AP_Ladder/src/main/resources/com/example/ap_ladder/" + String.valueOf(r) + ".png')";
            //     this.button.setStyle(str + "; -fx-background-size: cover;");
            // });
                
            //     pause.setCycleCount(4);  
            //     pause.play();
            // pause.play();
            // pause.play();

        } */
        
        // this.d.setStyle(this.s);
        // this.button.setText(this.s);
    }


    private void scaleDownDice() {
        ScaleTransition scale = new ScaleTransition();   
        //shifting the X coordinate of the centre of the circle by 400   
        // scale.setByX(0.1);
        // scale.setByY(0.1);
        scale.setFromX(1.5);  
        scale.setFromY(1.5);  
        scale.setToX(1);  
        scale.setToY(1);  
            
        //setting the duration for the Translate transition   
        scale.setDuration(Duration.millis(2000));  
            
        //setting cycle count for the Translate transition   
        scale.setCycleCount(1);  
            
        //the transition will set to be auto reversed by setting this to true   
        scale.setAutoReverse(true);
        scale.setNode(this.button);
        scale.play();
    }


    private void scaleUpDice() {
        ScaleTransition scale = new ScaleTransition();   
        //shifting the X coordinate of the centre of the circle by 400   
        // scale.setByX(0.1);
        // scale.setByY(0.1);
        scale.setFromX(1);  
        scale.setFromY(1);  
        scale.setToX(1.5);  
        scale.setToY(1.5);  
            
        scale.setDuration(Duration.millis(2000));  
        scale.setCycleCount(1);  
        scale.setAutoReverse(true);
        scale.setNode(this.button);
        scale.play();
    }


    private void rotateDice() {
        System.out.println("Inside rotate dice");

        RotateTransition trans = new RotateTransition();
        trans.setDuration(Duration.millis(1000));
        trans.setFromAngle(0.0);
        trans.setToAngle(360.0);
        // Let the animation run forever
        trans.setCycleCount(1);
        // Reverse direction on alternating cycles
        trans.setAutoReverse(true);
        
        trans.setNode(this.button);
        // Play the Animation
        // try {
        //     Thread.sleep(500);
        //     trans.play();
        // } catch (Exception e) {
        //     // TODO: handle exception
        //     e.printStackTrace();
        // } 
        
        System.out.println("End of rotate");
    }
}

class Dice_Animation2 implements Runnable {
    private Button d;
    private String s;
    Dice_Animation2(Button d1, String s1) {
        this.s = s1;
        this.d = d1;
    }
    @Override
    public void run() {
        this.d.setStyle(this.s);
    }
}