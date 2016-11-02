import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import java.util.Timer;
import java.util.TimerTask;

public class MillAction implements Action {

	public static Timer timer = new Timer( );

	@Override
	public void actionPerformed( ActionEvent arg0 ) {

		Mill.upgraded( );
		if ( Mill.level == 0 ) {
			millOn( );
			Framework.autoSell = false;
		}
	}

	public static void millOn( ) {
		int productionTimeF = (int) ( ProductionTime.FLOUR * ProductionTime.modifier );
		int productionTimeC = (int) ( ProductionTime.CORN_MEAL * ProductionTime.modifier );

		timer.scheduleAtFixedRate( new TimerTask( ) {
			@Override
			public void run( ) {
				Mill.flourOperate( );
			}

		}, productionTimeF, productionTimeF );

		timer.scheduleAtFixedRate( new TimerTask( ) {
			@Override
			public void run( ) {
				Mill.cornMealOperate( );
			}

		}, productionTimeC, productionTimeC );
	}

	public static void millOff( ) {
		timer.cancel( );
		timer = new Timer( );
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
