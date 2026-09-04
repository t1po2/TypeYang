package typeyang.service;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import typeyang.engine.TypeEngine2;

public class Controller implements Initializable {

    private TypeEngine2 engine;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the engine right when the view is ready
        this.engine = new TypeEngine2("/text.txt");
        //TODO add Text 
    }

    @FXML
    private void handleKeyTyped(KeyEvent e) {
        String input = e.getCharacter();

        if (input != null && !input.isEmpty()) {
            char c = input.charAt(0);

            if (c >= 32 || c == '\n' || c == '\r') {
                boolean correct = engine.evaluate(c);

                if (correct) {
                    System.out.println("Correct key: " + c);
                    // TODO: update JavaFX UI (e.g. advance text cursor)
                } else {
                    System.out.println("Wrong key: " + c);
                    // TODO: highlight error in red
                }

                if (engine.isFinished()) {
                    System.out.println("Finished!");
                }
            }
        }
    }
}