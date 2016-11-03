import java.awt.event.ActionEvent;
import java.util.Timer;
import java.beans.PropertyChangeListener;
import java.util.TimerTask;
import javax.swing.Action;

public class CornAction implements Action {

	static Timer timer = new Timer( );

	@Override
	public void actionPerformed( ActionEvent arg0 ) {
		// increments fields owned and deducts price from bank
		CornField.purchased( );

		// Calculates the grow time based on the modifier
		int growTime = (int) ( GrowTime.CORN * GrowTime.modifier );

		if ( CornField.owned == 1 ) {
			Framework.print( "Corn grows every 5 seconds and sells for $13.00" );
			// schedule the task according to the grow time
			timer.scheduleAtFixedRate( new TimerTask( ) {
				@Override
				public void run( ) {
					CornField.grow( );
				}

			}, growTime, growTime );
		}
	}

	@Override
	public void addPropertyChangeListener( PropertyChangeListener arg0 ) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getValue( String arg0 ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled( ) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void putValue( String arg0, Object arg1 ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePropertyChangeListener( PropertyChangeListener arg0 ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled( boolean arg0 ) {
		// TODO Auto-generated method stub

	}

}
