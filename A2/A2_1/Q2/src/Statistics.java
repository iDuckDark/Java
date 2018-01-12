
/**
 * The class  <b>Statistics</b> accumulates the results of
 * the experiments. It know ahead of time how many experiments
 * will be run, and provides at the end the min, the max, the
 * average and the standard deviation for the data.
 *
 * <b> this class should not use classes such as Array, 
 * Lists etc. </b> to store the data, only prinitive types 
 * and java arrays.
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */
public class Statistics {

// ADD HERE INSTANCE VARIABLES DECLARATION
	public double mean  = 0;
	public double standDev = 0;

	private int numberOfRuns;
	protected int currentRun = 0;

	private int[] results;
	private int[] minMaxTries = new int[2];
	/** 
     * Constructor.
     * 
     * @param numberOfRuns the number of experiments that will be run
     */
 	public  Statistics(int numberOfRuns){
          this.numberOfRuns=numberOfRuns;
          results = new int[numberOfRuns];
	}
	
	/** 
     * Updates statistics after one experiment.
     * This method cannot be called more times than the 
     * paramter that was passed in the constructor. If
     * it is, an error message should be printed and
     * no change should occur.
     *   @param value the result of the new experiment
     */
	public void updateStatistics(int value){
		// Check if we ran enough times
		if (currentRun>numberOfRuns){
		   System.out.println("Error Message, no change");
		}
		else{
			// Set initial max and min values
			if (currentRun == 0){
				minMaxTries[0] = value;
				minMaxTries[1] = value;
			}
			
			// Check for max or min
			if (value < minMaxTries[0])
				minMaxTries[0] = value;
			else if (value > minMaxTries[1])
				minMaxTries[1] = value;
			
			mean = average();
			standDev = standardDeviation();

			results[currentRun] = value;
			currentRun++;
		}          
	}

	/** 
     *   @return the current average of the values passed
     * to the method updateStatistic
     */
	public double average(){
		double sum = 0;
		for (int i = 0; i < results.length; i++){
		   sum += results[i];
		}
		return (sum/results.length);
	}


	/** 
     *   @return the current standard deviation of the values passed
     * to the method updateStatistic
     */
	public double standardDeviation(){
          double sumsquare = 0;
          double sum = 0;
          int n= results.length;

          for (int i = 0; i < results.length; i++){
               sumsquare += (results[i])*(results[i]);
               sum += results[i];
          }

          double sd=0;
          sd= ( sumsquare - ( (sum *sum) / n ) )/ ( n-1 );
          return Math.pow(sd, 0.5);

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

	}

	/** 
     *  @return Returns the complete statistics information:
     * current minimum, current maximim, current average and
     * current standard deviation. For the last two, only two 
     * digits decimals are shown
     */
	public String toString(){
          String s1 = "We have run " + numberOfRuns + " experiments\n";
          String s2 = "The minimum was : " + minMaxTries[0] + "\n";
          String s3 = "The maximum was : " + minMaxTries[1] + "\n";
          String s4 = "The mean was : " + mean + "\n";
          String s5 = "The standard deviation was : " + standDev + "\n";
          return s1+s2+s3+s4+s5;
	}
//      private static java.util.Random generator = new java.util.Random();
//           public static void main(String[] args) {
//                System.out.println( Math.pow(4, 0.5) );
//                System.out.println(generator);
// // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

     
}