import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
public class CSVFile {
	public static void main(String[] args) {
		String filePath = Objects.requireNonNull(CSVFile.class.getClassLoader().getResource("data.txt")).getPath();
		printCSVFile(filePath);
	}
	public static void printCSVFile(String filePath) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			String str;
			System.out.println("Last    First    Salary");
			while ((str = in.readLine())!=null){
				System.out.println(str.replace(",","    "));
			}
		} catch (IOException ignored) {
		}
	}
}