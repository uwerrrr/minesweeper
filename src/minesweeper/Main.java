package minesweeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		final int gameRow = 10;
		final int gameCol = 10;
		final int frameRow = gameRow+1;
		final int frameCol = gameCol+1;
		final int minX = 1;
		final int minY = 1;
		final int maxX = gameRow;
		final int maxY = gameCol;
		final int slotNum = gameRow * gameCol;
        final int mineNum = 8;
        final String unrevealStr = "[ ]";
        
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
        
        
        
		// game frame
        Cell[][] frame = new Cell[frameRow][frameCol];

        
        
		// add default cells to frame
		int num = 1;
		for (int row = 0; row < frameRow; row++) {
			for (int col = 0; col < frameCol; col++) {
				Cell cell = new Cell(row, col, false, unrevealStr, "", false);
				
		  		if(row == 0 && col == 0) {
		  			cell.isRevealed = true;
		  			frame[row][col] = cell;}
		  		
		  		else if(row == 0 || col == 0) {
		  			cell.isRevealed = true;
		  			cell.setRevealStr(String.valueOf(num));
		  			frame[row][col] = cell;
		  			++num;
		  			num = (num == frameRow) ? 1 : num;}
		  		
		  		else {
		  			cell.setUnrevealStr(unrevealStr);
		  			frame[row][col] = cell;}
				}
		}
		
        //mines array
  		ArrayList<Mine> mines = new ArrayList<>();
      		
  		// populate random mines -> add to mines arr & add to frame
		while (mines.size() < mineNum) {
			// int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
	  		int randomX = (int)Math.floor(Math.random() * (maxX - minX + 1) + minX);			
	  		int randomY = (int)Math.floor(Math.random() * (maxY - minY + 1) + minY);	
	  		Mine tempMine = new Mine(randomX, randomY); 
	  
	  		if (mines.contains(tempMine)) continue;
	  		
	  		frame[tempMine.x][tempMine.y].setHasMine();
	  		mines.add(tempMine);
	  		
	  		tempMine.printCoor();
		};
		
		// display frame
		Frame.displayFrame(frame);
		
		
		// add mine numbers to cells
		for (int row = 1; row < frameRow; row++) {
			for (int col = 1; col < frameCol; col++){
				int count = 0;
				if(frame[row][col].hasMine == false) {
					if (row+1 < frameRow && frame[row+1][col].hasMine) ++count;
					if (col+1 < frameCol && frame[row][col+1].hasMine) ++count;
					if (row-1 >= 0 && frame[row-1][col].hasMine) ++count;
					if (col-1 >= 0 && frame[row][col-1].hasMine) ++count;
					if (row+1 < frameRow && col+1 < frameCol && frame[row+1][col+1].hasMine) ++count;
					if (row-1 >= 0 && col-1 >= 0 && frame[row-1][col-1].hasMine) ++count;
					if (row-1 >= 0 && col+1 < frameCol && frame[row-1][col+1].hasMine) ++count;
					if (row+1 < frameRow && col-1 >= 0 && frame[row+1][col-1].hasMine) ++count;
					frame[row][col].setMineNum(count);
					
					
//					int[]checkCoors = {-1,0,1};
//					for (int coorX : checkCoors){
//						for (int coorY : checkCoors) {
//							int newRow = row + coorX;
//					        int newCol = col + coorY;
//							if (coorX == 0 && coorY == 0) continue;
//							if (newRow >= 0 && newRow < frameRow && newCol >= 0 && newCol < frameCol && frame[newRow][newCol].hasMine) {
//								count++;
//							}
//						}
//					}
					
					
				}
			}
		}
		
		
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
		Frame.displayFrame(frame);
	}


}
