package typeyang.engine;

import java.util.ArrayDeque;
import java.util.Queue;

import javafx.scene.control.Label;
import typeyang.model.SessionTracker;
import typeyang.service.LoadText;

public class TypeEngine2 {


    public enum TypeResult {
        CORRECT,
        INCORRECT,
        TIME_LIMIT,
        NO_CHARS_LEFT;
    }
    
    //gotta pass the timer label threw all calsses Damn 

    private Label timer;
    private Label typoLabel;



    private String mainText;

    private int currentIndex=0;


    private final Queue<Character> charQ = new ArrayDeque<>();

    private SessionTracker sessionTracker;

    public TypeEngine2(Label timer, Label typoLabel) {
        this.timer = timer;
        this.typoLabel = typoLabel;
        reset(this.timer,this.typoLabel);
    }

    // method reset should create a instance of a SessionTracker so it always starts
    // clean
    public void reset(Label timer, Label typoLabel) {
        charQ.clear();
        this.sessionTracker = new SessionTracker(timer,typoLabel);
        LoadText textLoader = new LoadText();
        String text = textLoader.getTotalText();
        this.mainText = text;

        if (text != null) {
            for (char c : text.toCharArray()) {
                charQ.add(c);
            }
        }
    }

    public void handleFirstInput() {
        sessionTracker.startTimer();
    }

    // instead of boolean which can only show 2 conditions int can show multiple
    // conditions
    // 1 = correct input
    // 2 = fasle input
    // 3 = time limit has reached
    // 4 = no Chars left --> might replace iAT with a list of words that are oulled
    // out randomly (basicaly no Queue DS is needed )


    public TypeResult evaluate(char input) {
        if (sessionTracker.isTimeRemaining()) {


            if (currentIndex >= mainText.length()) {
                System.out.println("no chars left in Q");
                return TypeResult.NO_CHARS_LEFT;
            }
            char expectedChar = mainText.charAt(currentIndex);

            if (expectedChar == input) {
                currentIndex++; //tthis makes it possible to type another char and color it green
                return TypeResult.CORRECT;
            } else {
                sessionTracker.incrementMistakes();
                return TypeResult.INCORRECT; // Typo! Leave in queue (or handle accordingly)
            }
        }
        return TypeResult.TIME_LIMIT;
    }

 
    public String getRemainingText() {
    return mainText.substring(currentIndex);
}

    public String getTypedText() {
    return mainText.substring(0, currentIndex);
    }

    

}
