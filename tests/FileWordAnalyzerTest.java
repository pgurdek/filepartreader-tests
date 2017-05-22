import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by pgurdek on 22.05.17.
 */
class FileWordAnalyzerTest {

    FileWordAnalyzer fileWordAnalyzer;

    @BeforeEach
    void createNewFileWordAnalyzerTest() throws FileNotFoundException {
        FilePartReader filePartReader = new FilePartReader();

        this.fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    }

    @Test
    @DisplayName("Tests whether wordsByABC sort words alphabetically")
    void testWordsByABCSortLine2_4() throws IOException {

        this.fileWordAnalyzer.getFilePartReader().setup("test_data.txt", 2, 4);

        ArrayList<String> excepted = new ArrayList<>(Arrays.asList("2a", "2b", "3a", "3b", "3c", "4a", "4bb4", "4cr", "4d"));

        assertEquals(excepted, this.fileWordAnalyzer.wordsByABC());

    }
}