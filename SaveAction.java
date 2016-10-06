import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import java.io.*;

public class SaveAction implements Action {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Write to a file pertinent information, encrypt it later
		File save = new File("saveGame.txt");
		try {
			if(Framework.savedGame || Framework.loadedGame){
				save.delete();
			}
			
			PrintWriter writer = new PrintWriter(save);
			// Game variables will always have value
			writer.println(Framework.bank);
			writer.println(Framework.maxBank);
			writer.println(Framework.autoSell);
			writer.println(MarketPrice.modifier);
			writer.println(GrowTime.modifier);

			// Crop variables may not have value
			if (WheatField.owned != 0) {
				writer.println(WheatField.owned);
				writer.println(Framework.wheat);
			}

			if (CornField.owned != 0) {
				writer.println(CornField.owned);
				writer.println(Framework.corn);
			}

			writer.close();
			save.setReadOnly();
			
			Framework.print("Game saved");
			Framework.savedGame = true;
			
		} catch (FileNotFoundException e) {
			Framework.print("Error saving");
		}

	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void putValue(String arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled(boolean arg0) {
		// TODO Auto-generated method stub

	}

}
