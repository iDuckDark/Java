
/**
 * The class <b>DotInfo</b> is a simple helper class to store the initial color and state
 * (captured or not) at the dot position (x,y)
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class DotInfo {
    protected int x;
    protected int y;
    protected int color;
    protected boolean captured;


// ADD YOUR INSTANCE VARIABLES HERE
    /**
     * Constructor 
     * 
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     * @param color
     *            the initial color
     */
    public DotInfo(int x, int y, int color){
        this.x=x;
        this.y=y;
        this.color=color;
// ADD YOUR CODE HERE
    }

    /**
     * Getter method for the attribute x.
     * 
     * @return the value of the attribute x
     */
    public int getX(){
        return x;
// ADD YOUR CODE HERE
    }
    
    /**
     * Getter method for the attribute y.
     * 
     * @return the value of the attribute y
     */
    public int getY(){
// ADD YOUR CODE HERE
        return y;
    }
    
 
    /**
     * Setter for captured
     * @param captured
     *            the new value for captured
     */
    public void setCaptured(boolean captured) {
        captured=true;
// ADD YOUR CODE HERE
    }

    /**
     * Get for captured
     *
     * @return captured
     */
    public boolean isCaptured(){
        return (captured==true);
// ADD YOUR CODE HERE

    }

    /**
     * Get for color
     *
     * @return color
     */
    public int getColor() {
// ADD YOUR CODE HERE
        return color;
    }

 }