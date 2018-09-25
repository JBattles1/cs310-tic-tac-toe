package edu.jsu.mcis;

public class TicTacToeView {


    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
                
        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE */
        System.out.print("\n  ");
		
		for(int i = 0; i<model.width; i++) {
			System.out.print(i);
		}
		System.out.println();
		System.out.println();
		for(int row=0;row<model.width; row++) {
			System.out.print(row + " ");
			for(int col=0;col<model.width; col++) {
				System.out.print(model.getMark(row,col));
			}
			System.out.print("\n");	
		}
		System.out.print("\n");
    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        /* INSERT YOUR CODE HERE */
		
		if (model.xTurn == true) {
			System.out.println("Player 1 (X) Move: ");
		}
		else {
			System.out.println("Player 2 (O) Move: ");
		}
		
		System.out.print("Enter the row and column numbers, separated by a space: ");
    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */
		
		System.out.println("Error: invalid input");

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}