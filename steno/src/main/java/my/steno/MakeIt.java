package my.steno;

public class MakeIt {

	public final static String INFO = "INFO";
	public final static String WRITE = "WRITE";

	public static void main(String[] args) {
		System.out.println("--**************************** START *******************");
		long start = System.currentTimeMillis();

		if (args == null || args.length <= 0 || args.length < 3) {
			System.err.println(
					"No parameters not found, 1:methodName(INFO-WRITE-....) 2:directoryPath 3:pictureFullPathWithName(for info, other put '')");
			return;
		}

		String methodName = args[0];
		String directoryPath = args[1];
		String fileNameFullPath = args[2];

		if (INFO.equals(methodName)) {
			Informations info = new Informations();
			info.getInfo(fileNameFullPath);
		} else if (WRITE.equals(methodName)) {
			Writter write = new Writter();
			write.writeHiddenText(directoryPath);
		}

		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000f + " seconds");
		System.out.println("--************************************ DONE *****************");

	}

}
