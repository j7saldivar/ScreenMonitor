import javax.sound.sampled.*;

public class Alarm {

	public static float SAMPLE_RATE = 1150f;

	public static void alarm(int repeat) throws LineUnavailableException,
			InterruptedException {
		AudioFormat af = new AudioFormat(SAMPLE_RATE, // sampleRate
				8, // sampleSizeInBits
				1, // channels
				true, // signed
				false); // bigEndian
		SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
		sdl.open(af);
		sdl.start();

		byte[] buf = new byte[1];
		int step;

		for (int j = 0; j < repeat; j++) {
			step = 10;
			for (int i = 0; i < 2000; i++) {
				buf[0] = ((i % step > 0) ? 32 : (byte) 0);

				if (i % 250 == 0)
					step += 2;
				sdl.write(buf, 0, 1);
			}
			Thread.sleep(200);
		}
		sdl.drain();
		sdl.stop();
		sdl.close();
	}

	public static void loopAlarm() throws InterruptedException,
			LineUnavailableException {
		
		int count = 0;
		boolean volume = true;

		while (++count < 1000) {

			Alarm.alarm(5);

			if (volume) {
				Alarm.SAMPLE_RATE += 50;
				volume = false;
			} else {
				Alarm.SAMPLE_RATE -= 50;
				volume = true;
			}
		}

	}

}