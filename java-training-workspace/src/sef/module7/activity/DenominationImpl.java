package sef.module7.activity;

import java.awt.Component;

import javax.swing.JOptionPane;

import sef.module6.activity.Point2D;

/**
 * An implementation of the Denomination interface.  The equality test for between instances
 * of this class considers the name and the symbol
 * 
 * @author John Doe
 *
 */
public class DenominationImpl implements Denomination {

	
	private String description;
	private String name;
	private String symbol;

	/**
	 * Creates a new instance with the specified parameters
	 * 
	 * @param name the name of the denomination
	 * @param description a description 
	 * @param symbol
	 */
	public DenominationImpl(String name, String description, String symbol) {
		this.name = name; //USD or PHP
		this.description = description; //U.S. Dollar or Philippine Peso
		this.symbol = symbol; // $ or P
		
//		JOptionPane.showMessageDialog(null, symbol);
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Denomination#getDescription()
	 */
	public String getDescription() {
		return this.description;
	}
	
	/* (non-Javadoc)
	 * @see sef.module6.activity.Denomination#getName()
	 */
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Denomination#getSymbol()
	 */
	public String getSymbol() {
		return this.symbol;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if(o instanceof Denomination) {
			Denomination object = (Denomination)o;
			if(object.getName().equals(this.name) && object.getSymbol().equals(this.symbol)) {
				return true;
			}
			
		}
		return false;

	}

}
