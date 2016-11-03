import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class Interface {
	// The main window and container (default BorderLayout)
	static JFrame frame = new JFrame( "Farm Game" );
	static Container mainPane = frame.getContentPane( );

	// Text field and String for bank (NORTH)
	static JTextField bankField = new JTextField( );
	static String formattedVal = "";

	// Text area for message box on a scroll pane, with caret for auto-scrolling
	// (EAST)
	static JTextArea messageBox = new JTextArea( );
	static JScrollPane messageScroll = new JScrollPane( messageBox );
	static DefaultCaret caret = (DefaultCaret) messageBox.getCaret( );

	// Tabbed Pane with panel for each tab, scroll pane for fields
	static JTabbedPane tabs = new JTabbedPane( );
	static JPanel fieldPanel = new JPanel( );
	static JPanel inventoryPanel = new JPanel( );
	static JPanel buildingPanel = new JPanel( );
	static JPanel optionsPanel = new JPanel( );
	static JScrollPane fieldScroll = new JScrollPane( fieldPanel );

	// Booleans to determine if tabs are showing
	static boolean buildings = false;

	// Buttons for crops
	static JButton wheatButton = new JButton( "Wheat Field" );
	static JButton cornButton = new JButton( "Corn Field" );

	// Panels for inventory

	static JPanel leftPanel = new JPanel( );
	static JPanel rightPanel = new JPanel( );

	// Text Boxes for inventory
	static Font inventoryFont = new Font( "Arial", Font.PLAIN, 42 );
	static JTextField wheatText = new JTextField( "Wheat: 0" );
	static JTextField cornText = new JTextField( "Corn: 0" );

	// Sell button for inventory
	static JButton sellButton = new JButton( "Sell all" );

	// Buttons for buildings
	static JButton millButton = new JButton( "Purchase Mill  |  $1,500" );

	// Option buttons
	static JButton saveButton = new JButton( "Save" );
	static JButton loadButton = new JButton( "Load" );

	// Actions for buttons
	static Action wheatAction = new WheatAction( );
	static Action cornAction = new CornAction( );

	static Action millAction = new MillAction( );

	static Action saveAction = new SaveAction( );
	static Action loadAction = new LoadAction( );

	public void GUIinit( ) {

		// border layout with tabbed pane in center, bank on top, and message
		// box on the right
		mainPane.add( messageScroll, BorderLayout.EAST );
		mainPane.add( tabs, BorderLayout.CENTER );
		mainPane.add( bankField, BorderLayout.NORTH );

		// Message box auto scrolling, font, non-editable
		caret.setUpdatePolicy( DefaultCaret.ALWAYS_UPDATE );
		messageBox.setFont( new Font( "Arial", Font.PLAIN, 28 ) );
		messageBox.setEditable( false );

		// Note: Tabs can have icons
		// Add tabs to the pane and set their font
		tabs.setFont( new Font( "Arial", Font.PLAIN, 30 ) );
		tabs.addTab( "Fields", fieldPanel );
		tabs.addTab( "Inventory", inventoryPanel );
		tabs.addTab( "Options", optionsPanel );

		// Layout, color, and add buttons to field panel
		fieldPanel.setLayout( new GridLayout( 5, 0 ) );
		fieldPanel.setBackground( new Color( 0, 217, 0 ) );
		fieldPanel.add( wheatButton );
		fieldPanel.add( cornButton );

		// Tool tips for field buttons
		wheatButton.setToolTipText( "Buy a wheat field" );
		cornButton.setToolTipText( "Buy a corn field" );

		// Font for field buttons
		wheatButton.setFont( new Font( "Arial", Font.PLAIN, 60 ) );
		cornButton.setFont( new Font( "Arial", Font.PLAIN, 60 ) );

		// Actions for field buttons
		wheatButton.setAction( wheatAction );
		cornButton.setAction( cornAction );

		// Text for field buttons
		wheatButton.setText( WheatField.text );
		if ( Framework.maxBank >= 150 )
			cornButton.setText( CornField.text );
		else
			cornButton.setText( "Corn Field" );

		// Enable or disable field buttons based on bank
		if ( Framework.bank >= WheatField.price )
			wheatButton.setEnabled( true );
		else
			wheatButton.setEnabled( false );
		if ( Framework.bank >= CornField.price )
			cornButton.setEnabled( true );
		else
			cornButton.setEnabled( false );

		// Layout, background, and buttons for inventory panel
		inventoryPanel.setLayout( new GridLayout( 5, 0 ) );
		inventoryPanel.setBackground( new Color( 252, 213, 141 ) );

		inventoryPanel.setLayout( new GridLayout( 0, 2 ) );
		inventoryPanel.add( leftPanel );
		inventoryPanel.add( rightPanel );

		leftPanel.setBackground( new Color( 252, 213, 141 ) );
		leftPanel.setLayout( new GridLayout( 10, 0 ) );

		rightPanel.setBackground( new Color( 252, 213, 141 ) );
		rightPanel.setLayout( new GridLayout( 10, 0 ) );

		leftPanel.add( wheatText );
		leftPanel.add( cornText );

		wheatText.setFont( inventoryFont );
		cornText.setFont( inventoryFont );

		wheatText.setOpaque( false );
		cornText.setOpaque( false );

		wheatText.setHorizontalAlignment( 0 );
		cornText.setHorizontalAlignment( 0 );

		wheatText.setEditable( false );
		cornText.setEditable( false );

		rightPanel.add( sellButton );

		sellButton.setEnabled( true );
		sellButton.setFont( inventoryFont );
		sellButton.setText( "Sell All" );

		// Layout, background, and buttons for building panel
		buildingPanel.setLayout( new GridLayout( 3, 0 ) );
		buildingPanel.setBackground( new Color( 66, 176, 176 ) );
		buildingPanel.add( millButton );

		millButton.setFont( new Font( "Arial", Font.PLAIN, 60 ) );

		millButton.setAction( millAction );

		millButton.setToolTipText( "Purchase a mill" );

		millButton.setText( "Purchase Mill  |  $1,500" );

		// Layout, background, and buttons for options panel
		optionsPanel.setLayout( new GridLayout( 3, 0 ) );
		optionsPanel.setBackground( new Color( 0, 0, 217 ) );
		optionsPanel.add( saveButton );
		optionsPanel.add( loadButton );

		// Tool tips for options buttons
		saveButton.setToolTipText( "Save your progress" );
		loadButton.setToolTipText( "Load your previous progress" );

		// Font for options buttons
		saveButton.setFont( new Font( "Arial", Font.PLAIN, 42 ) );
		loadButton.setFont( new Font( "Arial", Font.PLAIN, 42 ) );

		// Actions for options buttons
		saveButton.setAction( saveAction );
		loadButton.setAction( loadAction );

		// Text for options buttons
		saveButton.setText( "Save Game" );
		loadButton.setText( "Load Game" );

		// Enable options buttons
		saveButton.setEnabled( true );
		loadButton.setEnabled( true );

		// Properties for bank field
		bankField.setFont( new Font( "Arial", Font.PLAIN, 50 ) );
		bankField.setEditable( false );
		bankField.setHorizontalAlignment( JTextField.CENTER );

		// Create string and set text for bank field
		formattedVal = String.format( "$ %,.2f", Framework.bank );
		bankField.setText( formattedVal );

		// 1080p in center of screen, exits program on close, sets frame visible
		frame.setSize( 1920, 1080 );
		frame.setLocationRelativeTo( null );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setVisible( true );
	}

	public void GUIupdate( ) {
		// Update text for bank value
		formattedVal = String.format( "$ %,.2f", Framework.bank );
		bankField.setText( formattedVal );
		bankField.repaint( );

		// Update text for field buttons
		wheatButton.setText( WheatField.text );

		if ( Framework.maxBank >= 150 )
			cornButton.setText( CornField.text );
		else
			cornButton.setText( "Corn Field" );

		// Enable/disable buttons based on bank
		if ( Framework.bank >= WheatField.price )
			wheatButton.setEnabled( true );
		else
			wheatButton.setEnabled( false );

		if ( Framework.bank >= CornField.price )
			cornButton.setEnabled( true );
		else
			cornButton.setEnabled( false );

		if ( Mill.level > 0 ) {
			millButton.setText( Mill.text );
			millButton.setToolTipText( "Upgrade your mill" );
		}

		if ( Framework.bank >= Mill.price )
			millButton.setEnabled( true );
		else
			millButton.setEnabled( false );

		addTabs( );
		invenUpdate( );
	}

	public static void addTabs( ) {
		if ( Framework.maxBank >= 1000 && !buildings ) {
			tabs.add( buildingPanel, "Buildings", 2 );
			buildings = true;
		}
	}

	public static void invenUpdate( ) {
		wheatText.setText( "Wheat: " + Framework.wheat);
		cornText.setText( "Corn: " + Framework.corn );
	}

}
