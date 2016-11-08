import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

public class SellAction implements Action {

	@Override
	public void actionPerformed( ActionEvent arg0 ) {
		double income;

		income = Framework.wheat * MarketPrice.WHEAT * MarketPrice.modifier;
		if ( income != 0 ) {
			Framework.print( String.format( "%d wheat sold for $%.2f", Framework.wheat, income ) );
			Framework.bank += income;
			Framework.wheat = 0;
		}

		income = Framework.corn * MarketPrice.CORN * MarketPrice.modifier;
		if ( income != 0 ) {
			Framework.print( String.format( "%d corn sold for $%.2f", Framework.corn, income ) );
			Framework.bank += income;
			Framework.corn = 0;
		}
		
		income = Framework.flour * MarketPrice.FLOUR * MarketPrice.modifier;
		if ( income != 0 ) {
			Framework.print( String.format( "%d flour sold for $%.2f", Framework.flour, income ) );
			Framework.bank += income;
			Framework.flour = 0;
		}
		
		income = Framework.cornMeal * MarketPrice.CORN_MEAL * MarketPrice.modifier;
		if ( income != 0 ) {
			Framework.print( String.format( "%d corn meal sold for $%.2f", Framework.cornMeal, income ) );
			Framework.bank += income;
			Framework.cornMeal = 0;
		}
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
