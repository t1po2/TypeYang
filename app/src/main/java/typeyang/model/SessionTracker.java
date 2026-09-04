package typeyang.model;

public class SessionTracker {

    private int mistakes;
    private static boolean firstInput = false;
    private static long startTime;



    public SessionTracker(){
    }
    

    public void startTimer(){

        if (!firstInput){
            startTime = System.currentTimeMillis();
            firstInput = true;
        }
    }

          
    public boolean isTimeRemaining(){

        if(!firstInput){
            return true;
        }
        return (System.currentTimeMillis() -startTime) <= 30000;
    }



    
}
