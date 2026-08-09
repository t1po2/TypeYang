package typeyang.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LoadText {

    private String totalText;

    public LoadText(String resourcePath) {
        StringBuilder sb = new StringBuilder();

        // Load the file as a resource stream instead of a standard file path
        try (InputStream is = getClass().getResourceAsStream(resourcePath)) {
            
            if (is == null) {
                throw new IOException("Resource not found: " + resourcePath);
            }
            
            // Wrap the InputStream in a BufferedReader
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n"); // Keeps the line breaks
                }
                totalText = sb.toString();
            }
            
        } catch (IOException e) {
            e.printStackTrace(); 
            // Fallback to prevent NullPointerException in TypeEngine if loading fails
            totalText = "Error loading text file.";
        }
    }

    public String getTotalText() {
        return totalText;
    }
}