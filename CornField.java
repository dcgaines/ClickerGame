
public class CornField implements Field {

	//store how many fields are owned, price of field, text on button
	public static int owned = 0;
	public static double price = 500.00;
	public static String text = "Corn Field   |   " + owned + " Owned   |   " + String.format("$%.2f", price);;

	//Method to execute when corn grows
	public static void grow() {
		Framework.wheat += owned;
		Framework.update();
	}

	//Method to execute when corn field is purchased
	public static void purchased() {
		owned++;
		Framework.bank -= price;
		price = updatePrice();
		text = updateText();
		Framework.update();
	}

	//Price algorithm based on how many field are owned
	public static double updatePrice() {
		// TODO: write an actual price algorithm
		double newPrice = 500;
		newPrice += 1.2 * owned;

		return newPrice;

	}

	//Method to update text on button
	public static String updateText() {
		return "Corn Field   |   " + owned + " Owned   |   " + String.format("$%.2f", price);
	}

}
