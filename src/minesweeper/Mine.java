package minesweeper;

import java.util.ArrayList;


public class Mine {
	
	private int x;
	private int y;
	
	
	public Mine(int x, int y) {
		this.x = x;
		this.y = y;
	}	
	
	public void setMine(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int x() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int y() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int[] getVal() { 
		return new int[]{this.x, this.y};
	}
	public void printVal() { 
		System.out.println(this.x + " " +this.y);
	}
	public String getValStr() { 
		return new String(this.x + " " +this.y);
	}
	

//	public boolean equals(Mine mine) {
//		if (mine.x == this.x && mine.y == this.y) {
//			return true;
//		}
//		return false;
//	}
	
	 @Override
    public boolean equals(Object o) {
        if (this == o) return true; // same memory ref
        if (o == null || getClass() != o.getClass()) return false; // diff class

        Mine otherMine = (Mine) o; // cast o to Mine
        return x == otherMine.x && y == otherMine.y;
    }
	
	
}
