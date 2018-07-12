/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evdictlite;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

/**
 *
 * @author Huu Hien
 */
public class ReadFile {
    private final FileInputStream fin;
    private final InputStreamReader inSR;
    private final BufferedReader bfRead;
    private final DataStorage data;
    //private String line;
    
    
    public ReadFile(String fileName) throws Exception{
        fin = new FileInputStream(fileName);
        inSR = new InputStreamReader(fin, "UTF8");
        bfRead = new BufferedReader(inSR);
        data = new DataStorage();
        
        read();
    }
    
    public DataStorage getData(){
        return data;
    }
    
    /*
        read text file, line != null 
        if line != "" (not empty)
            if (line[0] == @ 
                split string to get eword and pronounce and put it to Vector mean
            else 
                add to Vector
        line = bfRead.readLine();
        try catch wwith EOF, add last word
        if(line[0] == @
            put eword and Vector mean into data
    */
    public void read() throws IOException{
        String line = "";   
        String eWord= "", pronounce;
        Vector<String> meaning = new Vector<String>();
        int index =0;
        line = bfRead.readLine();
        int count = 0;
        while(line != null){
            
            if(!line.equals("")){
                if (line.charAt(0) == '@'){
                    meaning = new Vector<String>();  
                    //System.out.println(line);
                    if(line.contains(" /")){
                        //count++;
                        index = line.indexOf(" /");
                        eWord = line.substring(1, index);
                        pronounce = line.substring(index);
                        meaning.addElement(pronounce);
                    }                        
                    else{
                        
                        eWord = line.substring(1);
                        pronounce = "không có phát âm";
                        meaning.addElement(pronounce);
                    }
                        
                    eWord = eWord.trim();
                    
                      
                }else {
                    meaning.addElement(line);
                }    
                
                line = bfRead.readLine();
                if(line == null){
                    data.addWord(eWord, meaning);count++;
                    //System.out.println("Đã thêm: "+ eWord);
                }
                else{
                    if(!line.equals("") && line.charAt(0) == '@'){
                        data.addWord(eWord, meaning);count++;
                        //System.out.println("Đã thêm: "+ eWord);
                    }
                }

            }else{
                data.addWord(eWord, meaning);count++;
                //System.out.println("Đã thêm: "+ eWord);
                line = bfRead.readLine();
            }            
        }
        System.out.println("Số từ tiếng Anh đọc được là: "+ count);
        bfRead.close();
        fin.close();
    }
}