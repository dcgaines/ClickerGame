
public class Framework {
	public static boolean autoSell = true;
	public static boolean loadedGame = false;
	public static boolean savedGame = false;

	public static Interface window = new Interface();

	// inventory variables
	static int wheat = 0, corn = 0;

	// starting player bank
	public static double bank = 1.00;
	public static double maxBank = 1.00;

	public static void update() {
		if (autoSell) {
			sellAll();
		}
		if (bank > maxBank)
			maxBank = bank;

		window.GUIupdate();
	}

	public static void sellAll() {
		bank += wheat * MarketPrice.WHEAT * MarketPrice.modifier;
		wheat = 0;

		bank += corn * MarketPrice.CORN * MarketPrice.modifier;
		corn = 0;
	}

	public static void print(String str) {
		Interface.messageBox.append(str + "\n");
	}
}
