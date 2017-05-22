import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by pgurdek on 22.05.17.
 */
public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    FileWordAnalyzer(FilePartReader filePartReader) {

        this.filePartReader = filePartReader;

    }

    ArrayList<String> wordsByABC() throws IOException {

        ArrayList<String> words = new  ArrayList<>(Arrays.asList(this.filePartReader.readLines().split("\\r?\\n?\\s+")));

        Collections.sort(words);

        return words;

    }

    public FilePartReader getFilePartReader() {
        return filePartReader;
    }

    public void setFilePartReader(FilePartReader filePartReader) {

        this.filePartReader = filePartReader;

    }
}
