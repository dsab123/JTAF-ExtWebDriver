package org.finra.jtaf.ewd.bootstrap;

import java.util.ArrayList;
import org.finra.jtaf.ewd.ExtWebDriver;
import org.finra.jtaf.ewd.properties.GUIProperties;
import org.finra.jtaf.ewd.session.SessionManager;
import org.finra.jtaf.ewd.widget.WidgetException;
import org.finra.jtaf.ewd.widget.WidgetRuntimeException;
import org.finra.jtaf.ewd.widget.element.Element;
import org.finra.jtaf.ewd.widget.element.html.CheckBox;
import org.finra.jtaf.ewd.widget.element.html.Input;
import org.finra.jtaf.ewd.bootstrap.*;

public class BootstrapInputGroup extends Element {
		
	/**
	 * 
	 */
	public BootstrapInputGroup(String locatorIn) {
		super(locatorIn);
	}

	/** returns a list of all the addon elements in this InputGroup
	 * 	If they can be downcasted to a more descriptive type, they will be
	 */
	public ArrayList<Element> getAddonElements() throws WidgetException {
		boolean done = false;
		int index = 1;
		ArrayList<Element> list = new ArrayList<Element>();
		
		while(!done) {
			System.out.println("index: " + index);
			
			Element currSpan = new Element(getLocator() + "/span[" + index + "]");
			Element currAddon = new Element(currSpan.getLocator() + 
					"/*[contains(@class,\"input-group-addon\"");
	        
			
			// if the addon is a radio or checkbox, we cast it to that type
			if (currAddon.getAttribute("type").equals("checkbox")) {
				currAddon = (CheckBox) currAddon;
			} else if (currAddon.getAttribute("type").equals("radio")) {
				
				// not implemented yet
				//currAddon = (RadioGroup) currAddon;
			}
			
			if (currSpan.isElementNotPresent()) {
				done = true;
			} else {
				list.add(currAddon);
			}
			
			index++;
		}
		
		return list;
	}
	
	/** 
	 * Returns the input field of this InputGroup
	 * */
	public Input getInput() {
		Input input = new Input(getLocator() + "//input");
		return input;
	}
	
}
