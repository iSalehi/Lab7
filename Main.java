import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        createSampleFile();

        try {
            System.out.println("A sample file was created.");
            System.out.println("Type this filename: sample.txt");

            System.out.print("\nEnter the filename: ");
            String filename = input.nextLine();

            if (filename.trim().isEmpty()) {
                throw new EmptyFilenameException("Filename cannot be empty.");
            }

            File file = new File(filename);

            if (!file.exists()) {
                throw new FileNotFoundException("The file does not exist.");
            }

            FileAnalyzer analyzer = new FileAnalyzer(filename);
            analyzer.analyzeFile();

        } catch (EmptyFilenameException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("General error: " + e.getMessage());

        } finally {
            input.close();
        }
    }

    public static void createSampleFile() {

        try {
            PrintWriter writer = new PrintWriter("sample.txt");

            writer.println("Great job Java student!");
            writer.println("This is a sample file.");
            writer.println("The program will count lines words and characters.");
            writer.println("Keep practicing Java.");

            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Could not create sample file.");
        }
    }
}
