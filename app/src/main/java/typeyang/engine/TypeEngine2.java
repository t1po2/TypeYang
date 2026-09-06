package typeyang.engine;

import java.util.ArrayDeque;
import java.util.Queue;
import typeyang.model.SessionTracker;
import typeyang.service.LoadText;

public class TypeEngine2 {


    private String mainText;
    private final Queue<Character> charQ = new ArrayDeque<>();

    private SessionTracker sessionTracker;

    public TypeEngine2() {
        reset();
    }

    // method reset should create a instance of a SessionTracker so it always starts
    // clean
    public void reset() {
        charQ.clear();
        this.sessionTracker = new SessionTracker();
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
                sessionTracker.incrementMistakes();
                return 2; // Typo! Leave in queue (or handle accordingly)
            }
        }
        return 3;
    }

    // MEthod builds String cia CharQ so i can display it in the mainLabel
    // method could be unnecessary if only used once for method getRemainingText
    // if so just put the whole Stringbuilder inside it
    public void getRemainingText() {
        StringBuilder sb = new StringBuilder();

        for (Character c : charQ) {
            sb.append(c);
        }
        mainText = sb.toString();
    }

    public String getMainText() {
        getRemainingText();
        return mainText;
    }

}
