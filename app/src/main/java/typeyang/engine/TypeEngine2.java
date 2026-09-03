package typeyang.engine;


import java.util.ArrayDeque;
import java.util.Queue;

import typeyang.service.*;;


public class TypeEngine2 {


    private final String FILEPATH = "";     //TODO add FILEPATH

    private String mainText;
    private LoadText textLoader;

    private Queue<Character> charQ;


    public TypeEngine2(){

        // Only when engine starts the text will load in 
        this.textLoader = new LoadText(FILEPATH);
        this.charQ = new ArrayDeque<Character>();




        
        this.mainText = textLoader.getTotalText();

        if (mainText.isEmpty()){
            System.out.println("Loaded main Text in TypeEngine Class is empty");
        } else {
            System.out.println("mainText inside TypeEngine is loaded");
        }


        for (char c : mainText.toCharArray()){
            charQ.add(c);
        }


        

        









    }




    
}
