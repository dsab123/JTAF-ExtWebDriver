package org.finra.jtaf.ewd.bootstrap;

import org.finra.jtaf.ewd.widget.WidgetException;
import org.finra.jtaf.ewd.widget.element.Element;

public class PageHeader extends Element {
    public PageHeader(String locator) {
        super(locator);
    }

    /**
    Get page header string info http://getbootstrap.com/components/#page-header
    */
    public String getHeader(String type) throws WidgetException {
        return new Element(getLocator() + "//" + type).getText();
    }
}