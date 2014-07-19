package org.finra.jtaf.ewd.bootstrap;

import org.finra.jtaf.ewd.ExtWebDriver;
import org.finra.jtaf.ewd.bootstrap.BootstrapListGroup;
//import org.finra.jtaf.ewd.bootstrap.MyBootStrapButton;
import org.finra.jtaf.ewd.session.SessionManager;
import org.finra.jtaf.ewd.widget.IButton;
import org.finra.jtaf.ewd.widget.element.Element;
import org.finra.jtaf.ewd.widget.element.html.Button;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BootstrapListGroupTests {
    static ExtWebDriver ewd;

    @BeforeClass
    public static void before() throws Exception {
        ewd = SessionManager.getInstance().getNewSession("client","client.properties");
    }

    @AfterClass
    public static void after() throws Exception {
        ewd.close();
    }

    @Test
    public void testBootstrapListGroupGetItems() throws Exception {
        // Open ExtWebDriver home page
        ewd.open("http://marshyski.com/");

        BootstrapListGroup lg = new BootstrapListGroup("//*[@class=\"list-group\"][1]");
        lg.waitForElementPresent();

        List<String> actualItems = lg.getListItems();
        List<String> expectedItems = new ArrayList<String>();
        expectedItems.add("Blog");
        expectedItems.add("Marshy Ski");
        expectedItems.add("Man Behind The Keyboard");
        expectedItems.add("Downloadables");
        expectedItems.add("The Studio");
        expectedItems.add("Projects");

        int index = 0;
        for(String s : expectedItems) {
            Assert.assertEquals(s, actualItems.get(index));
            index++;
        }
    }

    @Test
    public void testBootstrapListGroupClick() throws Exception {
        // Open ExtWebDriver home page
        ewd.open("http://marshyski.com/");

        BootstrapListGroup lg = new BootstrapListGroup("//*[@class=\"list-group\"][1]");
        lg.waitForElementPresent();

        lg.clickItem("The Studio");

        boolean titleChanged = false;
        while(!titleChanged) {
            if(ewd.getTitle().equals("Marshy Ski")) {
                titleChanged = true;
            }
        }
    }
    
    @Test
    public void testGetActiveItem() throws Exception {
    	ewd.open("http://www.getbootstrap.com/components");
    	BootstrapListGroup group = new BootstrapListGroup("/html/body/div[2]/div/div[1]/div[18]/div[8]/div");
    	group.waitForElementPresent();
    	
    	Element active = group.getLinkedItem();
    	
    	Assert.assertEquals(active.getText(), "Cras justo odio");   	
    }
    
    @Test 
    public void getDisabledItem() throws Exception {
    	ewd.open("http://www.getbootstrap.com/components");
    	BootstrapListGroup group = new BootstrapListGroup("/html/body/div[2]/div/div[1]/div[18]/div[11]/div");
    	group.waitForElementPresent();
    	
    	Element active = group.getDisabledItem();
    	
    	Assert.assertEquals(active.getText(), "Cras justo odio");   	    
    }
}
