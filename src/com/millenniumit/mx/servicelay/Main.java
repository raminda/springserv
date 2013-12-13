/**
 * 
 */
package com.millenniumit.mx.servicelay;

import java.net.URL;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;

import com.millenniumit.mx.data.nethdsizing.service.ItemTypesService;
import com.millenniumit.spring.consoleutil.ApplicationContextLoader;

/**
 * 
 * Logs issue data from issue management systems
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
public class Main {


	@Autowired
	ItemTypesService itemTypesService;
	/**
	 * Spring application context loader
	 */
	private static ApplicationContextLoader contextLoader = new ApplicationContextLoader();
	
	/**
	 * Logger for the main class
	 */
	static final Logger logger = Logger.getLogger(Main.class);

	@Autowired
	TestClass tc;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// initialize logging
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("log4j.properties");
		PropertyConfigurator.configure(url);	
		
		logger.info("*******************Application Start********************");
		
		// Initialize the Spring application main
		Main main = new Main();
		
		// comment this when testing
		contextLoader.load(main, "applicationContext.xml");
		
		main.tc.TestSourceTickets();

	}
}
