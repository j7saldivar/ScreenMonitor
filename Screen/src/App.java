import java.awt.AWTException;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;


public class App {

	public static void main(String[] args) {
		
		try {
			
			Monitor.monitorScreen();
			Alarm.loopAlarm();
			
		} catch (AWTException | InterruptedException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
