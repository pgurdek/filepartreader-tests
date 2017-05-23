import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by pgurdek on 22.05.17.
 */
public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    FilePartReader getFilePartReader() {
        return filePartReader;
    }

    ArrayList<String> wordsByABC() throws IOException {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(this.filePartReader.readLines().split("\\r?\\n?\\s+")));
        Collections.sort(words);

        return words;
    }

    ArrayList<String> wordsContainingSubString(String substring) throws IOException {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(this.filePartReader.readLines().split("\\r?\\n?\\s+")));
        if (words.size() <= 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        words.removeIf(word -> !word.contains(substring));
        return words;
    }

    ArrayList<String> wordsArePalindrome() throws IOException {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(this.filePartReader.readLines().split("\\r?\\n?\\s+")));
        if (words.size() <= 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (Iterator<String> iterator = words.iterator(); iterator.hasNext(); ) {
            char[] word = iterator.next().toCharArray();
            if (!isaPalindromic((word))) {
                iterator.remove();
            }
        }
        System.out.println(words);
        return words;
    }

    private Boolean isaPalindromic(char[] word) {
        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            if (word[i1] != word[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }
}
