package minesweeper;

import java.util.ArrayList;

public class Testing {
	
    public static void main(String[] args) {
//    	 final String emptySlot = "[ ]";
//         int row = 10;
//         int col = 10;

         // Game frame as ArrayList<ArrayList<String>>
//         ArrayList<ArrayList<String>> frame = new ArrayList<>();

//         // Populate frame with default val
//         for (int i = 0; i < row; i++) {
////             ArrayList<String> rowList = new ArrayList<>(); 
//             for (int j = 0; j < col; j++) {
////                 rowList.add(emptySlot);
//            	 frame.get(i).add(j,emptySlot);
//             }
//         }
//
//         // Display the 10x10 frame
//         for (int i = 0; i < row; i++) {
//             for (int j = 0; j < col; j++) {
//                 System.out.printf("%4s ", frame.get(i).get(j));
//             }
//             System.out.println();
//         }
//         frame.get(0).add(0,"2"); //get row im 
//         System.out.println(frame.get(1).get(1));
    		final int gameRow = 10;
		final int gameCol = 10;
		final int frameRow = gameRow+1;
		final int frameCol = gameCol+1;
		// coordinates: 1-10
		final int minX = 1;
		final int minY = 1;
		final int maxX = gameRow;
		final int maxY = gameCol;
		final int slotNum = gameRow * gameCol;
        final int mineNum = 8;
        
     // int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
       
        for(int i=0; i<20;i++) {
        	 int randomY = (int)Math.floor(Math.random() * (maxY - minY + 1) + minY);
        System.out.println(randomY);}
    }
}
