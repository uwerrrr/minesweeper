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
		final int slotNum = gameRow * gameCol;
        final int mineNum = 8;
        final String emptySlot = "[ ]";
        
        // game frame
		String[][] frame = new String[frameRow][frameCol]; // 10 rows x 10 columns
		
		// Populate frame with default val and display
		int num = 1;
        for (int row = 0; row < frameRow; row++) {
            for (int col = 0; col < frameCol; col++) {
            		if(row == 0 && col == 0) {
            			frame[row][col] = "";}
            		else if(row == 0 || col == 0) {
            			frame[row][col] = String.valueOf(num);
            			++num;
            			num = (num == frameRow) ? 1 : num;}
            		else {
            			frame[row][col] = emptySlot;}
                System.out.printf("%4s ", frame[row][col]);
            }
            System.out.println();
        }
        
        //mines array
    		ArrayList<Mine> mines = new ArrayList<>();
    		
    		// populate random mines -> add to mines arr
        while (mines.size() < mineNum) {
        		int randomX = (int)Math.floor(Math.random() * (mineNum - 0 + 1) + 0);			
        		int randomY = (int)Math.floor(Math.random() * (mineNum - 0 + 1) + 0);			
        		Mine tempMine = new Mine(randomX, randomY); 
        
        		if (mines.contains(tempMine)) continue;
        		
        		mines.add(tempMine);
        };
        
        for(Mine mine : mines) {
        		System.out.println(mine.getValStr());
        }
      
        Selection selection = new Selection(5,5);
        
      
	}



}
