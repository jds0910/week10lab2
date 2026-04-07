import java.io.PrintWriter;
import java.io.IOException;
import java.util.Date;

public class FileLogger {
    public static void writeLog(String filename, String message) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename);
            writer.println(new Date() + ": " + message);
            throw new RuntimeException("Simulated write error");
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
            System.out.println("Logger closed.");
        
        }
    }

    public static void main(String[] args) {
        try {
            writeLog("log.txt", "Test log entry");
        } catch (RuntimeException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}