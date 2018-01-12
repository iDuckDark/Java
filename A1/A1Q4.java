import java.util.Scanner;
import java.util.Random;
//import static java.lang.Integer.parseInt;

/**
 * The class <b>A1Q4</b> is an implementation of the
 * ``Old Maid'' card game, based on the Python implementation
 * given in ITI1020
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class A1Q4{

	/**
	* Array used to store the full deck of cards,
	*/
	private static String[] deck;

	/**
	* The current number of cards in the full deck of cards
	*/
	private static int sizeDeck;

	/**
	* Array used to store the player's deck of cards
	*/
	private static String[] playerDeck;

	/**
	* The current number of cards in the player's deck of cards
	*/
	private static int sizePlayerDeck;

	/**
	* Array used to store the computer's deck of cards
	*/
	private static String[] computerDeck;

	/**
	* The current number of cards in the computer's deck of cards
	*/
	private static int sizeComputerDeck;

	/**
	* An instance of java.util.Scanner, which will get input from the
	* standard input
	*/
 	private static Scanner sc;

	/**
	* An instance of java.util.Random, to generate random numbers
	*/
 	private static Random generator;

	/** 
     * Constructor of the class. Creates the full deck of cards
     */
 
 	public  A1Q4(){
		
		sc = new Scanner(System.in);
		generator = new Random();

		String[] suits = {"\u2660", "\u2661", "\u2662", "\u2663"};
		String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		sizeDeck = suits.length*ranks.length - 1;
		deck = new String[sizeDeck];
		int index = 0;
		for(int i =0 ; i < ranks.length; i++){
			for(int j =0 ; j < suits.length; j++){
				if(!(ranks[i]=="Q" && suits[j]=="\u2663")){
					deck[index++]= ranks[i] + " of " + suits[j];
				}
			}
		}
	}

	/** 
     * Waits for user input
     */
	private static void waitForUserInput(){
		sc.nextLine();
	}

	/**
	*  Deals the cards, taking sizeDeck cards out of deck, and deals them
	*  into playerDeck and computerDeck, starting with playerDeck
	*/
	private static void dealCards(){

		ArrayStringsTools tools = new ArrayStringsTools();
		int cardPos = 0;

		// Initialize deck sizes
		sizeComputerDeck = sizeDeck/2;
		sizePlayerDeck = sizeDeck - sizeComputerDeck;

		// Initialize decks
		playerDeck = new String[sizePlayerDeck];
		computerDeck = new String[sizeComputerDeck];

		for (int i = 0; i < sizeDeck; i++){			
			// Deal the cards
			if (i%2 == 0 && cardPos != sizePlayerDeck)
				playerDeck[cardPos] = deck[i];
			else if (cardPos != sizeComputerDeck)
				computerDeck[cardPos++] = deck[i];
		}

		// Debugging: Check if decks are different
		compareDecks();
		
		/*
		showDeck(playerDeck);
		System.out.println("showing computer deck now");
		showDeck(computerDeck);
		*/	
	}
	
	private static void compareDecks(){
		
		for (int i = 0; i < sizePlayerDeck; i++){
			for (int j = 0; j < sizeComputerDeck; j++){
				if (playerDeck[i] == computerDeck[j])
					System.out.println("P: " + playerDeck[i] + "	C: " + computerDeck[j]);
			}
		}
	}
	
	private static void shuffleDeck(){	
		ArrayStringsTools tools = new ArrayStringsTools();
		
		tools.shuffleArray(deck, sizeDeck);
	}

	/**
	*  Removes all the pairs of cards from the array deckOfCards, that currently
	* contains currentSize cards. deckOfCards is unsorted. It should also not
	* be sorted once the method terminates. 
	*
    *   @param deckOfCards the array of Strings representing the deck of cards
    *   @param currentSize the number of strings in the arrayOfStrings,
    *			stored from arrayOfStrings[0] to arrayOfStrings[currentSize-1] 
    *   @return the number of cards in deckOfCards once the pair are removed
    */
	private static int removePairs(String[] deckOfCards, int currentSize){
	
// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
		ArrayStringsTools tools = new ArrayStringsTools();
		
		String[] noPairs = new String[currentSize];
				
		// Sort deck of cards
		tools.sortArray(deckOfCards, currentSize);		

		int i = 0;
		int newDeckSize = 0;
		
		while (i < currentSize-1){
			String card1 = deckOfCards[i];
			String card2 = deckOfCards[i+1];
			
			if (card1.charAt(0) == card2.charAt(0) && card1.charAt(0) == card2.charAt(0))
				i += 1;
			else if (card1.charAt(0)==card2.charAt(0))
				i += 1;
			else
				noPairs[newDeckSize++] = deckOfCards[i];	
			i += 1;
		}
		
		// Check if last card not a pair
		if (i == currentSize-1)
			noPairs[newDeckSize++] = deckOfCards[i];
		
		// Shuffle the cards
		tools.shuffleArray(noPairs, newDeckSize);
				
		// Set deck to the new shuffled deck
		System.arraycopy(noPairs, 0, deckOfCards, 0, currentSize);
		currentSize = newDeckSize;
		
		return newDeckSize;
	}

	/**
	*  Get a valid index of a card to be removed from computerDeck.
	*	Note: this method does not check that the input is indeed an integer and
	*	will crash if something else is provided.
	*  @return the valid input.
	*/
	private static int getValidInput(){

		int n = sizeComputerDeck;

		System.out.println("I have " + n + " cards. If 1 stands for my first card and");
		System.out.println(n + " for my last card, which of my cards would you like?");
		System.out.println("Give me an integer between 1 and " + n + ":");
		int position = 0;

     
		// Get position
		while (true){
			try{
				position = Integer.parseInt(sc.next());
			}catch(NumberFormatException e){
				System.out.println("Invalid number. Please enter integer between 1 and " + n);
			}
			
			// Check if we have a valid number
			if (1 <= position && position <= n)						
				return position;
			else
				System.out.println("Invalid number. Please enter integer between 1 and " + n);
		}
	}
	
	private static void enterContinue(){
		System.out.println();	
		System.out.println("Press enter to continue");
		waitForUserInput();
	}


	/**
	*  The actual game, as per the Python implementation
	*/
	public static void playGame(){
		ArrayStringsTools tools = new ArrayStringsTools();
		sc = new Scanner(System.in);
		
		String[] englishOrdinalsEnd = { "st", "nd", "rd", "th" };
		int ordIndex = 0;
		int roundNum = 0;
		
		// Shuffle the deck
		shuffleDeck();
		
		// Debugging: Show the deck
		//showDeck();
		
		// Deal the cards
		dealCards();
		
		// Welcome message
		System.out.println("Hello. My name is Robot and I am the dealer.");
		System.out.println("Welcome to my card game!");
		System.out.println("Your current deck of cards is:");
		System.out.println();
		
		// Print player deck
		tools.printArray(playerDeck, sizePlayerDeck);
		System.out.println();
		
		System.out.println("Do not worry. I cannot see the order of your cards.");
		System.out.println("Now discard all the pairs from your deck. I will do the same.");
		
		// Press enter to continue
		enterContinue();		
		
		// Remove the pairs
		sizePlayerDeck = removePairs(playerDeck, sizePlayerDeck);
		sizeComputerDeck = removePairs(computerDeck, sizeComputerDeck);
		
		// main gameplay
		while (sizeComputerDeck > 0 && sizePlayerDeck > 0){
			// Switch starting player every round
			if (roundNum%2 == 0){
				System.out.println("***********************************************************");
				System.out.println("Your turn.");
				System.out.println("Your current deck of cards is:");
								
				// Print player deck
				System.out.println();
				tools.printArray(playerDeck, sizePlayerDeck);
				System.out.println();
				
				int cardPos = getValidInput();
				
				// Save computer's card
				String item = computerDeck[cardPos-1];
				
				// Remove computer's card
				sizeComputerDeck = tools.removeItemByIndex(computerDeck, sizeComputerDeck, cardPos-1);
				
				// Give card to player
				sizePlayerDeck = tools.appendItem(playerDeck, sizePlayerDeck, item);
				
				if (3 < cardPos)
					ordIndex = 3;
				else
					ordIndex = cardPos-1;
				
				System.out.println("You asked for my " + cardPos + englishOrdinalsEnd[ordIndex] + " card.");
				System.out.println("Here it is. It is " + item);
				System.out.println();
				System.out.println("With " + item + " added, your current deck of cards is:");
				
				// Print player deck
				System.out.println();
				tools.printArray(playerDeck, sizePlayerDeck);
				System.out.println();
				
				// Remove pairs and shuffle
				System.out.println("And after discarding pairs and shuffling, your deck is:");
				sizePlayerDeck = removePairs(playerDeck, sizePlayerDeck);
				
				// Print player deck
				System.out.println();
				tools.printArray(playerDeck, sizePlayerDeck);
				System.out.println();
				
				enterContinue();
			}
			else{
				System.out.println("***********************************************************");
				System.out.println("My turn.");
				
				// Get random card position
				int cardPos = 0;
				
				// Ensure we get a valid random number
				do {
					cardPos = generator.nextInt(sizeComputerDeck);
				} while (cardPos < 0 || cardPos >= sizePlayerDeck);
				
				// Save player's card
				String item = playerDeck[cardPos];
				
				//System.out.println("\n" + cardPos + " " + sizePlayerDeck);
				
				// Remove Player's card
				sizePlayerDeck = tools.removeItemByIndex(playerDeck, sizePlayerDeck, cardPos);
				
				// Give card to Computer
				sizeComputerDeck = tools.appendItem(computerDeck, sizeComputerDeck, item);
				
				// Remove pairs and shuffle
				sizeComputerDeck = removePairs(computerDeck, sizeComputerDeck);
				
				if (3 < cardPos)
					ordIndex = 3;
				else
					ordIndex = cardPos;
				
				System.out.println("I took your " + (cardPos+1) + englishOrdinalsEnd[ordIndex] + " card.");
				
				enterContinue();	
			}
			roundNum++;
		}
		
		if (sizeComputerDeck == 0){
			System.out.println("Ups. I do not have any more cards");
			System.out.println("You lost! I, Robot, win");
		}
		else{
			System.out.println("***********************************************************");
			System.out.println("Ups. You do not have any more cards");
			System.out.println("Congratulations! You, Human, win");
		}
	}

	/**
     * The main method of this program. Creates the game object
     * and calls the playGame method on it.
     * @param args ignored
	 */    

 
	public static void main(String[] args){
		StudentInfo.display();
	
		A1Q4 game = new A1Q4();		
		
		game.playGame();
		//game.showDeck();	
	}
}

