import java.awt.event.*;
/**
 * The class <b>GameController</b> is the controller of the game. It has a method
 * <b>selectColor</b> which is called by the view when the player selects the next
 * color. It then computesthe next step of the game, and  updates model and view.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */


public class GameController implements ActionListener {

 // ADD YOUR INSTANCE VARIABLES HERE
    private int size;
    private GameModel model;


    /**
     * Constructor used for initializing the controller. It creates the game's view 
     * and the game's model instances
     * 
     * @param size
     *            the size of the board on which the game will be played
     */
    public GameController(int size) {
		// Set board size
        this.size = size;
		
		// Initalize model and view
        GameModel model = new GameModel(size);
		GameView view;

// ADD YOUR CODE HERE

    }

    /**
     * resets the game
     */
    public void reset(){
        gamemodel.reset();

// ADD YOUR CODE HERE

    }

    /**
     * Callback used when the user clicks a button (reset or quit)
     *
     * @param e
     *            the ActionEvent
     */

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("reset")) {
         reset();
    } 
    else if (e.getActionCommand().equals("quit")) {
        System.exit(0);
    }
    
    //update();

// ADD YOUR CODE HERE

    }

    /**
     * <b>selectColor</b> is the method called when the user selects a new color.
     * If that color is not the currently selected one, then it applies the logic
     * of the game to capture possible locations. It then checks if the game
     * is finished, and if so, congratulates the player, showing the number of
     * moves, and gives two options: start a new game, or exit
     * @param color
     *            the newly selected color
     */
    public void selectColor(int color){		
		// Check if colour is not currently captured
		if (model.getCurrentSelectedColor() != color){
			// Capture possible dots
		}
		else{
			
		}
		
		// Check if the game is finished
    }


// ADD YOUR PRIVATE METHODS HERE
}

























































