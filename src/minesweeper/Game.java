package minesweeper;

import java.util.ArrayList;

public class Game {
	
	final static int gameRow = 10;
	final static int gameCol = 5;
	final static int frameRow = gameRow+1;
	final static int frameCol = gameCol+1;
	final static int minX = 1;
	final static int minY = 1;
	final static int maxX = gameRow;
	final static int maxY = gameCol;
	final static int slotNum = gameRow * gameCol;
    final static int mineNum = 8;
    final static String unrevealStr = "[ ]";

	// display array method
	public static void displayFrame(Cell[][] frame) {
		System.out.println();
		for (int row = 0; row < frame.length; row++) {
	        for (int col = 0; col < frame[row].length; col++) {				
	        		if(frame[row][col].isRevealed == false) 
	        			System.out.printf("%3s ", frame[row][col].getUnrevealStr()); 
	        		else 
	        			System.out.printf("%3s ", frame[row][col].getRevealStr());
	
	        }
	        		System.out.println();
	    }
		System.out.println();
	};
	
	
	// populate mines arr
	public static ArrayList<Mine> populateMineArr(){
		//mines array
  		ArrayList<Mine> mines = new ArrayList<>();
  		
  		// populate random mines -> add to mines arr
		while (mines.size() < mineNum) {
			// int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
	  		int randomX = (int)Math.floor(Math.random() * (maxX - minX + 1) + minX);			
	  		int randomY = (int)Math.floor(Math.random() * (maxY - minY + 1) + minY);	
	  		Mine tempMine = new Mine(randomX, randomY); 
	  
	  		if (mines.contains(tempMine)) continue;
	  		
	  		
	  		mines.add(tempMine);
	  		
	  		tempMine.printCoor();
		}
		
		return mines;
	}

	//create game frame and add mines to frame
	public static Cell[][] createGameFrame(ArrayList<Mine> mines){
		Cell[][] frame = new Cell[frameRow][frameCol];
		int labelNum = 1;
		for (int row = 0; row < frameRow; row++) {
			for (int col = 0; col < frameCol; col++) {
				Cell cell = new Cell(row, col, false, unrevealStr, "", false);
				
		  		if(row == 0 && col == 0) {
		  			cell.isRevealed = true;
		  			frame[row][col] = cell;}
		  		
		  		else if(row == 0 || col == 0) {
		  			cell.isRevealed = true;
		  			cell.setRevealStr(String.valueOf(labelNum));
		  			frame[row][col] = cell;
		  			++labelNum;
		  			labelNum = (labelNum == frameRow) ? 1 : labelNum;}
		  		
		  		else {
		  			cell.setUnrevealStr(unrevealStr);
		  			if (mines.contains(cell)) cell.setHasMine();
		  			frame[row][col] = cell;
				}
			}
		}
		
		return frame;
	}
	
	
	public static void addMineNumToFrame(Cell[][] frame){
		final int frameRow = frame.length;
		final int frameCol = frame[0].length;
		
		
		for (int row = 1; row < frameRow; row++) {
			for (int col = 1; col < frameCol; col++){
				int count = 0;
				if(frame[row][col].hasMine == false) {
					
					// method 1
	//				if (row+1 < frameRow && frame[row+1][col].hasMine) ++count;
	//				if (col+1 < frameCol && frame[row][col+1].hasMine) ++count;
	//				if (row-1 >= 0 && frame[row-1][col].hasMine) ++count;
	//				if (col-1 >= 0 && frame[row][col-1].hasMine) ++count;
	//				if (row+1 < frameRow && col+1 < frameCol && frame[row+1][col+1].hasMine) ++count;
	//				if (row-1 >= 0 && col-1 >= 0 && frame[row-1][col-1].hasMine) ++count;
	//				if (row-1 >= 0 && col+1 < frameCol && frame[row-1][col+1].hasMine) ++count;
	//				if (row+1 < frameRow && col-1 >= 0 && frame[row+1][col-1].hasMine) ++count;
	//				frame[row][col].setMineNum(count);
					
					
					// method 2
					int[]checkCoors = {-1,0,1};
					for (int coorX : checkCoors){
						for (int coorY : checkCoors) {
							int newRow = row + coorX;
					        int newCol = col + coorY;
							if (coorX == 0 && coorY == 0) continue;
							if (newRow >= 0 && newRow < frameRow && newCol >= 0 && newCol < frameCol && frame[newRow][newCol].hasMine) count++;
						
						}
					}
					frame[row][col].setMineNum(count);
					
					
				}
			}
		}
	}

}
