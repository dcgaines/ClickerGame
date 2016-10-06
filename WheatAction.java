import java.awt.event.ActionEvent;
import java.util.Timer;
import java.beans.PropertyChangeListener;
import java.util.TimerTask;
import javax.swing.Action;

public class WheatAction implements Action {

	static Timer timer = new Timer();

	@Override
	public void actionPerformed(ActionEvent arg0) {
		WheatField.purchased();
		
		int growTime = (int) (GrowTime.WHEAT * GrowTime.modifier);

		if (WheatField.owned == 1) {
			Framework.print("Wheat is produced at 1 per second\nand is sold for $1.00");
			timer.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
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
