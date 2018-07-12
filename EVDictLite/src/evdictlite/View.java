/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evdictlite;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.*;
/**
 *
 * @author Huu Hien
 */
public class View implements ActionListener, KeyListener, MouseListener{
    //không cho phóng to view
    //xử lí sự kiện mouse move cho tính năng instant search
    
    private JFrame mainFrame;
    private JButton btnSearch;
    private JTextField txtSearch;
    private JTextArea txtrResultField;
    private JLabel lbTimer;
    private JLabel lbSearchField;
    private JLabel lbSearchResult;
    private JLabel lbCopyright;
    private JScrollPane showResultArea;
    private JPanel pnResultArea;
    private JPanel pnCopyright;
    
    private DataStorage data;
    
    public View() throws Exception{
        ReadFile read = new ReadFile("anhviet109K.txt");;
        data = read.getData();
        prepareGUI();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String searchingWord;
        Vector result;
        if(txtSearch.isEditable() == true){
            txtrResultField.setText("");
            searchingWord= txtSearch.getText();
            result = data.decoding(searchingWord);
            if (result.size()>0)
                for (int i =0; i< result.size(); i++){
                    txtrResultField.append((String)result.elementAt(i));
                    txtrResultField.append("\n");
                }
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void prepareGUI(){
        mainFrame = new JFrame("English - Vietnamese Dictionary 1.0");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setSize(800, 700);
        mainFrame.addKeyListener(this);
        //set icon for button
        ImageIcon searchIcon = new ImageIcon("download.png");
        
        lbSearchField = new JLabel("Nhập từ bạn muốn tìm kiếm");
        lbSearchField.setSize(200, 20);
        lbSearchField.setLocation(10, 25);
        txtSearch = new JTextField();
        txtSearch.setSize(300, 30);
        txtSearch.setLocation(10, 60);
        //txtSearch.addMouseListener(this);
        btnSearch = new JButton("Search");
        btnSearch.setLocation(300, 60);
        btnSearch.setSize(80, 30);
        btnSearch.addActionListener(this);
        lbSearchResult = new JLabel("Kết quả tìm kiếm: ");
        lbSearchResult.setBounds(10, 100, 200, 20);
        pnResultArea = new JPanel();
        pnResultArea.setLayout(null);
        pnResultArea.setBounds(10, 125, 760, 500);
        pnResultArea.setBackground(Color.white);
        
        txtrResultField = new JTextArea();
        txtrResultField.setEditable(false);
        showResultArea = new JScrollPane(txtrResultField);
        showResultArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        showResultArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnResultArea.add(txtrResultField);
        txtrResultField.setBounds(5, 10, 760, 500);
        
        lbTimer = new JLabel();
        lbTimer.setText("05:20");
        lbTimer.setBounds(320, 415, 40, 25);
        
        pnCopyright = new JPanel(null);
        pnCopyright.setBounds(0, 630, 800, 30);
        pnCopyright.setBackground(Color.lightGray);
        lbCopyright = new JLabel("@copyright HuuHien from Quy Nhon University");
        pnCopyright.add(lbCopyright);
        lbCopyright.setBounds(10, 3, 350, 25);
        
        
        mainFrame.add(btnSearch);
        mainFrame.add(lbSearchField);
        mainFrame.add(txtSearch);
        mainFrame.add(lbSearchResult);
        mainFrame.add(pnResultArea);
        mainFrame.add(showResultArea);
        //mainFrame.add(lbTimer);
        mainFrame.add(pnCopyright);
        mainFrame.setLocation(100, 40);
        mainFrame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == txtSearch){
            txtSearch.setText("");
            txtrResultField.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
