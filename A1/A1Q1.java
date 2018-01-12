/**
 * The class <b>A1Q1</b> implements a static function 
 * that counts the number of strictly positive integers
 * in an array
 *
 * @author Marcel Turcotte (turcotte@eecs.uottawa.ca)
 *
 */

//import System.out;

public class A1Q1 {

	/** 
     * Returns the number of strictly positive elements in elems.
     * We assume that the list is not null.
     * 
     *   @param elems the list of integers
     *  @return the number of strictly positive elements in elems 
     */ 
    private static int countPositive(int[] elems) {
// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
    	int counter = 0;
    	for (int i = 0; i < elems.length; i++){
    		if (elems[i] > 0) {
    			counter++;
    		}
    	}
    	return counter;
    }
 	/**
     * The main method of this program. Gets an array of
     * strings as input parameter. The array is assumed to
     * be non-null, and all the strings in the array are
     * parsable as integer.
     *
     * The function prints out the number of positive 
     * integers parsed in args
     * @param args space-separated list of strings parsable as integers
	 */    

 	public static void main(String[] args) {
        StudentInfo.display();
 		int[] elems = new int[args.length];

 		for (int i = 0; i < args.length; i++)
 		{
 			elems[i] = Integer.parseInt(args[i]);
 		}

 		int positive=countPositive(elems);
 		System.out.println(positive);
	
// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

    }
}
