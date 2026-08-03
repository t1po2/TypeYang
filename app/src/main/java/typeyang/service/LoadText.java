package typeyang.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadText {

    private String path;
    private final String TEXT;
    private StringBuilder allText; // readed Texxt 


    public LoadText(String path){

        this.path = path;
        try (BufferedReader br = new BufferedReader(new FileReader(this.path))) {

            String line;
            while ((line = br.readLine())!=null){
            allText.append(line).append("\n");  
            }
        } catch (IOException e){
            System.out.println(e.getMessage()+e.getStackTrace());
        }



        TEXT = allText.toString();
    }


    private String getText(){
        return TEXT;
    }

    



}
