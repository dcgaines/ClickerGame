
public class CornField implements Field {

	public static int owned = 0;
	public static double price = 500.00;
	public static String text = "Corn Field   |   " + owned + " Owned   |   " + String.format("$%.2f", price);;

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
		double newPrice = 500;
		newPrice += 1.2 * owned;

		return newPrice;

	}

	public static String updateText() {
		return "Corn Field   |   " + owned + " Owned   |   " + String.format("$%.2f", price);
	}

}
