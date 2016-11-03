import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import java.io.*;
import java.util.*;

public class LoadAction implements Action {

	static Timer timer = new Timer( );

	@Override
	public void actionPerformed( ActionEvent e ) {
		try {
			Scanner reader = new Scanner( new File( "saveGame.txt" ) );

			// Game variables will always have value
			Framework.bank = Double.parseDouble( reader.nextLine( ) );
			Framework.maxBank = Double.parseDouble( reader.nextLine( ) );
			MarketPrice.modifier = Double.parseDouble( reader.nextLine( ) );
			GrowTime.modifier = Double.parseDouble( reader.nextLine( ) );

			// Crop variables may not have value
			if ( reader.hasNextLine( ) ) {
				if ( reader.findWithinHorizon( "wheat", 99999 ) != null ) {
					// reads in all wheat variables
					reader.nextLine( );
					WheatField.owned = Integer.parseInt( reader.nextLine( ) );
					Framework.wheat = Integer.parseInt( reader.nextLine( ) );
					WheatField.price = WheatField.updatePrice( );
					WheatField.text = WheatField.updateText( );

					// Cancels previously scheduled grows
					WheatAction.timer.cancel( );

					// Determines grow time
					int growTime = (int) ( GrowTime.WHEAT * GrowTime.modifier );

					// Reschedules grows according to the loaded file
					timer.scheduleAtFixedRate( new TimerTask( ) {
						@Override
						public void run( ) {
							WheatField.grow( );
						}
					}, growTime, growTime );
				}
			}

			if ( reader.hasNextLine( ) ) {
				if ( reader.findWithinHorizon( "corn", 99999 ) != null ) {
					// reads in all corn variables
					reader.nextLine( );
					CornField.owned = Integer.parseInt( reader.nextLine( ) );
					Framework.corn = Integer.parseInt( reader.nextLine( ) );
					CornField.updatePrice( );
					CornField.updateText( );

					// Cancels previously scheduled grows
					CornAction.timer.cancel( );

					// Determines grow time
					int growTime = (int) ( GrowTime.CORN * GrowTime.modifier );

					// Reschedules according to the loaded file
					timer.scheduleAtFixedRate( new TimerTask( ) {
						@Override
						public void run( ) {
							CornField.grow( );
						}
					}, growTime, growTime );
				}
			}

			// Prints loaded, disables the load button, and updates the GUI
			Framework.print( "Game loaded" );
			Framework.loadedGame = true;
			Interface.loadButton.setEnabled( false );
			Framework.update( );

			// closes reader
			reader.close( );
		} catch ( FileNotFoundException f ) {
			// If there is no save file
			Framework.print( "No save data found." );
		}

	}

	@Override
	public void addPropertyChangeListener( PropertyChangeListener listener ) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getValue( String key ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled( ) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void putValue( String key, Object value ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePropertyChangeListener( PropertyChangeListener listener ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled( boolean b ) {
		// TODO Auto-generated method stub

	}

}
