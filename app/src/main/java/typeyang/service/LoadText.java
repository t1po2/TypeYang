package typeyang.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadText {

    private static StringBuilder allText; // readed Texxt 


    public LoadText(){
    }


    // loads the Text from the File into the Game 
    public static String getText(String path){
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;
            while ((line = br.readLine())!=null){
            allText.append(line).append("\n");  
            }
        } catch (IOException e){
            System.out.println(e.getMessage()+e.getStackTrace());
        }
        return allText.toString();

        
    }

}
