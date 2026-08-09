package typeyang;

import java.util.EventListener;



import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application implements EventListener{



    Button selectFileButton;


    // Added back so the default test file (AppTest.java) can find it
    public String getGreeting() {
        return "Hello World!";
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TypeYang - YangYang");


        BorderPane layout = new BorderPane(); //layout like in swing Border Pane ahst Containers left right top bottom and big center 

        Scene scene = new Scene(layout,1280,960);



        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent event) {

                System.out.println(event.getCode());
                //works passes Keys pressed into sout
                //TODO: link eventCodes to TypingEngine


            }



            
        });
        primaryStage.setScene(scene);
        primaryStage.show();









    } 


    public static void main(String[] args) {
        launch(args);



    }
}