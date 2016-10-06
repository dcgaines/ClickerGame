import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class Interface {
	// TODO: organize these declarations logically
	static Button exit = new Button("Exit");
	static JFrame frame = new JFrame("Farm Game");
	static JPanel fieldPanel = new JPanel();
	static JPanel inventoryPanel = new JPanel();
	static JPanel optionsPanel = new JPanel();
	static JTextArea messageBox = new JTextArea();
	static DefaultCaret caret = (DefaultCaret) messageBox.getCaret();
	static JScrollPane messageScroll = new JScrollPane(messageBox);
	static JScrollPane fieldScroll = new JScrollPane(fieldPanel);
	static Container mainPane = frame.getContentPane();
	static JTabbedPane tabs = new JTabbedPane();
	static JTextField bankField = new JTextField();
	static String formattedVal = "";

	static JButton wheatButton = new JButton("Wheat Field");
	static JButton cornButton = new JButton("Corn Field");
	static JButton saveButton = new JButton("Save");
	static JButton loadButton = new JButton("Load");

	static Action wheatAction = new WheatAction();
	static Action cornAction = new CornAction();
	static Action saveAction = new SaveAction();
	static Action loadAction = new LoadAction();

	public void GUIinit() {
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		messageBox.setFont(new Font("Arial", Font.PLAIN, 28));
		messageBox.setEditable(false);

		fieldPanel.setLayout(new GridLayout(5, 0));

		saveButton.setFont(new Font("Arial", Font.PLAIN, 42));
		loadButton.setFont(new Font("Arial", Font.PLAIN, 42));

		// Note: Tabs can have icons
		tabs.addTab("Fields", fieldPanel);
		tabs.addTab("Inventory", inventoryPanel);
		tabs.addTab("Options", optionsPanel);

		wheatButton.setToolTipText("Buy a wheat field");
		cornButton.setToolTipText("Buy a corn field");

		wheatButton.setAction(wheatAction);
		cornButton.setAction(cornAction);

		saveButton.setAction(saveAction);
		loadButton.setAction(loadAction);

		if (Framework.bank >= WheatField.price)
			wheatButton.setEnabled(true);
		else
			wheatButton.setEnabled(false);

		if (Framework.bank >= CornField.price)
			cornButton.setEnabled(true);
		else
			cornButton.setEnabled(false);

		fieldPanel.add(bankField);
		fieldPanel.add(wheatButton);
		fieldPanel.add(cornButton);

		optionsPanel.setLayout(new GridLayout(3, 0));
		optionsPanel.setBackground(new Color(0, 0, 217));
		optionsPanel.add(saveButton);
		optionsPanel.add(loadButton);

		saveButton.setText("Save Game");
		loadButton.setText("Load Game");

		saveButton.setEnabled(true);
		loadButton.setEnabled(true);

		wheatButton.setText(WheatField.text);
		if (Framework.maxBank >= 150)
			cornButton.setText(CornField.text);
		else
			cornButton.setText("Corn Field");

		wheatButton.setFont(new Font("Arial", Font.PLAIN, 60));
		cornButton.setFont(new Font("Arial", Font.PLAIN, 60));

		bankField.setEditable(false);
		bankField.setHorizontalAlignment(JTextField.CENTER);
		formattedVal = String.format("$ %.2f", Framework.bank);
		bankField.setText(formattedVal);
		bankField.setFont(new Font("Arial", Font.PLAIN, 50));

		// sets a 2 column layout with a tabbed pane on the left and a scrolling
		// message box on the right
		mainPane.add(tabs, BorderLayout.CENTER);
		tabs.setFont(new Font("Arial", Font.PLAIN, 30));
		fieldPanel.setBackground(new Color(0, 217, 0));
		mainPane.add(messageScroll, BorderLayout.EAST);
		mainPane.add(bankField, BorderLayout.NORTH);

		// 1080p in center of screen, exits program on close
		frame.setSize(1920, 1080);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void GUIupdate() {
		//Update text for bank value
		formattedVal = String.format("$ %.2f", Framework.bank);
		bankField.setText(formattedVal);
		bankField.repaint();

		//Update text for field buttons
		wheatButton.setText(WheatField.text);
		
		if (Framework.maxBank >= 150)
			cornButton.setText(CornField.text);
		else
			cornButton.setText("Corn Field");
		
		
		//Enable/disable buttons based on bank
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
