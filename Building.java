//cannot have methods both static and abstract
//this interface is more of a guide to field classes because the methods cannot be forced to be overridden
public interface Building {

	public static void operate( ) {

	}

	public static void upgraded( ) {

	}

	public static double updatePrice( ) {
		return 0;
	}

	public static String updateText( ) {
		return null;
	}
}
