package poe.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Application {
	// nom de la classe qui log
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	 public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);

	        logger.info("info from log");
	        logger.debug("debug from log");
	        logger.error("error from log");
	        logger.warn("warn from log");
	        logger.trace("trace from log");
	    }
}
