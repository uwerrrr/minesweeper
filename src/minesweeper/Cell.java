package minesweeper;

public class Cell extends GameObject{
    protected boolean hasMine;
    protected String unrevealStr;
    protected String revealStr;
    protected boolean isRevealed;
    protected int numMineArround;
    
    public Cell(int x, int y, boolean hasMine, String unrevealStr, String revealStr, boolean isRevealed) {
		this.x = x;
		this.y = y;
		this.hasMine = hasMine;
		this.unrevealStr = unrevealStr;
		this.revealStr = revealStr;
		this.isRevealed = isRevealed;
	}
    
    public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		this.hasMine = false;
		this.unrevealStr = "";
		this.revealStr = "";
		this.isRevealed = false;
	}
    
    public Cell(int x, int y, String unrevealStr) {
		this.x = x;
		this.y = y;
		this.hasMine = false;
		this.unrevealStr = unrevealStr;
		this.revealStr = "";
		this.isRevealed = false;
	}
    
    public String getUnrevealStr() {
		return unrevealStr;
	}

	public void setUnrevealStr(String unrevealStr) {
		this.unrevealStr = unrevealStr;
	}

	public String getRevealStr() {
		return revealStr;
	}

	public void setRevealStr(String revealStr) {
		this.revealStr = revealStr;
	}
    
	public boolean getHasMine() {
		return this.hasMine;
	}
    public void setHasMine() {
    		this.hasMine = true;
    		this.revealStr = "[*]";
    }
    
    public void setMineNumStr(int numMineArround) {
		this.revealStr = "["+ String.valueOf(numMineArround) + "]";
    }
    
    public void setMineNumArround(int numMineArround) {
    	this.numMineArround = numMineArround;
    	setMineNumStr(numMineArround);
    }
    
    public void reveal() {
    		this.isRevealed = true;
    }
    
    
    // compare to other cell
    public boolean equalsCell(Object o) {
        
        if (this == o) return true; // same memory ref
        if (o == null) return false; // null reference check
        if (!(o instanceof Cell)) return false; // not from Cell
        
        Cell otherCell = (Cell) o; // cast o to GameObject
        return x == otherCell.x && 
        		y == otherCell.y && 
        		otherCell.hasMine == hasMine && 
        		otherCell.unrevealStr == unrevealStr && 
        		otherCell.revealStr == revealStr && 
        		otherCell.isRevealed == isRevealed;
    }
    
}
