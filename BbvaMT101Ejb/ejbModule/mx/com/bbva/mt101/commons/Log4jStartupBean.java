package mx.com.bbva.mt101.commons;

import java.net.URL;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4jStartupBean {
	private static final String LOG4J_XML = "/META-INF/log4j.xml";
	private Logger logger = null;

	@PostConstruct
	public void startup() {
		URL url = getClass().getResource(LOG4J_XML);
		if ((url == null) || (url.getFile().length() == 0)) {
			throw new RuntimeException(
					"Log4j config file /META-INF/log4j.xml not found");
		}
		DOMConfigurator.configure(url.getFile());
		this.logger = Logger.getLogger(getClass());
		this.logger.info("logger initialized with /META-INF/log4j.xml...");
	}
}
