package typeyang.model;

public class SessionTracker {


    private int correct = 0 , mistakes = 0, totalChar;

    



    public SessionTracker(){


    }


    // Setter
    public void incrementMistakes(){
        this.mistakes++;
    }

    public void incrementCorrect(){
        this.correct++;
    }
    

    // getters 


    public int getMistakes(){
        return mistakes;
    }
    public int getCorrect(){
        return correct;
    }
    public int getTotalChar(){
        return totalChar;
    }



}
