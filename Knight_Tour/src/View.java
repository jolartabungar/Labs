/**
 * Lab Exam
 * View Class
 * Jolar Tabungar
 * 101030060
 */
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View {
	
	//Create frame and content pane
    public JFrame frame;
	//The view's model
	private static Model model; 
	//The view's controllers, one for each tile
	private static Controller controllers[][];
	//The view's grid of JButtons for the tiles
	private JButton tiles[][];
	
	//The bounds of the board
	public static final int X_MAX = 5;
	public static final int Y_MAX = 5;
	
	public View() {
		model = new Model();
		controllers = new Controller[X_MAX][Y_MAX];
		tiles = new JButton[X_MAX][Y_MAX];
		createGUI();
	}
	
	public void createGUI() {
		//Create frame and content pane
        frame = new JFrame("Knight's Tour");
        Container contentPane = frame.getContentPane();
       
        //Set contentPane to BorderLayout
        contentPane.setLayout(new BorderLayout());
        
    
        
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(5, 5));
        
        for (int i = 0; i < X_MAX; i ++) {
        	for (int j = 0; j < Y_MAX; j ++) {
        		tiles[i][j] = new JButton();
        		controllers[i][j] = new Controller(model, this, i, j);
        		tiles[i][j].addActionListener(controllers[i][j]);
        		board.add(tiles[i][j], i, j);
        	}
        }
  
        
        //Add all the components to the contentPane
        contentPane.add(board, BorderLayout.CENTER);
     
        //Pack the frame and its components and set it visible
        frame.pack();
        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setLocation(100, 100);
        frame.setVisible(true);
	}
	
	/**
	 * Update the clicked tile with its move count
	 * @param x the x position of the last clicked tile
	 * @param y the y position of the last clicked tile
	 */
	public void update(int x, int y) {
		tiles[x][y].setText("" + model.getMove());
	}
	
	/**
	 * Update all the tiles based on if they are legal or illegal
	 */
	public void disableIllegals() {
		for (int i = 0; i < X_MAX; i ++) {
        	for (int j = 0; j < Y_MAX; j ++) {
        		tiles[i][j].setEnabled(model.getTile(i,  j));
        		
        		//Tiles already visited are illegal
        		if (tiles[i][j].getText() != "")
        			tiles[i][j].setEnabled(false);
        	}
        }
	}
	
	/**
	 * Check if player has won or lost
	 */
	public void checkGame() {
		//Check Flags, if not unflagged then game will end
		boolean gameOver = true;
		boolean gameWin = true;
		
		//Check each tile
		for (int i = 0; i < X_MAX; i ++) {
        	for (int j = 0; j < Y_MAX; j ++) {
        		
        		if (tiles[i][j].isEnabled())
        			gameOver = false;
   
        		if (tiles[i][j].getText().equals("") || tiles[i][j].getText() == null) {
        			gameWin = false;
        		}
        			
        	}
        }
		
		//Display Messages
		if (gameOver) {
			JOptionPane.showMessageDialog(frame, "GAME OVER!");
		}
		else if (gameWin) {
			JOptionPane.showMessageDialog(frame, "PUZZLE COMPLETE!");
		}
			
	}
	
	
	
	public static void main(String[] args) {
		//Initialize a new view
		View view = new View();
	}

}
