package typeyang;

import java.util.EventListener;



import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import typeyang.engine.TypeEngine;

public class App extends Application implements EventListener{


    //String for passing keys to TypeEngine
    private String keyPressed;
    //TypeEngine
    private TypeEngine typeEngine;


    //filePath
    private String filePath = "/mobydick.txt";



    // Added back so the default test file (AppTest.java) can find it
    public String getGreeting() {
        return "Hello World!";
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TypeYang - YangYang");


        BorderPane layout = new BorderPane(); //layout like in swing Border Pane ahst Containers left right top bottom and big center 
        Scene scene = new Scene(layout,1280,960);

        //initiate Engine
        typeEngine = new TypeEngine(this.filePath);


        //handles KeyEvent
        scene.setOnKeyTyped(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent event) {                
                //works passes Keys pressed into sout
                keyPressed = event.getCharacter();  //TODO getText method is not working but i need KeyString for SPACE et.
                typeEngine.setInputChar(keyPressed);        //passes KeyEvent into typeEngine for CHeckup 
                
            }            
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    } 


    public static void main(String[] args) {
        launch(args);
    }
}