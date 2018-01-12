// ADD YOUR IMPORTS HERE
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;

/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out the actual game and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameView extends JFrame {

// ADD YOUR INSTANCE VARIABLES HERE
	private DotButton[][] dots;
	private int size = 0;
	private GameModel model;
	private GameController gameController;
	
    /**
     * Constructor used for initializing the Frame
     * 
     * @param model
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public GameView(GameModel model, GameController gameController) {
    	this.model=model;
    	this.gameController=gameController;

		size = gameController.getSize()*gameController.getSize();
		
		setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		dots = new DotButton[size][size];
		addDots();
    }

    /**
     * update the status of the board's DotButton instances based on the current game model
     */

    public void update(){
    	System.out.println(model.toString());
    }

	private void addDots(){
		Random rand = new Random();
        int[] list = {GameModel.COLOR_0, GameModel.COLOR_1, GameModel.COLOR_2, GameModel.COLOR_3, GameModel.COLOR_4, GameModel.COLOR_5};
        int  n;
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				n = rand.nextInt(5);
				DotButton dot = new DotButton(i,j,n,size);
				dots[i][j] = dot;
				// Add dot to frame
				add(dot, BorderLayout.CENTER);
			}
		}
	}
}