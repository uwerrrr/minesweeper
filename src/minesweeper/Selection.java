package minesweeper;

public class Selection {
	private int x;
	private int y;
	
	public Selection(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setSelection(int x, int y) {
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
}
