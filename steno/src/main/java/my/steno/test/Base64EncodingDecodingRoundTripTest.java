package my.steno.test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64EncodingDecodingRoundTripTest {
	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[57];
		String bb = "Sortidopict property";
		bytes = bb.getBytes();
		String enc2 = new String(java.util.Base64.getEncoder().withoutPadding().encode(bytes), StandardCharsets.UTF_8);

		System.out.println("enc2 = <" + enc2 + ">");

		String dec2 = new String(Base64.getDecoder().decode(enc2));

		System.out.println("dec2 = <" + dec2 + ">");

		byte[] bytesEncoded = Base64.getMimeEncoder().encode("bonjour".getBytes());
		System.out.println("ecncoded value is " + new String(bytesEncoded));

		// Decode data on other side, by processing encoded data
		byte[] valueDecoded = Base64.getMimeDecoder().decode(bytesEncoded);
		System.out.println("Decoded value is " + new String(valueDecoded));

	}

}
