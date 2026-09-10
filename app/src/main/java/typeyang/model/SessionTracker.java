package typeyang.model;

import java.util.HashMap;

import javafx.application.Platform;
import javafx.scene.control.Label;
import typeyang.ui.LabelStats;

public class SessionTracker implements Runnable {

    private int mistakes;
    private static boolean firstInput = false;
    private static long startTime;


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
        return (System.currentTimeMillis() - startTime) <= 30000;
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

}
