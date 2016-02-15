import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Monitor {

	public static void monitorScreen() throws AWTException,
			InterruptedException, IOException {

		UserInterface userInterface = new UserInterface();
		userInterface.setTextField("Starting");

		Robot robot = new Robot();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int areaWidth = (int) (screenSize.getWidth() / 2.3);
		int areaHeight = (int) (screenSize.getHeight() / 1.6);
		int x = 0, y = 0;

		Rectangle area = new Rectangle(x, y, areaWidth, areaHeight);

		Thread.sleep(3000);
		BufferedImage beforeImage = robot.createScreenCapture(area);
		BufferedImage afterImage = null;

		ImageIO.write(beforeImage, "bmp", new File("before.bmp"));

		int compareFiveTimes = 0;
		boolean alert = false;

		while (!alert) {

			robot.mouseMove((int) ((Math.random() * 10) + (areaWidth + 200)),
					(int) (Math.random() * 10) + 100);

			Thread.sleep(5000);
			
			afterImage = robot.createScreenCapture(area);

			if (ImageCompare.compareImages(beforeImage, afterImage)) {
				userInterface.setTextField("Nothing has changed");
				//System.out.println("Nothing has changed");
				compareFiveTimes = 0;
			} else {
				userInterface.setTextField("Something might have changed. "
						+ ++compareFiveTimes + " /5 spot checks");
				//System.out.println("Something might have changed. "
					//	+ compareFiveTimes + " /5 spot checks");
				if (compareFiveTimes >= 5) {
					userInterface.setTextField("Something changed");
					//System.out.println("Something changed");
					alert = true;
				}
			}

		}

		ImageIO.write(afterImage, "bmp", new File("after.bmp"));


	}

}
