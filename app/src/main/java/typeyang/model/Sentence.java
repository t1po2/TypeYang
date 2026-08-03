package typeyang.model;

public class Sentence {

    private String targetText; // loaded text
    private int textLength;
    

    public Sentence(){

        String[] splitTargetText = targetText.split(" ");
        this.textLength = splitTargetText.length;


        

    }



    
}
