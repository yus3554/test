
import java.applet.*;
import java.net.*;

public class PlayAudio {

	private URL url;
	private AudioClip audioClip;

	public PlayAudio(String fileName) {
		fileLoad(fileName);
	}

	public void fileLoad(String fileName) {

		try {
			url = new URL("file:" +
				System.getProperty("user.dir") + "/" + fileName);
		}

		catch (MalformedURLException ex) {
			System.err.println(ex);
		}

		audioClip = Applet.newAudioClip(url);
	}

	public void play() {
		audioClip.play();
	}

	public void loop() {
		audioClip.loop();
	}
	public void stop() {
		audioClip.stop();
	}
}
