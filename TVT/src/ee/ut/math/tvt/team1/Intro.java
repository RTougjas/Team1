package ee.ut.math.tvt.team1;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Intro {

	static Logger logger = Logger.getLogger(Intro.class);
	
	public static void main(String[] args) {
		
		IntroUI intro = new IntroUI("application.properties", "version.properties");
		
		BasicConfigurator.configure();

	    logger.info(Intro.class.getSimpleName() + " Window has opened");
		
		

	}

}
