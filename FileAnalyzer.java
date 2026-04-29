import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileAnalyzer {

    private String filename;

    public FileAnalyzer(String filename) {
        this.filename = filename;
    }

    public void analyzeFile() throws FileNotFoundException {

        File file = new File(filename);

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();

            lineCount++;
            charCount += line.length();

            String trimmedLine = line.trim();

            if (!trimmedLine.isEmpty()) {
                String[] words = trimmedLine.split("\\s+");
                wordCount += words.length;
            }
        }

        fileScanner.close();

        System.out.println("\nFile Analysis Summary");
        System.out.println("Lines: " + lineCount);
        System.out.println("Words: " + wordCount);
        System.out.println("Characters: " + charCount);

        writeOutput(lineCount, wordCount, charCount);
    }

    public void writeOutput(int lines, int words, int characters) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter("analysis_output.txt");

        writer.println("File Analysis Summary");
        writer.println();
        writer.println("Lines: " + lines);
        writer.println("Words: " + words);
        writer.println("Characters: " + characters);

        writer.close();

        System.out.println("\nResults saved to analysis_output.txt");
    }
}
