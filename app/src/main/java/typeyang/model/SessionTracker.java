package typeyang.model;

import java.util.HashMap;

public class SessionTracker {

    private int totalChar;
    private long startTimer = 0; 
    private final long TIME_LIMIT = 30000; // 30 seconds in milliseconds
    private boolean firstKeyPressed = false;

    private Counter counter;

    public SessionTracker() {
        counter = new Counter();
    }

    public void startTimer() {
        if (!firstKeyPressed) {
            startTimer = System.currentTimeMillis();
            firstKeyPressed = true;
        }
    }

    public void incrementMistakes() {
        if (isWithinTimeLimit()) {
            counter.incrementMistakes();
        }
    }

    public void incrementCorrect() {
        if (isWithinTimeLimit()) {
            counter.incrementCorrect();
        }
    }

    // Helper method to check if the session is still active
    private boolean isWithinTimeLimit() {
        // If the timer hasn't started yet, don't count inputs
        if (!firstKeyPressed) {
            return false;
        }
        return (System.currentTimeMillis() - startTimer) <= TIME_LIMIT;
    }

    // Returns stats only if within the 30-second window
    public HashMap<String, Integer> getStats() {
        if (isWithinTimeLimit()) {
            return counter.getStats();
        } else {
            // Return empty stats or handle expiration as needed
            return new HashMap<>(); 
        }
    }

    public int getTotalChar() {
        return totalChar;
    }
}