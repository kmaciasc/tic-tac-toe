package metronom.view;

import java.util.Scanner;

import metronom.model.Board;
import metronom.model.Cell;

public class TicTacToeView {

	Scanner input;

	public TicTacToeView() {
		input = new Scanner(System.in);
	}

	public void displayMessage(String mssg) {
		System.out.println(mssg);
	}

	public String readFromInput() {
		return input.nextLine();
	}

	public void printBoard(Board board) {
		int rows = board.getRows();
		int cols = board.getCols();
		Cell[][] gameBoard = board.getGameBoard();

		for (int row = 0; row < rows; row++) {
	         for (int col = 0; col < cols; col++) {
	        	 System.out.print(" "+gameBoard[row][col].getValue()+" ");
	            if (col != cols - 1) {
	               System.out.print("|");
	            }
	         }
	         System.out.println();
	         if (row != rows - 1) {
	        	 for (int i = 1; i < rows; i++) {
	        		System.out.print("-----");
				}
	        	 System.out.println();
	         }
	      }

	}
}
