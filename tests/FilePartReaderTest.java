import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FilePartReaderTest {

    FilePartReader filePartReader;

    @BeforeEach
    void createNewFilePartReader() {
        this.filePartReader = new FilePartReader();
    }

    @Test
    @DisplayName("Test readLines method on non existing file")
    void testReadLinesBeforeSetup() throws FileNotFoundException {
        this.filePartReader.setup("", 1, 30);
        assertThrows(FileNotFoundException.class, this.filePartReader::readLines);
    }

    @Test
    @DisplayName("Tests whether calling setup() with fromLine argument less than (LT) 1 throws a IllegalArgumentException")
    void testSetupFromLineLT1() {
        assertThrows(IllegalArgumentException.class, () -> this.filePartReader.setup("test_data", -10, 10));
    }

    @Test
    @DisplayName("Tests whether readLines() called to read first two lines returns expected string")
    void testReadLines1_2() throws IOException {
        this.filePartReader.setup("test_data.txt", 1, 2);
        assertEquals("1a1\n" +
                "2b 2a\n", this.filePartReader.readLines());
    }

    @Test
    @DisplayName("Tests whether readLines() called to read lines from 2 to 4 returns expected string")
    void testReadLines2_4() throws IOException {
        this.filePartReader.setup("test_data.txt", 2, 4);
        assertEquals("2b 2a\n" +
                "3c 3b 3a\n" +
                "4d 4cr 4bb4 4a\n", this.filePartReader.readLines());
    }

    @Test
    @DisplayName("Tests whether readLines() called to read all lines returns expected string")
    void testReadLinesAll() throws IOException {
        this.filePartReader.setup("test_data.txt", 1, 7);
        String excepted = "1a1\n" +
                "2b 2a\n" +
                "3c 3b 3a\n" +
                "4d 4cr 4bb4 4a\n" +
                "5e 5d 5c 5b 5ax\n" +
                "6f 6ea 6d 6ca 6bb 6a\n" +
                "7g 7f 7ea\n";
        assertEquals(excepted, this.filePartReader.readLines());
    }

    @Test
    @DisplayName("Test readLines() when toLine is past end of File.")
    void testReadLinesPastEof() throws IOException {
        this.filePartReader.setup("test_data.txt", 1, 9999);
        assertThrows(ArrayIndexOutOfBoundsException.class, this.filePartReader::readLines);
    }
    
}