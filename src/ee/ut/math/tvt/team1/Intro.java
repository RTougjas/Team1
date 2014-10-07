package ee.ut.math.tvt.team1;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.text.html.ImageView;

public class Intro {
	
	private String teamName;
	private String teamLeader;
	private String teamLeaderEmail;
	private String[] teamMembers = new String[4];
	private ImageView logo;
	private String versionNumber;
	
	public static String readProperty(File file, String key) {
		
		Properties properties = new Properties();
		InputStream input;
		String value = "";
		
		try {
			input = new FileInputStream(file);
			properties.load(input);
			value = properties.getProperty(key);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	public static void main(String[] args) {
		
		
		File appProp = new File("application.properties");
		File verProp = new File("version.properties");
		
		

	}

}
