
public class CornField implements Field {

	// store how many fields are owned, price of field, text on button
	public static int owned = 0;
	public static double price = 200.00;
	public static String text = "Corn Field   |   " + owned + " Owned   |   " + String.format( "$%.2f", price );;

	// Method to execute when corn grows
	public static void grow( ) {
		Framework.corn += owned;
		Framework.update( );
	}

	// Method to execute when corn field is purchased
	public static void purchased( ) {
		owned++;
		Framework.bank -= price;
		updatePrice( );
		updateText( );
		Framework.update( );
	}

	// Price algorithm based on how many field are owned
	public static void updatePrice( ) {
		// TODO: write an actual price algorithm
		price *= 1.1;

	}

	// Method to update text on button
	public static void updateText( ) {
		text = "Corn Field   |   " + owned + " Owned   |   " + String.format( "$%.2f", price );
	}

}
