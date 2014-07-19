package org.finra.jtaf.ewd.bootstrap;

import org.finra.jtaf.ewd.widget.WidgetException;
import org.finra.jtaf.ewd.widget.element.Element;

/**
 * Created with IntelliJ IDEA.
 * User: marcinot
 * Date: 7/19/14
 * Time: 2:20 PM
 * To change this template use File | Settings | File Templates.
 */

public class PageHeader extends Element {
    public PageHeader(String locator) {
        super(locator);
    }

    public String getHeader(String type) throws WidgetException {
        return new Element(getLocator() + "//" + type).getText();
    }

    public String testMethod() {
        return "hello";
    }
}