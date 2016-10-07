import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class Interface {
	// The main window and container (default BorderLayout)
	static JFrame frame = new JFrame("Farm Game");
	static Container mainPane = frame.getContentPane();

	// Text field and String for bank (NORTH)
	static JTextField bankField = new JTextField();
	static String formattedVal = "";

	// Text area for message box on a scroll pane, with caret for auto-scrolling
	// (EAST)
	static JTextArea messageBox = new JTextArea();
	static JScrollPane messageScroll = new JScrollPane(messageBox);
	static DefaultCaret caret = (DefaultCaret) messageBox.getCaret();

	// Tabbed Pane with panel for each tab, scroll pane for fields
	static JTabbedPane tabs = new JTabbedPane();
	static JPanel fieldPanel = new JPanel();
	static JPanel inventoryPanel = new JPanel();
	static JPanel optionsPanel = new JPanel();
	static JScrollPane fieldScroll = new JScrollPane(fieldPanel);

	// Buttons for crops
	static JButton wheatButton = new JButton("Wheat Field");
	static JButton cornButton = new JButton("Corn Field");

	// Option buttons
	static JButton saveButton = new JButton("Save");
	static JButton loadButton = new JButton("Load");

	// Actions for buttons
	static Action wheatAction = new WheatAction();
	static Action cornAction = new CornAction();
	static Action saveAction = new SaveAction();
	static Action loadAction = new LoadAction();

	public void GUIinit() {

		// border layout with tabbed pane in center, bank on top, and message
		// box on the right
		mainPane.add(messageScroll, BorderLayout.EAST);
		mainPane.add(tabs, BorderLayout.CENTER);
		mainPane.add(bankField, BorderLayout.NORTH);

		// Message box auto scrolling, font, non-editable
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		messageBox.setFont(new Font("Arial", Font.PLAIN, 28));
		messageBox.setEditable(false);

		// Note: Tabs can have icons
		// Add tabs to the pane and set their font
		tabs.setFont(new Font("Arial", Font.PLAIN, 30));
		tabs.addTab("Fields", fieldPanel);
		tabs.addTab("Inventory", inventoryPanel);
		tabs.addTab("Options", optionsPanel);

		// Layout, color, and add buttons to field panel
		fieldPanel.setLayout(new GridLayout(5, 0));
		fieldPanel.setBackground(new Color(0, 217, 0));
		fieldPanel.add(wheatButton);
		fieldPanel.add(cornButton);

		// Tool tips for field buttons
		wheatButton.setToolTipText("Buy a wheat field");
		cornButton.setToolTipText("Buy a corn field");

		// Font for field buttons
		wheatButton.setFont(new Font("Arial", Font.PLAIN, 60));
		cornButton.setFont(new Font("Arial", Font.PLAIN, 60));

		// Actions for field buttons
		wheatButton.setAction(wheatAction);
		cornButton.setAction(cornAction);

		// Text for field buttons
		wheatButton.setText(WheatField.text);
		if (Framework.maxBank >= 150)
			cornButton.setText(CornField.text);
		else
			cornButton.setText("Corn Field");

		// Enable or disable field buttons based on bank
		if (Framework.bank >= WheatField.price)
			wheatButton.setEnabled(true);
		else
			wheatButton.setEnabled(false);
		if (Framework.bank >= CornField.price)
			cornButton.setEnabled(true);
		else
			cornButton.setEnabled(false);

		// Layout, background, and buttons for options panel
		optionsPanel.setLayout(new GridLayout(3, 0));
		optionsPanel.setBackground(new Color(0, 0, 217));
		optionsPanel.add(saveButton);
		optionsPanel.add(loadButton);

		// Tool tips for options buttons
		saveButton.setToolTipText("Save your progress");
		loadButton.setToolTipText("Load your previous progress");

		// Font for options buttons
		saveButton.setFont(new Font("Arial", Font.PLAIN, 42));
		loadButton.setFont(new Font("Arial", Font.PLAIN, 42));

		// Actions for options buttons
		saveButton.setAction(saveAction);
		loadButton.setAction(loadAction);

		// Text for options buttons
		saveButton.setText("Save Game");
		loadButton.setText("Load Game");

		// Enable options buttons
		saveButton.setEnabled(true);
		loadButton.setEnabled(true);

		// Properties for bank field
		bankField.setFont(new Font("Arial", Font.PLAIN, 50));
		bankField.setEditable(false);
		bankField.setHorizontalAlignment(JTextField.CENTER);

		// Create string and set text for bank field
		formattedVal = String.format("$ %.2f", Framework.bank);
		bankField.setText(formattedVal);

		// 1080p in center of screen, exits program on close, sets frame visible
		frame.setSize(1920, 1080);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void GUIupdate() {
		// Update text for bank value
		formattedVal = String.format("$ %.2f", Framework.bank);
		bankField.setText(formattedVal);
		bankField.repaint();

		// Update text for field buttons
		wheatButton.setText(WheatField.text);

		if (Framework.maxBank >= 150)
			cornButton.setText(CornField.text);
		else
			cornButton.setText("Corn Field");

		// Enable/disable buttons based on bank
		if (Framework.bank >= WheatField.price)
			wheatButton.setEnabled(true);
		else
			wheatButton.setEnabled(false);

		if (Framework.bank >= CornField.price)
			cornButton.setEnabled(true);
		else
			cornButton.setEnabled(false);
	}

}
