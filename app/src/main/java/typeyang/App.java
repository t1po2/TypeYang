package typeyang;

import java.util.EventListener;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{


    


    // Added back so the default test file (AppTest.java) can find it
    public String getGreeting() {
        return "Hello World!";
    }

    @Override
    public void start(Stage primaryStage) {


        try {


            Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    } 


    public static void main(String[] args) {
        launch(args);
    }
}