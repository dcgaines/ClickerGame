import java.awt.event.ActionEvent;
import java.util.Timer;
import java.beans.PropertyChangeListener;
import java.util.TimerTask;
import javax.swing.Action;

public class WheatAction implements Action {

	static Timer timer = new Timer();
	
	//Calculates initial grow time, including modifier
	int growTime = (int) (GrowTime.WHEAT * GrowTime.modifier);

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//increments field count, deducts cost from bank
		WheatField.purchased();
		
		//only executes the first time a field is purchased
		if (WheatField.owned == 1) {
			Framework.print("Wheat is produced at 1 per second\nand is sold for $1.00");
			
			//Grows wheat every second
			timer.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					//Adds to inventory every time it executes
					WheatField.grow();
				}
			}, growTime, growTime);
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
