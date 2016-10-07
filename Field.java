//cannot have methods both static and abstract
//this interface is more of a guide to field classes because the methods cannot be forced to be overridden
public interface Field {

	public static void grow() {

	}

	public static void purchased() {

	}

	public static double updatePrice() {
		return 0;
	}

	public static String updateText() {
		return null;
	}
}
