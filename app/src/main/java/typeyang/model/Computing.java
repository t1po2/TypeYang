package typeyang.model;

public class Computing {

    // class to calculate Accuracy 
    
    
    

    public static double calculateAccuracy(int correctInput, int totalInput){
        return ((double) correctInput / (double) totalInput) * 100;
    }

}
