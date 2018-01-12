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

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
          Statistics stats = new Statistics(numberOfRuns);
          int[] birthdays = new int[366];

          birthdays = setBirthdays(birthdays);

          // Number of runs
          for (int run = 0; run < numberOfRuns; run++){
               // Number of experiments
               int tries = 0;
               int element = 0;
               while (true){
                    element = generator.nextInt(range);

                    if (checkSameBirthday(element, birthdays)){
                         break;
                    }

                    birthdays[tries++] = element;
               }
               // Move onto next run and update results
               stats.updateStatistics(element);
          }
          return stats;
	}

     private static boolean checkSameBirthday(int birthday, int[] birthdays){
          for (int i = 0; i < birthdays.length; i++){
               if (birthdays[i] != -1)
                    if (birthdays[i] == birthday)
                         return true;
               else
                    return false;
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

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

	}

}