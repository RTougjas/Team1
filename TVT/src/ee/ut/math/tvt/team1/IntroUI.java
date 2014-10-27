package ee.ut.math.tvt.team1;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IntroUI extends JFrame{
	
	private String teamName;
	private String teamLeader;
	private String teamLeaderEmail;
	private String[] teamMembers = new String[4];
	private int majorNumber;
	private int minorNumber;
	private int revisionNumber;
	private String version;
	
	public IntroUI(String appProperties, String versionProperties) {
		super();

		Properties appProp = loadProperties(appProperties);
		Properties verProp = loadProperties(versionProperties);
		
		this.teamName = appProp.getProperty("teamName", null);
		this.teamLeader = appProp.getProperty("teamLeader", null);
		this.teamLeaderEmail = appProp.getProperty("teamLeaderEmail", null);
		this.teamMembers = appProp.getProperty("teamMembers", null).split(",");
		
		this.majorNumber = Integer.parseInt(verProp.getProperty("build.major.number", "0"));
		this.minorNumber = Integer.parseInt(verProp.getProperty("build.minor.number", "0"));
		this.revisionNumber = Integer.parseInt(verProp.getProperty("build.revision.number", "0"));
		
		this.version = majorNumber + "." + minorNumber + "." + revisionNumber;
		
		displayWindow();
	}

	public int getMajorNumber() {
		return majorNumber;
	}

	public int getMinorNumber() {
		return minorNumber;
	}

	public int getRevisionNumber() {
		return revisionNumber;
	}

	public String getVersion() {
		return version;
	}

	public String getTeamName() {
		return teamName;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public String getTeamLeaderEmail() {
		return teamLeaderEmail;
	}

	public String[] getTeamMembers() {
		return teamMembers;
	}

	public Properties loadProperties(String fileName) {
		
		Properties properties = new Properties();
		InputStream input = null;
		
		try {
			input = new FileInputStream(fileName);
			
			properties.load(input);
			
			input.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;	
		
	}
	
	public void displayWindow() {
		
		JFrame frame = new JFrame("Team introduction");
		JPanel panel = new JPanel();
	    GroupLayout layout = new GroupLayout(panel);
	    panel.setLayout(layout);
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//Paneb v22rtused yhte labelisse yksteise alla.
		JLabel jlbempty = new JLabel(
				"<html>Team name: " + teamName +
				"<br>Team leader: " + teamLeader + 
				"<br>Team leader email: "+ teamLeaderEmail +
				"<br>Team members: " + teamMembers[0] + " " + teamMembers[1] + " " +  teamMembers[2] + " " +  teamMembers[3] +
				"<br>Version: " + version +
				"</html>");
		
		frame.getContentPane().add(jlbempty, BorderLayout.PAGE_START);
		frame.add(new JLabel(new ImageIcon("logo.png")));
		frame.pack();
		frame.setVisible(true);
	}

}
