package typeyang.model;

import java.util.HashMap;

public class Counter {
    private int correct , mistakes ;


    private HashMap<String,Integer> stats;


    public Counter(){

        stats = new HashMap<>();

        this.correct = 0;
        this.mistakes = 0;

    }


    public void incrementCorrect(){
        correct++;
    }


    public void incrementMistakes(){
        mistakes++;
    }



    public HashMap<String,Integer> getStats(){

        stats.put("correct",this.correct);
        stats.put("mistakes",this.mistakes);

        return stats;
        
    }
}
