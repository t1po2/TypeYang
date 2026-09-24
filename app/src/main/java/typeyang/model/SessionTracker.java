package typeyang.model;


import javafx.application.Platform;
import typeyang.ui.LabelStats;

public class SessionTracker implements Runnable {

    private static int mistakes, correct;

    //total chars will be mistakes + corrects ig for now cuz io have object tatoalInput 

    private static int totalInput=0;

    private static boolean firstInput = false;
    private static long startTime;

    private static long timeLimit = 30000;

    private LabelStats labels;

    public SessionTracker(LabelStats labels) {
        this.labels = labels;
        mistakes = 0;
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


    @Override
    public void run(){
        while (isTimeRemaining()) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            long remainingSeconds = (30000 - elapsedTime) / 1000;

            if (remainingSeconds < 0) {
                remainingSeconds = 0;
                Computing.calculateAccuracy(correct, totalInput);
                //TODO set label of endscene to that return value of that method
            }

            final String timeString = remainingSeconds + "s";
            if (remainingSeconds % 2 == 0){
                calculateWPM(elapsedTime);
            }

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


    public static void incrementTotalTyped() {
        totalInput++;
    }

    //doesnt need to be statiC cuz it is used locally 
    public void incrementMistakes() {           
        mistakes++;
        labels.typoLabel().setText("Typos: " + mistakes);
    }

    public static void incrementCorrect(){
        correct++;
    }







    public void calculateWPM(long elapsedTime){

       if (elapsedTime <= 0 ){
        return;
       }

       double minutes = elapsedTime / 60000.0;
       double words = totalInput / 5.0;
       
       int wpm = (int) Math.round(words / minutes);
      
       Platform.runLater(() -> {
            if (labels.wpmCounter() != null){
                labels.wpmCounter().setText("WPM: " + wpm);
            }
       });   
    }


    

}
