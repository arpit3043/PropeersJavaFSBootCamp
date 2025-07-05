import java.io.FileWriter;
import java.io.IOException;

public class FileWriteExample {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("D:/Sessions/JavaFSBootCamp/PropeersJavaFSBootCamp/Session-3/hello.txt");
            fileWriter.write("Hello To java Programming");
            fileWriter.close();
            System.out.println("File Written Successfully");
        } catch (IOException e) {
            System.out.println("Error Occured: " + e.getMessage());
        }
    }
}