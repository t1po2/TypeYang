package typeyang.model;

import java.util.HashMap;

public class SessionTracker {


    private int totalChar;

    private float startTimer = 0 , currentTime , timeLimit = 30000;

    private boolean firstKeyPressed = false;

    private Counter counter;
    

    private HashMap<String,Integer> stats;

    public SessionTracker(){
        
        while (System.currentTimeMillis() - startTimer < timeLimit){

            counter = new Counter();


            if(System.currentTimeMillis() - startTimer <= timeLimit){

                stats = counter.getStats();
            }
        }
    }










    // Setter
    public void incrementMistakes(){
        counter.incrementMistakes();
    }

    public void incrementCorrect(){
        this.incrementCorrect();
    }


    public void startTimer(){
        startTimer = System.currentTimeMillis();
    }
    

    // getters 


   

    public int getTotalChar(){
        return totalChar;
    }



}
