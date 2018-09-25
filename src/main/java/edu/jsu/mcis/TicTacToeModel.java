package edu.jsu.mcis;


public class TicTacToeModel {
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    public Mark[][] grid; /* Game grid */
    public boolean xTurn; /* True if X is current player */
    public int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        /* INSERT YOUR CODE HERE */
		
            grid = new Mark[width][width];

        /* Initialize grid by filling every square with empty marks */

        /* INSERT YOUR CODE HERE */
		for (int row = 0; row < width; row++) {
			for (int col = 0; col < width; col++) {
				grid[row][col] = Mark.EMPTY;
			}
		}
	}
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
        /* INSERT YOUR CODE HERE */

        boolean mark = false;
		
		if ((isValidSquare(row, col) == true) && (isSquareMarked(row, col) == false) && (xTurn == true)) {
			
			grid[row][col] = Mark.X;
			xTurn = false;
			mark = true; 
			
		}
		else if ((isValidSquare(row, col) == true) && (isSquareMarked(row, col) == false) && (xTurn == false)){
			
			grid[row][col] = Mark.O;
			xTurn = true;
			mark = true;
		}
		else {
			mark = false;
		}
		
	return mark;
        
    }
	
    boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        /* INSERT YOUR CODE HERE */

        if((row < width & row >= 0) && (col < width & col >= 0)) {
			return true;
		}
		else {
			return false;
		}
    }
	
    boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        /* INSERT YOUR CODE HERE */
        return !((isValidSquare(row, col) == true) && (grid[row][col] == Mark.EMPTY));
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        /* INSERT YOUR CODE HERE */

        if(isValidSquare(row, col) == true) {
			return grid[row][col];
		}
		else {
            return null;
        }
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */

        if (isMarkWin(Mark.X) == true) {
           return Result.X;
        }   
        if(isMarkWin(Mark.O) == true) {
            return Result.O;
        }
        else if(isTie() == true) {
            return Result.TIE;
		}
        else {
            return Result.NONE;
		}

    }
	
    public boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /* INSERT YOUR CODE HERE */

        int counter = 0;
        int winMethod = 0;
        boolean result = false;
		
		// CHECK ROWS
		
		for (int i = 0; i < width; ++i) {
			
			counter = 0;
			
			for (int j = 0; j < width; ++j) {
				
				if (grid[i][j] == mark)
					counter++;
				
			}
			
			if (counter == width)
				
				result = true;
			
		}
		
		// CHECK COLUMNS
		
		for (int i = 0; i < width; ++i) {
			
			counter = 0;
			
			for (int j = 0; j < width; ++j) {
				
				if (grid[j][i] == mark)
					counter++;
				
			}
			
			if (counter == width)
				
				result = true;
			
		}
		
		// CHECK L-to-R DIAGONAL
		
		counter = 0;
		
		for (int i = 0; i < width; ++i) {
			
			if (grid[i][i] == mark)
			
				counter++;
			
		}
		
		if (counter == width)
			
			result = true;
			
		// CHECK R-to-L DIAGONAL
		
		counter = 0;
		
		for (int i = 0; i < width; ++i) {
			
			if (grid[i][width - i - 1] == mark)
			
				counter++;
			
		}
		
		if (counter == width)
			
			result = true;
		
        return result;
		
    }
    

	
    public boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */

        boolean tie = false;
		int counter = 0;
		
		for (int i = 0; i <(width); i++) {
			for(int j = 0; j < width; j++) {
				if(grid[i][j] != Mark.EMPTY) {
					counter++;
				}
			}
			
		}
		
		if(counter == (width * width)) {
			tie = true;
		}
		return tie;
		
    }

    public boolean isGameover() {
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
	}
       
    
}