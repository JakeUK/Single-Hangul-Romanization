package hangulromanization;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class FUtil {

	private static String outputFile = "output.csv";
	private static File file;
	private static StringBuilder currentWrite = new StringBuilder();
	
	
	public static void append(String add) {
		currentWrite.append(add);
	}
	
	public static void write() {
		try {
			FileOutputStream fs = new FileOutputStream(file);
			fs.write(currentWrite.toString().getBytes("UTF-8"));
			fs.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void setOutputFile(String newF) {
		outputFile = newF;
	}
	
	public static void clearFile() {
		currentWrite = new StringBuilder();
		openFile();
		file.delete();
		try {
			file.createNewFile();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void openFile() {
		if(file != null) {
			return;
		}
		try {
			file = new File(outputFile);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
