import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

public class SellAction implements Action {

	@Override
	public void actionPerformed( ActionEvent arg0 ) {
		Framework.bank += Framework.wheat * MarketPrice.WHEAT * MarketPrice.modifier;
		Framework.wheat = 0;

		Framework.bank += Framework.corn * MarketPrice.CORN * MarketPrice.modifier;
		Framework.corn = 0;

		Framework.bank += Framework.flour * MarketPrice.FLOUR * MarketPrice.modifier;
		Framework.flour = 0;

		Framework.bank += Framework.cornMeal * MarketPrice.CORN_MEAL * MarketPrice.modifier;
		Framework.cornMeal = 0;

		MillAction.millOff( );
		Framework.millF = false;
		Framework.millC = false;

		Framework.update( );
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
