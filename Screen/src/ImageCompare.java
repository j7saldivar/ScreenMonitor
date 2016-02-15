import java.awt.image.BufferedImage;

public class ImageCompare {

	// Compares pixels
	public static boolean compareImages(BufferedImage bufferedImageA,
			BufferedImage bufferedImageB) {

		if (bufferedImageA.getWidth() == bufferedImageB.getWidth()
				&& bufferedImageA.getHeight() == bufferedImageB.getHeight()) {
			int width = bufferedImageA.getWidth();
			int height = bufferedImageA.getHeight();

			// Loop over every pixel.
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					// Compare the pixels for equality.
					if (bufferedImageA.getRGB(x, y) != bufferedImageB.getRGB(x,
							y)) {
						return false;
					}
				}
			}
		} else {
			return false;
		}

		return true;
	}

}
