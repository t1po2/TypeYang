package typeyang.engine;

import java.util.ArrayDeque;
import java.util.Queue;
import typeyang.service.LoadText;

public class TypeEngine2 {

    private final String filePath;
    private final Queue<Character> charQ = new ArrayDeque<>();

    public TypeEngine2(String filePath) {
        this.filePath = filePath;
        reset();
    }

    public void reset() {
        charQ.clear();
        LoadText textLoader = new LoadText(filePath);
        String text = textLoader.getTotalText();

        if (text != null) {
            for (char c : text.toCharArray()) {
                charQ.add(c);
            }
        }
    }

    public boolean evaluate(char input) {
        if (charQ.isEmpty()) {
            return false;
        }   

        if (charQ.peek() == input) {
            charQ.poll(); // Match! Remove char from queue
            return true;
        }
        return false; // Typo! Leave in queue (or handle accordingly)
    }

    public boolean isFinished() {
        return charQ.isEmpty();
    }
}