import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @DisplayName("Tests whether wordsByABC sort words alphabetically line 2-4")
    void testWordsByABCSortLine2_4() throws IOException {
        this.fileWordAnalyzer.getFilePartReader().setup("test_data.txt", 2, 4);
        ArrayList<String> excepted = new ArrayList<>(Arrays.asList("2a", "2b", "3a", "3b", "3c", "4a", "4bb4", "4cr", "4d"));
        assertEquals(excepted, this.fileWordAnalyzer.wordsByABC());
    }

    @Test
    @DisplayName("Tests whether wordsByABC sort words alphabetically line 4-6")
    void testWordsByABCSortLine4_6() throws IOException {
        this.fileWordAnalyzer.getFilePartReader().setup("test_data.txt", 4, 6);
        ArrayList<String> excepted = new ArrayList<>(Arrays.asList("4a", "4bb4", "4cr", "4d", "5ax", "5b", "5c", "5d", "5e", "6a", "6bb", "6ca", "6d", "6ea", "6f"));
        assertEquals(excepted, this.fileWordAnalyzer.wordsByABC());
    }

    @Test
    @DisplayName("Check whether wordsContainingSubString returns words containg substring from line 2-4")
    void testWordsContainingSubStringLine2_4() throws IOException {
        this.fileWordAnalyzer.getFilePartReader().setup("test_data.txt", 2, 4);
        ArrayList<String> excepted = new ArrayList<>(Arrays.asList("4d", "4cr", "4bb4", "4a"));
        assertEquals(excepted, this.fileWordAnalyzer.wordsContainingSubString("4"));
    }

    @Test
    @DisplayName("Check whether wordsContainingSubString result is Empty")
    void testWordsContainingSubStringResultEmpty() throws IOException {
        this.fileWordAnalyzer.getFilePartReader().setup("test_data.txt", 1, 1);
        assertEquals(new ArrayList<>(), this.fileWordAnalyzer.wordsContainingSubString("loremipsum_not_In"));
    }

    @Test
    @DisplayName("Check whether wordsArePalindrome returns correct values from test file")
    void testWordsArePalindromeAllResults() throws IOException {
        this.fileWordAnalyzer.getFilePartReader().setup("test_data.txt", 1, 7);
        ArrayList<String> excepted = new ArrayList<>(Arrays.asList("1a1", "4bb4"));
        assertEquals(excepted, this.fileWordAnalyzer.wordsArePalindrome());
    }

}