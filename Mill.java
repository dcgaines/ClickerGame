
public class Mill implements Building {
	public static int level = 0;
	public static double price = 1500.00;
	public static String text = "Mill";

	public static void cornMealOperate( ) {
		Framework.cornMeal++;
		Framework.corn--;
	}

	public static void flourOperate( ) {
		Framework.wheat -= 2;
		Framework.flour++;
	}

	public static void upgraded( ) {
		level++;
		Framework.bank -= price;
		updatePrice( );
		updateText( );
		Framework.update( );
	}

	private static void updatePrice( ) {
		price *= 1.20;
	}

	private static void updateText( ) {
		text = "Mill   |   Level " + level + "   |   " + String.format( "$%.2f", price );
	}
}
