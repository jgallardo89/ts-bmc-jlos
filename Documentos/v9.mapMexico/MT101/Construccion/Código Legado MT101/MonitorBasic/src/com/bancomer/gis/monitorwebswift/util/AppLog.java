package com.bancomer.gis.monitorwebswift.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author MFragoso
 *
 */
public class AppLog {
	  static{
		  PropertyConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource("com/bancomer/gis/monitorwebswift/resources/Log4j.properties"));
	  }
	  public static Logger getLog(String _logger){
		  return Logger.getLogger(_logger);
	  }

}
