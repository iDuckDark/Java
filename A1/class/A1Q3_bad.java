/**
 * The class <b>A1Q3</b> implements a static function 
 * that counts the number of positive integers
 * in an array
 *
 * @author Marcel Turcotte (turcotte@eecs.uottawa.ca)
 *
 */


public class A1Q3 {

	/** 
     * Returns the longest run of consecutive identical elements in elems.
     * We assume that the list is not null.
     * 
     *   @param elems the list of integers
     *   @return size of the longest run
     */
 
    private static int getLongestRun(int[] elems) {
// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        if (elems.length==0){
            return 0;
        }
        int i=0;
        int maxlength=1;
        while (i< elems.length-1) {
            int len=1;
            while (i< elems.length-1 && elems[i]==elems[i+1]){
                len=len+1;
                i++;
            if (len> maxlength){
                maxlength=len;
            i++;
            }
            }
        }
        return maxlength;
    }

 	/**
     * The main method of this program. Gets an array of
     * strings as input parameter. The array is assumed to
     * be non-null, and all the strings in the array are
     * parsable as integer.
     *
     * The function prints out the longest run of consecutive 
     * identical integers parsed in args
     * @param args space-separated list of strings parsable as integers
	 */    

 	public static void main(String[] args) {
        int[] elems = new int[args.length];

        for (int i = 0; i < args.length; i++){
            elems[i] = Integer.parseInt(args[i]);
        }
        int answer=getLongestRun(elems);
        System.out.println(answer);

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

    }
}
