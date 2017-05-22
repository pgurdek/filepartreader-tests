import java.io.IOException;

/**
 * Created by pgurdek on 22.05.17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("working");
        FilePartReader newFilePathReader = new FilePartReader();
        try {
            newFilePathReader.setup("test_data.txt",2,4);
            FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(newFilePathReader);
            fileWordAnalyzer.wordsByABC();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
