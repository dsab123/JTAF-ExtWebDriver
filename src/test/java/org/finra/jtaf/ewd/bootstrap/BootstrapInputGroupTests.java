package org.finra.jtaf.ewd.bootstrap;

import org.junit.*;

import org.finra.jtaf.ewd.bootstrap.*;
import java.util.ArrayList;

import org.finra.jtaf.ewd.ExtWebDriver;
import org.finra.jtaf.ewd.properties.GUIProperties;
import org.finra.jtaf.ewd.session.SessionManager;
import org.finra.jtaf.ewd.widget.IButton;
import org.finra.jtaf.ewd.widget.element.Element;
import org.finra.jtaf.ewd.widget.element.html.Button;
import org.finra.jtaf.ewd.widget.element.html.Input;

public class BootstrapInputGroupTests {
	static ExtWebDriver driver;
	
	@BeforeClass
	public static void setup() throws Exception {
		driver = SessionManager.getInstance().getNewSession("client", "properties.properties");		
	}
	
	@Test
	public void testInput() throws Exception {
		driver.open("http://anvoz.github.io/bootstrap-tldr/");
		
		BootstrapInputGroup group = new BootstrapInputGroup("/html/body/div[2]/div/div[1]/div[25]/div[1]/div");		
		
		Input input = group.getInput();
		input.sendKeys("hello");

		group = new BootstrapInputGroup("/html/body/div[2]/div/div[1]/div[25]/div[1]/div");
		input = group.getInput();
		
		Assert.assertEquals(input.getText(), "hello");
	}

	@AfterClass
	public static void teardown() {
		driver.close();
	}
	
	@Test
	public void testListGroup() throws Exception {
		driver.open("http://getbootstrap.com/components/");
		
		BootstrapListGroup group = new BootstrapListGroup("/html/body/div[2]/div/div[1]/div[18]/div[11]/div");		
		
		//Element active = group.getLinkedItem();
	}
	
	
    
}
