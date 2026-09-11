package typeyang.model;

import java.util.HashMap;

import javafx.application.Platform;
import javafx.scene.control.Label;
import typeyang.ui.LabelStats;

public class SessionTracker implements Runnable {

    private int mistakes;
    private static boolean firstInput = false;
    private static long startTime;


    private int totalInput=0;


    private static long timeLimit = 30000;

    private LabelStats labels;

    public SessionTracker(LabelStats labels) {
        this.labels = labels;
        this.mistakes = 0;
    }

    public void startTimer() {

        if (!firstInput) {
            startTime = System.currentTimeMillis();
            firstInput = true;
        }

        Thread backgroundThread = new Thread(this);
        backgroundThread.setDaemon(true);
        backgroundThread.start();

    }

    public boolean isTimeRemaining() {

        if (!firstInput) {
            return true;
        }
        return (System.currentTimeMillis() - startTime) <= timeLimit;
    }

    public void incrementMistakes() {
        this.mistakes++;
        labels.typoLabel().setText("Typos: " + mistakes);
    }

    @Override
    public void run() {
        while (isTimeRemaining()) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            long remainingSeconds = (30000 - elapsedTime) / 1000;

            if (remainingSeconds < 0) {
                remainingSeconds = 0;
            }

            final String timeString = remainingSeconds + "s";
            calculateWPM(elapsedTime);

            Platform.runLater(() -> {
                if (labels.timer() != null) {
                    labels.timer().setText(timeString);
                }
            });

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        Platform.runLater(() -> {
            if (labels.timer() != null) {
                labels.timer().setText("0s");
            }
        });

    }


    public void DisplayWpmCounter(){

    }

    public void incrementTotalTyped() {
        totalInput++;
        }

    public void calculateWPM(long elapsedTime){
        double words = totalInput / 5.0; 
    
        double minutes = elapsedTime / 1000;
    
        long wpm = Math.round(words / minutes); 
    
        String wpmString = String.valueOf(wpm);
        System.out.println("WPM: " + wpmString);
        labels.wpmCounter().setText(wpmString);
    }


    //TODO: wom calc doesnt mae any sense 

}
