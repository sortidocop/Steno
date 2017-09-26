package my.steno;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StenoUtils {

	private StenoUtils() {
	}

	/**
	 * Index to retreive hidden text.
	 */
	private static String INDEX = "@@@@@@";

	/**
	 * Hide the data contents inside the picture.
	 *
	 * @param picture
	 *            the picture
	 * @param text
	 *            the text
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void hideTextData(File picture, String text) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(picture, true)) {

			byte[] encodedString = text.getBytes();

			fos.write(INDEX.getBytes());
			fos.write(encodedString);
			fos.close();
		} catch (Exception e) {
			System.err.println("FileName= " + picture.getName());
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * Get the hidden data from an picture.
	 *
	 * @param fileNameFullPath
	 *            the file name full path
	 * @return the hidden data
	 */
	public static String getHiddenData(String fileNameFullPath) {
		File file = new File(fileNameFullPath);
		if (!file.exists()) {
			throw new IllegalArgumentException("no file found");
		}
		try (InputStream inStream = new FileInputStream(file)) {

			byte[] fileData = new byte[(int) file.length()];
			inStream.read(fileData);
			inStream.close();

			String tempFileData = new String(fileData);

			if (tempFileData.indexOf(INDEX) >= 0) {
				return tempFileData.substring(tempFileData.indexOf(INDEX) + INDEX.length(), tempFileData.length());
			}

			return null;

		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * Gets the pictures.
	 *
	 * @param directory
	 *            the directory
	 * @return the pictures
	 */
	public static List<File> getPictures(File directory) {
		// trie du dossier, pour avoir que les fichiers de type jpg.
		String[] fileName = directory.list((dir, name) -> name.endsWith(".jpg"));

		// transformation du tableau de string en list de fichier.
		return Stream.of(fileName).map(s -> new File(directory + "/" + s)).collect(Collectors.toList());
		// return
		// Stream.of(fileName).map(File::new).collect(Collectors.toList());
	}
}
