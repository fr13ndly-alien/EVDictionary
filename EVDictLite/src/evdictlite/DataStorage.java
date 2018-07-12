/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evdictlite;

import java.util.Hashtable;
import java.util.Vector;

/**
 *
 * @author Huu Hien
 */
public class DataStorage {
    private Hashtable data ;
    private int numberOfWord;
    
    public DataStorage(){
        data = new Hashtable<String,Vector>();
        numberOfWord = 0;
    }
    
    public void addWord(String word, Vector meaning){
        data.put(word, meaning);
        numberOfWord++;
    }
    
    public int getNumberOfWord(){
        return numberOfWord;
    }
    
    public Vector search(String eWord){
        return (Vector)data.get(eWord);
    }
    
    public Vector decoding(String eword) throws NullPointerException{
        
        String temporary;
        Vector<String> got;
        Vector<String> result = new Vector<String>();
        if(data.containsKey(eword)){
            got = (Vector<String>)data.get(eword);
            int size = got.size();
            //encoding....
            temporary = "Phát âm: "+ got.elementAt(0);
            result.addElement(temporary);
            for (int i = 1; i < size; i++) {
                temporary = got.elementAt(i);
                switch(temporary.charAt(0)){
                    case '*':
                        temporary = temporary + ":";
                        
                        result.addElement(temporary); 
                        break;
                    case '-':
                        temporary = temporary.replace("-", "\t-");
                        result.addElement(temporary);
                        break;
                    case '=':
                        temporary = temporary.replace("=", "\t\tVí dụ: ");
                        temporary = temporary.replace("+", ": ");
                        result.addElement(temporary);
                        break;
                    
                }
            }
        }
        else got= new Vector<String>();
        return result;
    }
}
