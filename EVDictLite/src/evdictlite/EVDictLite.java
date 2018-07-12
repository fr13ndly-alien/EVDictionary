/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evdictlite;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author Huu Hien
 */
public class EVDictLite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        //View mainView = new View();
        //ReadFile read = new ReadFile("anhvietDemoData.txt");
        //MainView view = new MainView();
         
        EventQueue.invokeLater(new Runnable() {
         
            @Override
            public void run() {
                try {
                    //View view = new View();
                    NewJFrame newFrame = new NewJFrame();
                } catch (Exception ex) {
                    Logger.getLogger(EVDictLite.class.getName()).log(Level.SEVERE, null, ex);
                }
                try { 
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
                } catch (Exception ex) { 
                    ex.printStackTrace(); 
                }
            }
        });
    }    
}
