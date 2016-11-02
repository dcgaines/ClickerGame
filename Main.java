
public class Main {

	static Interface window = new Interface( );

	public static void main( String[] args ) {
		// Creates the initial window and applies settings to various components
		window.GUIinit( );

		// Prints welcome message and initial instructions to the message box
		Framework.print( "Hello! Welcome to the Farm Game!      \nBuy a wheat field to get started." );
	}
}
