package edu.jsu.mcis;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JPanel {

    private static final int DEFAULT_WIDTH = 3;

    public static void main(String[] args) {
        
        /* Set initial size of game board (default is 3x3) */

        int width = DEFAULT_WIDTH;
		
        TicTacToeModel model = new TicTacToeModel(width);
        TicTacToeView view = new TicTacToeView(model);
        
		JFrame win = new JFrame("Tic-Tac-Toe");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.add(view);
		win.pack();
		win.setVisible(true);
    
    }

}