/**
 * The class  <b>BirthdayParadox</b> is used to
 * simulated the so-called Birthday paradox, and uses
 * the class <b>Statistics</b> to store the results of
 * the experiments.
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class BirthdayParadox {


	/** 
     * Random generator 
     */
	private static java.util.Random generator = new java.util.Random();


	/** 
     * Runs the series of experiments, and stores the result into
     * a Statistics object
     * 
     * @param range the size of the set from which random number are drawn
     * @param numberOfRuns the number of experiments to run
	 *
	 * @return a reference to a Statistics instance that holds the result
	 * of the experiment
     */
 	public static Statistics runExperiments(int range, int numberOfRuns){

          Statistics stats = new Statistics(numberOfRuns);
          int[] birthdays = new int[range+10];

          // Number of runs
          for (int run = 0; run < numberOfRuns; run++){
				birthdays = setBirthdays(birthdays);
               // Number of tries
               int tries = 0;
               int element = 0;
			   
               while (true){
                    element = generator.nextInt(range);
					
					//System.out.println(element);
					
                    if (checkSameBirthday(element, birthdays))
                         break;

                    birthdays[tries++] = element;
               }
			   //System.out.println("NEW EXP");
               // Move onto next run and update results
               stats.updateStatistics(tries);
          }
          return stats;
	}

	private static boolean checkSameBirthday(int birthday, int[] birthdays){
		for (int i = 0; i < birthdays.length; i++){
			if (birthdays[i] != -1)
				if (birthdays[i] == birthday)
					return true;
		}
		return false;
	}

     private static int[] setBirthdays(int[] birthdays){
          for (int i = 0; i < birthdays.length; i++){
               birthdays[i] = -1;
          }
          return birthdays;
     }

 	/** 
     * Runs a single experiment.
     * The parameter range defines the size of the set from which
     * the experiment is drawn
     * 
     * @param range the size of the set from which random number are drawn
     *
	 * @return the number of random draw in the set that the method 
	 * used before drawing the same element for the second time
     */
	
 	private static int oneRun(int range){
          Statistics stats = runExperiments(range, 1);

          return stats.currentRun;
	}
	

	/** 
     * Main method. The default size of the set is 365, and
     * the experiment is run 50 times. Both numbers can be reset
     * from the command line.
     * This method runs the experiments and prints the
     * resulting Statistics
     * 
     * @param args if not empty, contains the runtime values for
     * the size of the set and the number of runs
     */
	public static void main(String[] args) {
		ITI1121Chart chart = new ITI1121Chart("Birthday Paradox Experiments");
		
		int range = 100;
		int deltaRange;
		int maxRange = 10000;
		int numExperiments = 1000;
		Statistics stats;
		
		StudentInfo.display();
		
		if (args.length >= 3){
			if (args[0] != null)
				range = Integer.parseInt(args[0]);
			if (args[1] != null)
				maxRange = Integer.parseInt(args[1]);
			if (args[2] != null)
				numExperiments = Integer.parseInt(args[2]);
		}
			
		// Set the change of range
		deltaRange = range;
		
		
		
		// Run numExperiments on set size range until maxRange reached
		while (range <= maxRange){ 
			// Run numExperiments
			stats = runExperiments(range, numExperiments);
			
			// Graph result
			chart.addDataPoint(range, stats.mean, stats.standDev);
			//System.out.print(stats.toString());
			
			// Increase range
			range += deltaRange;
		}
		// Now add lines for the polynomial k
		// Lower
		chart.addPolynome(0.49);
		// Middle
		chart.addPolynome(0.525);
		// Upper
		chart.addPolynome(0.5501);
		
		// Now we must render the graph
		chart.render();
	}
}