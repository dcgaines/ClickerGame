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
			Framework.print( "The mill converts 2 wheat to 1 flour every 4 seconds, "
					+ "and 1 corn to 1 corn meal every 7 seconds." );
			Framework.print( "Flour sells for $5.00 and corn meal sells for $41.00" );
			Framework.print( "Note that the mill will not run if there are insufficient crops!" );
		}
	}

	public static void millOnF( ) {
		int productionTimeF = (int) ( ProductionTime.FLOUR * ProductionTime.modifier );

		timer.scheduleAtFixedRate( new TimerTask( ) {
			@Override
			public void run( ) {
				Mill.flourOperate( );
			}

		}, productionTimeF, productionTimeF );

	}

	public static void millOnC( ) {
		int productionTimeC = (int) ( ProductionTime.CORN_MEAL * ProductionTime.modifier );

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
