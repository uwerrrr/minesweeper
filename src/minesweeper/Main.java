package minesweeper;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		

		System.out.println("Welcome to minesweeper game!!");
		System.out.println("A game that would blow your mind away...");
		
		
		final int gameRow = 10;
		final int gameCol = 10;
		
		int mineNum = 10;
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
		
		
		// user input
		Scanner s = new Scanner(System.in);
		
		
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
		

		
		
		
		
		
		
		
		
		
		
		
		
		
  		// testing corner
		
		
//		int[][] testFr = {{1,2,3},{4,5,6}};
//		
//		System.out.println(Arrays.deepToString(testFr));
		
		
//		Mine testMine = new Mine(5,5);
//		frame[testMine.x][testMine.y].setHasMine();
//  		
//		Selection selection1 = new Selection(5,5);
//		frame[selection1.x][selection1.y].selected();
//		
//		Selection selection2 = new Selection(10,5);
//		frame[selection2.x][selection2.y].selected();
////		frame[selection2.x][selection2.y].setMineNum(3);
//		
////		Selection selection2 = new Selection(10,5);
//		frame[10][6].selected();
		

		

	}


}
