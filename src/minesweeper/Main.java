package minesweeper;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		

		System.out.println("Welcome to minesweeper game!!");
		System.out.println("A game that would blow your mind away...");
		
		// user input
		Scanner s = new Scanner(System.in);
		
		
		// user config
		int gameRow;
		int gameCol;
		int slotNum;
		int mineNum;
	
		while (true) {
			try {
				System.out.println("Please enter number of rows for the game");
				gameRow = s.nextInt();
				
				System.out.println("Please enter number of columns for the game");
				gameCol = s.nextInt();
				
				slotNum = gameRow * gameCol;
				
				System.out.println("Please enter mine number smaller than the available slots of " + slotNum);
				mineNum = s.nextInt();
				
				if(mineNum >= slotNum) {
					mineNum = slotNum;
					System.out.println("You have entered number of mines larger than or equal to the available slots.");
					System.out.println("To honor your choice, the number of mine will be " + mineNum + " for a game of " + slotNum + " slots.... ");
					System.out.println("... :)");
					System.out.println("... :)");
					System.out.println("... :)");
				}
				
				// nextInt does NOT move the cursor to next line automatically -> we need manually move the cursor to next line
				s.nextLine();
				
				break;
			}
			catch(InputMismatchException e){
				System.out.println("Invalid input. Please enter a valid integer.");
				s.nextLine();
			}	  
		};
		
	
		
		boolean isWon = false;
		boolean isLost = false;
		
		
        //mines array
  		ArrayList<Mine> mines = Game.populateMineArr(mineNum, gameRow, gameCol);
		
		// game frame
        Cell[][] frame = Game.createFrameWMine(gameRow, gameCol, mines);
        
		// add mine number to each cell in frame
		Game.addMineNumToFrame(frame);
		
		// display frame
		Game.displayFrame(frame);
		
		
		// loop until game finish
		// The number of revealed cells without mines equals the total number of cells on the board minus the number of mines.
		int totalCellNum = gameRow * gameCol;
		int safeCellNum = totalCellNum - mineNum;
		int selectedCellNum = 0;
		
		while (Game.isPlaying) {	
			
			int selectedX = Game.getValidInteger(s, "X", frame);
			int selectedY = Game.getValidInteger(s, "Y", frame);
			
			System.out.println("selected [" + selectedX + " : "+ selectedY + "] cell.");
			
			Selection selection = new Selection(selectedX, selectedY);
			Cell selectedCell = frame[selection.x][selection.y];
			
		
			
			
			if (selectedCell.hasMine) {
				selectedCell.reveal();
				isLost = true;
			} else {
				Game.revealNeiCells(frame, selectedCell);
				
				isWon = Game.isWon(frame);
				
			}
			
			Game.displayFrame(frame);
			
			
			if (isWon) {
				Game.isPlaying = false;
				Game.stop(frame);
				System.out.println("Congratulation!!!");
				System.out.println("You won !!!!!!");
				
			} else if (isLost) {
				Game.isPlaying = false;
				Game.stop(frame);
				System.out.println("Game over!!!");
				System.out.println("Better luck next time :)");
			}
		
		}
		
		s.close();
		

		
		

		

	}


}
