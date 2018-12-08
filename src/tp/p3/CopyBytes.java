package tp.p3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class CopyBytes {
	
	public static void execute() throws IOException {
	BufferedInputStream inBytes = null;
	BufferedOutputStream outBytes = null;
	BufferedWriter outChars = null;
	try {
		//inBytes = new BufferedInputStream(
		//new FileInputStream("bytes_in.txt"));
			outChars = new BufferedWriter(new FileWriter("bytes_out.txt"));
		String c = "hello world"; // almacena el valor del byte en los últimos 8 bits
		int a = c.length();
		while (a >= 0) { outChars.write(Character.toChars(a + '0'));;outChars.newLine();a--; }
	} finally {
		if (inBytes != null) { inBytes.close(); }
		if (outChars != null) { outChars.close(); }
		}
	}
}