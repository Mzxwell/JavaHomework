import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
@SuppressWarnings("ResultOfMethodCallIgnored")
public class FileReader {
    public String readFile(String filePath) throws IOException{
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        System.out.println(file.length());
        byte[] buffer = new byte[(int) file.length()];
        inputStream.read(buffer);
        String s = new String(buffer);
        inputStream.close();
        return s;
    }
}
