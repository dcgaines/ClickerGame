
public class WheatField implements Field {

	// store how many fields are owned, price of field, text on button
	public static int owned = 0;
	public static double price = 1.00;
	public static String text = "Wheat Field";

	// Method to execute when wheat grows
	public static void grow( ) {
		Framework.wheat += owned;
		Framework.update( );
	}

	// Method to execute when a wheat field is purchased
	public static void purchased( ) {
		owned++;
		Framework.bank -= price;
		updatePrice( );
		updateText( );
		Framework.update( );
	}

	// Algorithm to calculate the price of the next field based on fields owned
	public static void updatePrice( ) {
		price *= 1.2;
	}

	// Method to update the text on the button
	public static void updateText( ) {
		text = "Wheat Field   |   " + owned + " Owned   |   " + String.format( "$%.2f", price );
	}
}
