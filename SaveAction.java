import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.JOptionPane;

import java.io.*;

public class SaveAction implements Action {

	@Override
	public void actionPerformed( ActionEvent arg0 ) {
		// TODO Write to a file pertinent information, encrypt it later
		File save = new File( "saveGame.txt" );
		try {
			// If save file already exists, deletes it so it can be overridden
			// This is necessary to make the file read-only for
			// tamper-resistance
			if ( save.exists( ) ) {
				// Confirm if overwrite save
				if ( JOptionPane.showConfirmDialog( null, "This will overwrite your save file.  Continue?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE ) == 0 ) {
					save.delete( );

					// Creates a new PrintWriter for the save file
					PrintWriter writer = new PrintWriter( save );

					// Game variables will always have value
					writer.println( Framework.bank );
					writer.println( Framework.maxBank );
					writer.println( MarketPrice.modifier );
					writer.println( GrowTime.modifier );

					// Crop variables may not have value
					if ( WheatField.owned != 0 ) {
						writer.println( "wheat" );
						writer.println( WheatField.owned );
						writer.println( WheatField.price );
						writer.println( Framework.wheat );
					}

					if ( CornField.owned != 0 ) {
						writer.println( "corn" );
						writer.println( CornField.owned );
						writer.println( CornField.price );
						writer.println( Framework.corn );
					}

					// Building variables may not have value
					if ( Mill.level != 0 ) {
						writer.println( "mill" );
						writer.println( Mill.level );
						writer.println( Mill.price );
						writer.println( Framework.flour );
						writer.println( Framework.cornMeal );
					}

					writer.close( );
					save.setReadOnly( );

					Framework.print( "Game saved" );
					Framework.savedGame = true;

				} else {
					// If save is canceled
					Framework.print( "Save Canceled" );
				}
			}

		} catch ( FileNotFoundException e ) {
			Framework.print( "Error saving" );
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
