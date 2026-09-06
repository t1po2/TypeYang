package typeyang.service;

import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import typeyang.engine.TypeEngine2;


public class Controller implements Initializable {

    private TypeEngine2 engine;


    @FXML
    Label mainLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the engine right when the view is ready
        this.engine = new TypeEngine2();
        setMainLabel();
        
        //TODO add Text 
        //TODO init SessionTracker for the Timer 
    }

    @FXML
    private void handleKeyTyped(KeyEvent e) {


        String input = e.getCharacter();
        System.out.println(input + "\n");
        
        if (input != null && !input.isEmpty()) {
            engine.handleFirstInput();

            char c = input.charAt(0);

            if (c >= 32 || c == '\n' || c == '\r') {
                int condition = engine.evaluate(c);

                if (condition == 3){
                    System.out.println("time limit has been reached");
                }

                else if (condition == 1) {
                    System.out.println("Correct key: " + c);
                    // TODO: update JavaFX UI (e.g. advance text cursor)
                } else if (condition == 2) {
                    System.out.println("Wrong key: " + c);
                    // TODO: highlight error in red
                }

                else if (condition == 4){
                    System.out.println("no words left");
                }
            }
        }
        setMainLabel();

    }

    
    private void setMainLabel(){
        
        mainLabel.setText(engine.getMainText());

    }




}