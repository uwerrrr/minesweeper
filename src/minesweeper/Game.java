package minesweeper;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
    final static String unrevealStr = "[ ]";
    
    public static boolean isPlaying = true;
    
    public void setIsPlaying(boolean status) {
    		isPlaying = status;
    }

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
	public static ArrayList<Mine> populateMineArr(int mineNum, int gameRow, int gameCol){
		int minX = 1;
		int minY = 1;
		int maxX = gameRow;
		int maxY = gameCol;
		int totalCellNum = gameRow * gameCol;
		
		if (mineNum > gameRow * gameCol) mineNum = totalCellNum;
		
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
	public static Cell[][] createFrameWMine(int gameRow, int gameCol, ArrayList<Mine> mines){
		int frameRow = gameRow+1;
		int frameCol = gameCol+1;
		
		Cell[][] frame = new Cell[frameRow][frameCol];
		
		int labelNum = 1;
		for (int row = 0; row < frameRow; row++) {
			for (int col = 0; col < frameCol; col++) {
				Cell cell = new Cell(row, col, unrevealStr);
				
		  		if(row == 0 && col == 0) {
		  			cell.isRevealed = true;
		  			frame[row][col] = cell;}
		  		
		  		else if(row == 0 || col == 0) {
		  			cell.isRevealed = true;
		  			cell.setRevealStr(String.valueOf(labelNum));
		  			frame[row][col] = cell;
		  			++labelNum;
		  			labelNum = (labelNum == frameCol && col == frameCol - 1) ? 1 : labelNum;}
		  		
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
					frame[row][col].setMineNumArround(count);
					
					
				}
			}
		}
	}

	
	public static void revealNeiCells(Cell[][] frame, Cell selectedCell) {
		int  currX = selectedCell.x;
		int  currY = selectedCell.y;
		
		int minX = 1;
		int minY = 1;
		int maxX = frame.length-1;
		int maxY = frame[0].length-1;
		
		
		if (!frame[currX][currY].isRevealed && !frame[currX][currY].hasMine) {
			frame[currX][currY].isRevealed = true; // Reveal the current cell
			
			if (frame[currX][currY].numMineArround == 0) {
				int[]checkCoors = {-1,0,1};
				for (int coorX : checkCoors){
					for (int coorY : checkCoors) {
						int newX = currX + coorX;
						int newY = currY + coorY;
						
//						row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
						
						
						if ( (minX <= newX && newX<= maxX && minY <= newY && newY<= maxY) && 
								(newX != currX || newY != currY ) ) {
							
							Cell newCell = new Cell(newX, newY);
							
							// use recursive method -> run until the method no longer calls itself and the recursion stops
							revealNeiCells(frame, newCell);
						}
		            
					}
				}
			}
				
		}
		
	}

	
	public static void stop(Cell[][] frame) {
		for (Cell[] rows : frame) {
			for (Cell cell : rows) {
				cell.reveal();
			}
		}
		Game.displayFrame(frame);
	}
	
	
	public static boolean isWon(Cell[][] frame) {
		for (Cell[] rows : frame) {
			for (Cell cell : rows) {
				if (!(cell.hasMine) && !(cell.isRevealed)){
					return false;
				}
			}}
		return true;
	}
	
	
	// Validation inputs
	
	public static boolean isValidInteger(String input) {
	    	try {
	    		Integer.parseInt(input);
	    		return true;
	        } 
	    	catch (NumberFormatException e) {
	        return false;
	        }
     }
	
	public static boolean isValidInput(String input, String coordinateName, Cell[][] frame) {
		int minX = 1;
		int minY = 1;
		int maxX = frame.length;
		int maxY = frame[0].length;
		
//		System.out.println("isValidInteger(input): "+ isValidInteger(input));
		
    		if (isValidInteger(input) && coordinateName == "X") {
    			int inputX = Integer.parseInt(input);
    			if(inputX >= maxX || inputX < minX) {
    				System.out.println("Please enter a coordinate in range "+ "[" + minX + " - " + (maxX-1) + "]" + ".");
    				return false;
    			} else {
    				return true;
    			}
    		} else if (isValidInteger(input) && coordinateName == "Y") {
    			int inputY = Integer.parseInt(input);
    			if(inputY >= maxY || inputY < minY) {
    				System.out.println("Please enter a coordinate in range "+ "[" + minY + " - " + (maxY-1) + "]" + ".");
    				return false;
    			} else {
    				return true;
    			}
    		} else return false;
  
	}
	 
	public static int getValidInteger(Scanner scanner, String coordinateName, Cell[][] frame) {
		int selectedCoordinate = 0;
		System.out.println("Please enter " + coordinateName + " coordinate:");
		   
		// keep asking until receive 
		while (true) {
		 
		    String input = scanner.nextLine();
		    
		    if(input.equals("exit")) {
		    		stop(frame);
		    		isPlaying = false;
		    		break;
		    }
		    else if (isValidInput(input, coordinateName, frame)) {
			    selectedCoordinate = Integer.parseInt(input);
			    break;} 
		    else {
			    System.out.println("Invalid input. Please enter a valid integer for " + coordinateName + " coordinate.");
//			
			    }
	    }
	    return selectedCoordinate;
	}
}
