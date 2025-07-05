import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        // write in try-catch block for safety and security
        try {
            FileReader fileReader = new FileReader("D:/Sessions/JavaFSBootCamp/PropeersJavaFSBootCamp/Session-3/hello.txt");
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error Occured: " + e.getMessage());
        }
    }
}