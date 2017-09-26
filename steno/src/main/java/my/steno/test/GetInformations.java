package my.steno.test;

import java.util.Base64;

import my.steno.StenoUtils;

public class GetInformations {

	public static void main(String[] args) {

		System.out.println("--**************************** START *******************");
		long start = System.currentTimeMillis();

		String fileNameFullPath = "";
		if (args == null || args.length <= 0) {
			System.err.println("No fileNameFullPath found");
			return;
		}

		fileNameFullPath = args[0];

		// Get back the data.
		String hiddenData64 = StenoUtils.getHiddenData(fileNameFullPath);
		System.out.println("!hiddenData64 data: " + hiddenData64);
		if (hiddenData64 == null) {
			System.err.println("Data not found");
		} else {
			String hiddenData = new String(Base64.getDecoder().decode(hiddenData64));
			System.out.println("!hidden data: " + hiddenData);
		}

		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000f + " seconds");
		System.out.println("--************************************ DONE *****************");
	}

}
