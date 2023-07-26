package minesweeper;

public class Frame {

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
	
	
	
//	// add mines and default vals to frame
//	public static void populateFrame(Cell[][] frame, ) {
//		
//		
//	};

}
