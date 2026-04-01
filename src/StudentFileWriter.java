import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class StudentFileWriter {
    public static void main(String[] args) {
        File file = new File("students.txt");
        if (file.exists()) {
            System.out.println("Warning: students.txt already exists. Overwriting...");
        }

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("Ali Karimov 3.85 ComputerScience");
            writer.println("John Doe 3.50 Mathematics");
            writer.println("Jane Smith 3.90 Physics");
            writer.println("Bob Jones 2.80 History");
            writer.println("Alice Brown 3.75 Biology");
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}