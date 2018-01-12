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
    private GameStack gamestack;
    /**
     * Constructor used for initializing the controller. It creates the game's view 
     * and the game's model instances
     * 
     * @param size
     *            the size of the board on which the game will be played
     */
    public GameController(int size) { 
		this.size = size;
        model = new GameModel(size);
		GameView view;
		gamestack = new GameStack(size);
		
    }

    /**
     * resets the game
     */
    public void reset(){
        model.reset();
// ADD YOUR CODE HERE
    }
    public int getSize(){
    	return size;
    }

    /**
     * Callback used when the user clicks a button (reset or quit)
     *
     * @param e
     *            the ActionEvent
     */

    public void actionPerformed(ActionEvent e) {
		// A dot is clicked
        //if(e.getActionCommand().equals("dot")) {
		//	selectColor();
		//} 
		// Reset button is clicked
		if(e.getActionCommand().equals("reset")) {
			reset();
		} 
		// Quit is clicked
		if (e.getActionCommand().equals("quit")) {
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
    	DotInfo[] emptystack= new DotInfo[size*size];	
		
		// Check if colour is not currently captured
		while (model.getCurrentSelectedColor() == color){
			for (int x=0; x<size*size ; x++){
				if (gamestack.getStack()[x].isCaptured() ){
					emptystack.push((gamestack.gamestack).pop());
				}
			}
			
		}
			// Capture possible dots)	
			//Check if dot should be captured

			// Remove all dots
			while (!stack.isEmpty()){
				pop();
			}
 
		// Check if the game is finished
		if (model.isFinished()){
			// Congratulate player and show number of moves
			System.out.println("Congratulations!" + model.getNumberOfSteps());
			
			// Give options
		}
    }
   }



// ADD YOUR PRIVATE METHODS HERE















// 	/**
//      * Tests if this Stack is empty.
//      *
//      * @return true if this Stack is empty; and false otherwise.
//      */
// 	public boolean isEmpty(){
// 		return (stack[0] == null);
// 	}

//     /**
//      * Returns a reference to the top element; does not change
//      * the state of this Stack.
//      *
//      * @return The top element of this stack without removing it.
//      */

//     public DotInfo peek(){
// 		int top = 1;
		
// 		if (stack[0] != null){
// 			while(top < (size*size)-1){
// 				if (stack[top+1] == null)
// 					return stack[top];
// 				top++;
// 			}
// 		}
// 		return stack[0];
// 	}

//     /**
//      * Removes and returns the element at the top of this stack.
//      *
//      * @return The top element of this stack.
//      */

//     public DotInfo pop(){
		
// 		if (stack[top-1] != null){
// 			while(top < (size*size)-1){
// 				if (stack[top] == null){
// 					DotInfo element = stack[top-1];
// 					stack[top] = null;
// 					return element;
// 				}
// 				top++;
// 			}
// 		}
// 		return stack[0];
// 	}

//     /**
//      * Puts an element onto the top of this stack.
//      *
//      * @param element the element be put onto the top of this stack.
//      */

//     public void push(DotInfo element){
		
// 		if (stack[top-1] != null){
// 			while(top < size*size){
// 				// Top of stack found
// 				if (stack[top] == null){
// 					stack[top] = element;
// 					break;
// 				}
// 				top++;
// 			}
// 		}
// 	}
// }

























































