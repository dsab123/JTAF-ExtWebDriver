package org.finra.jtaf.ewd.bootstrap;

import org.junit.*;

import org.finra.jtaf.ewd.ExtWebDriver;
import org.finra.jtaf.ewd.properties.GUIProperties;
import org.finra.jtaf.ewd.session.SessionManager;
import org.finra.jtaf.ewd.widget.IButton;
import org.finra.jtaf.ewd.widget.element.Element;
import org.finra.jtaf.ewd.widget.element.html.Button;
import org.finra.jtaf.ewd.widget.element.html.Input;

public class BootstrapNavTests {
	ExtWebDriver driver;
	
	@Before
	public void setup() throws Exception {
		driver = SessionManager.getInstance().getNewSession("client", "properties.properties");		
	}
	
	@Test
	public void testSimpleSite() throws Exception {
		driver.open("http://anvoz.github.io/bootstrap-tldr/");
		
		BootstrapNav nav = new BootstrapNav("/html/body/div[2]/div/div[1]/div[28]/div[1]/div[1]/ul");
		
		
		
	}

	@After
	public void teardown() {
		driver.close();
	}
	
	
    
}
