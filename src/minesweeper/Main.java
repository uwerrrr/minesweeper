package minesweeper;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		final int gameRow = 12;
		final int gameCol = 10;
		int mineNum = 8;
		
		boolean isWon = false;
		boolean isLost = false;
		boolean isFinished = false;
		
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
		while (isFinished) {
		
			int selectedX = Game.getValidInteger(s, "X", frame);
			int selectedY = Game.getValidInteger(s, "Y", frame);
			
			System.out.println("selected [" + selectedX + " : "+ selectedY + "] cell.");
			
			Selection selection = new Selection(selectedX, selectedY);
			Game.revealCell(frame, selection);
			
			Game.displayFrame(frame);
			
			
			if (frame[selection.x][selection.y].hasMine) {
				isLost = true;
			}
			
		
			if (isWon) {
				
				isFinished = true;
				Game.stop(frame);
			} else if (isLost) {
				isFinished = true;
				Game.stop(frame);
			}
		
		}
		
		
		
		
		
//		System.out.println("Please enter X coordinate");
//		String inputX = s.nextLine();
//		if (Game.isValidInteger(inputX) == true) {
//			int selectedX = Integer.parseInt(inputX);
//		} else {
//			System.out.println("Invalid input. Please enter a valid integer for X coordinate.");
//			s.next(); 
//		}
//		
//		System.out.println("Please enter Y coordinate");
//		String inputY = s.nextLine();
//		if (Game.isValidInteger(inputY) == true) {
//			int selectedY = Integer.parseInt(inputY);
//		} else {
//			System.out.println("Invalid input. Please enter a valid integer for Y coordinate.");
//			s.next(); 
//		}
		
//	
	
		
		
		
		

		
		
		
		
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
		

		
		
		// display frame
		Game.displayFrame(frame);
	}


}
