
public class WheatField implements Field {

	public static int owned = 0;
	public static double price = 1.00;
	public static String text = "Wheat Field";

	public static void grow() {
		Framework.wheat += owned;
		Framework.update();
	}

	public static void purchased() {
		owned++;
		Framework.bank -= price;
		price = updatePrice();
		text = updateText();
		Framework.update();
	}

	public static double updatePrice() {
		// TODO: write an actual price algorithm
		double newPrice = 5;
		newPrice *= owned;

		return newPrice;

	}

	public static String updateText() {
		return "Wheat Field   |   " + owned + " Owned   |   " + String.format("$%.2f", price);
	}
}
