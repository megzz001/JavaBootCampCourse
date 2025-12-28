package Project;
//
//public class Sudoko {
//	
//class Solution {
//	   public boolean isSafe(char[][] board, int row, int col, int number) {
//	       //column
//	       for(int i=0; i<board.length; i++) {
//	           if(board[i][col] == (char)(number+'0')) {
//	               return false;
//	           }
//	       }
//	      
//	       //row
//	       for(int j=0; j<board.length; j++) {
//	           if(board[row][j] == (char)(number+'0')) {
//	               return false;
//	           }
//	       }
//	      
//	       //grid
//	       int sr = 3 * (row/3);
//	       int sc = 3 * (col/3);
//	      
//	       for(int i=sr; i<sr+3; i++) {
//	           for(int j=sc; j<sc+3; j++) {
//	               if(board[i][j] == (char)(number+'0')) {
//	                   return false;
//	               }
//	           }
//	       }
//	      
//	       return true;
//	   }
//	  
//	   public boolean helper(char[][] board, int row, int col) {
//	       if(row == board.length) {
//	           return true;
//	       }
//	      
//	       int nrow = 0;
//	       int ncol = 0;
//	      
//	       if(col == board.length-1) {
//	           nrow = row + 1;
//	           ncol = 0;
//	       } else {
//	           nrow = row;
//	           ncol = col + 1;
//	       }
//	      
//	       if(board[row][col] != '.') {
//	           if(helper(board, nrow, ncol)) {
//	               return true;
//	           }
//	       } else {
//	          
//	           //fill the place
//	           for(int i=1; i<=9; i++) {
//	               if(isSafe(board, row, col, i)) {
//	                   board[row][col] = (char)(i+'0');
//	                   if(helper(board, nrow, ncol))
//	                       return true;
//	                   else
//	                        board[row][col] = '.';
//	               }
//	           }
//	       }
//	                     
//	       return false;
//	   }
//	  
//	   public void solveSudoku(char[][] board) {
//	       helper(board, 0, 0);
//	   }
//	}
//
//
//	public static void main(String[] args) {
//	
//	        int[][] sudokuBoard = {
//	                {5, 3, 0, 0, 7, 0, 0, 0, 0},
//	                {6, 0, 0, 1, 9, 5, 0, 0, 0},
//	                {0, 9, 8, 0, 0, 0, 0, 6, 0},
//	                {8, 0, 0, 0, 6, 0, 0, 0, 3},
//	                {4, 0, 0, 8, 0, 3, 0, 0, 1},
//	                {7, 0, 0, 0, 2, 0, 0, 0, 6},
//	                {0, 6, 0, 0, 0, 0, 2, 8, 0},
//	                {0, 0, 0, 4, 1, 9, 0, 0, 5},
//	                {0, 0, 0, 0, 8, 0, 0, 7, 9} };
//	        System.out.println("Sudoku Puzzle:");
//	        printBoard(sudokuBoard);
//
//	        if (solveSudoku(sudokuBoard)) {
//	            System.out.println("\nSolution:");
//	            printBoard(sudokuBoard);
//	        } else {
//	            System.out.println("\nNo solution exists.");
//	        }
//	}
//}
public class Sudoko{

    public static boolean solveSudoku(int[][] board) {
        int[] emptyLocation = findEmptyLocation(board);

        // If there is no empty location, the puzzle is solved.
        if (emptyLocation == null) {
            return true;
        }

        int row = emptyLocation[0];
        int col = emptyLocation[1];

        // Try placing digits 1 through 9 in the empty cell
        for (int num = 1; num <= 9; num++) {
            if (isValidMove(board, row, col, num)) {
                board[row][col] = num;

                // Recursively try to solve the remaining puzzle
                if (solveSudoku(board)) {
                    return true;
                }

                // If the current configuration doesn't lead to a solution, backtrack
                board[row][col] = 0;
            }
        }

        // No valid move for the current empty cell, trigger backtracking
        return false;
    }

    public static boolean isValidMove(int[][] board, int row, int col, int num) {
        // Check if 'num' is not present in the current row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Check if 'num' is not present in the 3x3 grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int[] findEmptyLocation(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    return new int[]{row, col};
                }
            }
        }
        return null; // All cells are filled
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] sudokuBoard = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println("Sudoku Puzzle:");
        printBoard(sudokuBoard);

        if (solveSudoku(sudokuBoard)) {
            System.out.println("\nSolution:");
            printBoard(sudokuBoard);
        } else {
            System.out.println("\nNo solution exists.");
        }
    }
}
