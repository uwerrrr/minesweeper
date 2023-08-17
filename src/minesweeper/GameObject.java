package minesweeper;

// super class of Mine and Selection
public abstract class GameObject { 
    protected int x;
    protected int y;
    
	@Override
	// ArrayList contains method use equals()
	// comparing with other mine or selection
    public boolean equals(Object o) {
        
        if (this == o) return true; // same memory ref
        if (o == null) return false; // null reference check
        if (!(o instanceof GameObject)) return false; // not from GameObject or its subclasses

        GameObject otherGameObj = (GameObject) o; // cast o to GameObject
        return x == otherGameObj.x && y == otherGameObj.y;
    }
	
	public void printCoor() { 
		System.out.println("x " + this.x + " " + "y " + this.y);
	}
	public String getCoorStr() { 
		return new String(this.x + " " +this.y);
	}
	public int[] getCorArr() { 
		return new int[]{this.x, this.y};
	}
	public void setCoor(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
