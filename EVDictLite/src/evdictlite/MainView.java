/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evdictlite;

import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.*;

/**
 *
 * @author Huu Hien
 */
public class MainView extends JFrame{
    private JPanel workingPane;
    //private JPanel lookupPane; will define in workingPane
    private JTextField tfSearch;
    private JTextArea lsWord;
    private JTextArea resultArea;
    private JMenuBar menuBar;
    private JButton btEV;
    private JButton btVE;
    
    public MainView(){
        super("My Dictionary - HuuHien");
        
        prepairUI();
    }
    
    public void prepairUI(){
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        workingPane = new JPanel();
        workingPane.setBounds(0, 90, 800, 400);
        workingPane.setBackground(Color.LIGHT_GRAY);
        workingPane.setLayout(null);
        JPanel searchArea = new JPanel();
        workingPane.add(searchArea);
        searchArea.setBounds(0, 0, 50, 190);
        searchArea.setBackground(Color.red);
        
        menuBar = new JMenuBar();
        JMenu mnFile = new JMenu("File");
        JMenu mnAbout = new JMenu("About",true);
        menuBar.add(mnFile);
        menuBar.add(mnAbout);
        
        setJMenuBar(menuBar);
        setLocation(100, 100);
        add(workingPane);
        setVisible(true);
    }
    
    public void prepairSearchArea(){
        
    }
    
}
