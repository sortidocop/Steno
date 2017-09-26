package my.steno;

import java.util.Base64;

/**
 * The Class Informations.
 */
public class Informations {

	/**
	 * Gets the info.
	 *
	 * @param fileNameFullPath
	 *            the file name full path
	 * @return the info
	 */
	public void getInfo(String fileNameFullPath) {

		// Get back the data.
		String hiddenData64 = StenoUtils.getHiddenData(fileNameFullPath);
		System.out.println("!hiddenData64 data: " + hiddenData64);
		if (hiddenData64 == null) {
			System.err.println("Data not found");
		} else {
			String hiddenData = new String(Base64.getDecoder().decode(hiddenData64));
			System.out.println("!hidden data: " + hiddenData);
		}

	}

}
