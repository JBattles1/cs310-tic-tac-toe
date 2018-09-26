package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeView extends JPanel implements ActionListener {
    
    TicTacToeModel model;

    private JButton[][] squares;
    private JPanel squaresPanel;
    private JLabel resultLabel;

    public TicTacToeView(TicTacToeModel model) {

        this.model = model;
		
        int width = model.getWidth();
		
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        squares = new JButton[width][width];
        squaresPanel = new JPanel(new GridLayout(width,width));
        resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");
        
        for (int row = 0; row < width; row++){
            
            for (int col = 0; col < width; col++){
				
				// loop through every row and col
				squares[row][col] = new JButton();
				squares[row][col].addActionListener(this);
				squares[row][col].setName("Square" + row + col);
				
				// finish initializing JButton; add to JPanel
                squares[row][col].setPreferredSize(new Dimension(64,64));
                squaresPanel.add(squares[row][col]);
				
			}
        }

        this.add(squaresPanel);
        this.add(resultLabel);
        
        resultLabel.setText("Welcome to Tic-Tac-Toe!");

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        /* Handle button clicks.  Extract the row and col values from the name
           of the button that was clicked, then make the mark in the grid using
           the Model's "makeMark()" method.  Finally, use the "updateSquares()"
           method to refresh the View.  If the game is over, show the result
           (from the Model's "getResult()" method) in the result label. */
        
        String name = ((JButton) event.getSource()).getName(); // Get button name
        
        // INSERT YOUR CODE HERE
		int row, col;
		char x, y;
		char[] ch = name.toCharArray();
		int width = model.getWidth();
		
		x = ch[6];
		y = ch[7];
		
		row = Character.getNumericValue(x);
		col = Character.getNumericValue(y);
		
		model.makeMark(row, col);
		updateSquares();
		
		if (model.getResult() != TicTacToeModel.Result.NONE) {
			
			resultLabel.setText(model.getResult().toString().toUpperCase());
			
			for (int i = 0; i < width; ++i) {
				for (int j = 0; j < width; ++j) {
					squares[i][j].setEnabled(false);
				}
			}
		}
    }
        
    public void updateSquares() {

        /* Loop through all View buttons and (re)set the text of each button
           to reflect the grid contents (use the Model's "getMark()" method). */
		   
		int width = model.getWidth();
		
		for (int row = 0; row < width; ++row) {
			for (int col = 0; col < width; ++col) {
				String contents = model.getMark(row, col).toString();
				squares[row][col].setText(contents);
			}
		}
    }
        
    public void showResult(String message) {
        resultLabel.setText(message);
    }
	
}