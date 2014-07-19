package org.finra.jtaf.ewd.bootstrap;

import org.finra.jtaf.ewd.widget.element.Element;

public class BootstrapAddon {
	private type thisType;
	
	private enum type {
		BUTTON, CHECKBOX
	}

	public BootstrapAddon(type typeIn) {
		thisType = typeIn;
	}
	
}


