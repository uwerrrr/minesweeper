package minesweeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		
        
//        // game frame
//		String[][] frame = new String[frameRow][frameCol]; // 10 rows x 10 columns
//		
//		// Populate frame with default val 
//		int num = 1;
//        for (int row = 0; row < frameRow; row++) {
//            for (int col = 0; col < frameCol; col++) {
//        		if(row == 0 && col == 0) {
//        			frame[row][col] = "";}
//        		else if(row == 0 || col == 0) {
//        			frame[row][col] = String.valueOf(num);
//        			++num;
//        			num = (num == frameRow) ? 1 : num;}
//        		else {
//        			frame[row][col] = emptySlot;}
//            }
//        }
//        
//     
//        

//      
//        
//        // user selection
//        Selection selection = new Selection(5,5);
        
//        public static boolean validateSelection(Selection selection) {
//        		return false;
//        }
//        selection x y
//        mine x y
//        match -> lost
        // not match -> ask
        // should display frame with while loop
        // while won false -> 
       // cell class -> cell array
        
        
        
		
		
//		for (Mine mine : mines)
//		frame[mine.x][mine.y].setHasMine();
//}	
		
        //mines array
  		ArrayList<Mine> mines = Game.populateMineArr();
		
		
		
		
		// game frame
        Cell[][] frame = Game.createGameFrame(mines);
        
//		// add mine and default cells to frame
//		int labelNum = 1;
//		for (int row = 0; row < frameRow; row++) {
//			for (int col = 0; col < frameCol; col++) {
//				Cell cell = new Cell(row, col, false, unrevealStr, "", false);
//				
//		  		if(row == 0 && col == 0) {
//		  			cell.isRevealed = true;
//		  			frame[row][col] = cell;}
//		  		
//		  		else if(row == 0 || col == 0) {
//		  			cell.isRevealed = true;
//		  			cell.setRevealStr(String.valueOf(labelNum));
//		  			frame[row][col] = cell;
//		  			++labelNum;
//		  			labelNum = (labelNum == frameRow) ? 1 : labelNum;}
//		  		
//		  		else {
//		  			cell.setUnrevealStr(unrevealStr);
//		  			if (mines.contains(cell)) cell.setHasMine();
//		  			frame[row][col] = cell;
//	  			}
//			}
//		}
		Game.addMineNumToFrame(frame);
		
		// display frame
		Game.displayFrame(frame);
		
		
		int[][] testFr = {{1,2,3},{4,5,6}};
		
		System.out.println(Arrays.deepToString(testFr));
		// add mine numbers to cells
		
		
		
		// user selection
  		
  		
  		// testing corner
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
		
		for (Cell[] rows : frame) {
			for (Cell cell : rows) {
				cell.selected();
			}
		}
		
		
		// display frame
		Game.displayFrame(frame);
	}


}
