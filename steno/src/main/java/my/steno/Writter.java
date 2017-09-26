package my.steno;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * The Class Writter.
 */
public class Writter {

	/** base64 = U29ydGlkb3BpY3QgcHJvcGVydHk */
	public static final String SECRET = "Sortidopict property";

	/**
	 * Write hidden text.
	 *
	 * @param directoryPath
	 *            the directory path
	 */
	public void writeHiddenText(String directoryPath) {
		byte[] bytes = SECRET.getBytes();
		String secretData64 = new String(Base64.getEncoder().withoutPadding().encode(bytes), StandardCharsets.UTF_8);
		// Hide the information.
		try {

			for (File file : StenoUtils.getPictures(new File(directoryPath))) {
				System.out.println("Run this picture: " + file.getName());
				StenoUtils.hideTextData(file, secretData64);
			}

		} catch (IOException e) {
			System.err.println(e);
		}
	}

}
