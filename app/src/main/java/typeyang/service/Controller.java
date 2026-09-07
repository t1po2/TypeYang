package typeyang.service;

import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import typeyang.engine.TypeEngine2;
import typeyang.engine.TypeEngine2.TypeResult;

public class Controller implements Initializable {

    private TypeEngine2 engine;

    @FXML
    TextFlow mainLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the engine right when the view is ready
        this.engine = new TypeEngine2();
        updateTextFlow();

        // TODO add Text
        // TODO init SessionTracker for the Timer
    }

    @FXML
    private void handleKeyTyped(KeyEvent e) {

        String input = e.getCharacter();
        System.out.println(input + "\n");


        if (input == null || input.isEmpty()) {
            return;
        }
        char c = input.charAt(0);

        if (c >= 32 || c == '\n' || c == '\r') {
            TypeResult condition = engine.evaluate(c);
        }

        engine.handleFirstInput();

        updateTextFlow();
    }

    private void updateTextFlow() {
        // Clear the current display
        mainLabel.getChildren().clear();

        Text typedTextNode = new Text(engine.getTypedText());
        typedTextNode.setFill(Color.GREEN);

        Text remainingTextNode = new Text(engine.getRemainingText());
        remainingTextNode.setFill(Color.GRAY);

        mainLabel.getChildren().addAll(typedTextNode, remainingTextNode);
    }

}