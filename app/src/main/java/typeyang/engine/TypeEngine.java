package typeyang.engine;

import java.util.ArrayDeque;
import java.util.Queue;

import typeyang.model.SessionTracker;
import typeyang.service.LoadText;

public class TypeEngine {

    private String inputChar;
    private String expectedChar;
    private String totalText;
    private Queue<Character> charQ;
    private LoadText loadText;
    private SessionTracker sessionTracker;

    public TypeEngine(String filePath) {
        // Create instance for tracking Typing Session
        sessionTracker = new SessionTracker();
        charQ = new ArrayDeque<>();
        loadText = new LoadText(filePath);
        
        // Load text and populate the queue
        this.totalText = loadText.getTotalText();
        for (char c : totalText.toCharArray()) {
            charQ.add(c);
        }

        // Set the very first expected character so it's ready for the first keystroke
        if (!charQ.isEmpty()) {
            expectedChar = charQ.poll().toString();
        }
        
        // NOTE: The comparison logic has been removed from here!
    }

    public void setInputChar(String inputChar) {
        if (inputChar == null) {
            System.out.println("Error: Null inputChar received.");
            return;
        }
        this.inputChar = inputChar;
        
        // Trigger the evaluation every time a new character is set
        evaluateTyping();
    }
    
    private void evaluateTyping() {
        // Guard against typing when the queue is already empty
        if (expectedChar == null) {
            System.out.println("Text completed!");
            return; 
        }

        // Compare strings safely using .equals()
        if (inputChar.equals(expectedChar)) {
            sessionTracker.incrementCorrect();
            System.out.println("Correct!"); // For testing
        } else {
            sessionTracker.incrementMistakes();
            System.out.println("Mistake! Expected: " + expectedChar + " but got: " + inputChar); // For testing
        }

        // Poll the next character for the next keystroke
        if (!charQ.isEmpty()) {
            expectedChar = charQ.poll().toString();
        } else {
            expectedChar = null; // Reached the end of the text
        }
    }
}