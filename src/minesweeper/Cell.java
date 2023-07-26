package minesweeper;

public class Cell extends GameObject{
    protected boolean hasMine;
    protected String unrevealStr;
    protected String revealStr;
    protected boolean isRevealed;
    
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
    
    public void setHasMine() {
    		this.hasMine = true;
    		this.revealStr = "[*]";
    }
    
    public void setMineNum(int mineNumArround) {
		this.revealStr = "["+ String.valueOf(mineNumArround) + "]";
    }
    
    public void selected() {
    		this.isRevealed = true;
    }
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true; // same memory ref
        if (o == null) return false; // null reference check
        if (!(o instanceof Cell)) return false; // not from GameObject or its subclasses
        
        Cell otherCell = (Cell) o; // cast o to GameObject
        return x == otherCell.x && 
        		y == otherCell.y && 
        		otherCell.hasMine == hasMine && 
        		otherCell.unrevealStr == unrevealStr && 
        		otherCell.revealStr == revealStr && 
        		otherCell.isRevealed == isRevealed;
    }
    
}
