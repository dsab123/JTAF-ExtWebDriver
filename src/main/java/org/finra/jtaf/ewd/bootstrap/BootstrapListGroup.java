package org.finra.jtaf.ewd.bootstrap;

import org.finra.jtaf.ewd.widget.WidgetException;
import org.finra.jtaf.ewd.widget.element.Element;
import org.finra.jtaf.ewd.widget.element.InteractiveElement;

import java.util.ArrayList;
import java.util.List;

public class BootstrapListGroup extends Element {
    public BootstrapListGroup(String locator) {
        super(locator);
    }

    /** 
     * Returns a list of all the elements in the ListGroup
     * */
    public List<String> getListItems() throws WidgetException {
        List<String> items = new ArrayList<String>();

        boolean done = false;
        int index = 1;
        while(!done) {
            Element e = new Element(getLocator() + "/*[contains(@class,\"list-group-item\")][" + index + "]");
            if(e.isElementNotPresent()) {
                done = true;
            }else {
                items.add(e.getText());
            }

            index++;
        }

        return items;
    }

    /** 
     * clicks the item with the specified text
     */
    public void clickItem(String itemText) throws WidgetException {
        InteractiveElement e = new InteractiveElement(getLocator() + "/*[contains(@class,\"list-group-item\") and text()='" + itemText + "']");
        e.waitForElementPresent();
        
        
        e.click();
    }
    
    /** 
     * Returns the first disabled item
     * */
    public Element getDisabledItem() throws WidgetException {
    	boolean done = false;
        int index = 1;
        while(!done) {
            Element e = new Element(getLocator() + "/*[contains(@class,\"list-group-item\")][" + index + "]");
            if (e.getAttribute("class").contains("disabled")) {
            	return e;
            }

            index++;
        }
        return null;
    }
    
    
    /**
     * Returns a list of all the disabled items
     * */
    public List<Element> getDisabledItems() throws WidgetException {
     	boolean done = false;
        int index = 1;

        List<Element> disabledList = new ArrayList<Element>();
        
        while(!done) {
            Element e = new Element(getLocator() + "/*[contains(@class,\"list-group-item\")][" + index + "]");
            if (e.getAttribute("class").contains("disabled")) {
            	disabledList.add(e);
            }
            
            index++;
        }
    
        return disabledList;
    }
    
    /** 
     * Returns a list of all the 'linked' items, that is, the items that are 
     * linked to other things
     * */
    public List<Element> getLinkedItems() throws WidgetException {
     	boolean done = false;
        int index = 1;

        List<Element> disabledList = new ArrayList<Element>();
        
        while(!done) {
            Element e = new Element(getLocator() + "/*[contains(@class,\"list-group-item\")][" + index + "]");
            if (e.getAttribute("class").contains("active")) {
            	disabledList.add(e);
            }
            
            index++;
        }
    
        return disabledList;
    }
    
    /** 
     * Returns the first 'linked' item, that is, the first item that is linked 
     * to something else
     * */
    public Element getLinkedItem() throws WidgetException {
     	boolean done = false;
        int index = 1;

        List<Element> disabledList = new ArrayList<Element>();
        
        while(!done) {
            Element e = new Element(getLocator() + "/*[contains(@class,\"list-group-item\")][" + index + "]");
            if (e.getAttribute("class").contains("active")) {
            	return e;
            }
            
            index++;
        }
        
		return null;
    }
}
