import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import java.io.*;
import java.util.*;

public class LoadAction implements Action {

	static Timer timer = new Timer();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Scanner reader = new Scanner(new File("saveGame.txt"));

			// Game variables will always have value
			Framework.bank = Double.parseDouble(reader.nextLine());
			Framework.maxBank = Double.parseDouble(reader.nextLine());
			Framework.autoSell = Boolean.parseBoolean(reader.nextLine());
			MarketPrice.modifier = Double.parseDouble(reader.nextLine());
			GrowTime.modifier = Double.parseDouble(reader.nextLine());

			// Crop variables may not have value
			if (reader.hasNextLine()) {
				WheatField.owned = Integer.parseInt(reader.nextLine());
				Framework.wheat = Integer.parseInt(reader.nextLine());
				WheatField.price = WheatField.updatePrice();
				WheatField.text = WheatField.updateText();

				int growTime = (int) (GrowTime.WHEAT * GrowTime.modifier);
				
				timer.scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						WheatField.grow();
					}
				}, growTime, growTime);
			}

			if (reader.hasNextLine()) {
				CornField.owned = Integer.parseInt(reader.nextLine());
				Framework.corn = Integer.parseInt(reader.nextLine());
				CornField.price = CornField.updatePrice();
				CornField.text = CornField.updateText();
				
				int growTime = (int) (GrowTime.CORN * GrowTime.modifier);
				
				timer.scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						CornField.grow();
					}
				}, growTime, growTime);
			}

			Framework.print("Game Loaded");
			Framework.loadedGame = true;
			Framework.update();

			reader.close();
		} catch (FileNotFoundException f) {
			Framework.print("No save data found.");
		}

	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub

	}

}
