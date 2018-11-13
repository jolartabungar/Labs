/**
 * Lab Exam
 * Controller Class
 * Jolar Tabungar
 * 101030060
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller implements ActionListener {
	
	//The Controller's model
	private Model model;
	//The controller's view
	private View view;
	//The position of the tile this controller is in control of
	private int x;
	private int y;
	
	public Controller(Model model, View view, int x, int y) {
		this.model = model;
		this.view = view;
		this.x = x;
		this.y = y;
	}
	
	public void actionPerformed(ActionEvent e) {
		setIllegalMoves(x, y);
	    model.setTile(x, y, false);
	    view.update(x, y);
	    model.incrementMove();
	    view.disableIllegals();
	    view.checkGame();
	}
	
	/**
	 * Update the model by setting all the illegal tiles
	 * @param x the x position of the last clicked tile
	 * @param y the y position of the last clicked tile
	 */
	public void setIllegalMoves(int x, int y) {
		
		//All the usual legal moves for a knight
		int xPos[] = {x + 2, x + 2, x - 2, x - 2, x + 1, x + 1, x - 1, x - 1};
		int yPos[] = {y + 1, y - 1, y + 1, y - 1, y + 2, y - 2, y + 2, y - 2};
		
		//Set all tiles to illegal
		for (int i = 0; i < View.X_MAX; i ++) {
        	for (int j = 0; j < View.Y_MAX; j ++) {
        		model.setTile(i,  j,  false);
        	}
        }
		
		//If legal moves are in bounds, set those tiles as legal
		for (int i = 0; i < 8; i ++) {
			if (xPos[i] >= 0 && xPos[i] <= 4 && yPos[i] >= 0 && yPos[i] <= 4)
				model.setTile(xPos[i], yPos[i], true);
		}
		
	}

}
