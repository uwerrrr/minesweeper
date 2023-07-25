package minesweeper;

import java.util.ArrayList;

public class Testing {
	
    public static void main(String[] args) {
    	 final String emptySlot = "[ ]";
         int row = 10;
         int col = 10;

         // Game frame as ArrayList<ArrayList<String>>
         ArrayList<ArrayList<String>> frame = new ArrayList<>();

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
         frame.get(0).add(0,"2"); //get row im 
//         System.out.println(frame.get(1).get(1));
    }
}
