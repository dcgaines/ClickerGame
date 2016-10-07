
public class Framework {
	// boolean variables used to determine the state of the game
	public static boolean autoSell = true;
	public static boolean loadedGame = false;
	public static boolean savedGame = false;

	// The GUI functions cannot be static, so an Interface must be instantiated
	public static Interface window = new Interface();

	// inventory variables
	static int wheat = 0, corn = 0;

	// starting player bank and variable to hold the max value of bank
	public static double bank = 1.00;
	public static double maxBank = 1.00;

	// Function that updates the GUI whenever anything occurs
	public static void update() {
		// Automatically sells all grown crops
		if (autoSell) {
			sellAll();
		}

		// updates max bank
		if (bank > maxBank)
			maxBank = bank;

		// updates all GUI components and repaints if necessary
		window.GUIupdate();
	}

	public static void sellAll() {
		// sells all wheat according to market price and modifier
		bank += wheat * MarketPrice.WHEAT * MarketPrice.modifier;
		wheat = 0;

		// sells all corn according to market price and modifier
		bank += corn * MarketPrice.CORN * MarketPrice.modifier;
		corn = 0;
	}

	// Standard print function for the game, sends everything to the message box
	// in the GUI as opposed to the console
	public static void print(String str) {
		Interface.messageBox.append(str + "\n\n");
	}
}
