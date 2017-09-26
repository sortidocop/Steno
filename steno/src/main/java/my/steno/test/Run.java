package my.steno.test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import my.steno.StenoUtils;

public class Run {

	/** base64 = U29ydGlkb3BpY3QgcHJvcGVydHk */
	public static final String SECRET = "Sortidopict property";

	public static void main(String[] args) {

		System.out.println("--**************************** START *******************");
		long start = System.currentTimeMillis();

		String directoryPath = "";
		if (args == null || args.length <= 0) {
			System.err.println("No directory path found");
			return;
		}

		directoryPath = args[0];

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
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000f + " seconds");
		System.out.println("--************************************ DONE *****************");
	}

}
