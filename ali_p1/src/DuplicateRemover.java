import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
    public Set<String> uniqueWords;
    String words_in_file;

    public void remove (String dataFile) throws FileNotFoundException {
        uniqueWords = new HashSet<String>();

        File text = new File(dataFile);

        Scanner scan_file = new Scanner(text);

        while(scan_file.hasNext())
        {
            words_in_file = scan_file.next();
            uniqueWords.add(words_in_file);
        }
        scan_file.close();
    }

    public void write(String outputFile) throws IOException {
        File new_file = new File(outputFile);
        FileWriter file_writer = null;

        int end = 0;

        boolean file_is_created = new_file.exists();

        if (!file_is_created) {

            new_file.createNewFile();

            file_writer = new FileWriter(new_file);

            Iterator looking_at_words = uniqueWords.iterator();

            while (looking_at_words.hasNext()) {
                String add = (String) looking_at_words.next();
                file_writer.write(add + " ");
            }

            file_writer.close();

            end = 1;

            System.out.println("unique_word.txt was created");

        } else {
            file_writer = new FileWriter(new_file, false);

            Iterator looking_at_words = uniqueWords.iterator();

            while (looking_at_words.hasNext()) {
                String add = (String) looking_at_words.next();
                file_writer.write(add + " ");
            }

            file_writer.close();

            end = 1;

            System.out.println("unique_word.txt was created");
        }

        if (end != 1) {
            System.out.println("An exceptional IO event occurred!");
            System.exit(0);
        }
    }
}