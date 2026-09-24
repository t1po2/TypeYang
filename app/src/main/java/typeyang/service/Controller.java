package typeyang.service;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import typeyang.engine.TypeEngine2;
import typeyang.engine.TypeEngine2.TypeResult;
import typeyang.model.SessionTracker;
import typeyang.ui.LabelStats;

public class Controller implements Initializable {

    private TypeEngine2 engine;

    @FXML
    TextFlow mainLabel;
    @FXML 
    Label timer;
    @FXML
    Label typoLabel;
    @FXML
    Label wpmCounter;



    private Stage stage;
    private Scene scene;
    private Parent root;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the engine right when the view is ready

        LabelStats labels = new LabelStats(timer,wpmCounter,typoLabel);

        this.engine = new TypeEngine2(labels);

        if (this.mainLabel != null) {
            updateTextFlow();
        }
        

        // TODO add Text
        // TODO init SessionTracker for the Timer
    }

    @FXML
    private void handleKeyTyped(KeyEvent e) {
        engine.handleFirstInput();
        SessionTracker.incrementTotalTyped();
        String input = e.getCharacter();
        System.out.println(input + "\n");


        if (input == null || input.isEmpty()) {
            return;
        }
        char c = input.charAt(0);

        if (c >= 32 || c == '\n' || c == '\r') {
            TypeResult condition = engine.evaluate(c);

            switch (condition) {
                case NO_CHARS_LEFT:
                    System.out.println("NO_CHARS_LEFT");
                    break;
                case CORRECT:
                    System.out.println("CORRECT INPUT CHAR");
                    break;
                case INCORRECT:
                    System.out.println("INCORRECT INPUT CHAR - Mistakes++");
                    break;
                case TIME_LIMIT:
                    System.out.println("TIME LIMIT HAS BEEN REACHED");
                    switchToEnd();
            }
        }

        
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



    // temp fix to activate method ???? 


   


    // https://www.youtube.com/watch?v=hcM-R-YOKkQ
    public void switchToMain(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToEnd(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/endscene.fxml"));
            stage = (Stage) mainLabel.getScene().getWindow();   //via mainlabel i get current Window (stage)
            stage.setScene(new Scene(root));
            stage.show();     
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Exception. Coudn't load endscene.fxml");
        }

        
    }

   

    

}