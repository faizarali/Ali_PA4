import java.io.*;
import java.util.*;

public class DuplicateCounter {
    HashMap<String, Integer> map_of_strings = new HashMap<String, Integer>();
    Integer count_of_words;

    public void count(String dataFile) throws FileNotFoundException {

        File text = new File(dataFile);

        Scanner scan_file = new Scanner(text);

        while(scan_file.hasNext()) {
            String word = scan_file.next();

            count_of_words = map_of_strings.get(word);

            if(count_of_words == null)
                count_of_words = 1;
            else
                count_of_words++;

            map_of_strings.put(word, count_of_words);
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

            PrintWriter out_file = new PrintWriter(new_file);

            for(String word : map_of_strings.keySet()) {
                out_file.print(word);
                out_file.print(" - ");
                out_file.println(map_of_strings.get(word));
            }

            out_file.close();

            file_writer.close();

            end = 1;

            System.out.println("unique_word.txt was created");

        } else {
            file_writer = new FileWriter(new_file, false);

            PrintWriter out_file = new PrintWriter(new_file);

            for(String word : map_of_strings.keySet()) {
                out_file.print(word);
                out_file.print(" - ");
                out_file.println(map_of_strings.get(word));
            }

            out_file.close();

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