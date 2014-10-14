package ee.ut.math.tvt.team1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class IntroUI {
	public void intro() throws Exception {
		
		
		// Sisselugemine
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader("application.properties"));
		String line = null;
		ArrayList values = new ArrayList();
		while ((line = reader.readLine()) != null) {
			String[] pieces = line.split("=");
			values.add(pieces[1]);
		}
		BufferedReader reader2 = null;
		reader2 = new BufferedReader(new FileReader("version.properties"));
		String line2 = null;
		String version = null;
		while ((line2 = reader2.readLine()) != null) {
			if (line2.contains("build.number")){
				version = line2.split("=")[1];
			}
		}
		// UI
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
		JLabel jlbempty = new JLabel("<html>Team name: "+values.get(0)+"<br>Team leader: "+values.get(1)+"<br>Team leader email: "+values.get(2)+"<br>Team members: "+values.get(3)+"<br>Version: "+version+"</html>");
		
		frame.getContentPane().add(jlbempty, BorderLayout.PAGE_START);
		frame.add(new JLabel(new ImageIcon("logo.png")));
		frame.pack();
		frame.setVisible(true);
		
		reader.close();
	}
}

