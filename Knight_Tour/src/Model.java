/**
 * Lab Exam
 * Model Class
 * Jolar Tabungar
 * 101030060
 */

public class Model {
	//Array of Tiles, that are legal = true, or illegal = false
	private boolean tiles[][];
	//Current Move Number
	private int currentMove;
	
	public Model() {
		tiles = new boolean[View.X_MAX][View.Y_MAX];
		currentMove = 0;
	}
	
	/**
	 * 
	 * @param x the x position
	 * @param y the y position
	 * @return true if tile is legal, false otherwise
	 */
	public boolean getTile(int x, int y) {
		return tiles[x][y];
	}
	
	/**
	 * 
	 * @param x the x position of the tile
	 * @param y the y position of the tile
	 * @param legal the legal/illegal value to be set
	 */
	public void setTile(int x, int y, boolean legal) {
		tiles[x][y] = legal;
	}
	
	/**
	 * Increment the current move count
	 */
	public void incrementMove() {
		currentMove ++;
	}
	
	/**
	 * 
	 * @return The current move count
	 */
	public int getMove() {
		return currentMove;
	}
}
