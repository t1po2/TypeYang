package typeyang.engine;

import java.util.ArrayDeque;
import java.util.Queue;
import typeyang.model.SessionTracker;
import typeyang.service.LoadText;

public class TypeEngine2 {

    private final String filePath;
    private final Queue<Character> charQ = new ArrayDeque<>();

    private SessionTracker sessionTracker;

    public TypeEngine2(String filePath) {
        this.filePath = filePath;
        reset();
    }


    //method reset should create a instance of a SessionTracker so it always starts clean
    public void reset() {
        charQ.clear();
        this.sessionTracker = new SessionTracker();
        LoadText textLoader = new LoadText(filePath);
        String text = textLoader.getTotalText();

        if (text != null) {
            for (char c : text.toCharArray()) {
                charQ.add(c);
            }
        }
    }


    public void handleFirstInput() {
        sessionTracker.startTimer();
    }
    


    // instead of boolean which can only show 2 conditions int can show multiple conditions
    // 1 = correct input
    // 2 = fasle input
    // 3 = time limit has reached 
    // 4 = no Chars left --> might replace iAT with a list of words that are oulled out randomly (basicaly no Queue DS is needed )
    public int evaluate(char input) {
        if (sessionTracker.isTimeRemaining()) {
            if (charQ.isEmpty()) {
                System.out.println("no chars left in Q");
                return 4;
            }

            if (charQ.peek() == input) {
                charQ.poll(); // Match! Remove char from queue
                return 1;
            } else {
                return 2; // Typo! Leave in queue (or handle accordingly)
            }
        }
        return 3;
    }

    
}
